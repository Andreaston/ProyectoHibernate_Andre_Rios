package entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Doctor;
    @Column(name = "nombre")
    private  String nombre_Doctor;
    @Column(name = "especialidad")
    private String especialidad_Doctor;
    @Column(name = "telefono")
    private String tfl_doctor;

    @OneToOne(mappedBy = "id")
    //@JoinColumn(name = "cita_ID", referencedColumnName = "id_Cita")
    private Cita cita;

    public void setCita(Cita cita) {
        this.cita = cita;
        cita.setDoctor(this);
    }




}
