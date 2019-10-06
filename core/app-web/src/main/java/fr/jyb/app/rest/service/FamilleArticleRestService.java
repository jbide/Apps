package fr.jyb.app.rest.service;

import fr.jyb.app.business.model.FamilleArticle;
import fr.jyb.app.business.service.FamilleArticleService;
import fr.jyb.app.rest.dto.FamilleArticleResponseDTO;
import fr.jyb.app.rest.mapper.FamilleArticleRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class FamilleArticleRestService {

    @Autowired
    private FamilleArticleRestMapper familleArticleRestMapper;

    @Autowired
    private FamilleArticleService familleArticleService;

    public List<FamilleArticleResponseDTO> getAllFamillesArticles() {

        List<FamilleArticle> famillesArtiles = familleArticleService.getAllFamillesArticles();

        List<FamilleArticleResponseDTO> dtos = familleArticleRestMapper.
                mapFamilleArticleToFamilleArticleResponseDTOList(famillesArtiles);

        return dtos;
    }
}
