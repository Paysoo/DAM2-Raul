package M9.UF3.Activitat8;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {
    static Scanner teclado = new Scanner(System.in);

//    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Elige una opción");
        System.out.println("[1 - GET]\n[2 - POST]");
        int opcion = teclado.nextInt();

        // PIDO LA URL DE LA PAGINA
        System.out.print("URL: ");
        String url = teclado.next();
        URL obj = new URL(url);

        // HAGO LA CONEXION
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();



        switch (opcion) {
            case 1:
                System.out.println("Testing 1 - Send Http GET request");

                // PIDO UN HEADER (En este caso user-agent) [En la pagina - F12 - Network - Primer elemnto de Name - Headers]
                System.out.println("USER-AGENT :");
                String userAgent = teclado.next();

                // Llamo a la funcion y le paso la URL, la conexion y el header que quiero (user-agent)
                http.sendGet(url, con, userAgent);
                break;

            case 2:
                System.out.println("\nTesting 2 - Send Http POST request");

                // PIDO UN HEADER (En este caso user-agent) [En la pagina - F12 - Network - Primer elemnto de Name - Headers]
                System.out.println("ACCEPT-ENCODING :");
                String acceptEncoding = teclado.nextLine();
                teclado.next();

                // Llamo a la funcion y le paso la URL, la conexion y el header que quiero (accept-encoding)
                http.sendPost(url, con, acceptEncoding);
                break;

            default:
                System.out.println("OPCIÓN ERRONEA");
                break;
        }

    }

    // HTTP GET request
    private void sendGet(String url, HttpURLConnection con, String userAgent) throws Exception {

//        String url = "http://www.insbaixcamp.org/";
//
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", userAgent);

        int responseCode = con.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost(String url, HttpURLConnection con, String acceptEncoding) throws Exception {

//        String url = "http://www.insbaixcamp.cat/moodle/";
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Encoding", acceptEncoding);
        con.setRequestProperty("Accept-Language", "ca-es");

        //Query string
        String urlParameters = "categoryid=7";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
