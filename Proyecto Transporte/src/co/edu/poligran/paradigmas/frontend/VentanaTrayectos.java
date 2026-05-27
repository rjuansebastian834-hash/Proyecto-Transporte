package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTrayectos extends JFrame {

    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JTextField txtKilometros;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaTrayectos() {

        JOptionPane.showMessageDialog(
                null,
                "Bienvenido al sistema de gestión de trayectos"
        );

        setTitle("Gestión de Trayectos");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE TRAYECTOS",
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
                        "Datos del Trayecto",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD,16),
                        Color.WHITE
                )
        );

        JLabel lblOrigen = new JLabel("Origen:");
        lblOrigen.setForeground(Color.WHITE);
        lblOrigen.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtOrigen = new JTextField();
        txtOrigen.setToolTipText("Ingrese ciudad de origen");

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setForeground(Color.WHITE);
        lblDestino.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtDestino = new JTextField();
        txtDestino.setToolTipText("Ingrese ciudad destino");

        JLabel lblKilometros = new JLabel("Kilómetros:");
        lblKilometros.setForeground(Color.WHITE);
        lblKilometros.setFont(new Font("Segoe UI", Font.BOLD,15));

        txtKilometros = new JTextField();
        txtKilometros.setToolTipText("Ingrese distancia del trayecto");

        formulario.add(lblOrigen);
        formulario.add(txtOrigen);

        formulario.add(lblDestino);
        formulario.add(txtDestino);

        formulario.add(lblKilometros);
        formulario.add(txtKilometros);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Kilómetros");

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
                        "Trayectos Registrados",
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

                txtOrigen.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtDestino.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtKilometros.setText(
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

        if(txtOrigen.getText().isEmpty()
                || txtDestino.getText().isEmpty()
                || txtKilometros.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos"
            );

            return;
        }

        modelo.addRow(new Object[]{
                txtOrigen.getText(),
                txtDestino.getText(),
                txtKilometros.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Trayecto registrado correctamente"
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(txtOrigen.getText(), fila,0);
            modelo.setValueAt(txtDestino.getText(), fila,1);
            modelo.setValueAt(txtKilometros.getText(), fila,2);

            JOptionPane.showMessageDialog(
                    this,
                    "Trayecto actualizado correctamente"
            );

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un trayecto"
            );
        }
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.removeRow(fila);

            JOptionPane.showMessageDialog(
                    this,
                    "Trayecto eliminado correctamente"
            );

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un trayecto"
            );
        }
    }

    private void limpiar(){

        txtOrigen.setText("");
        txtDestino.setText("");
        txtKilometros.setText("");

        txtOrigen.requestFocus();
    }
}