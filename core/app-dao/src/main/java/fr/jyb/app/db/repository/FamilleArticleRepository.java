package fr.jyb.app.db.repository;

import fr.jyb.app.db.entity.FamilleArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface FamilleArticleRepository extends JpaRepository<FamilleArticleEntity, Integer> {
}
