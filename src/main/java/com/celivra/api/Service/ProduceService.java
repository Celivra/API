package com.celivra.api.Service;

import com.celivra.api.Entity.Produce;
import com.celivra.api.Mapper.ProduceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceService {

    @Autowired
    ProduceMapper produceMapper;

    public Produce findById(Long id) {
        return produceMapper.findById(id);
    }
    public List<Produce> findAll() {
        return produceMapper.findAll();
    }
    public void delete(Long id) {
        produceMapper.delete(id);
    }
}
