package com.example.sc.controllers;

import com.example.sc.entity.Status;
import com.example.sc.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/TypeRepairs")
    public String type(Map<String, Object> model){

        model.put("typerep", statusService.findAll());
        return "TypeRepairs";
    }

    @RequestMapping("/UpdateTypeRepair")
    public String UpdateQuestion(@ModelAttribute("typerepair") Status status) {
        statusService.update(status);
        return "redirect:/TypeRepairs";
    }

    @GetMapping("/DeleteTypeRepair")
    public String DeleteOrd(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {

        statusService.delete(id_delete);
        return "redirect:/TypeRepairs";
    }
}
