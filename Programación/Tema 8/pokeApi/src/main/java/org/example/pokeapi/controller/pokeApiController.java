package org.example.pokeapi.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.example.pokeapi.model.Pokemon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pokeApiController implements Initializable {
    // hacemos implements Initializable

    // skeleton traido desde la app SceneBuilder ===>  view, show sample skeleton

    @FXML
    private Text alturaPoke;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField buscarTexto;

    @FXML
    private ImageView imagenPoke;

    @FXML
    private Text nombrePoke;

    @FXML
    private Text pesoPoke;

    @FXML
    private Text valorATK;

    @FXML
    private Text valorATKES;

    @FXML
    private Text valorDEFES;

    @FXML
    private Text valorDef;

    @FXML
    private Text valorHP;

    @FXML
    private Text valorVEL;



    //Override obligatorio del implements
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // metodo para que pasa con el click del button
        buscarBoton.setOnAction(actionEvent -> {
            if (!buscarTexto.getText().isEmpty()) buscarPokemon(buscarTexto.getText());
        });
    }

    public void buscarPokemon(String nombre){
        String urlBase = "https://pokeapi.co/api/v2/pokemon/";
        // mapea el Json a mis clases
        ObjectMapper mapper = new ObjectMapper();
        // convierte todos los snake_case a camelCase de java
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        // hace que si no encontramos algo, no lance error
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 1. Oculta todos los métodos (getters/setters/creators)
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        // 2. Hace visibles solo los campos directamente, de esta forma hacemos que no utilice los getters o setters de lombok para
        // hacer la traducción, si no los nombres de las variables.
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            Pokemon pokemon = mapper.readValue(new URL(urlBase+nombre).openStream(), Pokemon.class);
            nombrePoke.setText(pokemon.getName());
            alturaPoke.setText((double) pokemon.getHeight()/10 + "m");
            pesoPoke.setText((double)pokemon.getWeight()/10 + "kg");
            imagenPoke.setImage( new Image(pokemon.getSprites().getFrontDefault()));
            valorHP.setText(String.valueOf(pokemon.getStats().get(0).getBaseStat()));
            valorATK.setText(String.valueOf(pokemon.getStats().get(1).getBaseStat()));
            valorDef.setText(String.valueOf(pokemon.getStats().get(2).getBaseStat()));
            valorATKES.setText(String.valueOf(pokemon.getStats().get(3).getBaseStat()));
            valorDEFES.setText(String.valueOf(pokemon.getStats().get(4).getBaseStat()));
            valorVEL.setText(String.valueOf(pokemon.getStats().get(5).getBaseStat()));

        } catch (IOException e) {
            System.out.println("URL no encontrada");
            System.out.println(e.getMessage());
        }
    }
}
