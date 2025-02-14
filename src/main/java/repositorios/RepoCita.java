package repositorios;


import entidades.Cita;
import entidades.Doctor;
import entidades.Paciente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;


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
        Query<Cita> query = session.createQuery("FROM Cita WHERE paciente.id = :id", Cita.class);
        query.setParameter("id", id);
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

    public void asignarDoctorAPaciente() {
        Scanner scanner = new Scanner(System.in);

        // Pedir nombres por teclado
        System.out.print("Ingrese el nombre del doctor: ");
        String nombreDoctor = scanner.nextLine();

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        // Buscar doctor
        Query<Doctor> queryDoctor = session.createQuery("FROM Doctor WHERE nombre = :nombreDoctor", Doctor.class);
        queryDoctor.setParameter("nombreDoctor", nombreDoctor);
        Doctor doctor = queryDoctor.uniqueResult();

        // Buscar paciente
        //Query<Paciente> queryPaciente = session.createQuery("FROM Paciente WHERE nombre = :nombrePaciente", Paciente.class);
        Query<Paciente> queryPaciente = session.createQuery("FROM Paciente p WHERE p.nombre_Paciente = :nombrePaciente", Paciente.class);
        queryPaciente.setParameter("nombrePaciente", nombrePaciente);
        Paciente paciente = queryPaciente.uniqueResult();

        if (doctor != null && paciente != null) {
            // Iniciar transacción
            Transaction transaction = session.beginTransaction();

            // Crear y asignar la cita
            Cita cita = new Cita();
            cita.setDoctor(doctor);
            cita.setPaciente(paciente);
          //  cita.setFecha(LocalDateTime.now());

            // Convertir LocalDate a java.sql.Date
            LocalDate localDate = LocalDate.now();
            Date sqlDate = Date.valueOf(localDate);
            cita.setFecha(sqlDate);

            cita.setEstado("Pendiente");

            // Guardar en la base de datos
            session.persist(cita);
            transaction.commit();

            System.out.println("Cita asignada exitosamente: " + paciente.getNombre_Paciente() +
                    " será atendido por " + doctor.getNombre());
        } else {
            System.out.println("No se encontró el doctor o el paciente.");
        }
    }

}
