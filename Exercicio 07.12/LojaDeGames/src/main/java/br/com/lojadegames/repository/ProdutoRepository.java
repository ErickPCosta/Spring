package br.com.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojadegames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
}

