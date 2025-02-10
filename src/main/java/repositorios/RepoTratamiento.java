package repositorios;

import org.hibernate.query.Query;
import entidades.Paciente;
import entidades.Tratamiento;
import org.hibernate.Session;

import java.util.List;

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
    public Tratamiento obtener(String nombre) {
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

    public List<Tratamiento> obtenerTodos(){
        Query<Tratamiento> query = session.createQuery("FROM Tratamiento", Tratamiento.class);
        return query.getResultList();
    }

}
