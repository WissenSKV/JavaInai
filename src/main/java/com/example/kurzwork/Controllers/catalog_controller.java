package com.example.kurzwork.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class catalog_controller {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/catalog")
    public String getCatalog(@RequestParam(required = false) String query, Model model) {
        List<Catalog> catalog;

        if (query != null && !query.isEmpty()) {
            catalog = catalogRepository.findByNameContainingIgnoreCase(query);
        } else {
            catalog = (List<Catalog>) catalogRepository.findAll();
        }

        if (catalog.isEmpty()) {
            return "search_not_found";
        }

        model.addAttribute("catalog", catalog);

        return "catalog";
    }

    @GetMapping("/catalog/all")
    public String getAllCatalog(Model model) {
        Iterable<Catalog> catalog = catalogRepository.findAll();
        model.addAttribute("catalog", catalog);
        //catalogRepository.save(new Catalog("ffff", "fdsaf", "https://avatars.mds.yandex.net/i?id=329a652c9e349faef992e77a18534d0bd8471613-8210080-images-thumbs&n=13", "car", "1000"));
        //catalogRepository.save(new Catalog("аааа", "fdsaf", "https://avatars.mds.yandex.net/i?id=329a652c9e349faef992e77a18534d0bd8471613-8210080-images-thumbs&n=13", "car", "1000"));

        return "catalog";
    }
}
