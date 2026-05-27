package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaReservas extends JFrame {

    private JTextField txtCliente;
    private JTextField txtDestino;
    private JTextField txtFecha;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaReservas() {

        setTitle("Gestión de Reservas");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // MENSAJE BIENVENIDA
        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al sistema de gestión de reservas",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE RESERVAS",
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
                        "Datos de la Reserva",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setForeground(Color.WHITE);
        lblCliente.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtCliente = new JTextField();
        txtCliente.setToolTipText("Ingrese nombre del cliente");

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setForeground(Color.WHITE);
        lblDestino.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtDestino = new JTextField();
        txtDestino.setToolTipText("Ingrese destino del viaje");

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtFecha = new JTextField();
        txtFecha.setToolTipText("Ingrese fecha de la reserva");

        formulario.add(lblCliente);
        formulario.add(txtCliente);

        formulario.add(lblDestino);
        formulario.add(txtDestino);

        formulario.add(lblFecha);
        formulario.add(txtFecha);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Cliente");
        modelo.addColumn("Destino");
        modelo.addColumn("Fecha");

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
                        "Reservas Registradas",
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

        btnGuardar.setToolTipText("Guardar reserva");
        btnActualizar.setToolTipText("Actualizar reserva");
        btnEliminar.setToolTipText("Eliminar reserva");
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

                txtCliente.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtDestino.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtFecha.setText(
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

        if(txtCliente.getText().isEmpty()
                || txtDestino.getText().isEmpty()
                || txtFecha.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos",
                    "Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtCliente.getText(),

                txtDestino.getText(),

                txtFecha.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Reserva registrada correctamente",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(
                    txtCliente.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtDestino.getText(),
                    fila,
                    1
            );

            modelo.setValueAt(
                    txtFecha.getText(),
                    fila,
                    2
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva actualizada correctamente",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona una reserva de la tabla",
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
                    "¿Deseas eliminar esta reserva?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Reserva eliminada correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona una reserva para eliminar",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void limpiar(){

        txtCliente.setText("");
        txtDestino.setText("");
        txtFecha.setText("");

        txtCliente.requestFocus();

        JOptionPane.showMessageDialog(
                this,
                "Campos limpiados correctamente",
                "Limpieza Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}