package org.example.proyectosemanasanta.controller.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.User;
import org.example.proyectosemanasanta.model.Record;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCheckInOutController extends BaseAdminController implements Initializable {

    @FXML
    private Button adminFormButton;

    @FXML
    private Button adminListButton;

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView<Record> recordsTable;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    private TableColumn<Record, String> typeColumn;

    @FXML
    private TableColumn<Record, String> nameColumn;

    private ObservableList<Record> records;

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
                recordsTable.getSelectionModel().getSelectedItem().getUser().getRecords()
                        .remove(recordsTable.getSelectionModel().getSelectedItem());

                records.remove(recordsTable.getSelectionModel().getSelectedItem());
            }
        });
        adminListButton.setOnAction(event -> changeView(event, "adminListView.fxml", "Users List View", getUser()));
        adminFormButton.setOnAction(event -> changeView(event, "adminFormView.fxml", "Add User View", getUser()));

    }

    private void initGUI() {
        records = FXCollections.observableArrayList();
        DataUsers.getInstance().getUsers().forEach(user -> records.addAll(user.getRecords()));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getFirstName()));
        recordsTable.setItems(records);
    }
}
