package com.myservice.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QApiComposedKey is a Querydsl query type for ApiComposedKey
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QApiComposedKey extends BeanPath<ApiComposedKey> {

    private static final long serialVersionUID = 1687249838L;

    public static final QApiComposedKey apiComposedKey = new QApiComposedKey("apiComposedKey");

    public final ComparablePath<java.util.UUID> articleId = createComparable("articleId", java.util.UUID.class);

    public final StringPath keyword = createString("keyword");

    public final StringPath url = createString("url");

    public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

    public QApiComposedKey(String variable) {
        super(ApiComposedKey.class, forVariable(variable));
    }

    public QApiComposedKey(Path<? extends ApiComposedKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApiComposedKey(PathMetadata metadata) {
        super(ApiComposedKey.class, metadata);
    }

}

