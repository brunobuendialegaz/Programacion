package ejercicios;

import com.google.gson.Gson;
import model.Example;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Ejercicios {

    public void ej1(){
        String url = "https://randomuser.me/api/";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(httpResponse.body());
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            JSONObject results  = jsonArray.getJSONObject(0);
            JSONObject nombre = results.getJSONObject("name");
            JSONObject localizacion = results.getJSONObject("location");
            System.out.println("Nombre: " + nombre.getString("title")
                    + " " + nombre.getString("first") + " "
                    + nombre.getString("last"));
            System.out.println("Email: " + results.getString("email"));
            System.out.println("Pais: " + localizacion.getString("country"));
        } catch (IOException e) {
            System.out.println("Error de io" + e);
        } catch (InterruptedException e) {
            System.out.println("Error de red " + e);
        } finally {
            httpClient.close();
        }
    }

    public void ej2(){
        String url = "https://dummyjson.com/products?limit=15";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());
            JSONArray jsonArray = jsonObject.getJSONArray("products");
            JSONObject producto;
            for (int i = 0; i < jsonArray.length(); i++) {
                producto = jsonArray.getJSONObject(i);
                System.out.printf("""
                        Id: %d
                        Title: %s
                        Price: %.2f
                        """
                        ,producto.getInt("id")
                        ,producto.getString("title")
                        ,producto.getFloat("price")
                );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void ej3(){
        Scanner s = new Scanner(System.in);
        System.out.print("¿Que id producto quieres ver? ");
        String urlOG = "https://dummyjson.com/products/";
        String idProducto = s.nextLine();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(urlOG+idProducto))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject producto = new JSONObject(httpResponse.body());
            System.out.printf("""
                    Item encontrado:
                    title: %s
                    description: %s 
                    category: %s 
                    """
                    , producto.getString("title")
                    , producto.getString("description")
                    , producto.getString("category"));


        } catch (IOException e) {
            System.out.println("Url no encontrada.");;
        } catch (InterruptedException e) {
            System.out.println("Fallo de conexión.");;
        } catch (JSONException e) {
            System.out.println("Item no encontrado...");
        } catch (Exception e ) {
            System.out.println("Error no controlado, notifica al adminsitrador");
        } finally {
            httpClient.close();
        }

    }

    public void ej4(){

        String urlOG = "https://jsonplaceholder.typicode.com/";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(urlOG+"posts/1"))
                .build();

        try{
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());

            String urlFinal = urlOG + "users/" + jsonObject.get("userId");
            System.out.println(urlFinal);

            httpRequest = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlFinal))
                    .build();

            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject usuarioJson = new JSONObject(httpResponse.body());

            Gson gson = new Gson();
            Usuario usuario = gson.fromJson(String.valueOf(usuarioJson), Usuario.class);

            System.out.printf("""
                    Titulo del post: %s
                    Nombre del usuario: %s
                    Ciudad del usuario: %s                    
                    """
            ,jsonObject.getString("title")
            ,usuario.getName()
            ,usuario.getAddress().getCity());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            httpClient.close();
        }

    }

    public void ej6(){

        String url = "https://opentdb.com/api.php?amount=3&type=multiple";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Example example = gson.fromJson(httpResponse.body(), Example.class);
            example.getResults().forEach(result -> {
                System.out.printf("""
                        Categoria: %s
                        Pregunta: %s
                        Respuesta correcta: %s"""
                ,result.getCategory()
                ,result.getQuestion()
                ,result.correctAnswer);
            });

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            httpClient.close();
        }

    }
}
