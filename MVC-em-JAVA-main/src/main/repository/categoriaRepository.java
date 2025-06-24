package com.apiestoque.conn.repository;

import org.springframework.data.repository.CrudRepository;

import com.apiestoque.conn.model.categoria;

public interface categoriaRepository 
  extends CrudRepository<categoria, Long> {
}
