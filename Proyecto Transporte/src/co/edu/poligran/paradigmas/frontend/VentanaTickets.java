package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTickets extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtValor;
    private JTextField txtAsiento;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaTickets() {

        setTitle("Gestión de Tickets");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // MENSAJE BIENVENIDA
        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al sistema de gestión de tickets",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE TICKETS",
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
                        "Datos del Ticket",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setForeground(Color.WHITE);
        lblCodigo.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtCodigo = new JTextField();
        txtCodigo.setToolTipText("Ingrese código del ticket");

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setForeground(Color.WHITE);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtValor = new JTextField();
        txtValor.setToolTipText("Ingrese valor del ticket");

        JLabel lblAsiento = new JLabel("Asiento:");
        lblAsiento.setForeground(Color.WHITE);
        lblAsiento.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtAsiento = new JTextField();
        txtAsiento.setToolTipText("Ingrese número de asiento");

        formulario.add(lblCodigo);
        formulario.add(txtCodigo);

        formulario.add(lblValor);
        formulario.add(txtValor);

        formulario.add(lblAsiento);
        formulario.add(txtAsiento);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Valor");
        modelo.addColumn("Asiento");

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
                        "Tickets Registrados",
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

        btnGuardar.setToolTipText("Guardar ticket");
        btnActualizar.setToolTipText("Actualizar ticket");
        btnEliminar.setToolTipText("Eliminar ticket");
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

                txtCodigo.setText(
                        modelo.getValueAt(fila,0).toString()
                );

                txtValor.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtAsiento.setText(
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

        if(txtCodigo.getText().isEmpty()
                || txtValor.getText().isEmpty()
                || txtAsiento.getText().isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos",
                    "Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        modelo.addRow(new Object[]{

                txtCodigo.getText(),

                txtValor.getText(),

                txtAsiento.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Ticket registrado correctamente",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        limpiar();
    }

    private void actualizar(){

        int fila = tabla.getSelectedRow();

        if(fila != -1){

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

            modelo.setValueAt(
                    txtAsiento.getText(),
                    fila,
                    2
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Ticket actualizado correctamente",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un ticket de la tabla",
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
                    "¿Deseas eliminar este ticket?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Ticket eliminado correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un ticket para eliminar",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void limpiar(){

        txtCodigo.setText("");
        txtValor.setText("");
        txtAsiento.setText("");

        txtCodigo.requestFocus();

        JOptionPane.showMessageDialog(
                this,
                "Campos limpiados correctamente",
                "Limpieza Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}