package entidades;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Hospital;
    @Column(name = "nombre")
    private String nombre_Hospital;
    @Column(name = "ubicacion")
    private String ubicacion_Hospital;

    @OneToMany(mappedBy = "id")
    private Set<Tratamiento> tratamientos;





}
