package com.myservice.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNewsArticle is a Querydsl query type for NewsArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNewsArticle extends EntityPathBase<NewsArticle> {

    private static final long serialVersionUID = -1943666104L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsArticle newsArticle = new QNewsArticle("newsArticle");

    public final com.myservice.domain.base.entity.QBaseEntity _super = new com.myservice.domain.base.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final ComparablePath<java.util.UUID> createdBy = _super.createdBy;

    public final StringPath description = createString("description");

    public final QApiComposedKey id;

    public final StringPath link = createString("link");

    public final StringPath originalLink = createString("originalLink");

    public final StringPath pubDate = createString("pubDate");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final ComparablePath<java.util.UUID> updatedBy = _super.updatedBy;

    public QNewsArticle(String variable) {
        this(NewsArticle.class, forVariable(variable), INITS);
    }

    public QNewsArticle(Path<? extends NewsArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNewsArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNewsArticle(PathMetadata metadata, PathInits inits) {
        this(NewsArticle.class, metadata, inits);
    }

    public QNewsArticle(Class<? extends NewsArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QApiComposedKey(forProperty("id")) : null;
    }

}

