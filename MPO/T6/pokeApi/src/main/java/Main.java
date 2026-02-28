import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        String url = "https://pokeapi.co/api/v2/pokemon/";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> httpResponse = null;

        try {
            httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(httpResponse.body());

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        String urlVenusaur = jsonArray.getJSONObject(2).get("url").toString();

        httpRequest = HttpRequest.newBuilder().uri(URI.create(urlVenusaur)).build();

        try {
            httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jsonObject = new JSONObject(httpResponse.body());

        jsonArray = jsonObject.getJSONArray("abilities");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject habilidad = jsonArray.getJSONObject(i);

            JSONObject habilidadInfo = habilidad.getJSONObject("ability");

            System.out.println("Habilidad " + i + " " + habilidadInfo.get("name"));
        }

        httpClient.close();
    }
}
