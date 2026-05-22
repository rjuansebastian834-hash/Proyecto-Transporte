// ===============================
// VENTANATERMINALES.JAVA
// ===============================

package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTerminales extends JFrame {

    private JTextField txtNombre;
    private JTextField txtCiudad;

    private JTable tabla;

    private DefaultTableModel modelo;

    public VentanaTerminales() {

        setTitle("Gestión de Terminales");

        setSize(850,550);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15,23,42)
        );

        JLabel titulo = new JLabel(
                "GESTIÓN DE TERMINALES",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 28)
        );

        titulo.setForeground(Color.WHITE);

        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout());

        centro.setBackground(new Color(15,23,42));

        JPanel formulario = new JPanel(
                new GridLayout(2,2,15,15)
        );

        formulario.setBackground(new Color(30,41,59));

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);

        txtNombre = new JTextField();

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setForeground(Color.WHITE);

        txtCiudad = new JTextField();

        formulario.add(lblNombre);
        formulario.add(txtNombre);
        formulario.add(lblCiudad);
        formulario.add(txtCiudad);

        centro.add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");

        tabla = new JTable(modelo);

        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        JPanel botones = new JPanel();

        botones.setBackground(new Color(15,23,42));

        JButton btnGuardar = crearBoton("Guardar");
        JButton btnEliminar = crearBoton("Eliminar");

        botones.add(btnGuardar);
        botones.add(btnEliminar);

        add(botones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> {

            modelo.addRow(new Object[] {
                    txtNombre.getText(),
                    txtCiudad.getText()
            });

            limpiar();
        });

        btnEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if(fila != -1) {
                modelo.removeRow(fila);
            }
        });

        setVisible(true);
    }

    private JButton crearBoton(String texto) {

        JButton boton = new JButton(texto);

        boton.setBackground(new Color(191,219,254));

        boton.setForeground(Color.BLACK);

        return boton;
    }

    private void limpiar() {

        txtNombre.setText("");
        txtCiudad.setText("");
    }
}