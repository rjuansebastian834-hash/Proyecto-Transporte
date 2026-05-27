package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaVehiculos extends JFrame {

    private JTextField txtPlaca;
    private JTextField txtModelo;
    private JTextField txtCapacidad;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaVehiculos() {

        setTitle("Gestión de Vehículos");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // MENSAJE BIENVENIDA
        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al sistema de gestión de vehículos",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE VEHÍCULOS",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
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
                        "Datos del Vehículo",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setForeground(Color.WHITE);
        lblPlaca.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtPlaca = new JTextField();
        txtPlaca.setToolTipText("Ingrese la placa del vehículo");

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setForeground(Color.WHITE);
        lblModelo.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtModelo = new JTextField();
        txtModelo.setToolTipText("Ingrese el modelo");

        JLabel lblCapacidad = new JLabel("Capacidad:");
        lblCapacidad.setForeground(Color.WHITE);
        lblCapacidad.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtCapacidad = new JTextField();
        txtCapacidad.setToolTipText("Ingrese cantidad de pasajeros");

        formulario.add(lblPlaca);
        formulario.add(txtPlaca);

        formulario.add(lblModelo);
        formulario.add(txtModelo);

        formulario.add(lblCapacidad);
        formulario.add(txtCapacidad);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Placa");
        modelo.addColumn("Modelo");
        modelo.addColumn("Capacidad");

        tabla = new JTable(modelo);

        tabla.setRowHeight(28);

        tabla.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        tabla.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Vehículos Registrados",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
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

        btnGuardar.setToolTipText("Guardar vehículo");
        btnActualizar.setToolTipText("Actualizar vehículo");
        btnEliminar.setToolTipText("Eliminar vehículo");
        btnLimpiar.setToolTipText("Limpiar campos");

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

                txtPlaca.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtModelo.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtCapacidad.setText(
                        modelo.getValueAt(fila,2).toString()
                );
            }
        });

        setVisible(true);
    }

    // BOTON ESTILO
    private JButton crearBoton(String texto){

        JButton boton = new JButton(texto);

        boton.setBackground(new Color(170,170,170));

        boton.setForeground(Color.BLACK);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return boton;
    }

    // CRUD
    private void guardar(){

        if(txtPlaca.getText().isEmpty()
                || txtModelo.getText().isEmpty()
                || txtCapacidad.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos",
                    "Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtPlaca.getText(),

                txtModelo.getText(),

                txtCapacidad.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Vehículo registrado correctamente",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(
                    txtPlaca.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtModelo.getText(),
                    fila,
                    1
            );

            modelo.setValueAt(
                    txtCapacidad.getText(),
                    fila,
                    2
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Vehículo actualizado correctamente",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un vehículo de la tabla",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Deseas eliminar este vehículo?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Vehículo eliminado correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un vehículo para eliminar",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void limpiar(){

        txtPlaca.setText("");
        txtModelo.setText("");
        txtCapacidad.setText("");

        txtPlaca.requestFocus();

        JOptionPane.showMessageDialog(
                this,
                "Campos limpiados correctamente",
                "Limpieza Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}