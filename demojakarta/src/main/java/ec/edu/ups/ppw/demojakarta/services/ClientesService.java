package ec.edu.ups.ppw.demojakarta.services;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.GestionClientes;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")

/***
 * Solicitudes ejemplo
 * PUT demojakarta/rs/clientes/
 * POST demojakarta/rs/clientes/
 * DELETE demojakarta/rs/clientes/
 * 
 */
public class ClientesService {

	@Inject
	private GestionClientes gClientes;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Cliente cliente) {
		try {
		gClientes.createCliente(cliente);
		return Response.ok(cliente).build();
		}catch (Exception e) {
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
		}
		}
		
	
	
	
	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
public Response update(Cliente cliente) {
		  
		   try {
	            gClientes.updateCliente(cliente);
	            return Response.ok(cliente).build();
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	        }
	}
	
	@DELETE
	@Produces("application/json")
	public Response delete(@QueryParam("id") String cedula) {
	    try {
            gClientes.deleteCliente(cedula);
            return Response.ok(new Respuesta(Respuesta.OK, "Cliente eliminado correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error en DB" )).build();
        }
	}

@GET
@Path("/{cedula}")
public Cliente get(String cedula) {
	Cliente cliente;
	try {
		cliente = gClientes.getCliente(cedula);
		return cliente;
	}catch(Exception e){
		e.printStackTrace();
		return null;	
	}
	
	
}

@GET
@Produces("application/json")
public List<Cliente>list() {
	
	List<Cliente> clientes = gClientes.getClientes();
	return clientes;
	
	
}

}
