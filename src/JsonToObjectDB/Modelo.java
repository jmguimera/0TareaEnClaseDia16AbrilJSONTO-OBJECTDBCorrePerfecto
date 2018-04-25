package JsonToObjectDB;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author josem
 */
@Entity
public class Modelo {
    
    private int idModelo;
    @Id
    private String nombre;

    public Modelo(int idModelo, String nombre) {
        this.idModelo = idModelo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    
}
