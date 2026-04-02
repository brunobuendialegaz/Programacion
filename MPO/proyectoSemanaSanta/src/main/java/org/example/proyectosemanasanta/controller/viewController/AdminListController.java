package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class AdminListController implements Initializable {

    @FXML
    private Button CheckInOutButton;

    @FXML
    private Button CheckInOutList;

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button showDetButton;

    @FXML
    private Button userFormButton;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> userColumn;

    @FXML
    private TableColumn<User, String> mailColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();
    }

    private void actions() {
    }

    private void initGUI() {
    }

    private void instances() {
    }
}
