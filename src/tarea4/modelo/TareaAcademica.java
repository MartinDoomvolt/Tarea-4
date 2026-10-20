package tarea4.modelo;

/**
 * Clase que representa una Tarea Académica asociada a un curso.
 * Aplica los principios de POO y encapsulamiento.
 */
public class TareaAcademica {
    // Atributos privados
    private String titulo;
    private String descripcion;
    private String fechaEntrega;
    private Curso cursoAsociado;

    /**
     * Constructor de la tarea académica.
     * @param titulo Título de la tarea
     * @param descripcion Detalle o descripción de la tarea
     * @param fechaEntrega Fecha límite de entrega
     * @param cursoAsociado Referencia al curso al que pertenece
     */
    public TareaAcademica(String titulo, String descripcion, String fechaEntrega, Curso cursoAsociado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.cursoAsociado = cursoAsociado;
    }

    // Métodos Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Curso getCursoAsociado() {
        return cursoAsociado;
    }

    public void setCursoAsociado(Curso cursoAsociado) {
        this.cursoAsociado = cursoAsociado;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Entrega: " + fechaEntrega;
    }
}
