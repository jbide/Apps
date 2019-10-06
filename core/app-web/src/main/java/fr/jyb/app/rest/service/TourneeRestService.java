package fr.jyb.app.rest.service;

import fr.jyb.app.business.model.Tournee;
import fr.jyb.app.business.service.TourneeService;
import fr.jyb.app.rest.dto.TourneeDTO;
import fr.jyb.app.rest.dto.TourneeResponseDTO;
import fr.jyb.app.rest.mapper.TourneeRestMapper;
import fr.jyb.myapp.service.domain.ErrorCatalog;
import fr.jyb.myapp.service.domain.ErrorOrigin;
import fr.jyb.myapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class TourneeRestService {

    @Autowired
    private TourneeRestMapper tourneeRestMapper;

    @Autowired
    private TourneeService tourneeService;

    public List<TourneeResponseDTO> getAllTournees() {

        List<Tournee> tourneeResponseList = tourneeService.getAllTournees();

        List<TourneeResponseDTO> responses = tourneeRestMapper.
                mapTourneeListToTourneeResponseDTOList(tourneeResponseList);

        //throw new ServiceException(ErrorCatalog.APPLICATION_ERROR, ErrorOrigin.SERVER);
        return responses;
    }

    public TourneeResponseDTO registerTournee(TourneeDTO tourneeDTO) {
        Optional<Tournee> tourneeOptional = tourneeRestMapper.mapTourneeDTOtoTournee(tourneeDTO);

        Tournee tournee = tourneeOptional.orElseThrow(() -> new ServiceException(ErrorCatalog.TOURNEE_EMPTY,
                ErrorOrigin.CLIENT, ErrorCatalog.TOURNEE_EMPTY.getMessage()));

        Tournee tourneeResponse =  tourneeService.registerTournee(tournee);

        Optional<TourneeResponseDTO> tourneeOptionalResponse = tourneeRestMapper.
                mapTourneeToTourneeResponseDTO(tourneeResponse);

        return tourneeOptionalResponse.orElseThrow(() -> new ServiceException(ErrorCatalog.TOURNEES_DOES_NOT_EXIST,
                ErrorOrigin.SERVER, ErrorCatalog.TOURNEES_DOES_NOT_EXIST.getMessage()));

    }
}
