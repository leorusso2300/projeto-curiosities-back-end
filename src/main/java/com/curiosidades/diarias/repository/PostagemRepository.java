package com.curiosidades.diarias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curiosidades.diarias.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, String> {

	public List<Postagem> findAllByDataContainingIgnoreCase(String data);

}
