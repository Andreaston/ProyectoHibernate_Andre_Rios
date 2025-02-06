package entidades;


import jakarta.persistence.*;

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
    private float costo_Tratamiento;

    @OneToMany(mappedBy = "id")
    private Set<Recibe> recibes;



    @OneToOne()
    @JoinColumn(name = "id_hospital", referencedColumnName = "id")
    private Hospital hospital;


}
