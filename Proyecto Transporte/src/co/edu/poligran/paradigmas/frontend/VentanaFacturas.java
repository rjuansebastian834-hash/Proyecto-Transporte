package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaFacturas extends JFrame {

    private JTextField txtNumero;
    private JTextField txtTotal;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaFacturas() {

        setTitle("Sistema de Transporte - Facturas");

        setSize(850,550);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(25,25,25)
        );

        // TITULO

        JLabel titulo = new JLabel(
                "GESTIÓN DE FACTURAS",
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
                        "Datos de la Factura",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblNumero = new JLabel("Número:");

        lblNumero.setForeground(Color.WHITE);

        lblNumero.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        txtNumero = new JTextField();

        JLabel lblTotal = new JLabel("Total:");

        lblTotal.setForeground(Color.WHITE);

        lblTotal.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        txtTotal = new JTextField();

        formulario.add(lblNumero);

        formulario.add(txtNumero);

        formulario.add(lblTotal);

        formulario.add(txtTotal);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA

        modelo = new DefaultTableModel();

        modelo.addColumn("Número");

        modelo.addColumn("Total");

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
                        "Facturas Registradas",
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

                txtNumero.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtTotal.setText(
                        modelo.getValueAt(fila,1).toString()
                );
            }
        });

        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al módulo de Facturas."
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

        if(txtNumero.getText().isEmpty()
                || txtTotal.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos"
            );

            return;
        }

        try{
            Double.parseDouble(txtTotal.getText());
        }
        catch(Exception e){

            JOptionPane.showMessageDialog(
                    this,
                    "El total debe ser numérico."
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtNumero.getText(),

                txtTotal.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Factura registrada correctamente.\nGracias por usar el sistema."
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            modelo.setValueAt(
                    txtNumero.getText(),
                    fila,
                    0
            );

            modelo.setValueAt(
                    txtTotal.getText(),
                    fila,
                    1
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Factura actualizada correctamente."
            );
        }
    }

    private void eliminar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea eliminar esta factura?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Factura eliminada correctamente."
                );
            }
        }
    }

    private void limpiar(){

        txtNumero.setText("");

        txtTotal.setText("");

        txtNumero.requestFocus();
    }
}