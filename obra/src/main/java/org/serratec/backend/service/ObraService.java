package org.serratec.backend.service;

import org.serratec.backend.entity.Obra;
import org.serratec.backend.entity.ObraMaterial;
import org.serratec.backend.entity.Material;
import org.serratec.backend.exception.ResourceNotFoundException;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.repository.MaterialRepository;
import org.serratec.backend.repository.ObraMaterialRepository;
import org.serratec.backend.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private MaterialRepository materialRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ObraMaterialRepository obraMaterialRepository;

    public Obra buscarPorId(Long id) {
        return obraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada com ID: " + id));
    }

    @Transactional
    public Obra criar(Obra obra, Long clienteId) {
        clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + clienteId));
        
        obra.setTotalGasto(0.0);
        return obraRepository.save(obra);
    }
    
    @Transactional
    public Obra adicionarMaterial(Long obraId, Long materialId, int quantidade, double precoUnitario) {
        Obra obra = buscarPorId(obraId);
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Material não encontrado com ID: " + materialId));

        ObraMaterial obraMaterial = new ObraMaterial();
        obraMaterial.setObra(obra);
        obraMaterial.setMaterial(material);
        obraMaterial.setQuantidade(quantidade);
        obraMaterial.setPrecoMaterial(precoUnitario);
        
        obraMaterialRepository.save(obraMaterial);

        double custoAdicional = quantidade * precoUnitario;
        obra.setTotalGasto(obra.getTotalGasto() + custoAdicional);
        
        return obraRepository.save(obra);
    }
}