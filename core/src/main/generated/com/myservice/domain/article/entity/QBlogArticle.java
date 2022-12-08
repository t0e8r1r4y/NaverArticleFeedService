package com.myservice.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBlogArticle is a Querydsl query type for BlogArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlogArticle extends EntityPathBase<BlogArticle> {

    private static final long serialVersionUID = -1094834535L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlogArticle blogArticle = new QBlogArticle("blogArticle");

    public final com.myservice.domain.base.entity.QBaseEntity _super = new com.myservice.domain.base.entity.QBaseEntity(this);

    public final StringPath bloggerLink = createString("bloggerLink");

    public final StringPath bloggerName = createString("bloggerName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final ComparablePath<java.util.UUID> createdBy = _super.createdBy;

    public final StringPath description = createString("description");

    public final QApiComposedKey id;

    public final StringPath link = createString("link");

    public final StringPath postdate = createString("postdate");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final ComparablePath<java.util.UUID> updatedBy = _super.updatedBy;

    public QBlogArticle(String variable) {
        this(BlogArticle.class, forVariable(variable), INITS);
    }

    public QBlogArticle(Path<? extends BlogArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlogArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlogArticle(PathMetadata metadata, PathInits inits) {
        this(BlogArticle.class, metadata, inits);
    }

    public QBlogArticle(Class<? extends BlogArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QApiComposedKey(forProperty("id")) : null;
    }

}

