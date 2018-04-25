package JsonToObjectDB;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author josem
 */
@Entity
public class Data0 {
    @Id
    private int idMarca;
    private String nombre;
    private ArrayList<Modelo> misModelos;
    
    public Data0(int idMarca, String nombre, ArrayList<Modelo> misModelos) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.misModelos = misModelos;
    }

    public ArrayList<Modelo> getMisModelos() {
        return misModelos;
    }

    public void setMisModelos(ArrayList<Modelo> misModelos) {
        this.misModelos = misModelos;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    
}

