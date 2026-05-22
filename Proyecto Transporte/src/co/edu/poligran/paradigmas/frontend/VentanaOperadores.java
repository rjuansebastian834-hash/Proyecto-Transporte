package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaOperadores extends JFrame {

    private JTextField txtNombre;
    private JTextField txtLicencia;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaOperadores() {

        setTitle("Gestión de Operadores");

        setSize(850,550);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15,23,42)
        );

        // TITULO

        JLabel titulo = new JLabel(
                "GESTIÓN DE OPERADORES",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 28)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(20,0,20,0)
        );

        add(titulo, BorderLayout.NORTH);

        // PANEL CENTRAL

        JPanel centro = new JPanel(
                new BorderLayout()
        );

        centro.setBackground(
                new Color(15,23,42)
        );

        // FORMULARIO

        JPanel formulario = new JPanel(
                new GridLayout(2,2,15,15)
        );

        formulario.setBackground(
                new Color(30,41,59)
        );

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.WHITE),
                        "Datos del Operador",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblNombre = new JLabel("Nombre:");

        lblNombre.setForeground(Color.WHITE);

        lblNombre.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        txtNombre = new JTextField();

        JLabel lblLicencia = new JLabel("Licencia:");

        lblLicencia.setForeground(Color.WHITE);

        lblLicencia.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        txtLicencia = new JTextField();

        formulario.add(lblNombre);

        formulario.add(txtNombre);

        formulario.add(lblLicencia);

        formulario.add(txtLicencia);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");

        modelo.addColumn("Licencia");

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
                        BorderFactory.createLineBorder(Color.WHITE),
                        "Operadores Registrados",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        centro.add(scroll, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // BOTONES

        JPanel botones = new JPanel();

        botones.setBackground(
                new Color(15,23,42)
        );

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

        btnGuardar.addActionListener(
                e -> guardar()
        );

        btnActualizar.addActionListener(
                e -> actualizar()
        );

        btnEliminar.addActionListener(
                e -> eliminar()
        );

        btnLimpiar.addActionListener(
                e -> limpiar()
        );

        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if(fila != -1) {

                txtNombre.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtLicencia.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });

        setVisible(true);
    }

    // BOTON ESTILO

    private JButton crearBoton(String texto) {

        JButton boton = new JButton(texto);

        boton.setBackground(
                new Color(191,219,254)
        );

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

    // FUNCIONES CRUD

    private void guardar() {

        if(txtNombre.getText().isEmpty()
                || txtLicencia.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos"
            );

            return;
        }

        modelo.addRow(new Object[] {

                txtNombre.getText(),

                txtLicencia.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(
                    txtNombre.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtLicencia.getText(),
                    fila,
                    1
            );
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

        txtLicencia.setText("");
    }
}