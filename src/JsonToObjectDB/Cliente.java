package JsonToObjectDB;

 



/**
 *
 * @author fermin
 */

public class Cliente  {
     
       
       public MiTipoDeDato nif=new MiTipoDeDato(); // a la clase MiTipoDeDato hay que ponerle @XmlType en la definicion
       public String nombre;
       public String telefono;
       public String direccion;
       public float Deuda;
       
       
       
       @Override
       public String toString()
       { return "NIF: "+this.nif.dato+", Nombre = "+this.nombre
                +", Teléfono : "+this.telefono
                +", Direccición : "+this.direccion+
               ", Deuda : "+this.Deuda;
           
       }
       
       
}
