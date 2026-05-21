package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaVehiculos extends JFrame {

    private JTextField txtPlaca;
    private JTextField txtModelo;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaVehiculos() {

        setTitle("CRUD Vehículos");

        setSize(700,500);

        setLocationRelativeTo(null);

        setVisible(true);

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3,2,10,10));

        formulario.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        formulario.add(new JLabel("Placa"));

        txtPlaca = new JTextField();

        formulario.add(txtPlaca);

        formulario.add(new JLabel("Modelo"));

        txtModelo = new JTextField();

        formulario.add(txtModelo);

        add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Placa");

        modelo.addColumn("Modelo");

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

                txtPlaca.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtModelo.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });
    }

    private void guardar() {

        if(txtPlaca.getText().isEmpty()
                || txtModelo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Completa todos los campos");

            return;
        }

        modelo.addRow(new Object[] {
                txtPlaca.getText(),
                txtModelo.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(txtPlaca.getText(), fila,0);

            modelo.setValueAt(txtModelo.getText(), fila,1);
        }
    }

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.removeRow(fila);
        }
    }

    private void limpiar() {

        txtPlaca.setText("");

        txtModelo.setText("");
    }
}