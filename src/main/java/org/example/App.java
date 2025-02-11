package org.example;

/**
 * Hello world!
 *
 */

import entidades.Doctor;
import entidades.Hospital;
import entidades.Paciente;
import entidades.Tratamiento;
import org.hibernate.Session;
import repositorios.RepoDoctor;
import repositorios.RepoHospital;
import repositorios.RepoPaciente;
import repositorios.RepoTratamiento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Test");
        Session session = HibernateUtil.get().openSession();
        //enlazar los repos con la sesion
        RepoDoctor repoDoctor = new RepoDoctor(session);
        RepoPaciente repoPaciente = new RepoPaciente(session);
        RepoHospital repoHospital = new RepoHospital(session);
        RepoTratamiento repoTratamiento = new RepoTratamiento(session);

        Scanner leer = new Scanner(System.in);
        int orden;

        do {

            System.out.println("Dime que quieres hacer");
            System.out.println("1. Mostrar doctores");
            System.out.println("2. Crear doctor");
            System.out.println("3. Modificar doctor");
            System.out.println("4. Eliminar doctor");
            System.out.println("5. Mostrar pacientes");
            System.out.println("6. Crear pacientes");
            System.out.println("7. Modificar pacientes");
            System.out.println("8. Eliminar paciente");
            System.out.println("9. Asignar un doctor a un paciente");
            System.out.println("10. Indicar la fecha de fin del tratamiento de un paciente");
            System.out.println("11. Cambiar el hospital de un tratamiento");
            System.out.println("12. Mostrar los datos de un paciente TODO");
            System.out.println("13. Mostrar los datos de los tratamientos y el hospital en el que se realiza");
            System.out.println("14. Mostrar los datos de los tratamientos y el hospital que introduzca el usuario");
            System.out.println("15. SALIR");
            orden = leer.nextInt();

            switch (orden) {
                case 1:

                    List<Doctor> doctors = repoDoctor.obtenerTodos();

                    for (Doctor doctor : doctors) {
                        System.out.println("ID [" + doctor.getId() + "] Nombre [" + doctor.getNombre() + "] Especialidad [" + doctor.getEspecialidad() + "] Teléfono [" + doctor.getTelefono() + "]");
                    }

                    break;
                case 2:

                    System.out.println("Dime el nuevo id ");
                    int idDoc = leer.nextInt();
                    System.out.println("Dime el nombre");
                    String nomDoc = leer.next();
                    System.out.println("Dime la espacialidad");
                    String espDoc = leer.next();
                    System.out.println("Dime el teléfono");
                    String tlfDoc = leer.next();

                    //Crear un nuevo doctor
                    Doctor nuevoDoc = new Doctor(idDoc, nomDoc, espDoc, tlfDoc);
                    /*
                       nuevoDoc.setId(7);
                       nuevoDoc.setNombre("Marcos Alonso");
                       nuevoDoc.setEspecialidad("Ortopedia");
                       nuevoDoc.setTelefono("123-456-678");
                     */
                    repoDoctor.guardar(nuevoDoc);
                    System.out.println("Guardado nuevo doctor");

                    break;
                case 3:

                    System.out.println("Dime el id del doctor a modificar");
                    int idMod = leer.nextInt();

                    Doctor docExiste = repoDoctor.obtener(idMod);
                    if (docExiste == null) {
                        System.out.println("No existe el médico con el ID -> " + idMod);
                    } else {
                        System.out.print("Nuevo nombre (actual: " + docExiste.getNombre() + "): ");
                        String nuevoNombre = leer.next();
                        leer.next();
                        System.out.print("Nueva especialidad (actual: " + docExiste.getEspecialidad() + "): ");
                        String nuevaEspecialidad = leer.next();

                        System.out.print("Nuevo teléfono (actual: " + docExiste.getTelefono() + "): ");
                        String nuevoTelefono = leer.next();


                        docExiste.setNombre(nuevoNombre);
                        docExiste.setEspecialidad(nuevaEspecialidad);
                        docExiste.setTelefono(nuevoTelefono);

                        repoDoctor.actualizar(docExiste);
                        System.out.println("Doctor actualizado");
                    }


                    break;
                case 4:


                    System.out.println("Dime el ID del doctor a eliminar");
                    int eliminar = leer.nextInt();
                    repoDoctor.eliminar(eliminar);
                    System.out.println("Doctor eliminado doctor");

                    break;
                case 5:

                    List<Paciente> pacientes = repoPaciente.obtenerTodos();
                    for (Paciente pacient : pacientes) {
                        System.out.println("ID [" + pacient.getId_Paciente() + "] Nombre [" + pacient.getNombre_Paciente() + "] Fecha Nacimiento[" + pacient.getFechaNacimiento_Paciente() + "] Dirección [" + pacient.getDireccion_Paciente() + "]");
                    }

                    break;
                case 6:

                    System.out.println("Dime el ID del paciente");
                    int idPac = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Dime el NOMBRE del paciente");
                    String nomPac = leer.nextLine();
                    System.out.println("Dime el FECHA DE NACIMIENTO(yyyy-MM-dd) del paciente");
                    String fechPac = leer.nextLine();
                    System.out.println("Dime el DIRECCIÓN del paciente");
                    String dirPac = leer.nextLine();

                    //Necesitamos parsear la fecha
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    java.sql.Date nacPac;
                    try {
                        nacPac = new java.sql.Date(format.parse(fechPac).getTime());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }


                    Paciente pacienteNovo = new Paciente(idPac, nomPac, nacPac, dirPac);
                    repoPaciente.guardar(pacienteNovo);
                    System.out.println("Paciente nuevo guardado");

                    break;
                case 7:

                    System.out.println("Dime el nombre del paciente a modificar");
                    leer.nextLine();
                    String modPacNombre = leer.nextLine();  // Obtenemos el nombre del paciente

                    // Buscar el paciente por nombre
                    Paciente pacienteExistente = repoPaciente.obtener(modPacNombre);  // Usamos el método obtener() del repositorio

                    if (pacienteExistente == null) {
                        System.out.println("No se encontró un paciente con el nombre: " + modPacNombre);
                    } else {
                        // Pedir los nuevos datos para modificar
                        System.out.print("Nuevo nombre (actual: " + pacienteExistente.getNombre_Paciente() + "): ");
                        String nuevoNombre = leer.nextLine();
                        System.out.print("Nueva fecha de nacimiento (actual: " + pacienteExistente.getFechaNacimiento_Paciente() + "): ");
                        String nuevaFecha = leer.nextLine();
                        System.out.print("Nueva dirección (actual: " + pacienteExistente.getDireccion_Paciente() + "): ");
                        String nuevaDireccion = leer.nextLine();

                        // Crear un nuevo objeto paciente con los datos modificados
                        pacienteExistente.setNombre_Paciente(nuevoNombre);
                        // Necesitamos convertir la nueva fecha a java.sql.Date
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.sql.Date nuevaFechaNac = null;
                        try {
                            nuevaFechaNac = new java.sql.Date(format1.parse(nuevaFecha).getTime());
                        } catch (ParseException e) {
                            System.out.println("Error al convertir la fecha.");
                        }
                        pacienteExistente.setFechaNacimiento_Paciente(nuevaFechaNac);
                        pacienteExistente.setDireccion_Paciente(nuevaDireccion);

                        // Llamar al metodo actualizar para guardar los cambios
                        repoPaciente.actualizar(pacienteExistente);  // Ahora pasamos el paciente completo
                        System.out.println("Paciente actualizado");
                    }


                    break;
                case 8:

                    System.out.println("Dime el nombre del paciente a quién quieres que eliminemos");
                    leer.nextLine();
                    String nomEliminar = leer.nextLine();
                    repoPaciente.eliminar(nomEliminar);

                    break;
                case 9: //Asignar paciente-doctor
                    break;
                case 10: //Asignar fecha de fin de tratamiento

                    System.out.println("Dime el nombre del paciente");
                    String nomPacR = leer.nextLine();
                    System.out.println("Dime el ID del tipo de tratamiento que recibe");
                    String nomTraR = leer.nextLine();
                    System.out.println("Dime la fecha de inicio del tratamiento");
                    String fechaIni = leer.nextLine();
                    System.out.println("Dime la fecha de fin del tratamiento");
                    String fechaFin = leer.nextLine();




                    break;
                case 13:

                    System.out.println("Dime el nombre del Hospital");
                    leer.nextLine();
                    String nomH = leer.nextLine();
                    //Hay que poner la lista

                    Tratamiento tratamiento = repoTratamiento.obtener(nomH);

                    if (tratamiento != null){

                        Hospital hospital = tratamiento.getHospital();

                        System.out.println("=======INFORMACIÓN DEL TRATAMIENTO=======");
                        System.out.println("IDT["+tratamiento.getId_Tratamiento()+"] TIPO["+tratamiento.getTipoTratamiento()+"] COSTO["+tratamiento.getCosto_Tratamiento()+"]");
                        if (hospital != null){
                            System.out.println("=======INFORMACIÓN DEL HOSPITAL=======");
                            System.out.println("IDH["+hospital.getId_Hospital()+"] NOMBRE["+hospital.getNombre_Hospital()+"] UBICACIÓN["+hospital.getUbicacion_Hospital()+"]");

                        }else {
                            System.out.println("No encontré el hospital. Sorry");
                        }


                    }else {
                        System.out.println("No encontré el tratamiento. Sorry");
                    }



                    /*
                    List<Hospital> hospitales = repoHospital.obtenerTodos();
                    List<Tratamiento> tratamientos = repoTratamiento.obtenerTodos();

                     */

                    /*
                    for (Tratamiento tratamiento : tratamientos){
                        System.out.println("IDT["+tratamiento.getId_Tratamiento()+"] TIPO["+tratamiento.getTipoTratamietno()+"] COSTO["+tratamiento.getCosto_Tratamiento()+"]");
                    }

                    for (Hospital hospital : hopitales){
                        System.out.println("IDH["+hospital.getId_Hospital()+"] NOMBRE["+hospital.getNombre_Hospital()+"] UBICACIÓN["+hospital.getUbicacion_Hospital()+"]");
                    }

                     */

                   // int maxSize = Math.max(hospitales.size(), tratamientos.size());
                    /*
                    for (Hospital hospital : hospitales) {
                        System.out.println("IDH[" + hospital.getId_Hospital() +
                                "] NOMBRE[" + hospital.getNombre_Hospital() +
                                "] UBICACIÓN[" + hospital.getUbicacion_Hospital() + "]");

                        for (Tratamiento tratamiento : tratamientos) {
                            if (tratamiento.getId_Tratamiento() == hospital.getId_Hospital()) {  //Los relacionamos por el ID
                                System.out.println(" IDT[" + tratamiento.getId_Tratamiento() +
                                        "] TIPO[" + tratamiento.getTipoTratamietno() +
                                        "] COSTO[" + tratamiento.getCosto_Tratamiento() + "]");
                            }
                        }
                    }
                    */

                    break;
            }

        }while (orden != 15);



        session.close();
        System.out.println("Finalizao");

    }
}
