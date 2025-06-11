package org.serratec.backend.service;

import java.util.List;

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

    public Material atualizar(Long id, Material materialNovo) {
        Material materialExistente = buscarPorId(id);
        materialExistente.setDescricao(materialNovo.getDescricao());
        return materialRepository.save(materialExistente);
    }

    public void apagar(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Material não encontrado com ID: " + id);
        }
        materialRepository.deleteById(id);
    }
}