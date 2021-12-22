package com.curiosidades.diarias.controller;

import java.util.List;

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

import com.curiosidades.diarias.model.Postagem;
import com.curiosidades.diarias.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/data/{data}")
	public ResponseEntity<List<Postagem>> GetByData(@PathVariable String data) {
		return ResponseEntity.ok(repository.findAllByDataContainingIgnoreCase(data));

	}

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem texto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(texto));
	}

	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem texto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(texto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	

}
