package repositorios;

import entidades.Hospital;
import entidades.Paciente;
import org.hibernate.Session;

public class RepoHospital implements Repositorio<Hospital>{

    private Session session;

    public RepoHospital(Session session){
        super();
        this.session = session;
    }

    @Override
    public void guardar(Hospital hospital) {

    }

    @Override
    public Hospital obtener(int id) {
        return null;
    }

    @Override
    public Paciente obtener(String nombre) {
        return null;
    }

    @Override
    public void actualizar(Hospital hospital) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void eliminar(String nombre) {

    }
}
