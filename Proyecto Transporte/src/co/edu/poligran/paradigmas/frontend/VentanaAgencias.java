package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaAgencias extends JFrame {

    private JTextField txtNombre;
    private JTextField txtCiudad;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaAgencias() {

        setTitle("Sistema de Transporte - Agencias");

        setSize(850,550);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(25,25,25)
        );

        // TITULO

        JLabel titulo = new JLabel(
                "GESTIÓN DE AGENCIAS",
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
                new Color(25,25,25)
        );

        // FORMULARIO

        JPanel formulario = new JPanel(
                new GridLayout(2,2,15,15)
        );

        formulario.setBackground(
                new Color(45,45,45)
        );

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Datos de la Agencia",
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

        JLabel lblCiudad = new JLabel("Ciudad:");

        lblCiudad.setForeground(Color.WHITE);

        lblCiudad.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        txtCiudad = new JTextField();

        formulario.add(lblNombre);

        formulario.add(txtNombre);

        formulario.add(lblCiudad);

        formulario.add(txtCiudad);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");

        modelo.addColumn("Ciudad");

        tabla = new JTable(modelo);

        tabla.setRowHeight(28);

        tabla.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        tabla.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        tabla.setSelectionBackground(
                new Color(90,90,90)
        );

        tabla.setSelectionForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Agencias Registradas",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        scroll.setPreferredSize(
                new Dimension(800,300)
        );

        centro.add(scroll, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // BOTONES

        JPanel botones = new JPanel();

        botones.setBackground(
                new Color(25,25,25)
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

            if(fila != -1){

                txtNombre.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtCiudad.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });

        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al módulo de Agencias."
        );

        setVisible(true);
    }

    // BOTON ESTILO

    private JButton crearBoton(String texto){

        JButton boton = new JButton(texto);

        boton.setBackground(
                new Color(170,170,170)
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

    // CRUD

    private void guardar(){

        if(txtNombre.getText().isEmpty()
                || txtCiudad.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos"
            );

            return;
        }

        if(txtNombre.getText().length() < 3){

            JOptionPane.showMessageDialog(
                    this,
                    "El nombre de la agencia es muy corto."
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtNombre.getText(),

                txtCiudad.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Agencia registrada correctamente.\nGracias por usar el sistema."
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(
                    txtNombre.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtCiudad.getText(),
                    fila,
                    1
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Datos de la agencia actualizados correctamente."
            );
        }
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea eliminar esta agencia?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Agencia eliminada correctamente."
                );
            }
        }
    }

    private void limpiar(){

        txtNombre.setText("");

        txtCiudad.setText("");

        txtNombre.requestFocus();
    }
}