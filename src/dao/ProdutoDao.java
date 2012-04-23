package dao;

import java.util.List;

import modelo.Produto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProdutoDao {

	private final Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void salva(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}
	
	public void deleta(Long id){
		Transaction tx = session.beginTransaction();
		Produto produtoDelete = (Produto) session.load(Produto.class,id);
		session.delete(produtoDelete);
		tx.commit();
	}
	
	public void atualiza(Produto produto){
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
	}
	
	public Produto carrega(Long id){
		return (Produto) session.load(Produto.class,id);
	}
	
	public List<Produto> listaTudo() {
		return session.createCriteria(Produto.class).list();
	}

	public List<Produto> busca(String nome) {
		return session.createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}
}
