package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.entity.Material;
import org.serratec.backend.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/materiais")
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> listarMateriais() {
        return materialService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> buscarMaterialPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Material> criarMaterial(@Valid @RequestBody Material material) {
        return new ResponseEntity<>(materialService.inserir(material), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> atualizarMaterial(@PathVariable Long id, @Valid @RequestBody Material material) {
        return ResponseEntity.ok(materialService.atualizar(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarMaterial(@PathVariable Long id) {
        materialService.apagar(id);
        return ResponseEntity.noContent().build();
    }
}