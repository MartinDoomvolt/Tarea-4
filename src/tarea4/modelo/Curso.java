package tarea4.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Curso académico.
 * Aplica los principios de POO y encapsulamiento.
 */
public class Curso {
    // Atributos privados (Encapsulamiento)
    private String codigo;
    private String nombre;
    private String tutor;
    private List<TareaAcademica> tareas;

    /**
     * Constructor para inicializar los datos del curso.
     * @param codigo Código identificador del curso (ej. 0770)
     * @param nombre Nombre de la asignatura (ej. IPC1)
     * @param tutor Nombre del tutor responsable
     */
    public Curso(String codigo, String nombre, String tutor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tutor = tutor;
        this.tareas = new ArrayList<>();
    }

    // Métodos Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public List<TareaAcademica> getTareas() {
        return tareas;
    }

    /**
     * Agrega una tarea asociada a este curso.
     * @param tarea Tarea académica a asociar
     */
    public void agregarTarea(TareaAcademica tarea) {
        if (tarea != null) {
            this.tareas.add(tarea);
        }
    }

    /**
     * Representación textual amigable para componentes como JComboBox.
     */
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
