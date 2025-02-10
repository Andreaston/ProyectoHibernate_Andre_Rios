package entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para autoincremental
    @Column(name = "id")
    private int id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "estado")
    private String estado;

    @OneToOne()
    @JoinColumn(name = "id_doctor", unique = true)
    private Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @OneToOne()
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public void  setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Cita() {

    }

    public Cita(int id, Date fecha, String estado, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
