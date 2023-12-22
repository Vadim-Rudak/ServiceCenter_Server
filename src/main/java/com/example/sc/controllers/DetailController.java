package com.example.sc.controllers;

import com.example.sc.entity.Details;
import com.example.sc.entity.Ord;
import com.example.sc.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/Parts")
    public String cust(Map<String, Object> model){

//        Iterable<infocustumer> custumers = custumerRepo.findAll();
        model.put("details", detailService.findAll());

        return "Parts";
    }

    @GetMapping("/PartsOrd")
    public String partsOrd(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model){

//        Iterable<infocustumer> custumers = custumerRepo.findAll();
        model.put("id",id);
        if (detailService.getByOrdId(id).size()!=0){
            model.put("details", detailService.getByOrdId(id));
        }
        return "PartsOrd";
    }

    @GetMapping("/PageAddD")
    public String pageaddD(@RequestParam(name="id", required=false, defaultValue="") int id,Map<String, Object> model){
        model.put("id", id);
        return "AddDetail";
    }

    @RequestMapping("/AddDetail")
    public String add(@Valid @ModelAttribute("details")Details details, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("details",details);
            model.put("id", details.getOrd_id());
            model.put("name_detailError",errorsMap.get("name_detailError"));
            model.put("price_detailError",errorsMap.get("price_detailError"));
//            System.out.println("FF" + errorsMap.get("client.phone_numberError"));
            System.out.println(details.getOrd_id());
            return "AddDetail";
        }else {
            detailService.save(details);
            model.put("id",details.getOrd_id());
            model.put("details", detailService.getByOrdId(details.getOrd_id()));
            return "PartsOrd";
        }
    }

    @RequestMapping("/UpdateD")
    public String UpdateD(@RequestParam(name="id", required=false, defaultValue="") int id, Map<String, Object> model) {
        model.put("details",detailService.getById(id));
        return "UpDetail";
    }

    @RequestMapping("/UpdatePart")
    public String UpdateQuestion(@Valid @ModelAttribute("details") Details details, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("details",details);
            model.put("name_detailError",errorsMap.get("name_detailError"));
            model.put("price_detailError",errorsMap.get("price_detailError"));

//            System.out.println("FF" + errorsMap.get("client.phone_numberError"));
            return "UpDetail2";
        }else {
            System.out.println(details.getDetails_id());
            detailService.update(details);
            model.put("id",details.getOrd_id());
            model.put("details", detailService.getByOrdId(details.getOrd_id()));
            return "PartsOrd";
        }
    }

    @GetMapping("/DeletePart")
    public String DeleteOrd(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {

        int s = detailService.getById(id_delete).getOrd_id();
        detailService.delete(id_delete);
        model.put("id",s);
        if (detailService.getByOrdId(s).size()!=0){
            model.put("details", detailService.getByOrdId(s));
        }
        return "PartsOrd";
    }

    @GetMapping("/DeletePart2")
    public String DeleteOrd2(@RequestParam(name="id", required=false, defaultValue="") int id_delete, Map<String, Object> model) {
        detailService.delete(id_delete);
        return "redirect:/Parts";
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
