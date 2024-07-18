package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Producto producto) {
        em.persist(producto);
    }

    public void update(Producto producto) {
        em.merge(producto);
    }

    public void delete(int codigo) {
        Producto producto = this.read(codigo);
        if (producto != null) {
            em.remove(producto);
        }
    }

    public Producto read(int codigo) {
        return em.find(Producto.class, codigo);
    }

    public List<Producto> getAll() {
        String jpql = "SELECT p FROM Producto p";
        Query query = em.createQuery(jpql, Producto.class);
        return query.getResultList();
    }
}