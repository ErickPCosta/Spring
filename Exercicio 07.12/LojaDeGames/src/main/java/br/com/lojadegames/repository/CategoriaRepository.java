package br.com.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lojadegames.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	
	public List <Categoria> findAllByTipoContainingIgnoreCase(String tipo);
}
