/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descargafile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Ejemplo de descarga de un fichero de imagen desde la web.
 *
 * @author chuidiang
 *
 */
public class Prueba {

    /**
     * Descarga un fichero jpeg y lo guarda en e:/foto.jpg
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Url con la foto
            URL url = new URL("http://cdn.computerhoy.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2019/05/windows-7-windows-10.jpg");

            // establecemos conexion
            URLConnection urlCon = url.openConnection();

            // Sacamos por pantalla el tipo de fichero
            System.out.println("tipo de archivo: " + urlCon.getContentType());

            // Se obtiene el inputStream de la foto web y se abre el fichero
            // local.
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream("e:/foto.jpg");

            // Lectura de la foto de la web y escritura en fichero local
            byte[] array = new byte[1000]; // buffer temporal de lectura.
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
            }

            // cierre de conexion y fichero.
            is.close();
            fos.close();
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace();
        }
    }

}
