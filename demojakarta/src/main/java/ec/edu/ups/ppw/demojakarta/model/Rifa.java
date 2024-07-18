package ec.edu.ups.ppw.demojakarta.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "TBL_RIFA")
public class Rifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rifa_id")
    private int id;

    @Column(name = "rifa_nombre")
    private String nombre;

    @Column(name = "rifa_razon")
    private String razon;

    @ElementCollection
    @CollectionTable(name = "TBL_PREMIOS", joinColumns = @JoinColumn(name = "rifa_id"))
    @Column(name = "premio")
    private List<String> premios = new ArrayList<>();

 
    @Column(name = "rifa_fecha")
    private Date fecha;

    @Column(name = "rifa_valor_boleto")
    private BigDecimal valorBoleto;

    @Column(name = "rifa_cantidad_boletos")
    private int cantidadBoletos;

    @OneToMany(mappedBy = "rifa", cascade = CascadeType.ALL)
    private List<Boleto> boletosVendidos = new ArrayList<>();

    // Constructor vacío requerido por JPA
    public Rifa() {}

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public List<String> getPremios() {
        return premios;
    }

    public void setPremios(List<String> premios) {
        this.premios = premios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public List<Boleto> getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(List<Boleto> boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }
}