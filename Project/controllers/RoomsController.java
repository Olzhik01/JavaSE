package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.classes.App;
import project.classes.Room;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomsController implements Initializable {

    @FXML
    private Label totalNumberRooms;
    @FXML
    private Label availableRooms;
    @FXML
    private Label reservedRooms;
    @FXML
    private TableView<Room> roomsTable;

    private int totalAvailableRooms = 0;
    private int totalReservedRooms = 0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalNumberRooms.setText(Integer.toString(App.getRoomsList().size()));
        for(Room r:App.getRoomsList()){
            if(r.getIsAvailable()){
                totalAvailableRooms++;
            }
            else{
                totalReservedRooms++;
            }
        }
        availableRooms.setText(Integer.toString(totalAvailableRooms));
        reservedRooms.setText(Integer.toString(totalReservedRooms));

        TableColumn<Room, Integer> idColumn = new TableColumn<>("Room ID");
        idColumn.setMinWidth(131);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        TableColumn<Room, String> descriptionColumn = new TableColumn<>("Room Description");
        descriptionColumn.setMinWidth(131);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Room, String> typeColumn = new TableColumn<>("Room Type");
        typeColumn.setMinWidth(131);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        TableColumn<Room, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(131);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Room, Integer> capacityColumn = new TableColumn<>("Capacity");
        capacityColumn.setMinWidth(131);
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("roomsCapacity"));

        TableColumn<Room, Boolean> isAvailableColumn = new TableColumn<>("Is Available?");
        isAvailableColumn.setMinWidth(131);
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));

        ObservableList<Room> listOfRooms = FXCollections.observableArrayList(App.getRoomsList());
        roomsTable.setItems(listOfRooms);
        roomsTable.getColumns().addAll(idColumn,descriptionColumn,typeColumn,priceColumn,capacityColumn,isAvailableColumn);
    }




    @FXML
    private void switchMainPage(ActionEvent event){ switchScene("Project",event); }

    @FXML
    private void switchHistory(ActionEvent event) {
        switchScene("History(new)",event);
    }

    @FXML
    private void switchNewReservation(ActionEvent event){
        switchScene("NewReservation(new)",event);
    }

    @FXML
    private void switchReservation(ActionEvent event) {
        switchScene("Reservation(new)",event);
    }

    @FXML
    private void switchRooms(ActionEvent event) { switchScene("Rooms(new)",event); }

    @FXML
    private void switchVisitors(ActionEvent event) {
        switchScene("Visitors(new)",event);
    }

    @FXML
    private void switchAddNewRoom(ActionEvent event) {
        switchScene("AddNewRoom(new)",event);
    }

    private void switchScene(String name,ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/project/FXML/" +name+".fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
