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

    @OneToMany(mappedBy = "hospital")
    private Set<Tratamiento> tratamientos;


    public Hospital() {
    }

    public Hospital(int id_Hospital, String nombre_Hospital, String ubicacion_Hospital, Set<Tratamiento> tratamientos) {
        this.id_Hospital = id_Hospital;
        this.nombre_Hospital = nombre_Hospital;
        this.ubicacion_Hospital = ubicacion_Hospital;
        this.tratamientos = tratamientos;
    }

    public int getId_Hospital() {
        return id_Hospital;
    }

    public void setId_Hospital(int id_Hospital) {
        this.id_Hospital = id_Hospital;
    }

    public String getNombre_Hospital() {
        return nombre_Hospital;
    }

    public void setNombre_Hospital(String nombre_Hospital) {
        this.nombre_Hospital = nombre_Hospital;
    }

    public String getUbicacion_Hospital() {
        return ubicacion_Hospital;
    }

    public void setUbicacion_Hospital(String ubicacion_Hospital) {
        this.ubicacion_Hospital = ubicacion_Hospital;
    }

    public Set<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
