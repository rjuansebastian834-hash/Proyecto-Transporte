package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaClientes extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDocumento;

    private JTable tabla;

    private DefaultTableModel modelo;

    public VentanaClientes() {

        setTitle("CRUD Clientes");

        setSize(700,500);

        setLocationRelativeTo(null);

        setVisible(true);

        setLayout(new BorderLayout());

        // PANEL FORMULARIO

        JPanel formulario = new JPanel();

        formulario.setLayout(new GridLayout(3,2,10,10));

        formulario.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        formulario.add(new JLabel("Nombre"));

        txtNombre = new JTextField();

        formulario.add(txtNombre);

        formulario.add(new JLabel("Documento"));

        txtDocumento = new JTextField();

        formulario.add(txtDocumento);

        add(formulario, BorderLayout.NORTH);

        // TABLA

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");

        modelo.addColumn("Documento");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);

        // BOTONES

        JPanel botones = new JPanel();

        JButton btnGuardar = new JButton("Guardar");

        JButton btnActualizar = new JButton("Actualizar");

        JButton btnEliminar = new JButton("Eliminar");

        JButton btnLimpiar = new JButton("Limpiar");

        botones.add(btnGuardar);

        botones.add(btnActualizar);

        botones.add(btnEliminar);

        botones.add(btnLimpiar);

        add(botones, BorderLayout.SOUTH);

        // EVENTOS

        btnGuardar.addActionListener(e -> guardar());

        btnActualizar.addActionListener(e -> actualizar());

        btnEliminar.addActionListener(e -> eliminar());

        btnLimpiar.addActionListener(e -> limpiar());

        // SELECCIONAR TABLA

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if(fila != -1) {

                txtNombre.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtDocumento.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });
    }

    // GUARDAR

    private void guardar() {

        String nombre = txtNombre.getText();

        String documento = txtDocumento.getText();

        if(nombre.isEmpty() || documento.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Completa todos los campos");

            return;
        }

        modelo.addRow(new Object[] {
                nombre,
                documento
        });

        JOptionPane.showMessageDialog(this,
                "Cliente registrado");

        limpiar();
    }

    // ACTUALIZAR

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila == -1) {

            JOptionPane.showMessageDialog(this,
                    "Selecciona un cliente");

            return;
        }

        modelo.setValueAt(txtNombre.getText(), fila,0);

        modelo.setValueAt(txtDocumento.getText(), fila,1);

        JOptionPane.showMessageDialog(this,
                "Cliente actualizado");

        limpiar();
    }

    // ELIMINAR

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if(fila == -1) {

            JOptionPane.showMessageDialog(this,
                    "Selecciona un cliente");

            return;
        }

        modelo.removeRow(fila);

        JOptionPane.showMessageDialog(this,
                "Cliente eliminado");

        limpiar();
    }

    // LIMPIAR

    private void limpiar() {

        txtNombre.setText("");

        txtDocumento.setText("");

        tabla.clearSelection();
    }
}