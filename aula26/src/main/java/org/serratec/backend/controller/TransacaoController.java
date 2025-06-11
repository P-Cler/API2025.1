package org.serratec.backend.controller;

import org.serratec.backend.dto.TransacaoRequestDTO;
import org.serratec.backend.dto.TransacaoResponseDTO;
import org.serratec.backend.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pix")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<?> realizar(@RequestBody TransacaoRequestDTO dto) {
        try {
            return ResponseEntity.ok(service.realizarTransacao(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/historico")
    public ResponseEntity<List<TransacaoResponseDTO>> historico() {
        return ResponseEntity.ok(service.listarTransacoes());
    }
}
