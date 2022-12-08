package com.myservice.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCafeArticle is a Querydsl query type for CafeArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCafeArticle extends EntityPathBase<CafeArticle> {

    private static final long serialVersionUID = -833569730L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCafeArticle cafeArticle = new QCafeArticle("cafeArticle");

    public final com.myservice.domain.base.entity.QBaseEntity _super = new com.myservice.domain.base.entity.QBaseEntity(this);

    public final StringPath cafeName = createString("cafeName");

    public final StringPath cafeUrl = createString("cafeUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final ComparablePath<java.util.UUID> createdBy = _super.createdBy;

    public final StringPath description = createString("description");

    public final QApiComposedKey id;

    public final StringPath link = createString("link");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final ComparablePath<java.util.UUID> updatedBy = _super.updatedBy;

    public QCafeArticle(String variable) {
        this(CafeArticle.class, forVariable(variable), INITS);
    }

    public QCafeArticle(Path<? extends CafeArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCafeArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCafeArticle(PathMetadata metadata, PathInits inits) {
        this(CafeArticle.class, metadata, inits);
    }

    public QCafeArticle(Class<? extends CafeArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QApiComposedKey(forProperty("id")) : null;
    }

}

