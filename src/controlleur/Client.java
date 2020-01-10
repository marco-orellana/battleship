package controlleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {

            System.out.println("CLIENT : tentative");
            Socket socketClient = new Socket("192.168.60.21", 12345);
            System.out.println("CLIENT : connecter");


            //comunication avec le serveur

            InputStream is = socketClient.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);


            String ligne = br.readLine();
            String ligne2 = br.readLine();

            System.out.println("CLIENT : serveur dit " + ligne + " et " + ligne2);
            int i = Integer.parseInt(ligne) + Integer.parseInt(ligne2);
            System.out.println(i);

            String conazo = Integer.toString(i);

            OutputStream os = socketClient.getOutputStream();

            PrintWriter pr = new PrintWriter(os, true);
            pr.println(conazo);


            socketClient.close();

            // fermeture de la connexion
            System.out.println("CLIENT : connexion fermee.");

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

