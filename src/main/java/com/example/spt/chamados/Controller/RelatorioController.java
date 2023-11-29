package com.example.spt.chamados.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Service.ChamadoService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/consulta")
    public ResponseEntity<?> getRelatorio(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime primeiraData,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime segundaData) {
        List<Chamado> lista = chamadoService.getRelatorios(primeiraData, segundaData);
        if (lista.isEmpty()) {
            return ResponseEntity.status(403).body("Chamados não encontrados");
        }
        return ResponseEntity.ok(lista);
    }
}
