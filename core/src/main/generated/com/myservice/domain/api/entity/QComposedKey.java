package com.myservice.domain.api.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComposedKey is a Querydsl query type for ComposedKey
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QComposedKey extends BeanPath<ComposedKey> {

    private static final long serialVersionUID = 713892846L;

    public static final QComposedKey composedKey = new QComposedKey("composedKey");

    public final StringPath keyword = createString("keyword");

    public final StringPath requestUrl = createString("requestUrl");

    public final ComparablePath<java.util.UUID> userId = createComparable("userId", java.util.UUID.class);

    public QComposedKey(String variable) {
        super(ComposedKey.class, forVariable(variable));
    }

    public QComposedKey(Path<? extends ComposedKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComposedKey(PathMetadata metadata) {
        super(ComposedKey.class, metadata);
    }

}

