package co.edu.poligran.paradigmas.backend.vo;

public class TicketVO extends BaseVO {

    private double precio;

    public TicketVO(int id, double precio){
        super(id);
        this.precio = precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String toString(){
        return "Ticket: " + id + " - $" + precio;
    }
}