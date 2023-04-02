package com.sip.gestion_de_stock.controllers;

import com.sip.gestion_de_stock.entities.Fournisseur;
import com.sip.gestion_de_stock.repositories.FournisseurRepository;
import com.sip.gestion_de_stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.sip.gestion_de_stock.entities.Produit;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
@RequestMapping("/fournisseurs/")
public class fournisseurController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";


    @Autowired
    FournisseurRepository fournisseurRepository;

    @GetMapping("list")
    public String ListFournisseur(Model model ){

        model.addAttribute("fournisseurs",fournisseurRepository.findAll());
        return "fournisseurs/listFournisseur.html";
    }


    @GetMapping("add")
    public String showAddFournisseurForm(Model model) {
        System.out.println("******************************************************");
        Fournisseur fournisseur = new Fournisseur();// object dont la valeur des attributs par defaut
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseurs/addFournisseur";
    }
    @PostMapping("addFournisseur")
    public String addFournisseur(@Valid Fournisseur fournisseur, BindingResult result,
                              @RequestParam("files") MultipartFile[] files) {
        System.out.println("--------------------");
       /* if (result.hasErrors()) {
            return "fournisseurs/addFournisseur";
        }*/
        // upload du ficher
        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        fournisseur.setLogo(fileName.toString());

        System.out.println(fournisseur);
        fournisseurRepository.save(fournisseur);
        return "redirect:list";
    }

    @GetMapping("show/{id}")
    public String showFournisseur(@PathVariable("id") long id, Model model) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
        List<Produit> products = fournisseurRepository.findProduitByFournisseur(id);
        for (Produit a : products)
            System.out.println("Article = " + a.getLibelle());

        model.addAttribute("products", products);
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseurs/showFournisseur";
    }
}
