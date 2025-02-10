package repositorios;


import entidades.Cita;
import entidades.Paciente;
import org.hibernate.Session;

public class RepoCita implements Repositorio<Cita>{

    private Session session;

    public RepoCita(Session session){
        super();
        this.session = session;
    }

    @Override
    public void guardar(Cita cita) {

    }


    @Override
    public Cita obtener(int id) {
        return null;
    }

    @Override
    public Paciente obtener(String nombre) {
        return null;
    }

    @Override
    public void actualizar(Cita cita) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void eliminar(String nombre) {

    }
}
