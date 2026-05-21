package co.edu.poligran.paradigmas.backend.vo;

public class FacturaVO extends BaseVO {

    private double total;

    public FacturaVO(int id, double total){
        super(id);
        this.total = total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String toString(){
        return "Factura: " + id + " - $" + total;
    }
}