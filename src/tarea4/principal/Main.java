package tarea4.principal;

import tarea4.vista.VentanaPrincipal;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Clase de entrada (Entry Point) del programa.
 */
public class Main {
    public static void main(String[] args) {
        // Establecer Look and Feel del sistema para una apariencia moderna
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, se usa el Look and Feel por defecto de Java Swing (Metal)
            System.err.println("No se pudo cargar el Look & Feel del sistema: " + e.getMessage());
        }

        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }
}
