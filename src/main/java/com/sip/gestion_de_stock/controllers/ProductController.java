package com.sip.gestion_de_stock.controllers;

import com.sip.gestion_de_stock.entities.Fournisseur;
import com.sip.gestion_de_stock.entities.Produit;
import com.sip.gestion_de_stock.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sip.gestion_de_stock.repositories.ProductRepository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.BindingResult;
import java.nio.file.Path;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
@RequestMapping("/product/")
public class ProductController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";

    @Autowired
     ProductRepository productRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @GetMapping("list")
    public String ListProduct(Model model ){

        model.addAttribute("products",productRepository.findAll());
        return "product/listProduct";
    }
    @GetMapping("add")
    public String showAddProductForm(Produit product, Model model) {

        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
        model.addAttribute("product", new Produit());
        return "product/addProduct";
    }

    @PostMapping("add")
    public String addProduct(@Valid Produit product, BindingResult result, @RequestParam(name = "idFournisseur", required = false) Long p, @RequestParam("files") MultipartFile[] files, @RequestParam("filesProfilePicture") MultipartFile[] filesProfilePicture) {
System.out.println("----------------------------------->"+product.getDateExpiration());
        Fournisseur provider = fournisseurRepository.findById(p)
                .orElseThrow(()-> new IllegalArgumentException("Invalid fournisseur Id:" + p));
        product.setIdFournisseur(provider);

        /// part upload
        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath =  Paths.get(uploadDirectory, file.getOriginalFilename());

        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder fileName1 = new StringBuilder();
        MultipartFile file1 = filesProfilePicture[0];
        Path fileNameAndPath1 = Paths.get(uploadDirectory, file1.getOriginalFilename());

        fileName1.append(file1.getOriginalFilename());
        try {
            Files.write(fileNameAndPath1, file1.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setPhotoFace(fileName.toString());
        product.setPhotoProfil(fileName1.toString());

        productRepository.save(product);
        return "redirect:list";

    }
    @GetMapping("show/{id}")
    public String showProductDetails(@PathVariable("id") long id, Model model) {
        System.out.println(id);

        Produit product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid  Id:" + id));

        model.addAttribute("product", product);
        return "product/showProduct";
    }

}

