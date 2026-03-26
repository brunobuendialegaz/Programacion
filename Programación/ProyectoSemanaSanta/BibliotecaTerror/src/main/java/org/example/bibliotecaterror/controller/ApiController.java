package org.example.bibliotecaterror.controller;

import com.google.gson.Gson;
import org.example.bibliotecaterror.model.Biblioteca;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiController {


        public void llamadaApi(String url){

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> httpResponse;


            try {
               httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                Gson gson = new Gson();
                Biblioteca biblioteca = gson.fromJson(httpResponse.body(), Biblioteca.class);
                biblioteca.libros.forEach(libro -> {
                    System.out.printf("""
                            Id: %d
                            Nombre: %s
                            paginas: %d
                            """, libro.getId()
                    ,libro.getTitle()
                    ,libro.getPages());

                });
            } catch (IOException e) {
                System.out.println("Error de IO");
            } catch (InterruptedException e) {
                System.out.println("Error de red");
            }

        }

}
