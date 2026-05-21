package co.edu.poligran.paradigmas.backend.vo;

public class VehiculoVO extends BaseVO {

    private String placa;
    private String tipo;

    public VehiculoVO(int id, String placa, String tipo){
        super(id);
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String toString(){
        return "Vehiculo: " + placa + " - " + tipo;
    }
}