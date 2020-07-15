package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.classes.App;
import project.classes.Reservation;
import project.classes.Visitor;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class VisitorsController implements Initializable {
    @FXML
    private Label totalNumberVisitors;
    @FXML
    private TableView<Reservation> visitorTable;

    @FXML
    private TableColumn<Reservation, Integer> visitorIdColumn;

    @FXML
    private TableColumn<Reservation, String> visitorFullName;

    @FXML
    private TableColumn<Reservation, String> visitorEmail;

    @FXML
    private TableColumn<Reservation, String> visitorPhone;

    @FXML
    private TableColumn<Reservation, String> visitorReserveRoom;

    @FXML
    private TableColumn<Reservation, Date> createdAtColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalNumberVisitors.setText(Integer.toString(App.getVisitorsList().size()));

        if(!App.getVisitorsList().isEmpty()){
            visitorIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));
            visitorFullName.setCellValueFactory(new PropertyValueFactory<>("visitor"));
            visitorEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            visitorReserveRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
            visitorPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            createdAtColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
            ObservableList<Reservation> listOfReservations = FXCollections.observableArrayList(App.getReservationsList());
            visitorTable.setItems(listOfReservations);
            visitorTable.getColumns().addAll(visitorIdColumn, visitorFullName, visitorEmail, visitorPhone, visitorReserveRoom,createdAtColumn);
        }else{}
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
