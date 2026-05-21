package co.edu.poligran.paradigmas.backend.vo;

public class MantenimientoVO extends BaseVO {

    private String descripcion;

    public MantenimientoVO(int id, String descripcion){
        super(id);
        this.descripcion = descripcion;
    }

    public void setDescripcion(String d){
        this.descripcion = d;
    }

    public String toString(){
        return "Mantenimiento: " + id + " - " + descripcion;
    }
}