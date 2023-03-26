package com.example.kurzwork.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class catalog_controller {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/catalog")
    public String getCatalog(Model model) {
        Iterable<Catalog> catalog = catalogRepository.findAll();
        model.addAttribute("catalog", catalog);
        //catalogRepository.save(new Catalog("ffff", "fdsaf", "https://avatars.mds.yandex.net/i?id=329a652c9e349faef992e77a18534d0bd8471613-8210080-images-thumbs&n=13", "car", "1000"));
        //catalogRepository.save(new Catalog("аааа", "fdsaf", "https://avatars.mds.yandex.net/i?id=329a652c9e349faef992e77a18534d0bd8471613-8210080-images-thumbs&n=13", "car", "1000"));

        return "catalog";
    }
}
