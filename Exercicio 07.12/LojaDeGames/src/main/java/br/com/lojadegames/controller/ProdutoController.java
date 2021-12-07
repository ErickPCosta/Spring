package br.com.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.lojadegames.model.Produto;
import br.com.lojadegames.repository.CategoriaRepository;
import br.com.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*",allowedHeaders="*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity <List<Produto>> getAll()
	{ 
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Produto> getById(@PathVariable Long id) 
	{ 
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity <List<Produto>> getByNome (@Valid @PathVariable String nome)
	{
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity <List<Produto>> getByDescricao (@Valid @PathVariable String descricao)
	{
		return ResponseEntity.ok(produtoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto (@Valid @RequestBody Produto produto){
		return categoriaRepository.findById(produto.getCategoria().getId())
		.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity <Produto> putProduto (@Valid @RequestBody Produto produto)
	{
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)))   
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		   return produtoRepository.findById(id)
		           .map(resposta -> 
		           {
		               produtoRepository.deleteById(id);
		               return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		           })
		           .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

}
