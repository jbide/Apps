package fr.jyb.app.db.dao;

import fr.jyb.app.db.entity.FamilleArticleEntity;
import fr.jyb.app.db.repository.FamilleArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class FamilleArticleDao {

    @Autowired
    private FamilleArticleRepository familleArticleRepository;

    public List<FamilleArticleEntity> getAllFamillesArticles() {
        return familleArticleRepository.findAll();
    }
}
