package fr.jyb.app.business.mapper;

import fr.jyb.app.business.model.FamilleArticle;
import fr.jyb.app.db.entity.FamilleArticleEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class FamilleArticleMapper {


    public Optional<FamilleArticle> mapFamilleArticleEntityToFamilleArticle(FamilleArticleEntity familleArticleEntity) {

        if (Objects.isNull(familleArticleEntity)){
            return Optional.empty();
        }

        FamilleArticle familleArticle = new FamilleArticle();
        familleArticle.setId(familleArticleEntity.getId());
        familleArticle.setNom(familleArticleEntity.getNom());
        familleArticle.setDescription(familleArticleEntity.getDescription());
        return Optional.of(familleArticle);
    }

    public List<FamilleArticle> mapFamilleArticleEntityToFamilleArticleList(List<FamilleArticleEntity> familleArticleEntityList) {
        if (CollectionUtils.isEmpty(familleArticleEntityList)) {
            return Collections.emptyList();
        }

        return familleArticleEntityList.stream().
                map(familleArticleEntity -> mapFamilleArticleEntityToFamilleArticle(familleArticleEntity).get()).
                collect(Collectors.toList());
    }
}
