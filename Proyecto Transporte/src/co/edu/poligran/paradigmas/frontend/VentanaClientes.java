package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaClientes extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JTextField txtEdad;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaClientes() {

        setTitle("Gestión de Clientes");
        setSize(1000,650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // BIENVENIDA
        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al sistema de clientes",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE CLIENTES",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );

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
                new GridLayout(6,2,15,15)
        );

        formulario.setBackground(new Color(45,45,45));

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Datos del Cliente",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD,16),
                        Color.WHITE
                )
        );

        // LABELS
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setForeground(Color.WHITE);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setForeground(Color.WHITE);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setForeground(Color.WHITE);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setForeground(Color.WHITE);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(Color.WHITE);

        // CAMPOS
        txtNombre = new JTextField();
        txtDocumento = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        txtDireccion = new JTextField();
        txtEdad = new JTextField();

        txtNombre.setToolTipText("Ingrese el nombre");
        txtDocumento.setToolTipText("Ingrese el documento");
        txtTelefono.setToolTipText("Ingrese el teléfono");
        txtCorreo.setToolTipText("Ingrese el correo");
        txtDireccion.setToolTipText("Ingrese la dirección");
        txtEdad.setToolTipText("Ingrese la edad");

        formulario.add(lblNombre);
        formulario.add(txtNombre);

        formulario.add(lblDocumento);
        formulario.add(txtDocumento);

        formulario.add(lblTelefono);
        formulario.add(txtTelefono);

        formulario.add(lblCorreo);
        formulario.add(txtCorreo);

        formulario.add(lblDireccion);
        formulario.add(txtDireccion);

        formulario.add(lblEdad);
        formulario.add(txtEdad);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Documento");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("Dirección");
        modelo.addColumn("Edad");

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
                        "Clientes Registrados",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD,16),
                        Color.WHITE
                )
        );

        centro.add(scroll, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // BOTONES
        JPanel botones = new JPanel();

        botones.setBackground(new Color(25,25,25));

        JButton btnGuardar = crearBoton("Guardar");
        JButton btnActualizar = crearBoton("Actualizar");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnLimpiar = crearBoton("Limpiar");

        btnGuardar.setToolTipText("Guardar cliente");
        btnActualizar.setToolTipText("Actualizar cliente");
        btnEliminar.setToolTipText("Eliminar cliente");
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

                txtNombre.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtDocumento.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtTelefono.setText(
                        modelo.getValueAt(fila,2).toString()
                );

                txtCorreo.setText(
                        modelo.getValueAt(fila,3).toString()
                );

                txtDireccion.setText(
                        modelo.getValueAt(fila,4).toString()
                );

                txtEdad.setText(
                        modelo.getValueAt(fila,5).toString()
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

    // GUARDAR
    private void guardar(){

        if(txtNombre.getText().isEmpty() ||
                txtDocumento.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() ||
                txtCorreo.getText().isEmpty() ||
                txtDireccion.getText().isEmpty() ||
                txtEdad.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos",
                    "Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtNombre.getText(),

                txtDocumento.getText(),

                txtTelefono.getText(),

                txtCorreo.getText(),

                txtDireccion.getText(),

                txtEdad.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Cliente registrado correctamente",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiar();
    }

    // ACTUALIZAR
    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(txtNombre.getText(), fila,0);

            modelo.setValueAt(txtDocumento.getText(), fila,1);

            modelo.setValueAt(txtTelefono.getText(), fila,2);

            modelo.setValueAt(txtCorreo.getText(), fila,3);

            modelo.setValueAt(txtDireccion.getText(), fila,4);

            modelo.setValueAt(txtEdad.getText(), fila,5);

            JOptionPane.showMessageDialog(
                    this,
                    "Cliente actualizado correctamente",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un cliente",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // ELIMINAR
    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Deseas eliminar este cliente?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Cliente eliminado correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un cliente para eliminar",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // LIMPIAR
    private void limpiar(){

        txtNombre.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtEdad.setText("");

        txtNombre.requestFocus();

        JOptionPane.showMessageDialog(
                this,
                "Campos limpiados correctamente",
                "Limpieza Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}