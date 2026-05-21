package co.edu.poligran.paradigmas.backend.vo;

public class AgenciaVO extends BaseVO {

    private String nombre;

    public AgenciaVO(int id, String nombre){
        super(id);
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "Agencia: " + id + " - " + nombre;
    }
}