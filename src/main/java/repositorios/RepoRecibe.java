package repositorios;

import entidades.Paciente;
import entidades.Recibe;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RepoRecibe implements Repositorio<Recibe>{

    private Session session;

    public RepoRecibe(Session session) {
        super();
        this.session = session;
    }

    @Override
    public void guardar(Recibe recibe) {

    }

    @Override
    public Recibe obtener(int id) {
        return null;
    }

    @Override
    public Recibe obtener(String nombre) {
        return null;
    }


    @Override
    public void actualizar(Recibe recibe) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void eliminar(String nombre) {

    }

    public List<Recibe> obtenerTratamientoPaciente(int idPaciente){
        Query<Recibe> query = session.createQuery("FROM Recibe WHERE paciente.id_Paciente = :idPaciente", Recibe.class);
        query.setParameter("idPaciente",idPaciente);
        return query.getResultList();
    }

}
