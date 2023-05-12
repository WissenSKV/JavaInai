package com.example.kurzwork.repository;

import java.util.List;

import com.example.kurzwork.model.Karysel;
import org.springframework.data.repository.CrudRepository;

public interface KaryselRepository extends CrudRepository<Karysel, Long> {

    List<Karysel> findByImg(String img);

    Karysel findById(long id);
}
