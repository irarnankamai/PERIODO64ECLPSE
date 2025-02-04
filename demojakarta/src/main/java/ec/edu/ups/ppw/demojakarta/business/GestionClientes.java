package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;
	
	public Cliente getCliente(String cedula)throws Exception{
		if(cedula.length() !=10) {
			throw new Exception("Cedula incorrecta");
		}
		
		Cliente cliente = daoCliente.read(cedula);
		
		if(cedula == null) 
			throw new Exception("Cliente no existe");
			return cliente;
		}
		
		public List<Cliente> getClientes(){
			return daoCliente.getAll();
		}

		public void createCliente(Cliente cliente)  throws Exception {
			if(cliente.getCedula().length() !=10) {
				throw new Exception("Cedula incorrecta");
		}
		
			daoCliente.insert(cliente);
		}
		
		
		
		  public void updateCliente(Cliente cliente) throws Exception {
				if (cliente.getCedula().length()!=10) {
					throw new Exception("Cliente no existe");
			}
				daoCliente.update(cliente);	
				
		}
		  public void deleteCliente(String cedula) throws Exception {
			 
			        if (cedula.length() != 10) {
			            throw new Exception("Cedula incorrecta");
			        }

			        Cliente cliente = daoCliente.read(cedula);

			        if (cliente == null) {
			            throw new Exception("Cliente no existe");
			        }

			        daoCliente.delete(cedula);
			    }  
 		  
		    
}
