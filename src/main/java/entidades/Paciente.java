package entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Paciente;
    @Column(name = "nombre")
    private String nombre_Paciente;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento_Paciente;
    @Column(name = "direccion")
    private String direccion_Paciente;

    @OneToMany(mappedBy = "paciente")
    private Set<Cita> citas;


    @OneToMany(mappedBy = "paciente")
    private Set<Recibe> recibe;


    public Paciente() {
    }

    public Paciente(int id_Paciente, String nombre_Paciente, Date fechaNacimiento_Paciente, String direccion_Paciente) {
        this.id_Paciente = id_Paciente;
        this.nombre_Paciente = nombre_Paciente;
        this.fechaNacimiento_Paciente = fechaNacimiento_Paciente;
        this.direccion_Paciente = direccion_Paciente;
    }

    public Paciente(int id_Paciente, String nombre_Paciente, Date fechaNacimiento_Paciente, String direccion_Paciente, Set<Cita> citas, Set<Recibe> recibe) {
        this.id_Paciente = id_Paciente;
        this.nombre_Paciente = nombre_Paciente;
        this.fechaNacimiento_Paciente = fechaNacimiento_Paciente;
        this.direccion_Paciente = direccion_Paciente;
        this.citas = citas;
        this.recibe = recibe;
    }


    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getNombre_Paciente() {
        return nombre_Paciente;
    }

    public void setNombre_Paciente(String nombre_Paciente) {
        this.nombre_Paciente = nombre_Paciente;
    }

    public Date getFechaNacimiento_Paciente() {
        return fechaNacimiento_Paciente;
    }

    public void setFechaNacimiento_Paciente(Date fechaNacimiento_Paciente) {
        this.fechaNacimiento_Paciente = fechaNacimiento_Paciente;
    }

    public String getDireccion_Paciente() {
        return direccion_Paciente;
    }

    public void setDireccion_Paciente(String direccion_Paciente) {
        this.direccion_Paciente = direccion_Paciente;
    }

    public Set<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }

    public Set<Recibe> getRecibe() {
        return recibe;
    }

    public void setRecibe(Set<Recibe> recibe) {
        this.recibe = recibe;
    }
}
