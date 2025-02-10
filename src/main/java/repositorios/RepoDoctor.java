package repositorios;


import entidades.Doctor;
import entidades.Paciente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepoDoctor implements Repositorio<Doctor>{

    private Session session;

    public  RepoDoctor(Session session){
        super();
        this.session = session;
    }

    @Override
    public void guardar(Doctor doctor) {
        Transaction tra = this.session.beginTransaction();
        session.persist(doctor);
        tra.commit();
    }

    @Override
    public Doctor obtener(int id) {

        return session.get(Doctor.class,id);
    }

    @Override
    public Doctor obtener(String nombre) {
        return null;
    }

    @Override
    public void actualizar(Doctor doctor) {
        Transaction tra = session.beginTransaction();
        session.merge(doctor);
        tra.commit();
    }

    @Override
    public void eliminar(int id) {
        Transaction transaction = session.beginTransaction();
        Doctor doctor = session.get(Doctor.class,id);
        if (doctor != null){
            session.remove(doctor);
        }
        transaction.commit();
    }

    @Override
    public void eliminar(String nombre) {

    }

    public List<Doctor> obtenerTodos(){
        Query<Doctor> query = session.createQuery("FROM Doctor", Doctor.class);
        return query.getResultList();
    }




}
