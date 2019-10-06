package fr.jyb.app.rest.v1.controller;

import fr.jyb.app.rest.v1.PathConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping(path = PathConstants.VERSION, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ArticleRestController {
}
