package controller;

import java.util.List;

import modelo.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import dao.ProdutoDao;

@Resource
public class ProdutosController {
	
	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;
	
	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get @Path("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}
	
	@Post @Path("/produtos")
	public void adiciona(Produto produto) {
		
		if (produto.getNome() == null || produto.getNome().length() < 3) {
			validator.add(new ValidationMessage(
			"Nome é obrigatório e precisa ter mais de 3 letras", "produto.nome"));
		}
		
		if (produto.getDescricao() == null || produto.getDescricao().length() > 40) {
			validator.add(new ValidationMessage(
			"Descrição é obrigatória não pode ter mais que 40 letras",
			"produto.descricao"));
		}
		
		if (produto.getPreco() <= 0) {
			validator.add(new ValidationMessage(
			"Preço precisa ser positivo", "produto.preco"));
		}
		
		validator.onErrorUsePageOf(ProdutosController.class).formulario();
		dao.salva(produto);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Delete @Path("/produtos/{id}")
	public void remove(Long id){
		dao.deleta(id);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Get @Path("/produtos/novo")
	public void formulario(){
	}
	
	@Get @Path("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}
	
	@Put @Path("/produtos/{produto.id}")
	public void altera(Produto produto) {
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/produtos/busca")
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}
}
