package fr.jyb.app.rest.mapper;

import fr.jyb.app.business.model.Tournee;
import fr.jyb.app.rest.dto.TourneeDTO;
import fr.jyb.app.rest.dto.TourneeResponseDTO;
import fr.jyb.myapp.service.domain.ErrorCatalog;
import fr.jyb.myapp.service.domain.ErrorOrigin;
import fr.jyb.myapp.service.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class TourneeRestMapper {

    public Optional<Tournee> mapTourneeDTOtoTournee(TourneeDTO tourneeDTO) {
        if (Objects.isNull(tourneeDTO)) {
            return Optional.empty();
        }

        if(Objects.isNull(tourneeDTO.getTitle())) {
            throw new ServiceException(ErrorCatalog.TOURNEE_TITLE_NOT_VALID, ErrorOrigin.CLIENT,
                    ErrorCatalog.TOURNEE_TITLE_NOT_VALID.getMessage());
        }

        Tournee tournee = new Tournee();
        tournee.setIdTournee(tourneeDTO.getIdTournee());
        tournee.setTitle(tourneeDTO.getTitle());
        tournee.setStatus(tourneeDTO.getStatus());
        return Optional.of(tournee);
    }

    public List<Tournee> mapTOurneeDTOListToTourneeList(List<TourneeDTO> tourneeDTOList) {
        if (CollectionUtils.isEmpty(tourneeDTOList)) {
            return Collections.emptyList();
        }

        return tourneeDTOList.stream().
                map(tourneeDTO -> mapTourneeDTOtoTournee(tourneeDTO).get()).
                collect(Collectors.toList());
    }

    public Optional<TourneeResponseDTO> mapTourneeToTourneeResponseDTO(Tournee tournee) {

        if (Objects.isNull(tournee)) {
            return Optional.empty();
        }

        TourneeResponseDTO responseDTO = new TourneeResponseDTO();
        responseDTO.setIdTournee(tournee.getIdTournee());
        responseDTO.setTitle(tournee.getTitle());
        responseDTO.setStatus(tournee.getStatus());

        return Optional.of(responseDTO);


    }

    public List<TourneeResponseDTO> mapTourneeListToTourneeResponseDTOList(List<Tournee> tourneeList) {
        if (CollectionUtils.isEmpty(tourneeList)) {
            return Collections.emptyList();
        }

        return tourneeList.stream()
                .map(tournee -> mapTourneeToTourneeResponseDTO(tournee).get()).collect(Collectors.toList());
    }

}
