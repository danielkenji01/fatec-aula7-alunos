package edu.fatec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public ResponseEntity<?> buscarAlunos() {
		List<Aluno> alunos = alunoRepository.findAll();
		
		return ResponseEntity.ok(alunos);
	}
	
	@PostMapping("/aluno/adicionar")
	public String adicionarAluno(@RequestBody Aluno aluno) {
		alunoRepository.save(aluno);
		
		return "Aluno adicionado com sucesso";
	}
	
}