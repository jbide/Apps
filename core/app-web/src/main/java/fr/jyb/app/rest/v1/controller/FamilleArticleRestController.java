package fr.jyb.app.rest.v1.controller;

import fr.jyb.app.rest.dto.FamilleArticleResponseDTO;
import fr.jyb.app.rest.service.FamilleArticleRestService;
import fr.jyb.app.rest.v1.PathConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(path = PathConstants.VERSION, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FamilleArticleRestController {

    @Autowired
    private FamilleArticleRestService familleArticleRestService;

    @GetMapping(path = PathConstants.GET_ALL_FAMILLES_ARTICLES)
    public ResponseEntity<?> getAllTFamillesArticles() {
        List<FamilleArticleResponseDTO> dtos = familleArticleRestService.getAllFamillesArticles();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
