package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleFacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(DetalleFactura detalleFactura) {
        em.persist(detalleFactura);
    }

    public void update(DetalleFactura detalleFactura) {
        em.merge(detalleFactura);
    }

    public void delete(int codigo) {
        DetalleFactura detalleFactura = this.read(codigo);
        if (detalleFactura != null) {
            em.remove(detalleFactura);
        }
    }

    public DetalleFactura read(int codigo) {
        return em.find(DetalleFactura.class, codigo);
    }

    public List<DetalleFactura> getAll() {
        String jpql = "SELECT d FROM DetalleFactura d";
        Query query = em.createQuery(jpql, DetalleFactura.class);
        return query.getResultList();
    }
}