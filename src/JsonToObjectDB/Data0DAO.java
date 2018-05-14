/*
 * ClientesDAO.java
 */
package JsonToObjectDB;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Data0DAO {

    private EntityManagerFactory emf;
    private EntityManager em;
  

    // insertando un registro
    public void guardaRegistro(Data0 marca) {

        try {
            iniciaOperacion();

            em.getTransaction().begin();
            em.persist(marca);
            em.getTransaction().commit();
        } catch (Exception he) {
            // envia el error he si lo hay a la rutina que maneja los mensajes
            manejaExcepcion(he);
        } finally {
            // en cualquier caso cierra la sesion
            em.close();
        }

    }

    // modificando un registro (actualizarlo)
    public void actualizaCliente(String clienteNif,Data0 nvocl) {
        try {
            iniciaOperacion();
            // actualizacion objectDB
            em.getTransaction().begin();
            Data0 marca=em.find(Data0.class,clienteNif);
           /* marca.setNif(nvocl..idMarca());
            marca.setNombre(nvocl.getNombre());            
            marca.setTelefono(nvocl.getTelefono());            
            marca.setDireccion(nvocl.getDireccion());  */          
            // confirma la grabacion
            em.getTransaction().commit();
        } catch (Exception he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            em.close();
        }
    }

    // borrando un registro de la tabla
    public void eliminaCliente(Data0 marca) {
        try {
            iniciaOperacion();
            em.getTransaction().begin();
            em.remove(marca);
            em.getTransaction().commit();
        } catch (Exception he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            em.close();
        }
    }

    // buscando un registro
    public Data0 getCliente(String clienteNif) {
        Data0 marca = null;
        try {
            iniciaOperacion();
            // localiza el objeto mediante el atributo
            em.getTransaction().begin();

 //           marca = this.em.find(Data0.class, new Data0(clienteNif, null));

        }catch (Exception he) {
            manejaExcepcion(he);
            throw he;
        }
        
        finally {
            em.close();
        }

        return marca;
    }

    // se obtiene una List coleccion con los objetos clientes
    public List<Data0> getListaClientes() //throws Exception 
    {
        List<Data0> listaClientes = null;
        
        TypedQuery<Data0> query;
        try {
            iniciaOperacion();
            query = em.createQuery("SELECT c FROM Data0 c", Data0.class);
            listaClientes = query.getResultList();
        } finally {
            em.close();
        }

        return listaClientes;

    }
    // aqui llenamos el modelo de la rejilla    

    public DefaultTableModel llenaRejilla(DefaultTableModel dtm) {
        // rutina de creacion de sesion y transaction

        // creamos objeto lista de una coleccion list tipo Clientes retornado
        // por el metodo list() del objeto q de la clase Query
        List<Data0> lista = getListaClientes(); 

        // creamos el iterador iter de la lista
        Iterator<Data0> iter = lista.iterator();

        while (iter.hasNext()) {
            // aqui obtenemos cada objeto cliente que hay en la lista
            Data0 marca = iter.next();

            // luego creamos el objeto fila con los datos que mostrara la tabla,
            // de los gets de las propiedades que necesitamos nif y nombre
            // que es lo que mostraŕa nuestra rejilla
            Object[] fila = {marca.getIdMarca(), marca.getNombre()};

            // añadimos la fila a la rejilla
            dtm.addRow(fila);
        }
        //aqui devolvemos el modelo con el contenido de la rejilla
        return dtm;
    }

    // rutina de inicio de operacion de cada transacción sobre la base de datos
    // crea el objeto sesion e inicia la transaction 
    private void iniciaOperacion() {
        try {
            File fichero=new File("BaseDatos/marcas.odb");
            if(fichero.exists()) { fichero.delete();
            fichero=new File("BaseDatos/marcas.odb$");
             fichero.delete();
            }
           
            
            this.emf = Persistence.createEntityManagerFactory("BaseDatos/marcas.odb");
            this.em = emf.createEntityManager();
        } catch (Exception ex) {
            System.out.println("Error de exception: " + ex.getMessage());
        }
        
    }

    // rutina de captura de errores de Exception 
    private void manejaExcepcion(Exception he) {
        // cualquier error que suceda devuelve todo a su estado anterior de la
        // transaction en curso en la sesion
        em.getTransaction().rollback();

        try {
            throw new Exception("Ocurrió un error de acceso a datos en Data0DAO", he);
        } catch (Exception ex) {
            Logger.getLogger(Data0DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
