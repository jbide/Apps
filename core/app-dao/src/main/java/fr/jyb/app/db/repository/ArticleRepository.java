package fr.jyb.app.db.repository;

import fr.jyb.app.db.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
}
