# 📚 Tarea 4 - Programación Orientada a Objetos y Java Swing

> **Universidad de San Carlos de Guatemala (USAC)**  
> **Facultad de Ingeniería** | Escuela de Ciencias y Sistemas  
> **Curso:** Introducción a la Programación y Computación 1 (IPC1)  
> **Estudiante:** Martin Emanuel Jolomocox Jeataz  
> **Carnet:** 202500120  

---

## 📄 Documentación Oficial en PDF

El informe completo de entrega con la investigación teórica, diagramación conceptual, diseño de clases y evidencia fotográfica de ejecución se encuentra disponible directamente aquí:

👉 **[📥 Ver / Descargar Documento Oficial (PDF)](Documentacion_Tarea4_IPC1.pdf)**

---

## 📌 Descripción del Proyecto

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica **Java Swing** pura (programada 100% mediante código, sin GUI Builder ni arrastrar y soltar componentes).

El sistema integra los principios de la Programación Orientada a Objetos (POO), encapsulamiento, delegación de eventos y validación de datos en cuatro módulos funcionales:

1. **Gestión de Cursos:** Registro y validación de cursos académicos (código, nombre del curso, tutor responsable).
2. **Gestión de Tareas:** Asignación jerárquica de tareas (título, descripción, fecha de entrega) vinculadas a un curso específico seleccionado mediante un `JComboBox`.
3. **Conversor de Temperatura:** Conversión bidireccional de grados Celsius a Fahrenheit y Kelvin, con validación de entradas numéricas y diálogos modales `JOptionPane`.
4. **Visualización y Reportes:** Área de texto formateada (`JTextArea` con `JScrollPane`) que genera reportes estructurados de cursos y tareas registradas.

---

## 📁 Estructura del Repositorio

```text
├── Documentacion_Tarea4_IPC1.pdf   # Documento oficial de evidencia y reporte teórico
├── README.md                       # Documentación principal del repositorio
├── .gitignore                      # Configuración de exclusión para Git
├── Tarea4_IPC1.iml                 # Módulo de configuración para IntelliJ IDEA
└── src/
    └── tarea4/
        ├── modelo/
        │   ├── Curso.java          # Clase modelo de Curso (encapsulamiento y lista de tareas)
        │   └── TareaAcademica.java # Clase modelo de Tarea Académica (asociada a Curso)
        ├── vista/
        │   └── VentanaPrincipal.java# Interfaz gráfica de usuario con Java Swing
        └── principal/
            └── Main.java           # Entry point principal de la aplicación
```

---

## 🚀 Compilación y Ejecución

### Desde IntelliJ IDEA:
1. Clonar o abrir el repositorio en IntelliJ IDEA.
2. Localizar el archivo [`Main.java`](src/tarea4/principal/Main.java) en `src/tarea4/principal/Main.java`.
3. Presionar el botón verde **Run ▶** (o <kbd>Shift</kbd> + <kbd>F10</kbd>).

### Desde la Consola (Terminal):
```bash
# 1. Compilar los archivos fuente
javac -encoding UTF-8 -d bin src/tarea4/modelo/*.java src/tarea4/vista/*.java src/tarea4/principal/Main.java

# 2. Ejecutar la aplicación
java -cp bin tarea4.principal.Main
```
