package com.example.kurzwork.Controllers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

    List<Catalog> findByName(String name);

    Catalog findById(long id);
}