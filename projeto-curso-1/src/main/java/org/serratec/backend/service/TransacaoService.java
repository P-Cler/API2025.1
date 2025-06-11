package org.serratec.backend.service;

import org.serratec.backend.dto.TransacaoRequestDTO;
import org.serratec.backend.dto.TransacaoResponseDTO;
import org.serratec.backend.entity.Conta;
import org.serratec.backend.entity.Transacao;
import org.serratec.backend.repository.ContaRepository;
import org.serratec.backend.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public TransacaoResponseDTO realizarTransacao(TransacaoRequestDTO dto) throws Exception {
        Optional<Conta> contaOrigemOpt = contaRepository.findById(dto.getContaOrigemId());
        Optional<Conta> contaDestinoOpt = contaRepository.findById(dto.getContaDestinoId());

        if (dto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Valor da transação deve ser positivo.");
        }

        if (contaOrigemOpt.isEmpty() || contaDestinoOpt.isEmpty()) {
            throw new Exception("Conta origem ou destino não encontrada.");
        }

        Conta contaOrigem = contaOrigemOpt.get();
        Conta contaDestino = contaDestinoOpt.get();

        if (contaOrigem.getSaldo().compareTo(dto.getValor()) < 0) {
            throw new Exception("Saldo insuficiente na conta de origem.");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(dto.getValor()));
        contaDestino.setSaldo(contaDestino.getSaldo().add(dto.getValor()));

        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);

        Transacao transacao = new Transacao();
        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);
        transacao.setValor(dto.getValor());
        transacao.setDataHora(LocalDateTime.now());

        Transacao salva = transacaoRepository.save(transacao);

        return new TransacaoResponseDTO(
            salva.getId(),
            contaOrigem.getNumeroConta(),
            contaDestino.getNumeroConta(),
            salva.getValor(),
            salva.getDataHora()
        );
    }

    public List<TransacaoResponseDTO> listarTransacoes() {
        return transacaoRepository.findAll().stream().map(t ->
            new TransacaoResponseDTO(
                t.getId(),
                t.getContaOrigem().getNumeroConta(),
                t.getContaDestino().getNumeroConta(),
                t.getValor(),
                t.getDataHora()
            )
        ).collect(Collectors.toList());
    }
}
