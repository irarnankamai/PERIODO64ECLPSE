package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless

public class ClienteDAO {

	@PersistenceContext //Para llamar a la conexion de la base datos, em le esta enlacando a la BD
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);  //persist es como un enter 
		
	}

	
	public void update(Cliente cliente) {
		em.merge(cliente); //merge para eliminar
		
	}
	
	
	public void delete(String cedula) {
		Cliente cliente = this.read(cedula);
	    em.remove(cliente);	
		
	}
	
	
	public Cliente read(String cedula) {
		Cliente cliente = em.find(Cliente.class, cedula); //find es leer .., la clave primaria = cedula
		return null;
	}
	
	
	public List<Cliente> getAll(){
		
		String jpql = "SELECT c FROM Cliente c"; // solo importa el nombre de la entidades/ de la clase. Si importa mayusculas y minusculas
		Query query = em.createQuery(jpql, Cliente.class);  
		return query.getResultList();  //devuelve la lista de clientes
	}
	
	
}
