package fr.jyb.app.business.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    private Integer id;

    /* */
    private String nom;

    /* */
    private String reference;

    /* */
    private String couleur;

    /* */
    private String description;
}
