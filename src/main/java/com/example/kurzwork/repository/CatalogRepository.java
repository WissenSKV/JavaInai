package com.example.kurzwork.repository;

import java.util.List;

import com.example.kurzwork.model.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

    List<Catalog> findByNameContainingIgnoreCase(String name);

    Catalog findById(long id);
}
