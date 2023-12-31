package com.example.spt.chamados.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spt.chamados.Enum.ChamadoStatus;
import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Service.ChamadoService;

import jakarta.websocket.OnClose;

@RestController
@RequestMapping("/ticket")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping("/create")
    public ResponseEntity<?> criarChamado(@RequestBody Chamado ticket) {
        chamadoService.createSupportTicket(ticket);
        
        return ResponseEntity.status(200).body("Chamado Criado");
    }

    @PostMapping("/listar/{usuario}")
    public ResponseEntity<?> listarChamadoPorAutor(@PathVariable String usuario) {
        List<Chamado> lista = chamadoService.getAutorDoChamado(usuario);
        return ResponseEntity.status(200).body(lista);
    }

    @PutMapping(value = "/{id}/status/{status}")
    public ResponseEntity<?> alterarStatus(@PathVariable Long id, @PathVariable int status) {

        chamadoService.alterarStatus(id, status);
        return ResponseEntity.ok("Alterado para " + status);
    }

}
