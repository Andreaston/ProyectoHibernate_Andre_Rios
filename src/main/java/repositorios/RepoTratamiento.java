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
        Query<Tratamiento> query = session.createQuery("FROM Tratamiento WHERE tipoTratamiento = :nombre");
        query.setParameter("nombre", nombre);
        return query.uniqueResult();
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


    public long obtenerNumeroDeTratamientosPorHospital(String nombreHospital) {
        Query<Long> query = session.createQuery(
                "SELECT COUNT(t) FROM Tratamiento t WHERE t.hospital.nombre_Hospital = :nombreHospital", Long.class);
        query.setParameter("nombreHospital", nombreHospital);
        return query.uniqueResult();
    }

}
