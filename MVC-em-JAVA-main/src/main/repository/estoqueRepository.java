package com.apiestoque.conn.repository;

import org.springframework.data.repository.CrudRepository;

import com.apiestoque.conn.model.estoque;

public interface estoqueRepository 
  extends CrudRepository<estoque, Long> {


    
}
