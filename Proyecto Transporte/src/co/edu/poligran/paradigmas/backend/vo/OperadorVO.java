package co.edu.poligran.paradigmas.backend.vo;

public class OperadorVO extends BaseVO {

    private String nombre;

    public OperadorVO(int id, String nombre){
        super(id);
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "Operador: " + id + " - " + nombre;
    }
}