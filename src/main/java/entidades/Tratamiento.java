package entidades;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Tratamiento")
public class Tratamiento {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Tratamiento;
    @Column(name = "tipo")
    private String tipoTratamietno;
    @Column(name = "costo")
    private BigDecimal costo_Tratamiento;

    @OneToMany(mappedBy = "tratamiento")
    private Set<Recibe> recibes;



    @OneToOne()
    @JoinColumn(name = "id_hospital", referencedColumnName = "id")
    private Hospital hospital;


    public Tratamiento() {
    }

    public Tratamiento(int id_Tratamiento, String tipoTratamietno, BigDecimal costo_Tratamiento, Set<Recibe> recibes, Hospital hospital) {
        this.id_Tratamiento = id_Tratamiento;
        this.tipoTratamietno = tipoTratamietno;
        this.costo_Tratamiento = costo_Tratamiento;
        this.recibes = recibes;
        this.hospital = hospital;
    }

    public int getId_Tratamiento() {
        return id_Tratamiento;
    }

    public void setId_Tratamiento(int id_Tratamiento) {
        this.id_Tratamiento = id_Tratamiento;
    }

    public String getTipoTratamietno() {
        return tipoTratamietno;
    }

    public void setTipoTratamietno(String tipoTratamietno) {
        this.tipoTratamietno = tipoTratamietno;
    }

    public BigDecimal getCosto_Tratamiento() {
        return costo_Tratamiento;
    }

    public void setCosto_Tratamiento(BigDecimal costo_Tratamiento) {
        this.costo_Tratamiento = costo_Tratamiento;
    }

    public Set<Recibe> getRecibes() {
        return recibes;
    }

    public void setRecibes(Set<Recibe> recibes) {
        this.recibes = recibes;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
