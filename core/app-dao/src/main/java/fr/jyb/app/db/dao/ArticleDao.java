package fr.jyb.app.db.dao;

import fr.jyb.app.db.entity.ArticleEntity;
import fr.jyb.app.db.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ArticleDao {

    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }
}
