package tarea4.vista;

import tarea4.modelo.Curso;
import tarea4.modelo.TareaAcademica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class VentanaPrincipal extends JFrame {

    // Lista principal para almacenar los cursos registrados
    private List<Curso> listaCursos;

    // Componentes del Módulo de Cursos
    private JTextField txtCodigoCurso;
    private JTextField txtNombreCurso;
    private JTextField txtTutorCurso;
    private JButton btnRegistrarCurso;

    // Componentes del Módulo de Tareas
    private JComboBox<Curso> comboCursos;
    private JTextField txtTituloTarea;
    private JTextField txtDescripcionTarea;
    private JTextField txtFechaEntrega;
    private JButton btnAgregarTarea;

    // Componentes del Módulo de Conversión
    private JTextField txtCelsius;
    private JButton btnConvertirFahrenheit;
    private JButton btnConvertirKelvin;
    private JLabel lblResultadoConversion;

    // Componentes del Módulo de Visualización
    private JTextArea txtAreaVisualizacion;
    private JButton btnMostrarInformacion;
    private JButton btnLimpiarConsola;

    // Formateador para números decimales
    private DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Constructor principal de la ventana.
     */
    public VentanaPrincipal() {
        super("Control Académico y Conversor de Temperatura - Tarea 4 IPC1");
        this.listaCursos = new ArrayList<>();

        configurarVentana();
        inicializarComponentes();
        asignarEventos();
    }

    /**
     * Configuración básica del JFrame.
     */
    private void configurarVentana() {
        this.setSize(950, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra la ventana en pantalla
        this.setLayout(new BorderLayout(10, 10));
    }

    /**
     * Inicializa y organiza los componentes gráficos por código.
     */
    private void inicializarComponentes() {
        // Panel contenedor principal con padding
        JPanel panelContenedor = new JPanel(new GridLayout(1, 2, 12, 12));
        panelContenedor.setBorder(new EmptyBorder(12, 12, 12, 12));

        // ==========================================
        // COLUMNA IZQUIERDA: FORMULARIOS Y CONVERSIÓN
        // ==========================================
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

        // 1. Panel de Cursos
        JPanel panelCursos = new JPanel(new GridBagLayout());
        panelCursos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "1. Registro de Cursos",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 13), new Color(25, 55, 109)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 5, 4, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Código
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        panelCursos.add(new JLabel("Código del Curso:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        txtCodigoCurso = new JTextField(15);
        panelCursos.add(txtCodigoCurso, gbc);

        // Nombre
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panelCursos.add(new JLabel("Nombre del Curso:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        txtNombreCurso = new JTextField(15);
        panelCursos.add(txtNombreCurso, gbc);

        // Tutor
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panelCursos.add(new JLabel("Tutor Responsable:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        txtTutorCurso = new JTextField(15);
        panelCursos.add(txtTutorCurso, gbc);

        // Botón Registrar Curso
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        btnRegistrarCurso = new JButton("Registrar Curso");
        btnRegistrarCurso.setBackground(new Color(230, 240, 255));
        btnRegistrarCurso.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelCursos.add(btnRegistrarCurso, gbc);

        panelIzquierdo.add(panelCursos);
        panelIzquierdo.add(Box.createVerticalStrut(10));

        // 2. Panel de Tareas
        JPanel panelTareas = new JPanel(new GridBagLayout());
        panelTareas.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "2. Registro de Tareas Académicas",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 13), new Color(25, 55, 109)));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 5, 4, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Selección de Curso
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        panelTareas.add(new JLabel("Asociar a Curso:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        comboCursos = new JComboBox<>();
        panelTareas.add(comboCursos, gbc);

        // Título de la Tarea
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panelTareas.add(new JLabel("Título de Tarea:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        txtTituloTarea = new JTextField(15);
        panelTareas.add(txtTituloTarea, gbc);

        // Descripción
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panelTareas.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        txtDescripcionTarea = new JTextField(15);
        panelTareas.add(txtDescripcionTarea, gbc);

        // Fecha de Entrega
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        panelTareas.add(new JLabel("Fecha de Entrega:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.7;
        txtFechaEntrega = new JTextField(15);
        panelTareas.add(txtFechaEntrega, gbc);

        // Botón Agregar Tarea
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        btnAgregarTarea = new JButton("Agregar Tarea");
        btnAgregarTarea.setBackground(new Color(230, 240, 255));
        btnAgregarTarea.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelTareas.add(btnAgregarTarea, gbc);

        panelIzquierdo.add(panelTareas);
        panelIzquierdo.add(Box.createVerticalStrut(10));

        // 3. Panel de Conversión de Temperatura
        JPanel panelConversion = new JPanel(new GridBagLayout());
        panelConversion.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "3. Módulo de Conversión de Temperatura",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 13), new Color(25, 55, 109)));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Entrada Celsius
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.4;
        panelConversion.add(new JLabel("Grados Celsius (°C):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.6;
        txtCelsius = new JTextField(10);
        panelConversion.add(txtCelsius, gbc);

        // Botones de conversión en fila horizontal
        JPanel panelBotonesTemp = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnConvertirFahrenheit = new JButton("Convertir a Fahrenheit");
        btnConvertirKelvin = new JButton("Convertir a Kelvin");
        panelBotonesTemp.add(btnConvertirFahrenheit);
        panelBotonesTemp.add(btnConvertirKelvin);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panelConversion.add(panelBotonesTemp, gbc);

        // Etiqueta de resultado
        lblResultadoConversion = new JLabel("Resultado: Esperando conversión...", SwingConstants.CENTER);
        lblResultadoConversion.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblResultadoConversion.setForeground(new Color(0, 102, 51));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panelConversion.add(lblResultadoConversion, gbc);

        panelIzquierdo.add(panelConversion);

        // ==========================================
        // COLUMNA DERECHA: VISUALIZACIÓN Y REPORTES
        // ==========================================
        JPanel panelDerecho = new JPanel(new BorderLayout(8, 8));
        panelDerecho.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "4. Visualización de Cursos y Tareas Registradas",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 13), new Color(25, 55, 109)));

        // Área de texto con scroll
        txtAreaVisualizacion = new JTextArea();
        txtAreaVisualizacion.setEditable(false);
        txtAreaVisualizacion.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtAreaVisualizacion.setMargin(new Insets(8, 8, 8, 8));
        JScrollPane scrollVisualizacion = new JScrollPane(txtAreaVisualizacion);
        panelDerecho.add(scrollVisualizacion, BorderLayout.CENTER);

        // Panel de botones de visualización
        JPanel panelBotonesVisualizacion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        btnLimpiarConsola = new JButton("Limpiar Pantalla");
        btnMostrarInformacion = new JButton("Mostrar información");
        btnMostrarInformacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnMostrarInformacion.setBackground(new Color(220, 235, 252));
        btnMostrarInformacion.setForeground(new Color(15, 30, 80));

        panelBotonesVisualizacion.add(btnLimpiarConsola);
        panelBotonesVisualizacion.add(btnMostrarInformacion);
        panelDerecho.add(panelBotonesVisualizacion, BorderLayout.SOUTH);

        // Ensamblar en contenedor
        panelContenedor.add(panelIzquierdo);
        panelContenedor.add(panelDerecho);

        this.add(panelContenedor, BorderLayout.CENTER);
    }

    /**
     * Vinculación de eventos mediante ActionListener.
     */
    private void asignarEventos() {
        // Evento Registrar Curso
        btnRegistrarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCurso();
            }
        });

        // Evento Agregar Tarea
        btnAgregarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });

        // Evento Mostrar Información
        btnMostrarInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion();
            }
        });

        // Evento Limpiar Pantalla
        btnLimpiarConsola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaVisualizacion.setText("");
            }
        });

        // Evento Convertir a Fahrenheit
        btnConvertirFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura(true);
            }
        });

        // Evento Convertir a Kelvin
        btnConvertirKelvin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura(false);
            }
        });
    }

    /**
     * Valida y registra un nuevo curso.
     */
    private void registrarCurso() {
        String codigo = txtCodigoCurso.getText().trim();
        String nombre = txtNombreCurso.getText().trim();
        String tutor = txtTutorCurso.getText().trim();

        // Validación de campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || tutor.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos del curso son obligatorios. Por favor, complételos.",
                    "Validación - Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de código duplicado
        for (Curso c : listaCursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                JOptionPane.showMessageDialog(this,
                        "Ya existe un curso registrado con el código: " + codigo,
                        "Validación - Curso Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Creación del objeto Curso y almacenamiento
        Curso nuevoCurso = new Curso(codigo, nombre, tutor);
        listaCursos.add(nuevoCurso);
        comboCursos.addItem(nuevoCurso);

        // Limpiar campos
        txtCodigoCurso.setText("");
        txtNombreCurso.setText("");
        txtTutorCurso.setText("");

        JOptionPane.showMessageDialog(this,
                "Curso '" + nombre + "' (Código: " + codigo + ") registrado con éxito.",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Valida y asocia una nueva tarea al curso seleccionado.
     */
    private void agregarTarea() {
        // Validación de existencia de cursos
        if (listaCursos.isEmpty() || comboCursos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,
                    "No hay cursos registrados. Debe registrar un curso antes de agregar tareas.",
                    "Validación - Sin Cursos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Curso cursoSeleccionado = (Curso) comboCursos.getSelectedItem();
        String titulo = txtTituloTarea.getText().trim();
        String descripcion = txtDescripcionTarea.getText().trim();
        String fecha = txtFechaEntrega.getText().trim();

        // Validación de campos vacíos
        if (titulo.isEmpty() || descripcion.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe completar todos los datos de la tarea (título, descripción y fecha de entrega).",
                    "Validación - Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Creación del objeto TareaAcademica y asociación al curso
        TareaAcademica nuevaTarea = new TareaAcademica(titulo, descripcion, fecha, cursoSeleccionado);
        cursoSeleccionado.agregarTarea(nuevaTarea);

        // Limpiar campos
        txtTituloTarea.setText("");
        txtDescripcionTarea.setText("");
        txtFechaEntrega.setText("");

        JOptionPane.showMessageDialog(this,
                "Tarea '" + titulo + "' agregada con éxito al curso " + cursoSeleccionado.getNombre() + ".",
                "Tarea Registrada",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Despliega la información ordenada de todos los cursos y sus tareas asociadas.
     */
    private void mostrarInformacion() {
        if (listaCursos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay cursos ni tareas registradas para mostrar.",
                    "Información Vacía",
                    JOptionPane.INFORMATION_MESSAGE);
            txtAreaVisualizacion.setText("No hay cursos registrados en el sistema.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("======================================================================\n");
        sb.append("               REPORTE GENERAL DE CURSOS Y TAREAS ACADÉMICAS          \n");
        sb.append("======================================================================\n\n");

        int totalTareas = 0;
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso c = listaCursos.get(i);
            sb.append(String.format("[%d] CURSO: %s (CÓDIGO: %s)\n", (i + 1), c.getNombre(), c.getCodigo()));
            sb.append(String.format("    Tutor Responsable: %s\n", c.getTutor()));
            sb.append(String.format("    Cantidad de tareas asignadas: %d\n", c.getTareas().size()));

            if (c.getTareas().isEmpty()) {
                sb.append("    -> No tiene tareas asignadas aún.\n");
            } else {
                sb.append("    -> Listado de Tareas:\n");
                for (int j = 0; j < c.getTareas().size(); j++) {
                    TareaAcademica t = c.getTareas().get(j);
                    sb.append(String.format("       %d.%d Título: %s\n", (i + 1), (j + 1), t.getTitulo()));
                    sb.append(String.format("           Descripción: %s\n", t.getDescripcion()));
                    sb.append(String.format("           Fecha Entrega: %s\n", t.getFechaEntrega()));
                }
            }
            sb.append("----------------------------------------------------------------------\n");
            totalTareas += c.getTareas().size();
        }

        sb.append(String.format("Resumen General: Total Cursos: %d | Total Tareas: %d\n", listaCursos.size(), totalTareas));
        sb.append("======================================================================\n");

        txtAreaVisualizacion.setText(sb.toString());
        txtAreaVisualizacion.setCaretPosition(0);
    }

    /**
     * Valida y realiza la conversión de temperatura de Celsius a Fahrenheit o Kelvin.
     * @param aFahrenheit true para Fahrenheit, false para Kelvin
     */
    private void convertirTemperatura(boolean aFahrenheit) {
        String textoCelsius = txtCelsius.getText().trim();

        // 1. Validación de campo vacío
        if (textoCelsius.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese un valor de temperatura en grados Celsius.",
                    "Validación - Campo Vacío",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Validación de valor numérico
        double celsius;
        try {
            celsius = Double.parseDouble(textoCelsius);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "El valor ingresado ('" + textoCelsius + "') no es un número válido. Use números enteros o decimales (ej. 25 o 36.5).",
                    "Validación - Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Cálculos
        if (aFahrenheit) {
            // Fórmula: F = C * (9/5) + 32
            double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
            String resultadoStr = df.format(fahrenheit) + "°F";
            lblResultadoConversion.setText("Resultado: " + resultadoStr);

            JOptionPane.showMessageDialog(this,
                    celsius + " °C equivale a " + resultadoStr,
                    "Conversión a Fahrenheit",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Fórmula: K = C + 273.15
            double kelvin = celsius + 273.15;
            String resultadoStr = df.format(kelvin) + " K";
            lblResultadoConversion.setText("Resultado: " + resultadoStr);

            JOptionPane.showMessageDialog(this,
                    celsius + " °C equivale a " + resultadoStr,
                    "Conversión a Kelvin",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
