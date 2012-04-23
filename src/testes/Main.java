package testes;

import modelo.Produto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		// Cria uma configuração
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Produto produto = (Produto) session.load(Produto.class, 1L);
		produto.setPreco(50);
		produto.setNome("Prateleira");
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
	}

}
