/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diddatafixer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpadilla
 */
public class genscript {
    //String qry;
     genscript (String qry) {//private static void gen ()
        
        try {
            final String path = System.getProperty("user.dir");
            File scriptf = new File(path+File.separator+"script");//Crear carpeta
            if (!scriptf.exists()) {
                if (scriptf.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            }      
        catch (Exception e) {
            System.err.println("IMPOSIBLE INICIAR EL LOG. SE DEBEN REVISAR LOS PARAMETROS");
            }
                
        try {
            String ruta = System.getProperty("user.dir")+File.separator+"script"+File.separator+"script.sql";
            //String contenido = "Contenido de ejemplo23";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(qry);
            bw.write("\r\n\r\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
}
    
    

