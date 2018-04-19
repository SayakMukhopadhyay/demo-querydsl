package com.sayak.tableschema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyEntity is a Querydsl query type for MyEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyEntity extends EntityPathBase<MyEntity> {

    private static final long serialVersionUID = -965045132L;

    public static final QMyEntity myEntity = new QMyEntity("myEntity");

    public final QTableEntity _super = new QTableEntity(this);

    public final StringPath botDescription = createString("botDescription");

    public final StringPath botName = createString("botName");

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final ComparablePath<java.util.UUID> hexId = _super.hexId;

    public QMyEntity(String variable) {
        super(MyEntity.class, forVariable(variable));
    }

    public QMyEntity(Path<? extends MyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyEntity(PathMetadata metadata) {
        super(MyEntity.class, metadata);
    }

}

