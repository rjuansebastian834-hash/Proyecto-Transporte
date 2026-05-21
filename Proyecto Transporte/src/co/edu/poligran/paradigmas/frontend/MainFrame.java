package co.edu.poligran.paradigmas.frontend;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Sistema de Transporte");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("SISTEMA DE TRANSPORTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel menu = new JPanel();

        // CAMBIADO A 6x2 PARA QUE QUEPAN TODOS
        menu.setLayout(new GridLayout(6, 2, 20, 20));

        menu.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JButton btnClientes = new JButton("Clientes");
        JButton btnOperadores = new JButton("Operadores");
        JButton btnVehiculos = new JButton("Vehiculos");
        JButton btnTrayectos = new JButton("Trayectos");
        JButton btnTickets = new JButton("Tickets");
        JButton btnAgencias = new JButton("Agencias");
        JButton btnTerminales = new JButton("Terminales");
        JButton btnFacturas = new JButton("Facturas");
        JButton btnReservas = new JButton("Reservas");
        JButton btnMantenimientos = new JButton("Mantenimientos");
        JButton btnSalir = new JButton("Salir");

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

        // EVENTOS FUNCIONALES

        btnClientes.addActionListener(e ->
                new VentanaClientes());

        btnOperadores.addActionListener(e ->
                new VentanaOperadores());

        btnVehiculos.addActionListener(e ->
                new VentanaVehiculos());

        btnTrayectos.addActionListener(e ->
                new VentanaTrayectos());

        btnTickets.addActionListener(e ->
                new VentanaTickets());

        btnAgencias.addActionListener(e ->
                new VentanaAgencias());

        btnTerminales.addActionListener(e ->
                new VentanaTerminales());

        btnFacturas.addActionListener(e ->
                new VentanaFacturas());

        btnReservas.addActionListener(e ->
                new VentanaReservas());

        btnMantenimientos.addActionListener(e ->
                new VentanaMantenimientos());

        btnSalir.addActionListener(e ->
                System.exit(0));

        add(panelPrincipal);
    }
}