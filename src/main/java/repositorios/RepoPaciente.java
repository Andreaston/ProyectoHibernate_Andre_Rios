package repositorios;

import entidades.Paciente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepoPaciente implements Repositorio<Paciente>{

    private Session session;

    public RepoPaciente(Session session){
        super();
        this.session = session;
    }

    @Override
    public void guardar(Paciente paciente) {
        Transaction transaction = this.session.beginTransaction();
        session.merge(paciente);
        transaction.commit();
    }

    @Override
    public Paciente obtener(int id) {
        return null;
    }

    @Override
    public Paciente obtener(String nombre) {
        Query<Paciente> query = session.createQuery("FROM Paciente WHERE nombre_Paciente = :nombre", Paciente.class);
        query.setParameter("nombre", nombre);
        return query.uniqueResult();  // Devuelve un solo resultado o null
    }



    @Override
    public void actualizar(Paciente paciente) {

        // Buscar al paciente por nombre
        Query<Paciente> query = session.createQuery("FROM Paciente WHERE nombre_Paciente = :nombre", Paciente.class);
        query.setParameter("nombre", paciente.getNombre_Paciente());
        Paciente p = query.uniqueResult();

        if (p == null) {
            System.out.println("No encontramos el paciente, vuelve a intentarlo");
        } else {
            // Actualizar los datos del paciente
            p.setFechaNacimiento_Paciente(paciente.getFechaNacimiento_Paciente());
            p.setDireccion_Paciente(paciente.getDireccion_Paciente());

            // Iniciar la transacción para guardar los cambios
            Transaction transaction = session.beginTransaction();
            session.update(p);  // Persistir los cambios
            transaction.commit();

            System.out.println("Paciente actualizado");
        }

    }

    @Override
    public void eliminar(int id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Paciente WHERE paciente = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public void eliminar(String nombre) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Paciente WHERE nombre_Paciente = :nombre");
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        transaction.commit();
        System.out.println("Paciente eliminado");
    }

    public List<Paciente> obtenerTodos(){
        Query<Paciente> query = session.createQuery("FROM Paciente", Paciente.class);
        return query.getResultList();
    }

}
