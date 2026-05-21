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

        setTitle("CRUD Terminales");

        setSize(700,500);

        setLocationRelativeTo(null);

        setVisible(true);

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3,2,10,10));

        formulario.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        formulario.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        formulario.add(txtNombre);

        formulario.add(new JLabel("Ciudad"));

        txtCiudad = new JTextField();

        formulario.add(txtCiudad);

        add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");

        modelo.addColumn("Ciudad");

        tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel botones = new JPanel();

        JButton guardar = new JButton("Guardar");

        JButton actualizar = new JButton("Actualizar");

        JButton eliminar = new JButton("Eliminar");

        JButton limpiar = new JButton("Limpiar");

        botones.add(guardar);

        botones.add(actualizar);

        botones.add(eliminar);

        botones.add(limpiar);

        add(botones, BorderLayout.SOUTH);

        guardar.addActionListener(e -> guardar());

        actualizar.addActionListener(e -> actualizar());

        eliminar.addActionListener(e -> eliminar());

        limpiar.addActionListener(e -> limpiar());

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if(fila != -1) {

                txtNombre.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtCiudad.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });
    }

    private void guardar() {

        if(txtNombre.getText().isEmpty()
                || txtCiudad.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Completa todos los campos");

            return;
        }

        modelo.addRow(new Object[] {
                txtNombre.getText(),
                txtCiudad.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(txtNombre.getText(), fila,0);

            modelo.setValueAt(txtCiudad.getText(), fila,1);
        }
    }

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.removeRow(fila);
        }
    }

    private void limpiar() {

        txtNombre.setText("");

        txtCiudad.setText("");
    }
}