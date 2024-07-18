package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Factura factura) {
        em.persist(factura);
    }

    public void update(Factura factura) {
        em.merge(factura);
    }

    public void delete(int numero) {
        Factura factura = this.read(numero);
        if (factura != null) {
            em.remove(factura);
        }
    }

    public Factura read(int numero) {
        return em.find(Factura.class, numero);
    }

    public List<Factura> getAll() {
        String jpql = "SELECT f FROM Factura f";
        Query query = em.createQuery(jpql, Factura.class);
        return query.getResultList();
    }
}
