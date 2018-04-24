/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonToObjectDB;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josem
 */
public class dameURLyTeDoyJSON {

  //  private static String getURL;
    private static String getURL;

    /**
     * Get the value of getURL
     *
     * @return the value of getURL
     */
    public String getGetURL() {
        return getURL;
    }

    public dameURLyTeDoyJSON(String getURL) {
        this.getURL = getURL;
    }

   
    public String getJSONdelURL() {
      

        String coche = null;
        try {
//            coche = getStringFromURL("http://www.ferminvelez.es/PROGRAMACION/PRUEBAS/marcas.json");            
            coche = getStringFromURL(getURL);

        } catch (IOException ex) {
            Logger.getLogger(dameURLyTeDoyJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        //aqui obtengo los datos desde la URL
        // El mismo es un string de objectos en formato 
        System.out.println("Este es el string obtenido: " + coche);

/*        ArrayList listaCoches = new ArrayList();
        Gson g = new Gson();
        
        listaCoches = g.fromJson(coche, Data0.class);
*/
        return (coche);

    }

    private String getStringFromURL(String urlSolicitada) throws MalformedURLException, IOException {
        URL url = new URL(urlSolicitada); // ojo poner el protocolo (http)           

        // leemos lo que nos devuelve el servidor pero OJO!!! lo queremos como UTF8 
        InputStream is = url.openStream();
        InputStreamReader isrUTF = new InputStreamReader(is, Charset.forName("UTF-8"));

        String s = "";
        int ch;
        BufferedReader br = new BufferedReader(isrUTF); // ya podemos leer de es URL en formato UTF8
        while ((ch = br.read()) != -1) {
            s += (char) ch;
        }
        br.close();
        return s; // esto es el     
    }

}
