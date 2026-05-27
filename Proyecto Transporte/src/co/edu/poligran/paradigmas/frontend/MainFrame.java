package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Sistema de Transporte");

        setSize(1000,650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // COLOR PRINCIPAL NEGRO

        getContentPane().setBackground(
                new Color(18,18,18)
        );

        // PANEL PRINCIPAL

        JPanel panelPrincipal = new JPanel(
                new BorderLayout()
        );

        panelPrincipal.setBackground(
                new Color(18,18,18)
        );

        // TITULO

        JLabel titulo = new JLabel(
                "SISTEMA DE TRANSPORTE",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 40)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(40,0,40,0)
        );

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // MENU

        JPanel menu = new JPanel();

        menu.setLayout(
                new GridLayout(6,2,20,20)
        );

        menu.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        40,
                        40,
                        40
                )
        );

        menu.setBackground(
                new Color(18,18,18)
        );

        // BOTONES

        JButton btnClientes = crearBoton("Clientes");

        JButton btnOperadores = crearBoton("Operadores");

        JButton btnVehiculos = crearBoton("Vehículos");

        JButton btnTrayectos = crearBoton("Trayectos");

        JButton btnTickets = crearBoton("Tickets");

        JButton btnAgencias = crearBoton("Agencias");

        JButton btnTerminales = crearBoton("Terminales");

        JButton btnFacturas = crearBoton("Facturas");

        JButton btnReservas = crearBoton("Reservas");

        JButton btnMantenimientos = crearBoton("Mantenimientos");

        JButton btnSalir = crearBoton("Salir");

        // AGREGAR BOTONES

        menu.add(btnClientes);

        menu.add(btnOperadores);

        menu.add(btnVehiculos);

        menu.add(btnTrayectos);

        menu.add(btnTickets);

        menu.add(btnAgencias);

        menu.add(btnTerminales);

        menu.add(btnFacturas);

        menu.add(btnReservas);

        menu.add(btnMantenimientos);

        menu.add(btnSalir);

        panelPrincipal.add(menu, BorderLayout.CENTER);

        // EVENTOS

        btnClientes.addActionListener(
                e -> new VentanaClientes()
        );

        btnOperadores.addActionListener(
                e -> new VentanaOperadores()
        );

        btnVehiculos.addActionListener(
                e -> new VentanaVehiculos()
        );

        btnTrayectos.addActionListener(
                e -> new VentanaTrayectos()
        );

        btnTickets.addActionListener(
                e -> new VentanaTickets()
        );

        btnAgencias.addActionListener(
                e -> new VentanaAgencias()
        );

        btnTerminales.addActionListener(
                e -> new VentanaTerminales()
        );

        btnFacturas.addActionListener(
                e -> new VentanaFacturas()
        );

        btnReservas.addActionListener(
                e -> new VentanaReservas()
        );

        btnMantenimientos.addActionListener(
                e -> new VentanaMantenimientos()
        );

        btnSalir.addActionListener(
                e -> System.exit(0)
        );

        add(panelPrincipal);

        setVisible(true);
    }

    // BOTONES MODERNOS

    private JButton crearBoton(String texto) {

        JButton boton = new JButton(texto);

        boton.setBackground(
                new Color(120,120,120)
        );

        boton.setForeground(Color.WHITE);

        boton.setFont(
                new Font("Segoe UI", Font.BOLD, 20)
        );

        boton.setFocusPainted(false);

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        boton.setBorder(
                BorderFactory.createLineBorder(
                        new Color(180,180,180),
                        1
                )
        );

        return boton;
    }
}