package com.project.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.store.entities.ProductoEntity;
import com.project.store.models.services.IProductoService;

@Controller
public class MainController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<ProductoEntity> productos = productoService.findAll();

        model.addAttribute("productos", productos);

        return "/pages/main";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "search", required = false) String search) {
        List<ProductoEntity> productos = productoService.findByNombreProducto(search);

        if (search == null) {

            productos = productoService.findAll();

        }
        model.addAttribute("productos", productos);

        return "/pages/main";
    }

}
