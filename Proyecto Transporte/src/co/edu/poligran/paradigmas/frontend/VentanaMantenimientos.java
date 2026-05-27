package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaMantenimientos extends JFrame {

    private JTextField txtVehiculo;
    private JTextField txtFecha;
    private JTextField txtCosto;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaMantenimientos() {

        JOptionPane.showMessageDialog(
                null,
                "Bienvenido al sistema de mantenimientos"
        );

        setTitle("Gestión de Mantenimientos");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE MANTENIMIENTOS",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Segoe UI", Font.BOLD,28));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(
                BorderFactory.createEmptyBorder(20,0,20,0)
        );

        add(titulo, BorderLayout.NORTH);

        // PANEL CENTRAL
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(new Color(25,25,25));

        // FORMULARIO
        JPanel formulario = new JPanel(
                new GridLayout(3,2,15,15)
        );

        formulario.setBackground(new Color(45,45,45));

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Datos del Mantenimiento",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD,16),
                        Color.WHITE
                )
        );

        JLabel lblVehiculo = new JLabel("Vehículo:");
        lblVehiculo.setForeground(Color.WHITE);
        lblVehiculo.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtVehiculo = new JTextField();

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtFecha = new JTextField();

        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setForeground(Color.WHITE);
        lblCosto.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtCosto = new JTextField();

        formulario.add(lblVehiculo);
        formulario.add(txtVehiculo);

        formulario.add(lblFecha);
        formulario.add(txtFecha);

        formulario.add(lblCosto);
        formulario.add(txtCosto);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Vehículo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Costo");

        tabla = new JTable(modelo);

        tabla.setRowHeight(28);

        tabla.setFont(
                new Font("Segoe UI", Font.PLAIN,14)
        );

        tabla.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD,15)
        );

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Mantenimientos Registrados",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD,16),
                        Color.WHITE
                )
        );

        scroll.setPreferredSize(new Dimension(800,300));

        centro.add(scroll, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // BOTONES
        JPanel botones = new JPanel();

        botones.setBackground(new Color(25,25,25));

        JButton btnGuardar = crearBoton("Guardar");
        JButton btnActualizar = crearBoton("Actualizar");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnLimpiar = crearBoton("Limpiar");

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

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if(fila != -1){

                txtVehiculo.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtFecha.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtCosto.setText(
                        modelo.getValueAt(fila,2).toString()
                );
            }
        });

        setVisible(true);
    }

    // BOTON
    private JButton crearBoton(String texto){

        JButton boton = new JButton(texto);

        boton.setBackground(new Color(170,170,170));
        boton.setForeground(Color.BLACK);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Segoe UI", Font.BOLD,15)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return boton;
    }

    // CRUD
    private void guardar(){

        if(txtVehiculo.getText().isEmpty()
                || txtFecha.getText().isEmpty()
                || txtCosto.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos"
            );

            return;
        }

        modelo.addRow(new Object[]{
                txtVehiculo.getText(),
                txtFecha.getText(),
                txtCosto.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Mantenimiento registrado correctamente"
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(txtVehiculo.getText(), fila,0);
            modelo.setValueAt(txtFecha.getText(), fila,1);
            modelo.setValueAt(txtCosto.getText(), fila,2);

            JOptionPane.showMessageDialog(
                    this,
                    "Mantenimiento actualizado correctamente"
            );

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un mantenimiento"
            );
        }
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.removeRow(fila);

            JOptionPane.showMessageDialog(
                    this,
                    "Mantenimiento eliminado correctamente"
            );

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un mantenimiento"
            );
        }
    }

    private void limpiar(){

        txtVehiculo.setText("");
        txtFecha.setText("");
        txtCosto.setText("");

        txtVehiculo.requestFocus();
    }
}