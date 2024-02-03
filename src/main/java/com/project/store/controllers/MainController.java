package com.project.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return "index.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<ProductoEntity> allProducts = !productoService.findAll().isEmpty() ? productoService.findAll() : null;

        if (allProducts == null) {
            model.addAttribute("producto", "No hay productos en el inventario");
        } else {
            model.addAttribute("productos", allProducts);
        }

        return "/pages/main.html";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "search", required = false) String search) {
        List<ProductoEntity> products = !productoService.findByNombreProducto(search).isEmpty() ? productoService.findByNombreProducto(search) : null;

        List<ProductoEntity> allProducts = !productoService.findAll().isEmpty() ? productoService.findAll() : null;

        if (products == null && allProducts == null) {
            model.addAttribute("producto", "No hay productos en el inventario");
        }

        if (allProducts != null && products == null) {
            model.addAttribute("opcion", "No existe el producto");
            model.addAttribute("productos", allProducts);
        }
        if (allProducts != null && products != null) {

            model.addAttribute("productos", products);
        }

        return "/pages/main.html";
    }

      @GetMapping("/buscar")
    public ResponseEntity<List<ProductoEntity>> buscarProductosPorNombre(@RequestParam String keyword) {
        List<ProductoEntity> resultados = productoService.findByNombreProducto(keyword);
        return ResponseEntity.ok(resultados);
    }

}
