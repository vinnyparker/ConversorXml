package br.com.tabernatech.conversorxml.service;

import br.com.tabernatech.conversorxml.model.Pais;
import br.com.tabernatech.conversorxml.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;

    public void saveAll(List<Pais> paisList) {
        paisRepository.saveAll(paisList);
    }
}
