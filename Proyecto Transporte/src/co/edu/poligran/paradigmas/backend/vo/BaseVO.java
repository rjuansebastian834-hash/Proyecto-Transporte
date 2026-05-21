package co.edu.poligran.paradigmas.backend.vo;

public abstract class BaseVO {

    protected int id;

    public BaseVO(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}