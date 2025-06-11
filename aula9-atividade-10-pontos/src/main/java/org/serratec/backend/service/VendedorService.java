package org.serratec.backend.service;

import java.util.List;

import org.serratec.backend.dto.VendedorRequestDTO;
import org.serratec.backend.dto.VendedorResponseDTO;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public VendedorResponseDTO listarPorId(Long id) {
        Vendedor vendedor = vendedorRepository.findById(id)
            .orElseThrow(() -> new LancamentoVendasException("Vendedor não encontrado com o id: " + id));

        return new VendedorResponseDTO(
            vendedor.getCodigoVendedor(),
            vendedor.getNome(),
            vendedor.getEmail(),
            vendedor.getSalario()
        );
    }


    public List<Vendedor> listarTodos() {
        return vendedorRepository.findAll();
    }

    public Vendedor inserirVendedor(VendedorRequestDTO dto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(dto.getNome());
        vendedor.setEmail(dto.getEmail());
        vendedor.setSalario(dto.getSalario());

        return vendedorRepository.save(vendedor);
    }


    public VendedorResponseDTO atualizar(Long id, Vendedor vendedorAtualizado) {
        Vendedor vendedorExistente = vendedorRepository.findById(id)
            .orElseThrow(() -> new LancamentoVendasException("Vendedor não encontrado com o id: " + id));

        vendedorExistente.setNome(vendedorAtualizado.getNome());
        vendedorExistente.setEmail(vendedorAtualizado.getEmail());
        vendedorExistente.setSalario(vendedorAtualizado.getSalario());

        Vendedor atualizado = vendedorRepository.save(vendedorExistente);

        return new VendedorResponseDTO(
            atualizado.getCodigoVendedor(),
            atualizado.getNome(),
            atualizado.getEmail(),
            atualizado.getSalario()
        );
    }



    public void deletar(Long id) {
        if (!vendedorRepository.existsById(id)) {
            throw new LancamentoVendasException("Vendedor não encontrado para exclusão");
        }
        vendedorRepository.deleteById(id);
    }
}