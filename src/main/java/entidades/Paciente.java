package entidades;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Paciente;
    @Column(name = "nombre")
    private String nombre_Paciente;
    @Column(name = "fecha_naciemiento")
    private Date fechaNacimiento_Paciente;
    @Column(name = "direccion")
    private String direccion_Paciente;

    @OneToMany(mappedBy = "id")
    private Set<Cita> citas;


    @OneToMany(mappedBy = "id")
    private Set<Recibe> recibe;


}
