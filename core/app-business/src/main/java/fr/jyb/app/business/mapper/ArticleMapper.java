package fr.jyb.app.business.mapper;

import fr.jyb.app.business.model.Article;
import fr.jyb.app.db.entity.ArticleEntity;
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
public class ArticleMapper {

    public Optional<Article> mapArticleEntityToArticle(ArticleEntity articleEntity) {

        if (Objects.isNull(articleEntity)){
            return Optional.empty();
        }

        Article article = new Article();
        article.setId(articleEntity.getId());
        article.setNom(articleEntity.getNom());
        article.setDescription(articleEntity.getDescription());
        article.setCouleur(articleEntity.getCouleur());
        article.setReference(articleEntity.getReference());
        return Optional.of(article);
    }

    public List<Article> mapArticleEntityToArticleList(List<ArticleEntity> articleEntityList) {
        if (CollectionUtils.isEmpty(articleEntityList)) {
            return Collections.emptyList();
        }

        return articleEntityList.stream().
                map(articleEntity -> mapArticleEntityToArticle(articleEntity).get()).
                collect(Collectors.toList());
    }
}
