package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaOperadores extends JFrame {

    private JTextField txtNombre;
    private JTextField txtLicencia;
    private JTextField txtExperiencia;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaOperadores() {

        setTitle("Gestión de Operadores");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(25,25,25));

        // MENSAJE BIENVENIDA
        JOptionPane.showMessageDialog(
                this,
                "Bienvenido al sistema de gestión de operadores",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // TITULO
        JLabel titulo = new JLabel(
                "GESTIÓN DE OPERADORES",
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
                        "Datos del Operador",
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtNombre = new JTextField();
        txtNombre.setToolTipText("Ingrese nombre del operador");

        JLabel lblLicencia = new JLabel("Licencia:");
        lblLicencia.setForeground(Color.WHITE);
        lblLicencia.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtLicencia = new JTextField();
        txtLicencia.setToolTipText("Ejemplo: C1, C2 o C3");

        JLabel lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setForeground(Color.WHITE);
        lblExperiencia.setFont(new Font("Segoe UI", Font.BOLD, 15));

        txtExperiencia = new JTextField();
        txtExperiencia.setToolTipText("Años de experiencia");

        formulario.add(lblNombre);
        formulario.add(txtNombre);

        formulario.add(lblLicencia);
        formulario.add(txtLicencia);

        formulario.add(lblExperiencia);
        formulario.add(txtExperiencia);

        centro.add(formulario, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Licencia");
        modelo.addColumn("Experiencia");

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
                        "Operadores Registrados",
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

        btnGuardar.setToolTipText("Guardar operador");
        btnActualizar.setToolTipText("Actualizar operador");
        btnEliminar.setToolTipText("Eliminar operador");
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

                txtLicencia.setText(
                        modelo.getValueAt(fila,1).toString()
                );

                txtExperiencia.setText(
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
                new Font("Segoe UI", Font.BOLD,15)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return boton;
    }

    // CRUD
    private void guardar(){

        if(txtNombre.getText().isEmpty()
                || txtLicencia.getText().isEmpty()
                || txtExperiencia.getText().isEmpty()){

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

                txtLicencia.getText(),

                txtExperiencia.getText()
        });

        JOptionPane.showMessageDialog(
                this,
                "Operador registrado correctamente",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
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
                    txtLicencia.getText(),
                    fila,
                    1
            );

            modelo.setValueAt(
                    txtExperiencia.getText(),
                    fila,
                    2
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Operador actualizado correctamente",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un operador de la tabla",
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
                    "¿Deseas eliminar este operador?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if(opcion == JOptionPane.YES_OPTION){

                modelo.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Operador eliminado correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona un operador para eliminar",
                    "Sin Selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void limpiar(){

        txtNombre.setText("");
        txtLicencia.setText("");
        txtExperiencia.setText("");

        txtNombre.requestFocus();

        JOptionPane.showMessageDialog(
                this,
                "Campos limpiados correctamente",
                "Limpieza Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}