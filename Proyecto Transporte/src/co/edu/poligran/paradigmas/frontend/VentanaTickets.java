package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTickets extends JFrame {

    private JTextField txtPasajero;
    private JTextField txtDestino;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaTickets() {

        setTitle("CRUD Tickets");

        setSize(700,500);

        setLocationRelativeTo(null);

        setVisible(true);

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3,2,10,10));

        formulario.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        formulario.add(new JLabel("Pasajero"));

        txtPasajero = new JTextField();

        formulario.add(txtPasajero);

        formulario.add(new JLabel("Destino"));

        txtDestino = new JTextField();

        formulario.add(txtDestino);

        add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Pasajero");

        modelo.addColumn("Destino");

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

                txtPasajero.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtDestino.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });
    }

    private void guardar() {

        if(txtPasajero.getText().isEmpty()
                || txtDestino.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Completa todos los campos");

            return;
        }

        modelo.addRow(new Object[] {
                txtPasajero.getText(),
                txtDestino.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(txtPasajero.getText(), fila,0);

            modelo.setValueAt(txtDestino.getText(), fila,1);
        }
    }

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.removeRow(fila);
        }
    }

    private void limpiar() {

        txtPasajero.setText("");

        txtDestino.setText("");
    }
}