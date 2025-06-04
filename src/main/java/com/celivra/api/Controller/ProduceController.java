package com.celivra.api.Controller;

import com.celivra.api.Entity.Produce;
import com.celivra.api.Service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/produce")
public class ProduceController {
    @Autowired
    private ProduceService produceService;
    @PostMapping("/getall")
    public List<Produce> getAll() {
        List<Produce> result = produceService.findAll();
        if(result == null){
            return null;
        }
        return result;
    }

}
