package com.sayak.repository;

import com.sayak.tableschema.TableEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.MultiValueBinding;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface TableRepository<T extends TableEntity, S extends EntityPathBase<T>> extends PagingAndSortingRepository<T, UUID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<S> {
    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull S root) {
        bindings.bind(String.class).all((MultiValueBinding<StringPath, String>) (path, values) -> {
            BooleanBuilder predicate = new BooleanBuilder();
            values.forEach(value -> predicate.or(path.containsIgnoreCase(value)));
            return Optional.of(predicate);
        });
    }

//    Deletes will be handled later
    /*@Override
    @Query("update #{#entityName} e set e.deleted=true where e.hexId = ?1")
    @Modifying
    void deleteById(@NonNull UUID uuid);

    @Override
    @Query("update #{#entityName} e set e.deleted=true where e = ?1")
    @Modifying
    void delete(@NonNull T entity);*/
}
