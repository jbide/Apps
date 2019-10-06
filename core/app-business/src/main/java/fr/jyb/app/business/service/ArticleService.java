package fr.jyb.app.business.service;

import fr.jyb.app.business.mapper.ArticleMapper;
import fr.jyb.app.business.model.Article;
import fr.jyb.app.db.dao.ArticleDao;
import fr.jyb.app.db.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAllArticles() {

        List<ArticleEntity> articleEntityList = articleDao.getAllArticles();

        List<Article> model = articleMapper.mapArticleEntityToArticleList(articleEntityList);

        return model;
    }
}
