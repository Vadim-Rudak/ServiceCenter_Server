package com.example.sc.controllers;



import com.example.sc.config.AppConfig;
import com.example.sc.entity.Client;
import com.example.sc.entity.Ord;
import com.example.sc.entity.Warranty;
import com.example.sc.service.ClientService;
import com.example.sc.service.OrderService;
import com.example.sc.service.StatusService;
import com.example.sc.service.WarrantyService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class TopPageController {

    @Autowired
    OrderService orderService;

    @Autowired
    ClientService clientService;

    @Autowired
    StatusService statusService;

    @Autowired
    WarrantyService warrantyService;

    //перед использованием программы редактировать i, т.к. может повториться id
    public int i = 25;

    @GetMapping("/")
    public String startpage(Map<String, Object> model, Authentication authentication) {
        model.put("userstatus",authentication.getAuthorities());
        return "StartPage";
    }

    @GetMapping("/menu")
    public String menu(Map<String, Object> model){
        model.put("order", orderService.findAll());
        return "TopPage";
    }

    @RequestMapping("/UpdateOrd")
    public String UpdateQuestion(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model) {
        model.put("ord",orderService.getById(id));
        return "UpOrd";
    }

    @RequestMapping("/PageUp")
    public String upOrd(@Valid @ModelAttribute("ord")Ord ord, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("ord",ord);
            model.put("name_ordError",errorsMap.get("name_ordError"));
            model.put("date_add_ordError",errorsMap.get("date_add_ordError"));
            model.put("breakdown_infoError",errorsMap.get("breakdown_infoError"));
            model.put("info_statusError",errorsMap.get("status.info_statusError"));
            model.put("warrantyError",errorsMap.get("warranty.warrantyError"));
            model.put("date_addError",errorsMap.get("warranty.date_addError"));
            model.put("validityError",errorsMap.get("warranty.validityError"));
            model.put("surnameError",errorsMap.get("client.surnameError"));
            model.put("nameError",errorsMap.get("client.nameError"));
            model.put("patronymicError",errorsMap.get("client.patronymicError"));
            model.put("addressError",errorsMap.get("client.addressError"));
            model.put("phone_numberError",errorsMap.get("client.phone_numberError"));
//            System.out.println("FF" + errorsMap.get("client.phone_numberError"));
            return "Up2Ord";
        }else {
            ord.getClient().setInfoclient_id(ord.getInfoclient_id());
            ord.getStatus().setStatus_id(ord.getStatus_id());
            ord.getWarranty().setWarranty_id(ord.getWarranty_id());
            clientService.update(ord.getClient());
            statusService.update(ord.getStatus());
            warrantyService.update(ord.getWarranty());
            orderService.update(ord);
//            System.out.println(ord.getStatus().getStatus_id());
            return "redirect:/menu";
        }
    }

    @GetMapping("/DeleteOrd")
    public String DeleteOrd(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {

        orderService.delete(id_delete);

        return "redirect:/menu";
    }

    @GetMapping("/PageAdd")
    public String pageadd(Map<String, Object> model){
        return "AddOrd";
    }

    @GetMapping("/PageInfoWork")
    public String pageInfo(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model){
        model.put("info",orderService.getById(id).getBreakdown_info());
        return "InfoWork";
    }

    @GetMapping("/PageInfoClient")
    public String pageInfoClient(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model){
        model.put("InfoClient",clientService.getById(id));
        return "InfoClient";
    }

    @GetMapping("/PageInfoWarranty")
    public String pageInfoWarranty(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model){
        model.put("InfoWarranty",warrantyService.getById(id));
        return "InfoWarranty";
    }

    @RequestMapping("/AddOrd")
    public String add(@Valid @ModelAttribute("ord")Ord ord, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("ord",ord);
            model.put("name_ordError",errorsMap.get("name_ordError"));
            model.put("date_add_ordError",errorsMap.get("date_add_ordError"));
            model.put("breakdown_infoError",errorsMap.get("breakdown_infoError"));
            model.put("info_statusError",errorsMap.get("status.info_statusError"));
            model.put("warrantyError",errorsMap.get("warranty.warrantyError"));
            model.put("date_addError",errorsMap.get("warranty.date_addError"));
            model.put("validityError",errorsMap.get("warranty.validityError"));
            model.put("surnameError",errorsMap.get("client.surnameError"));
            model.put("nameError",errorsMap.get("client.nameError"));
            model.put("patronymicError",errorsMap.get("client.patronymicError"));
            model.put("addressError",errorsMap.get("client.addressError"));
            model.put("phone_numberError",errorsMap.get("client.phone_numberError"));
//            System.out.println("FF" + errorsMap.get("client.phone_numberError"));
            return "AddOrd";
        }else {
            i++;
            ord.getClient().setInfoclient_id(i);
            ord.getStatus().setStatus_id(i);
            ord.getWarranty().setWarranty_id(i);
            ord.setInfoclient_id(i);
            ord.setStatus_id(i);
            ord.setWarranty_id(i);
            clientService.save(ord.getClient());
            statusService.save(ord.getStatus());
            warrantyService.save(ord.getWarranty());
            orderService.save(ord);
            return "redirect:/menu";
        }
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
