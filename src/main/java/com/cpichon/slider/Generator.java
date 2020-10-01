package com.cpichon.slider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

/**
 *
 * @author Christophe PICHON
 *
 *
 * genere les nombres aleatoires
 */
public class Generator {

    private final String USER__AGENT = "Mozilla/5.0";
    /**
     * l'url du site generateur
     */
    private final String URLDATA = "https://www.random.org/integers/?min=0&max=" + (Constantes.NBNOTES-1) + "&col=1&num=1&format=plain&rnd=new&base=10";

    /**
     * renvoie un nombre entier aleatoire en 0 et 4
     *
     * @return
     */
    public int getValue() {
        try {
            return queryValue();
        } catch (IOException | ParseException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        return 0; // en cas d'erreur
    }

    /**
     * obtient un entier depuis URLDATA et le renvoie
     *
     * @return
     */
    private int queryValue() throws MalformedURLException, IOException, ParseException {

        URL obj = new URL(URLDATA);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER__AGENT);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine = "";
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return Integer.parseInt(response.toString());

    }

}
