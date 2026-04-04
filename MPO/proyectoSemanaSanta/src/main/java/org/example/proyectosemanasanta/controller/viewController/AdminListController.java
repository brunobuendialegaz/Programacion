package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class AdminListController extends BaseAdminController implements Initializable {

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
        initGUI();
        actions();
    }

    private void actions() {
        logOutButton.setOnAction(event -> logOut(event));
        CheckInOutButton.setOnAction(event -> checkInOut(getUser()));
        userFormButton.setOnAction(event -> changeView(event,"adminFormView.fxml", "Add User View", getUser()));
        CheckInOutList.setOnAction(event -> changeView(event, "recordsView.fxml", "Records List View", getUser()));
        delButton.setOnAction(event -> {
            DataUsers.getInstance().getUsers().remove(userTable.getSelectionModel().getSelectedItem());
            Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
            dialogPane.setHeaderText("Info");
            dialogPane.setContentText("User removed.");
            dialogPane.show();
        });
        showDetButton.setOnAction(event -> {
            DataUsers.getInstance().setFocusUser(userTable.getSelectionModel().getSelectedItem());
            changeView(event, "infoUserView.fxml", "Info User", getUser());
        });




    }

    private void initGUI() {
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        userTable.setItems(DataUsers.getInstance().getUsers());
    }
}
