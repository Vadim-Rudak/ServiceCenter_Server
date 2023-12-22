package com.example.sc.controllers;

import com.example.sc.entity.Warranty;
import com.example.sc.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    @GetMapping("/Repairs")
    public String rep(Map<String, Object> model){

        model.put("warranty", warrantyService.findAll());

        return "Repairs";
    }

    @RequestMapping("/UpdateRepair")
    public String UpdateQuestion(@ModelAttribute("repair") Warranty warranty) {
        warrantyService.update(warranty);
        return "redirect:/Repairs";
    }

    @GetMapping("/DeleteRepair")
    public String DeleteOrd(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {

        warrantyService.delete(id_delete);
        return "redirect:/Repairs";
    }
}
