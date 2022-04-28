package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CasoDao;
import br.com.fiap.jpa.dao.ItemDao;
import br.com.fiap.jpa.dao.SistemaDao;
import br.com.fiap.jpa.dao.UsuarioDao;
import br.com.fiap.jpa.dao.impl.CasoDaoImpl;
import br.com.fiap.jpa.dao.impl.ItemDaoImpl;
import br.com.fiap.jpa.dao.impl.SistemaDaoImpl;
import br.com.fiap.jpa.dao.impl.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.Caso;
import br.com.fiap.jpa.entity.Item;
import br.com.fiap.jpa.entity.Sistema;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploCadastro {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//Sistema
			Sistema sistema = new Sistema("Sistema teste");
			SistemaDao sistemaDao = new SistemaDaoImpl(em);
			sistemaDao.cadastrar(sistema);
			sistemaDao.commit();
			
			//Caso
			Caso caso = new Caso(sistema, "Teste", "Caso 1 teste teste teste");
			CasoDao casoDao = new CasoDaoImpl(em);
			casoDao.cadastrar(caso);
			casoDao.commit();
			
			//Item
			Item item = new Item(caso, "Item teste");
			ItemDao itemDao = new ItemDaoImpl(em);
			itemDao.cadastrar(item);
			itemDao.commit();
			
			//Usuario
			Usuario usuario = new Usuario("João");
			UsuarioDao usuarioDao = new UsuarioDaoImpl(em);
			usuarioDao.cadastrar(usuario);
			usuarioDao.commit();
			
		}catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}
