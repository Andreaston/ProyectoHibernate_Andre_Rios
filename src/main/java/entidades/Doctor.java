package entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Doctor")
public class
Doctor {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "telefono")
    private String telefono;

    @OneToOne(mappedBy = "doctor")
    //@JoinColumn(name = "cita_ID", referencedColumnName = "id_Cita")
    private Cita cita;

    public Doctor(int id, String nombre, String especialidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
        cita.setDoctor(this);
    }

    public Doctor() {

    }

    public Doctor(int id, String nombre, String especialidad, String telefono, Cita cita) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.cita = cita;
    }

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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cita getCita() {
        return cita;
    }
}
