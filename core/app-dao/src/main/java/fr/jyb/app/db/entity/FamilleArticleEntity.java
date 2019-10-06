package fr.jyb.app.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Utilisateur
 *
 */
@Entity
@Table(name = "T_TXN_FAMILLE_ARTICLE")
public class FamilleArticleEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -172173663377411292L;

    /* */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /* */
    private String nom;

    /* */
    private String description;

    /* */
    private List<ArticleEntity> articles;

    public FamilleArticleEntity() {

    }

    @Id
    @Column(name = "ID_FAMILLE_ARTICLE")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "familleArticle", fetch = FetchType.LAZY)
    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

}
