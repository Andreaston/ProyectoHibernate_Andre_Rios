package repositorios;

import entidades.Paciente;
import entidades.Recibe;
import entidades.Tratamiento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.sql.Date;

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

    public void actualizarFechaFinTratamiento(String nombrePaciente, Date fechaFin) {
        // Buscar el paciente por su nombre
        Query<Paciente> queryPaciente = session.createQuery("FROM Paciente WHERE nombre_Paciente = :nombre", Paciente.class);
        queryPaciente.setParameter("nombre", nombrePaciente);
        Paciente paciente = queryPaciente.uniqueResult();

        if (paciente != null) {
            // Buscar las relaciones Recibe del paciente
            RepoRecibe repoRecibe = new RepoRecibe(session);
            List<Recibe> recibeList = repoRecibe.obtenerTratamientoPaciente(paciente.getId_Paciente());

            if (!recibeList.isEmpty()) {
                // Iterar sobre las relaciones Recibe para actualizar la fecha de fin
                for (Recibe recibe : recibeList) {
                    Tratamiento tratamiento = recibe.getTratamiento();  // Obtener el tratamiento de la relación
                    if (tratamiento != null) {
                        // Actualizar la fecha de fin del tratamiento
                        recibe.setFechaFin(fechaFin);

                        // Guardar los cambios en la base de datos
                        Transaction transaction = session.beginTransaction();
                        session.update(recibe);  // Persistir la actualización de la relación Recibe
                        transaction.commit();

                        System.out.println("Fecha de fin del tratamiento actualizada para el paciente " + nombrePaciente);
                    }
                }
            } else {
                System.out.println("No se encontraron tratamientos para el paciente " + nombrePaciente);
            }
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }


}
