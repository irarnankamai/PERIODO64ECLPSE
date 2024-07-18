package ec.edu.ups.ppw.demojakarta.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "TBL_BOLETO")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boleto_id")
    private int id;

    @Column(name = "boleto_numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "rifa_id")
    private Rifa rifa;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Comprador comprador;

    // Constructor vacío requerido por JPA
    public Boleto() {}

    // Constructor con parámetros
    public Boleto(String numero, Rifa rifa, Comprador comprador) {
        this.numero = numero;
        this.rifa = rifa;
        this.comprador = comprador;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Rifa getRifa() {
        return rifa;
    }

    public void setRifa(Rifa rifa) {
        this.rifa = rifa;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}