package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaMantenimientos extends JFrame {

    private JTextField txtVehiculo;
    private JTextField txtEstado;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaMantenimientos() {

        setTitle("CRUD Mantenimientos");

        setSize(700,500);

        setLocationRelativeTo(null);

        setVisible(true);

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3,2,10,10));

        formulario.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );

        formulario.add(new JLabel("Vehículo"));

        txtVehiculo = new JTextField();

        formulario.add(txtVehiculo);

        formulario.add(new JLabel("Estado"));

        txtEstado = new JTextField();

        formulario.add(txtEstado);

        add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Vehículo");

        modelo.addColumn("Estado");

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

                txtVehiculo.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtEstado.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });
    }

    private void guardar() {

        if(txtVehiculo.getText().isEmpty()
                || txtEstado.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Completa todos los campos");

            return;
        }

        modelo.addRow(new Object[] {
                txtVehiculo.getText(),
                txtEstado.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(txtVehiculo.getText(), fila,0);

            modelo.setValueAt(txtEstado.getText(), fila,1);
        }
    }

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.removeRow(fila);
        }
    }

    private void limpiar() {

        txtVehiculo.setText("");

        txtEstado.setText("");
    }
}