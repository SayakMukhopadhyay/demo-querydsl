package com.sayak.tableschema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTableEntity is a Querydsl query type for TableEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QTableEntity extends EntityPathBase<TableEntity> {

    private static final long serialVersionUID = 48037740L;

    public static final QTableEntity tableEntity = new QTableEntity("tableEntity");

    public final BooleanPath deleted = createBoolean("deleted");

    public final ComparablePath<java.util.UUID> hexId = createComparable("hexId", java.util.UUID.class);

    public QTableEntity(String variable) {
        super(TableEntity.class, forVariable(variable));
    }

    public QTableEntity(Path<? extends TableEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTableEntity(PathMetadata metadata) {
        super(TableEntity.class, metadata);
    }

}

