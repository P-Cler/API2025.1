package org.serratec.backend.controller;

import org.serratec.backend.entity.Obra;
import org.serratec.backend.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private ObraService obraService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Obra> buscarObraPorId(@PathVariable Long id) {
        return ResponseEntity.ok(obraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Obra> criarObra(@RequestBody Obra obra) {
        Obra novaObra = obraService.criar(obra, obra.getCliente().getId());
        return new ResponseEntity<>(novaObra, HttpStatus.CREATED);
    }

    @PostMapping("/{obraId}/materiais")
    public ResponseEntity<Obra> adicionarMaterialNaObra(
            @PathVariable Long obraId,
            @RequestBody Map<String, Object> payload) {
        
        Long materialId = Long.parseLong(payload.get("materialId").toString());
        int quantidade = Integer.parseInt(payload.get("quantidade").toString());
        double precoUnitario = Double.parseDouble(payload.get("precoUnitario").toString());

        Obra obraAtualizada = obraService.adicionarMaterial(obraId, materialId, quantidade, precoUnitario);
        return ResponseEntity.ok(obraAtualizada);
    }
}