package co.edu.poligran.paradigmas.backend.vo;

public class ClienteVO extends BaseVO {

    private String nombre;

    public ClienteVO(int id, String nombre){
        super(id);
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "Cliente: " + id + " - " + nombre;
    }
}