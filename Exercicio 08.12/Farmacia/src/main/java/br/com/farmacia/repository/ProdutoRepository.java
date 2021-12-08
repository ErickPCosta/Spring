package br.com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findAllByNomeContainingIgnoreCase(String nome);//Busca o produto pelo nome
	
	public List <Produto> findByNomeAndLaboratorioContainingIgnoreCase(String nome, String laboratorio);//Busca pelo nome e laboratório
	
}
