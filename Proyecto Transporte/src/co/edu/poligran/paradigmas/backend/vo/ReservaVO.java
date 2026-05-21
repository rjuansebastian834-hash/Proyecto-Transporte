package co.edu.poligran.paradigmas.backend.vo;

public class ReservaVO extends BaseVO {

    private String estado;

    public ReservaVO(int id, String estado){
        super(id);
        this.estado = estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String toString(){
        return "Reserva: " + id + " - " + estado;
    }
}