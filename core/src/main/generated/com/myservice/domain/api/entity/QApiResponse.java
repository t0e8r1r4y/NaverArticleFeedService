package com.myservice.domain.api.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApiResponse is a Querydsl query type for ApiResponse
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApiResponse extends EntityPathBase<ApiResponse> {

    private static final long serialVersionUID = 1731881084L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApiResponse apiResponse = new QApiResponse("apiResponse");

    public final com.myservice.domain.base.entity.QBaseEntity _super = new com.myservice.domain.base.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final ComparablePath<java.util.UUID> createdBy = _super.createdBy;

    public final QComposedKey id;

    public final StringPath lastBuildDate = createString("lastBuildDate");

    public final NumberPath<Long> total = createNumber("total", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final ComparablePath<java.util.UUID> updatedBy = _super.updatedBy;

    public QApiResponse(String variable) {
        this(ApiResponse.class, forVariable(variable), INITS);
    }

    public QApiResponse(Path<? extends ApiResponse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApiResponse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApiResponse(PathMetadata metadata, PathInits inits) {
        this(ApiResponse.class, metadata, inits);
    }

    public QApiResponse(Class<? extends ApiResponse> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QComposedKey(forProperty("id")) : null;
    }

}

