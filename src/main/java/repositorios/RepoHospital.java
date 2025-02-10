package repositorios;

import org.hibernate.query.Query;
import entidades.Hospital;
import entidades.Paciente;
import org.hibernate.Session;

import java.util.List;

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
    public Hospital obtener(String nombre) {
        Query<Hospital> query = session.createQuery("FROM Hospital WHERE nombre_Hospital = :nombre");
        query.setParameter("nombre",nombre);
        return query.uniqueResult();
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

    public List<Hospital> obtenerTodos(){
        Query<Hospital> query = session.createQuery("FROM Hospital", Hospital.class);
        return query.getResultList();
    }

}
