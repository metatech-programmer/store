package com.project.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventaryController {

    @GetMapping("/inventario")
    public String index() {
        return "pages/inventary";
    }

    @GetMapping("/inventario/agregar")
    public String addInventary() {
        return "pages/addInventary";
    }

    }

