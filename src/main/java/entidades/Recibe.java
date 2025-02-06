package entidades;

import jakarta.persistence.*;

import java.util.Date;
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




}
