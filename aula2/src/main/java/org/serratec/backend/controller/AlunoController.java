package org.serratec.backend.controller;

import org.serratec.backend.entity.Aluno;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private static List<Aluno> alunos = new ArrayList<>();
    
    static {
    	alunos.add(new Aluno(123L, "Cler", "Cler@teste"));
    	alunos.add(new Aluno(321L, "Elton", "Elton@teste"));
    	alunos.add(new Aluno(345L, "Roni", "Roni@teste"));
    	alunos.add(new Aluno(567L, "Arthur", "Arthur@teste"));
    }
    
    @GetMapping("/listar")
    public List<Aluno> listar(){
    	return alunos;
    }
    
    @GetMapping("{matricula}")
    public Aluno buscar(@PathVariable Long matricula) {
    	
    	for (Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
    	
    }
    
    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
    	alunos.add(aluno);
    	return aluno;
    }
    
    @PostMapping("/varios")
    public List<Aluno> inserirVarios(@RequestBody List<Aluno> alunosNovos){
    	alunos.addAll(alunosNovos);
    	return alunos;
    }
    
    @DeleteMapping("/{matricula}")
    public List<Aluno> apagar(@PathVariable Long matricula) {
    	for (Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				alunos.remove(aluno);
				return alunos;
			}
			return alunos;
		}
		return null;
    }
    
    @PutMapping("/{matricula}")
    public Aluno alterarNome(@PathVariable Long matricula, @RequestBody Aluno aluno) {
    	for (Aluno alunoAlterado : alunos) {
			if(alunoAlterado.getMatricula().equals(matricula)) {
				alunoAlterado.setNome("Nome Alterado");
				alunoAlterado.setEmail("EmailAlterado@email");
			}
			return aluno;
		}
		return null;
    }
}
