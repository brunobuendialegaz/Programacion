package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Data;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminFormController extends BaseAdminController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private RadioButton adminRadio;

    @FXML
    private RadioButton userRadio;

    @FXML
    private Button checkInOut;

    @FXML
    private Button checkInOutList;

    @FXML
    private Button clearButton;

    @FXML
    private TextField dni;

    @FXML
    private TextField firstNameField;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField mail;

    @FXML
    private TextField secondNameField;

    @FXML
    private Button userListButton;

    private ToggleGroup roleGroup;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        actions();
    }

    private void actions() {
        logOutButton.setOnAction(this::logOut);
        checkInOut.setOnAction(event -> checkInOut(getUser()));
        userListButton.setOnAction(event -> changeView(event, "adminListView.fxml", "Users List View", getUser()));
        checkInOutList.setOnAction(event -> changeView(event, "recordsView.fxml", "Records List View", getUser()));
        clearButton.setOnAction(event -> {
            firstNameField.setText("");
            secondNameField.setText("");
            dni.setText("");
            mail.setText("");
        });
        addButton.setOnAction(event -> {
            if (!firstNameField.getText().equals("")&&
                    !secondNameField.getText().equals("")&&
                    !dni.getText().equals("")){
                DataUsers.getInstance().getUsers()
                        .add(new User(firstNameField.getText(), secondNameField.getText(),
                                dni.getText(), mail.getText(),
                                ((RadioButton) roleGroup.getSelectedToggle()).getText(),
                                new ArrayList<>()));
                firstNameField.setText("");
                secondNameField.setText("");
                dni.setText("");
                mail.setText("");
                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Info");
                dialogPane.setContentText("User added.");
                dialogPane.show();
            }else {
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("Can't add user, check the information.");
                dialogPane.show();
            }
        });
    }

    private void initGUI() {
        roleGroup = new ToggleGroup();

        adminRadio.setToggleGroup(roleGroup);
        userRadio.setToggleGroup(roleGroup);

        userRadio.setSelected(true);
    }
}
