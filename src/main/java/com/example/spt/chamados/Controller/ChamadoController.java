package com.example.spt.chamados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Service.ChamadoService;



@RestController
@RequestMapping("/ticket")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping("/create")
    public ResponseEntity<?> criarChamado(@RequestBody Chamado ticket){
        chamadoService.createSupportTicket(ticket);
        return ResponseEntity.status(200).body("Chamado Criado");
    }

    @PostMapping("/listar/{usuario}")
    public ResponseEntity<?> listarChamadoPorAutor(@PathVariable String usuario){
        List<Chamado> lista = chamadoService.getAutorDoChamado(usuario);
        return ResponseEntity.status(200).body(lista);
    }

    // @PutMapping(value="/{id}")
    // public ResponseEntity<?> alterarStatus(@PathVariable String id) {
    //     //TODO: process PUT request
        
    //     return entity;
    // }
}
