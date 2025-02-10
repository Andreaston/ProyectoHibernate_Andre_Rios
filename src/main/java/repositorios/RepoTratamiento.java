package repositorios;

import entidades.Paciente;
import entidades.Tratamiento;
import org.hibernate.Session;

public class RepoTratamiento implements Repositorio<Tratamiento>{

    private Session session;

    public RepoTratamiento(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Tratamiento tratamiento) {

    }

    @Override
    public Tratamiento obtener(int id) {
        return null;
    }

    @Override
    public Paciente obtener(String nombre) {
        return null;
    }

    @Override
    public void actualizar(Tratamiento tratamiento) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void eliminar(String nombre) {

    }
}
