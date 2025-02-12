package repositorios;


import entidades.Cita;
import entidades.Paciente;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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
        Query<Cita> query = session.createQuery("FROM Cita WHERE paciente = : id", Cita.class);
        query.setParameter("id",id);
        return query.uniqueResult();
    }

    @Override
    public Cita obtener(String nombre) {
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

    public List<Cita> obtenerCitasPaciente(int idPaciente){
        Query<Cita> query = session.createQuery("FROM Cita WHERE paciente.id = :idPaciente", Cita.class);
        query.setParameter("idPaciente",idPaciente);
        return query.getResultList();
    }

}
