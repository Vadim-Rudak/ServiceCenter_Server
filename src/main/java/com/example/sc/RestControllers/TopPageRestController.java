package com.example.sc.RestControllers;

import com.example.sc.entity.Ord;
import com.example.sc.service.DetailService;
import com.example.sc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopPageRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DetailService detailService;


    @RequestMapping(value = "/OrderDao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms2( Model model) {
        Iterable<Ord> ords = orderService.findAll();
        return ords;
    }

    @RequestMapping(value = "/Detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms23(@RequestParam(name="id", required=false, defaultValue="") Integer id,Model model) {
        return detailService.getByOrdId(id);
    }

    @PostMapping("/OrderUp")
    public ResponseEntity<?> up(@RequestBody Ord ord)
    {
        orderService.update(ord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/OrderDelete")
    public ResponseEntity<?> del(@RequestParam(name="id", required=false, defaultValue="") int id_delete)
    {
        orderService.delete(id_delete);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/OrderAdd")
    public ResponseEntity<?> add(@RequestBody Ord ord)
    {
        orderService.save(ord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
