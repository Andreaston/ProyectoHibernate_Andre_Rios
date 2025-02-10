package entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "Recibe")
public class Recibe {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fecha_inicio")
    private Date FechaInicio;
    @Column(name = "fecha_fin")
    private Date FechaFin;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private  Paciente paciente;

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    @ManyToOne()
    @JoinColumn(name = "tratamiento_id", referencedColumnName = "id")
    private Tratamiento tratamiento;

    public Recibe() {
    }

    public Recibe(Date fechaInicio, Date fechaFin, Paciente paciente, Tratamiento tratamiento) {
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        this.paciente = paciente;
        this.tratamiento = tratamiento;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
}
