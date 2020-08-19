package com.project.medium.services;

import java.util.List;

public interface GenericService<T> {
   T findById(Long id);
   List<T> getAll();
   T remove(Long id);
   T createNewObject(T model);
}
