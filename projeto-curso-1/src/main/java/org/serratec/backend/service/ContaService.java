package org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.backend.dto.ContaDTO;
import org.serratec.backend.dto.ContaRequestDTO;
import org.serratec.backend.entity.Conta;
import org.serratec.backend.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<ContaDTO> listar() {
		return repository.findAll().stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	public Optional<ContaDTO> buscarPorId(Long id) {
		return repository.findById(id).map(this::toDTO);
	}

	public ContaDTO inserir(ContaRequestDTO dto) {
		Conta conta = new Conta();
		conta.setNomeTitular(dto.getNomeTitular());
		conta.setSenha(passwordEncoder.encode(dto.getSenha()));
		conta.setCpf(dto.getCpf());
		conta.setNumeroConta(dto.getNumeroConta());
		conta.setSaldo(dto.getSaldo());
		return toDTO(repository.save(conta));
	}

	public List<ContaDTO> inserirLista(List<ContaRequestDTO> dtos) {
		List<Conta> contas = dtos.stream().map(dto -> {
			Conta conta = new Conta();
			conta.setNomeTitular(dto.getNomeTitular());
			conta.setSenha(passwordEncoder.encode(dto.getSenha()));
			return conta;
		}).collect(Collectors.toList());

		return repository.saveAll(contas).stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	public Optional<ContaDTO> atualizar(Long id, ContaRequestDTO dto) {
		if (!repository.existsById(id)) return Optional.empty();

		Conta conta = new Conta();
		conta.setId(id);
		conta.setNomeTitular(dto.getNomeTitular());
		conta.setSenha(passwordEncoder.encode(dto.getSenha()));
		return Optional.of(toDTO(repository.save(conta)));
	}

	public boolean remover(Long id) {
		if (!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}

	private ContaDTO toDTO(Conta conta) {
		return new ContaDTO(conta.getId(), conta.getNomeTitular(), conta.getCpf(), conta.getNumeroConta(), conta.getSaldo());
	}
}
