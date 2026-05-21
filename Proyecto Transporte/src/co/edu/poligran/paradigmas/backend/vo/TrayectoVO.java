package co.edu.poligran.paradigmas.backend.vo;

public class TrayectoVO extends BaseVO {

    private String inicio;
    private String fin;
    private String horaSalida;
    private String horaLlegada;

    public TrayectoVO(int id, String inicio, String fin, String horaSalida, String horaLlegada){
        super(id);
        this.inicio = inicio;
        this.fin = fin;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String toString(){
        return "Trayecto: " + inicio + " -> " + fin +
                " | Salida: " + horaSalida +
                " | Llegada: " + horaLlegada;
    }
}