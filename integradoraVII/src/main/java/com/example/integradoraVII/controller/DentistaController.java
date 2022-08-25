package com.example.integradoraVII.controller;

import com.example.integradoraVII.model.Dentista;
import com.example.integradoraVII.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @GetMapping
    public Dentista salvar(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "nome") String nome,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "numMatricula") String numMatricula,
                           @RequestParam(value = "atendeConvenio") boolean atendeConvenio) {
        return dentistaService.salvar(new Dentista(id, nome, email, numMatricula, atendeConvenio));
    }

    @GetMapping("/buscar")
    public List<Dentista> buscarTodos() {
        return dentistaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        return dentistaService.excluir(id);
    }
}
