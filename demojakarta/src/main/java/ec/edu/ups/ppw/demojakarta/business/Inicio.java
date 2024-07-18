package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.dao.DetalleFacturaDAO;
import ec.edu.ups.ppw.demojakarta.dao.FacturaDAO;
import ec.edu.ups.ppw.demojakarta.dao.PersonaDAO;
import ec.edu.ups.ppw.demojakarta.dao.ProductoDAO;

import ec.edu.ups.ppw.demojakarta.model.Cliente;
import ec.edu.ups.ppw.demojakarta.model.DetalleFactura;
import ec.edu.ups.ppw.demojakarta.model.Factura;
import ec.edu.ups.ppw.demojakarta.model.Persona;
import ec.edu.ups.ppw.demojakarta.model.Producto;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.util.Date;


@Singleton
@Startup

public class Inicio {
/*
	@Inject
	private ClienteDAO daoCliente;   //estoy trayendo del server, no tiene, me lo crea y devuelve y luego lo saca de la memoria por el Singleton
	
	//todo
	@Inject
    private PersonaDAO daoPersona;
    
    @Inject
    private ProductoDAO daoProducto;
    
    @Inject
    private FacturaDAO daoFactura;
    
    @Inject
    private DetalleFacturaDAO daoDetalleFactura;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola Mundo EJB");
		
		
		Cliente cliente  = new Cliente();
		cliente.setCedula("1450170350");
		cliente.setNombre("Irar Nankamai");
		cliente.setDireccion("Ciudadela la catolica");
		
		daoCliente.insert(cliente);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.err.println(cli.getCedula() + " " + cli.getNombre());
		}
		
		
	}*/
	

	@Inject
	private ClienteDAO daoCliente; 

    @Inject
    private PersonaDAO daoPersona;

    @Inject
    private ProductoDAO daoProducto;

    @Inject
    private FacturaDAO daoFactura;

    @Inject
    private DetalleFacturaDAO daoDetalleFactura;

    @PostConstruct
    public void init() {
    	System.out.println("Hola Mundo EJB");
    	
    	Cliente cliente  = new Cliente();
		cliente.setCedula("1450170350");
		cliente.setNombre("Irar Nankamai");
		cliente.setDireccion("Ciudadela la catolica");
		
		daoCliente.insert(cliente);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.err.println(cli.getCedula() + " " + cli.getNombre());
		}

    	// Crear y guardar personas 
        Persona persona1 = new Persona();
        persona1.setCedula("1450170350");
        persona1.setNombre("Irar Nankamai");
        persona1.setDireccion("Ciudadela la Católica");
        daoPersona.insert(persona1);

        Persona persona2 = new Persona();
        persona2.setCedula("1450170351");
        persona2.setNombre("Lucía Torres");
        persona2.setDireccion("Av. Amazonas 1234");
        daoPersona.insert(persona2);

        Persona persona3 = new Persona();
        persona3.setCedula("1450170352");
        persona3.setNombre("Juan Pérez");
        persona3.setDireccion("La Mariscal, Cuenca");
        daoPersona.insert(persona3);

        // Crear y guardar productos
        Producto producto1 = new Producto();
        producto1.setPrecio(50.0);
        producto1.setStock(100);
        daoProducto.insert(producto1);

        Producto producto2 = new Producto();
        producto2.setPrecio(30.0);
        producto2.setStock(50);
        daoProducto.insert(producto2);

        Producto producto3 = new Producto();
        producto3.setPrecio(70.0);
        producto3.setStock(200);
        daoProducto.insert(producto3);

        // Crear y guardar  detalle
        DetalleFactura detalleFactura1 = new DetalleFactura();
        detalleFactura1.setCantidad(2);
        detalleFactura1.setPrecio(producto1.getPrecio());
        detalleFactura1.setProducto(producto1);
        daoDetalleFactura.insert(detalleFactura1);

        DetalleFactura detalleFactura2 = new DetalleFactura();
        detalleFactura2.setCantidad(1);
        detalleFactura2.setPrecio(producto2.getPrecio());
        detalleFactura2.setProducto(producto2);
        daoDetalleFactura.insert(detalleFactura2);

        DetalleFactura detalleFactura3 = new DetalleFactura();
        detalleFactura3.setCantidad(3);
        detalleFactura3.setPrecio(producto3.getPrecio());
        detalleFactura3.setProducto(producto3);
        daoDetalleFactura.insert(detalleFactura3);

        // Crear y guardar  factura 
        Factura factura1 = new Factura();
        factura1.setFecha(new Date());
        factura1.setCliente(persona1);
        factura1.setDetalles(List.of(detalleFactura1)); // Asocia detalleFactura1 a factura1
        daoFactura.insert(factura1);

        Factura factura2 = new Factura();
        factura2.setFecha(new Date());
        factura2.setCliente(persona2);
        factura2.setDetalles(List.of(detalleFactura2)); 
        daoFactura.insert(factura2);

        Factura factura3 = new Factura();
        factura3.setFecha(new Date());
        factura3.setCliente(persona3);
        factura3.setDetalles(List.of(detalleFactura3)); 
        daoFactura.insert(factura3);

        // Imprimir datos de personas
        System.out.println("DATOS DE PERSONA");
        List<Persona> personas = daoPersona.getAll();
        for (Persona pe : personas) {
            System.out.println("Cedula:"+pe.getCedula() + " Nombre: " + pe.getNombre() + " Direccion: " + pe.getDireccion());
        }

        // Imprimir datos de productos
        System.out.println("DATOS DE PRODUCTO");
        List<Producto> productos = daoProducto.getAll();
        for (Producto p : productos) {
            System.out.println("Codigo: "+p.getCodigo() + " Precio:  " + p.getPrecio() + " Stock: " + p.getStock());
        }

        // Imprimir datos de detalles de facturas
        System.out.println("DATOS DETALLEFACTURA");
        List<DetalleFactura> detallesFactura = daoDetalleFactura.getAll();
        for (DetalleFactura d : detallesFactura) {
            System.out.println("Codigo: "+d.getCodigo() + " Cantidad: " + d.getCantidad() + " Precio: " + d.getPrecio() + " Producto:" + d.getProducto().getCodigo());
        }

       /* // Imprimir datos de facturas
        System.out.println("DATOS FACTURA");
        List<Factura> facturas = daoFactura.getAll();
        for (Factura f : facturas) {
            System.out.println("Numero Factura: "+f.getNumero() + " Fecha: " + f.getFecha() + "  Cliente:" + f.getCliente().getNombre());
            // Imprimir detalles de cada factura
            for (DetalleFactura d : f.getDetalles()) {
                System.out.println("  Detalle: " + d.getCodigo() + " " + d.getCantidad() + " " + d.getPrecio() + " " + d.getProducto().getCodigo());
            }
        }*/
        
     // Imprimir datos de facturas
        System.out.println("DATOS FACTURA");
        List<Factura> facturas = daoFactura.getAll();
        for (Factura f : facturas) {
            System.out.println("Numero Factura: " + f.getNumero());
            System.out.println("Fecha: " + f.getFecha());
            System.out.println("Cliente: " + f.getCliente().getNombre());
            
            // Imprimir detalles de cada factura
            for (DetalleFactura d : f.getDetalles()) {
                System.out.println("  Detalle:");
                System.out.println("    Codigo: " + d.getCodigo());
                System.out.println("    Cantidad: " + d.getCantidad());
                System.out.println("    Precio: " + d.getPrecio());
                System.out.println("    Producto: " + d.getProducto().getCodigo());
            }
            System.out.println(); // Añadir una línea en blanco entre facturas para mayor claridad
        }
    }
}

