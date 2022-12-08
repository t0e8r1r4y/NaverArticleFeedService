package com.myservice.domain.keyword.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKeyWord is a Querydsl query type for KeyWord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeyWord extends EntityPathBase<KeyWord> {

    private static final long serialVersionUID = 1155457755L;

    public static final QKeyWord keyWord = new QKeyWord("keyWord");

    public final com.myservice.domain.base.entity.QBaseEntity _super = new com.myservice.domain.base.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final ComparablePath<java.util.UUID> createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath keyword = createString("keyword");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final ComparablePath<java.util.UUID> updatedBy = _super.updatedBy;

    public QKeyWord(String variable) {
        super(KeyWord.class, forVariable(variable));
    }

    public QKeyWord(Path<? extends KeyWord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKeyWord(PathMetadata metadata) {
        super(KeyWord.class, metadata);
    }

}

