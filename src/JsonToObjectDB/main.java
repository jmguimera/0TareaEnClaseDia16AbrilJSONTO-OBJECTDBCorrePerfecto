/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonToObjectDB;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author josem
 */
public class main {

    public static void main(String[] args) {

        dameURLyTeDoyJSON js = new dameURLyTeDoyJSON("http://www.ferminvelez.es/PROGRAMACION/PRUEBAS/marcas.json");

        String s = js.getJSONdelURL();

        ArrayList listaCoches = new ArrayList();
        Gson g = new Gson();

        listaCoches = g.fromJson(s, ClaseParaLeerDATOS.class);

        System.out.println("\t --- Objeto leido ---\n");

        Iterator it = listaCoches.iterator();

        while (it.hasNext()) {
            Data0 obj = (Data0) it.next();
            System.out.println(obj.nombre);

            Iterator itobj = obj.misModelos.iterator();

            while (itobj.hasNext()) {
                Modelo objmod = (Modelo) itobj.next();
                System.out.println(objmod.nombre);
            }
            System.out.println();

            /*  for(int i=0;i<listaCoches.size();i++){
        
        ArrayList<Data0> obj=(ArrayList<Data0>) listaCoches.get(i);
             System.out.println("Marca: "+obj.get(i).nombre);
                 for(int j=0;obj.get(i).misModelos.size()<j;j++){
                    System.out.println("Modelo"+obj.get(i).misModelos.get(j).nombre);
            }            
        
        }*/
        }

    }

}
