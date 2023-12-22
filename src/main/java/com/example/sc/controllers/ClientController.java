package com.example.sc.controllers;

import com.example.sc.dao.InfoClient;
import com.example.sc.entity.Client;
import com.example.sc.entity.Details;
import com.example.sc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/custumer")
    public String cust(Map<String, Object> model){

        model.put("custumers", clientService.findAll());

        return "Custumer";
    }

    @RequestMapping("/UpdateClient")
    public String UpdateClient(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model) {
        model.put("clients",clientService.getById(id));
        return "UpClient";
    }

    @RequestMapping("/UpdateClient2")
    public String UpdateC2(@Valid @ModelAttribute("clients") Client client, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
//            System.out.println(client.getInfoclient_id());
            model.put("clients",client);
            model.put("surnameError",errorsMap.get("surnameError"));
            model.put("nameError",errorsMap.get("nameError"));
            model.put("patronymicError",errorsMap.get("patronymicError"));
            model.put("addressError",errorsMap.get("addressError"));
            model.put("phone_numberError",errorsMap.get("phone_numberError"));

//            System.out.println("FF" + errorsMap.get("client.phone_numberError"));
            return "UpClient2";
        }else {
            clientService.update(client);
            return "redirect:/custumer";
        }
    }

    @GetMapping("/DeleteCustumer")
    public String DeleteOrd(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {

        clientService.delete(id_delete);
        return "redirect:/custumer";
    }

    private Map<String, String> getErrorsMap(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        Map<String, String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
        return errorsMap;
    }
}
