package com.example.kurzwork.Controllers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KaryselRepository extends CrudRepository<Karysel, Long> {

    List<Karysel> findByImg(String img);

    Karysel findById(long id);
}
