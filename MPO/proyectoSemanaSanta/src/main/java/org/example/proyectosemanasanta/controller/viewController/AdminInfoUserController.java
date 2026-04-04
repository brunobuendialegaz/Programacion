package org.example.proyectosemanasanta.controller.viewController;

import javafx.collections.FXCollections;
import org.example.proyectosemanasanta.model.Record;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.example.proyectosemanasanta.data.DataUsers;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminInfoUserController extends BaseAdminController implements Initializable {

    @FXML
    private Button adminFormButton;

    @FXML
    private Button adminListButton;

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button checkInOutListButton;

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Text mailText;

    @FXML
    private Text nameText;

    @FXML
    private TableView<Record> recordsTable;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    private TableColumn<Record, String> typeColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        actions();
    }

    private void actions() {
        checkInOutButton.setOnAction(event -> checkInOut(getUser()));
        logOutButton.setOnAction(this::logOut);
        delButton.setOnAction(event -> {
            if (recordsTable.getSelectionModel().getSelectedItem()!=null){
            DataUsers.getInstance().getFocusUser().getRecords().remove(recordsTable.getSelectionModel().getSelectedItem());
            }
        });
        adminFormButton.setOnAction(event -> changeView(event, "adminFormView.fxml", "Add User View", getUser()));
        adminListButton.setOnAction(event -> changeView(event, "adminListView.fxml", "Users List View", getUser()));
        checkInOutListButton.setOnAction(event -> changeView(event, "recordsView.fxml", "Records List View", getUser()));


    }

    private void initGUI() {
        nameText.setText(DataUsers.getInstance().getFocusUser().getFirstName());
        mailText.setText(DataUsers.getInstance().getFocusUser().getMail());
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        recordsTable.setItems(FXCollections.observableList(DataUsers.getInstance().getFocusUser().getRecords()));
    }

}
