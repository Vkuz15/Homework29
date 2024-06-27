package ru.hogwarts.school.services;

import java.util.List;

public interface GeneralService<V> {

    V add(V faculty);

    V get(Long id);

    V edit(V faculty);

    V delete(Long id);

    List<V> getAll();
}
