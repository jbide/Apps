package fr.jyb.app.rest.mapper;

import fr.jyb.app.business.model.FamilleArticle;
import fr.jyb.app.rest.dto.FamilleArticleResponseDTO;
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
public class FamilleArticleRestMapper {

    public Optional<FamilleArticle> mapFamilleArticleResponseDTOToFamilleArticle(FamilleArticleResponseDTO familleArticleResponseDTO) {
        if (Objects.isNull(familleArticleResponseDTO)) {
            return Optional.empty();
        }

        if (Objects.isNull(familleArticleResponseDTO.getNom())) {
            throw new ServiceException(ErrorCatalog.FAMILLE_ARTICLE_NOM_NOT_VALID, ErrorOrigin.CLIENT,
                    ErrorCatalog.FAMILLE_ARTICLE_NOM_NOT_VALID.getMessage());
        }

        FamilleArticle familleArticle = new FamilleArticle();
        familleArticle.setId(familleArticleResponseDTO.getId());
        familleArticle.setNom(familleArticleResponseDTO.getNom());
        familleArticle.setDescription(familleArticleResponseDTO.getDescription());

        return Optional.of(familleArticle);
    }

    public Optional<FamilleArticleResponseDTO> mapFamilleArticleToFamilleArticleResponseDTO(FamilleArticle familleArticle) {
        if (Objects.isNull(familleArticle)) {
            return Optional.empty();
        }

        FamilleArticleResponseDTO familleArticleResponseDTO = new FamilleArticleResponseDTO();
        familleArticleResponseDTO.setId(familleArticle.getId());
        familleArticleResponseDTO.setNom(familleArticle.getNom());
        familleArticleResponseDTO.setDescription(familleArticle.getDescription());

        return Optional.of(familleArticleResponseDTO);
    }

    public List<FamilleArticleResponseDTO> mapFamilleArticleToFamilleArticleResponseDTOList(List<FamilleArticle> familleArticleList) {
        if (CollectionUtils.isEmpty(familleArticleList)) {
            return Collections.emptyList();
        }
        return familleArticleList.stream().
                map(familleArticle -> mapFamilleArticleToFamilleArticleResponseDTO(familleArticle).get()).
                collect(Collectors.toList());
    }
}
