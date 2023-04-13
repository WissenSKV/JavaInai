package com.example.kurzwork.Controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByCatalogId(Long catalogId);

}

//метод для комментариев брать и выводить в контролере меиод добавления  в самом хтмл потом запретить для не зарегтсьриированных