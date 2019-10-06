package fr.jyb.app.db.entity;

/**
 *
 * @author Utilisateur
 *
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_TXN_ARTICLE")
public class ArticleEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8490113799011814693L;

    /* */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /* */
    private String nom;

    /* */
    private String reference;

    /* */
    private String couleur;

    /* */
    private String description;

    /* */
    private FamilleArticleEntity familleArticle;

    /* */
    //private Fournisseur fournisseur;

    public ArticleEntity() {

    }

    @Id
    @Column(name = "ID_ARTICLE")
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

    @Column(name = "REFERENCE")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Column(name = "COULEUR")
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAM")
    public FamilleArticleEntity getFamilleArticle() {
        return familleArticle;
    }

    public void setFamilleArticle(FamilleArticleEntity familleArticle) {
        this.familleArticle = familleArticle;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FOURNISSEUR")
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    @Transient
    public GroupKey getKey() {
        Map<String, String> infos = new HashMap<String, String>();
        infos.put("NOM", nom);
        infos.put("REFERENCE", reference);
        return new DoubleKey<String, String>(nom, reference, infos);
    }

    @Override
    @Transient
    public int getComputableData() {
        return 1;
    }*/
}
