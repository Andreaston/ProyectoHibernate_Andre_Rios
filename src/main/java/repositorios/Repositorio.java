package repositorios;

import entidades.Paciente;

// "T" es un tipo genérico.
// Puede ser cualquier entidad (Paciente, Doctor, etc.)
public interface Repositorio<T> {

    void guardar(T t);
    T obtener(int id);

    Paciente obtener(String nombre);

    //T obtener(String n);
    void actualizar(T t);
    void eliminar(int id);


    void eliminar(String nombre);
}
