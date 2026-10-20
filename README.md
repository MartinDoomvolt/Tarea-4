# Tarea 4 - IPC 1

**Universidad de San Carlos de Guatemala (USAC)**  
**Facultad de Ingeniería**  
**Escuela de Ciencias y Sistemas**  
**Curso:** Introducción a la Programación y Computación 1  

---

## 📌 Descripción del Proyecto

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica **Java Swing** pura (programada 100% mediante código, sin GUI Builder ni arrastrar y soltar).  

Integra los conceptos fundamentales de Programación Orientada a Objetos (POO), encapsulamiento, manejo de eventos y validación de datos en cuatro módulos principales:

1. **Gestión de Cursos:** Registro y validación de cursos (código, nombre, tutor responsable).
2. **Gestión de Tareas:** Asignación de tareas académicas (título, descripción, fecha de entrega) asociadas a los cursos registrados mediante un `JComboBox`.
3. **Conversor de Temperatura:** Conversión precisa de grados Celsius a Fahrenheit y Kelvin con validación de entradas numéricas y diálogos `JOptionPane`.
4. **Visualización y Reportes:** Área de texto formateada que muestra la estructura completa de cursos y sus tareas asociadas, además de resúmenes cuantitativos.

---

## 📁 Estructura del Código

```text
src/
└── tarea4/
    ├── modelo/
    │   ├── Curso.java            # Clase modelo de Cursos con encapsulamiento
    │   └── TareaAcademica.java   # Clase modelo de Tareas asociadas a un Curso
    ├── vista/
    │   └── VentanaPrincipal.java # Interfaz gráfica principal con Swing
    └── principal/
        └── Main.java             # Entry point con Look & Feel del sistema
```

---

## 🚀 Ejecución

### Desde IntelliJ IDEA:
1. Abrir la carpeta del proyecto en IntelliJ IDEA.
2. Ejecutar la clase [`tarea4.principal.Main`](src/tarea4/principal/Main.java) presionando el botón verde **Run ▶**.

### Desde consola / terminal:
```bash
# Compilar
javac -encoding UTF-8 -d bin src/tarea4/modelo/*.java src/tarea4/vista/*.java src/tarea4/principal/Main.java

# Ejecutar
java -cp bin tarea4.principal.Main
```
