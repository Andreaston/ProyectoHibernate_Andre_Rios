package entidades;

import jakarta.persistence.*;

import java.util.Date;
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
    @JoinColumn(name = "id_doctor")
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

}
