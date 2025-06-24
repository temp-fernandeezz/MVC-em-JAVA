package com.apiestoque.conn.repository;

import org.springframework.data.repository.CrudRepository;

import com.apiestoque.conn.model.produto;

public interface produtoRepository 
  extends CrudRepository<produto, Long> {


    
}
