/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonToObjectDB;

import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author josem
 */
public class Main {

    public static void main(String[] args) {

        Main prog = new Main();

        dameURLyTeDoyJSON js = new dameURLyTeDoyJSON("http://www.ferminvelez.es/PROGRAMACION/PRUEBAS/marcas.json");

        String s = js.getJSONdelURL();

        ArrayList listaCoches = new ArrayList();
        Gson g = new Gson();

        listaCoches = g.fromJson(s, ClaseParaLeerDATOS.class);

        System.out.println("\t --- JSON leido ---\n");

        Data0DAO bd = new Data0DAO();

        Iterator it = listaCoches.iterator();

        while (it.hasNext()) {
            Data0 obj = (Data0) it.next();
            System.out.println(obj.getNombre());
            bd.guardaRegistro(obj);
            Iterator itobj = obj.getMisModelos().iterator();

            while (itobj.hasNext()) {
                Modelo objmod = (Modelo) itobj.next();
                System.out.println(objmod.getNombre());
            }

            System.out.println();

        }

    }

}
