package com.example.kurzwork.Controllers;

import com.example.kurzwork.model.Catalog;
import com.example.kurzwork.repository.CatalogRepository;
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
        //catalogRepository.save(new Catalog("e-Lavida", "Volkswagen e-Lavida is a European C—class sedan, which in the third generation shows a significant step forward in terms of exterior style, quality and luxury of the interior compared to its predecessor.", "http://localhost:8080/1.png", "Sedan", "$10000"));
        //catalogRepository.save(new Catalog("Volkswagen Jetta", "The seventh-generation Volkswagen Jetta sedan was unveiled at the North American International Auto Show in Detroit in January 2018.", "http://localhost:8080/2.png", "Sedan", "$10025"));
        //catalogRepository.save(new Catalog("Volkswagen Passat", "Volkswagen Passat 2020 model year received a slightly modified design and new items in terms of technology. The optics, bumpers and front grille have been updated, although all of them have generally retained the same style.", "http://localhost:8080/3.png", "Universal", "$20000"));
        //catalogRepository.save(new Catalog("Volkswagen Phaeton", "The Volkswagen Phaeton of the first generation has been produced since 2002. Phaeton is a representative of the premium segment, its luxurious interior is equipped, to choose from, with a solid rear sofa or two separate rear seats.", "http://localhost:8080/4.png", "Sedan", "$10558"));
        //catalogRepository.save(new Catalog("Volkswagen Passat CC", "Volkswagen Passat CC is a four—door comfort coupe built on the basis of the sixth-generation Passat. The model debuted in early 2008.", "http://localhost:8080/5.png", "Sedan", "$20054"));
        //catalogRepository.save(new Catalog("Volkswagen Saveiro", "Volkswagen Saveiro passenger pickup truck, sold in South American markets, is based on the Gol/Pointer model, which is popular in these countries.", "http://localhost:8080/6.png", "Truck", "$30000"));
        //catalogRepository.save(new Catalog("Taos", "Compact crossover Taos in the product hierarchy of the Volkswagen brand will stand a step below Tiguan and will compete with such market hits as Hyundai Creta, Kia Seltos and Renault Duster.", "http://localhost:8080/7.png", "Universal", "$32000"));
        //catalogRepository.save(new Catalog("Terramont", "The premiere of the restyled Terramont took place in February 2020 in the USA, where it is called Atlas. From the outside of the car of the previous model, it differs in the modified design of the front part, as well as another rear bumper.", "http://localhost:8080/8.png", "SUV", "$40000"));
        //catalogRepository.save(new Catalog("Volkswagen Tiguan", "The Volkswagen Tiguan of the second generation has been produced since 2016. The upgraded version was introduced in 2020. The design of the front and rear parts of the body has been changed.", "http://localhost:8080/9.png", "Hatchback", "$35000"));

        return "catalog";
    }
}
