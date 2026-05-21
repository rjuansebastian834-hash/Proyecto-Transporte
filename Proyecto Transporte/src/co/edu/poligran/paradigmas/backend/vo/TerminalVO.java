package co.edu.poligran.paradigmas.backend.vo;

public class TerminalVO extends BaseVO {

    private String nombre;

    public TerminalVO(int id, String nombre){
        super(id);
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "Terminal: " + id + " - " + nombre;
    }
}