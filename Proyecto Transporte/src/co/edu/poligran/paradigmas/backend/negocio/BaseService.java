package co.edu.poligran.paradigmas.backend.negocio;

import java.util.ArrayList;
import co.edu.poligran.paradigmas.backend.vo.BaseVO;

public class BaseService<T extends BaseVO> {

    protected ArrayList<T> lista = new ArrayList<>();

    public boolean crear(T obj){
        if(buscar(obj.getId()) == null){
            lista.add(obj);
            return true;
        }
        return false;
    }

    public void listar(){
        for(T obj : lista){
            System.out.println(obj);
        }
    }

    public T buscar(int id){
        for(T obj : lista){
            if(obj.getId() == id){
                return obj;
            }
        }
        return null;
    }

    public boolean eliminar(int id){
        T obj = buscar(id);
        if(obj != null){
            lista.remove(obj);
            return true;
        }
        return false;
    }
}