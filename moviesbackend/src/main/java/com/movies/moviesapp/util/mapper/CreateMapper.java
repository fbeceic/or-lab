package com.movies.moviesapp.util.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface CreateMapper<T, U> {

    U map(T from);

    default List<U> mapToList(Collection<T> from) {
        return (List<U>)from.stream().map(this::map).collect(Collectors.toList());
    }

}