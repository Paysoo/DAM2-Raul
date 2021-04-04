package M9.UF3.Activitat3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

// C:\Disco Duro 2TB\IntelliJ IDEA Project\out\production\IntelliJ IDEA Project>java M9.UF3.Activitat3.Activitat3 https://www.amazon.es/ 5 script

public class Activitat3 {
    @SuppressWarnings("rawtypes")
    public static void main (String[] args) {

        try {
            String cadena;
            URL url = new URL(args[0]);
            URLConnection connexio = url.openConnection();

            //Fem servir una estructura Map per a recuperar capçaleres
            Map campsCapçalera = connexio.getHeaderFields();
            Iterator it = campsCapçalera.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                System.out.println(map.getKey() + ":" + map.getValue());
            }

            // Mostra els nom de cada capçalera
            for (int i = 0; i < Integer.valueOf(args[1]); i++) {
                System.out.println(i + " - " + connexio.getHeaderField(i));
            }

            BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((cadena = pagina.readLine()) != null) {
                if (cadena.contains(args[2]))
                    System.out.println(cadena);
            }

        }
        catch (MalformedURLException e) { e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

}
