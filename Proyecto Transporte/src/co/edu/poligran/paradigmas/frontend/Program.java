package co.edu.poligran.paradigmas.frontend;

import java.util.Scanner;
import co.edu.poligran.paradigmas.backend.negocio.*;
import co.edu.poligran.paradigmas.backend.vo.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BaseService<ClienteVO> cliente = new ClienteService();
        BaseService<OperadorVO> operador = new OperadorService();
        BaseService<VehiculoVO> vehiculo = new VehiculoService();
        BaseService<TrayectoVO> trayecto = new TrayectoService();
        BaseService<TicketVO> ticket = new TicketService();
        BaseService<AgenciaVO> agencia = new AgenciaService();
        BaseService<TerminalVO> terminal = new TerminalService();
        BaseService<FacturaVO> factura = new FacturaService();
        BaseService<ReservaVO> reserva = new ReservaService();
        BaseService<MantenimientoVO> mantenimiento = new MantenimientoService();

        int op;

        do {
            System.out.println("\n=== SISTEMA TRANSPORTE ===");
            System.out.println("1. Clientes");
            System.out.println("2. Operadores");
            System.out.println("3. Vehiculos");
            System.out.println("4. Trayectos");
            System.out.println("5. Tickets");
            System.out.println("6. Agencias");
            System.out.println("7. Terminales");
            System.out.println("8. Facturas");
            System.out.println("9. Reservas");
            System.out.println("10. Mantenimiento");
            System.out.println("0. Salir");

            op = leerInt(sc);

            switch(op){
                case 1: menuCliente(sc, cliente); break;
                case 2: menuOperador(sc, operador); break;
                case 3: menuVehiculo(sc, vehiculo); break;
                case 4: menuTrayecto(sc, trayecto); break;
                case 5: menuTicket(sc, ticket); break;
                case 6: menuAgencia(sc, agencia); break;
                case 7: menuTerminal(sc, terminal); break;
                case 8: menuFactura(sc, factura); break;
                case 9: menuReserva(sc, reserva); break;
                case 10: menuMantenimiento(sc, mantenimiento); break;
            }

        } while(op != 0);

        sc.close();
    }

    // -------- CLIENTE --------
    public static void menuCliente(Scanner sc, BaseService<ClienteVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    s.crear(new ClienteVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    ClienteVO c = s.buscar(leerInt(sc));
                    System.out.println(c != null ? c : "No existe");
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- OPERADOR --------
    public static void menuOperador(Scanner sc, BaseService<OperadorVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    s.crear(new OperadorVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- VEHICULO --------
    public static void menuVehiculo(Scanner sc, BaseService<VehiculoVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    s.crear(new VehiculoVO(id, placa, tipo));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- TRAYECTO (MODIFICADO) --------
    public static void menuTrayecto(Scanner sc, BaseService<TrayectoVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();

                    System.out.print("Inicio: ");
                    String i = sc.nextLine();

                    System.out.print("Fin: ");
                    String f = sc.nextLine();

                    System.out.print("Hora salida (HH:mm): ");
                    String hs = sc.nextLine();

                    System.out.print("Hora llegada (HH:mm): ");
                    String hl = sc.nextLine();

                    s.crear(new TrayectoVO(id, i, f, hs, hl));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- TICKET --------
    public static void menuTicket(Scanner sc, BaseService<TicketVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    System.out.print("Precio: ");
                    double p = sc.nextDouble();
                    s.crear(new TicketVO(id,p));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- AGENCIA --------
    public static void menuAgencia(Scanner sc, BaseService<AgenciaVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    s.crear(new AgenciaVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- TERMINAL --------
    public static void menuTerminal(Scanner sc, BaseService<TerminalVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    s.crear(new TerminalVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- FACTURA --------
    public static void menuFactura(Scanner sc, BaseService<FacturaVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    System.out.print("Total: ");
                    double t = sc.nextDouble();
                    s.crear(new FacturaVO(id,t));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- RESERVA --------
    public static void menuReserva(Scanner sc, BaseService<ReservaVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Estado: ");
                    s.crear(new ReservaVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- MANTENIMIENTO --------
    public static void menuMantenimiento(Scanner sc, BaseService<MantenimientoVO> s){
        int op;
        do{
            System.out.println("\n1 Crear 2 Listar 3 Buscar 4 Eliminar 0 Volver");
            op = leerInt(sc);

            switch(op){
                case 1:
                    System.out.print("ID: ");
                    int id = leerInt(sc);
                    sc.nextLine();
                    System.out.print("Descripcion: ");
                    s.crear(new MantenimientoVO(id, sc.nextLine()));
                    break;

                case 2: s.listar(); break;

                case 3:
                    System.out.print("ID: ");
                    System.out.println(s.buscar(leerInt(sc)));
                    break;

                case 4:
                    System.out.print("ID: ");
                    if(!s.eliminar(leerInt(sc))) System.out.println("No existe");
                    break;
            }
        }while(op != 0);
    }

    // -------- VALIDACION --------
    public static int leerInt(Scanner sc){
        while(true){
            try{
                return sc.nextInt();
            }catch(Exception e){
                System.out.println("Dato invalido, intente otra vez");
                sc.nextLine();
            }
        }
    }
}