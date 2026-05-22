// ===============================
// VENTANATICKETS.JAVA
// ===============================

package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTickets extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtValor;

    private JTable tabla;

    private DefaultTableModel modelo;

    public VentanaTickets() {

        setTitle("Gestión de Tickets");

        setSize(850,550);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15,23,42)
        );

        JLabel titulo = new JLabel(
                "GESTIÓN DE TICKETS",
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

        JPanel centro = new JPanel(new BorderLayout());

        centro.setBackground(new Color(15,23,42));

        JPanel formulario = new JPanel(
                new GridLayout(2,2,15,15)
        );

        formulario.setBackground(new Color(30,41,59));

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.WHITE),
                        "Datos del Ticket",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setForeground(Color.WHITE);

        txtCodigo = new JTextField();

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setForeground(Color.WHITE);

        txtValor = new JTextField();

        formulario.add(lblCodigo);
        formulario.add(txtCodigo);
        formulario.add(lblValor);
        formulario.add(txtValor);

        centro.add(formulario, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Valor");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        centro.add(scroll, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        JPanel botones = new JPanel();

        botones.setBackground(new Color(15,23,42));

        JButton btnGuardar = crearBoton("Guardar");
        JButton btnActualizar = crearBoton("Actualizar");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnLimpiar = crearBoton("Limpiar");

        botones.add(btnGuardar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);
        botones.add(btnLimpiar);

        add(botones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());
        btnLimpiar.addActionListener(e -> limpiar());

        setVisible(true);
    }

    private JButton crearBoton(String texto) {

        JButton boton = new JButton(texto);

        boton.setBackground(new Color(191,219,254));

        boton.setForeground(Color.BLACK);

        boton.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        return boton;
    }

    private void guardar() {

        modelo.addRow(new Object[] {
                txtCodigo.getText(),
                txtValor.getText()
        });

        limpiar();
    }

    private void actualizar() {

        int fila = tabla.getSelectedRow();

        if(fila != -1) {

            modelo.setValueAt(
                    txtCodigo.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtValor.getText(),
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

        txtCodigo.setText("");
        txtValor.setText("");
    }
}