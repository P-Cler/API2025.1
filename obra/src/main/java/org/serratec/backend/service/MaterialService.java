package org.serratec.backend.service;

import java.util.List;
import java.util.Objects;

import org.serratec.backend.entity.Material;
import org.serratec.backend.exception.ResourceNotFoundException;
import org.serratec.backend.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    public Material buscarPorId(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Material não encontrado com ID: " + id));
    }

    public Material inserir(Material material) {
        return materialRepository.save(material);
    }

    public Material atualizar(Long id, Material novoMaterial) {
        Material existente = materialRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Material não encontrado"));
        
        if (!Objects.equals(existente.getNome(), novoMaterial.getNome())) {
            existente.setNome(novoMaterial.getNome());
        }

        if (!Objects.equals(existente.getDescricao(), novoMaterial.getDescricao())) {
            existente.setDescricao(novoMaterial.getDescricao());
        }

        if (!Objects.equals(existente.getPreco(), novoMaterial.getPreco())) {
            existente.setPreco(novoMaterial.getPreco());
        }

        if (!Objects.equals(existente.getCategoria(), novoMaterial.getCategoria())) {
            existente.setCategoria(novoMaterial.getCategoria());
        }
        
        if (!Objects.equals(existente.getImage(), novoMaterial.getImage())) {
            existente.setImage(novoMaterial.getImage());
        }


        
        return materialRepository.save(existente);
    }

    public void apagar(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Material não encontrado com ID: " + id);
        }
        materialRepository.deleteById(id);
    }
}