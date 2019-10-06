package fr.jyb.app.business.service;

import fr.jyb.app.business.mapper.FamilleArticleMapper;
import fr.jyb.app.business.model.FamilleArticle;
import fr.jyb.app.db.dao.FamilleArticleDao;
import fr.jyb.app.db.entity.FamilleArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class FamilleArticleService {

    @Autowired
    private FamilleArticleDao familleArticleDao;

    @Autowired
    private FamilleArticleMapper familleArticleMapper;

    public List<FamilleArticle> getAllFamillesArticles() {
        List<FamilleArticleEntity> familleArticleList =  familleArticleDao.getAllFamillesArticles();

        List<FamilleArticle> model = familleArticleMapper.mapFamilleArticleEntityToFamilleArticleList(familleArticleList);

        return model;
    }
}
