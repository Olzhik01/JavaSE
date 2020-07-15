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
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.classes.*;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Label totalNumberRooms;

    @FXML
    private Label totalNumberReservations;

    @FXML
    private Label lastVisitorName;

    @FXML
    private Label lastVisitorRoom;

    @FXML
    private TableView<Reservation> mainPageTable;

    @FXML
    private TableColumn<Reservation, Integer> reservationIdColumn;

    @FXML
    private TableColumn<Reservation, String> visitorsFullNameColumn;

    @FXML
    private TableColumn<Reservation, Integer> visitorsRoomColumn;

    @FXML
    private TableColumn<Reservation, Date> visitorCheckInColumn;

    @FXML
    private TableColumn<Reservation, Date> visitorCheckOutColumn;

    @FXML
    private TableColumn<Reservation, Date> createdAtColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalNumberRooms.setText(Integer.toString(App.getRoomsList().size()));
        totalNumberReservations.setText(Integer.toString(App.getReservationsList().size()));

        if(App.getReservationsList().isEmpty()){
            lastVisitorName.setText("Null");
            lastVisitorRoom.setText("Null");
        }
        else{
            lastVisitorName.setText(App.getReservationsList().get(App.getReservationsList().size()-1).getVisitor().getName());
            lastVisitorRoom.setText("rm"+App.getReservationsList().get(App.getReservationsList().size()-1).getRoom().getRoomNumber());
        }

        if(!App.getReservationsList().isEmpty()){
            reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));
            visitorsFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("visitor"));
            visitorsRoomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
            visitorCheckInColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
            visitorCheckOutColumn.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
            createdAtColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
            ObservableList<Reservation> listOfReservations = FXCollections.observableArrayList(App.getReservationsList());
            mainPageTable.setItems(listOfReservations);
            mainPageTable.getColumns().addAll(reservationIdColumn, visitorsFullNameColumn, visitorsRoomColumn, visitorCheckInColumn, visitorCheckOutColumn,createdAtColumn);
        }
        else{ }
    }



    @FXML
    private void switchMainPage(ActionEvent event){ switchScene("Project",event); }
    @FXML
    private void switchHistory(ActionEvent event) {switchScene("History(new)",event); }
    @FXML
    private void switchNewReservation(ActionEvent event){ switchScene("NewReservation(new)",event); }
    @FXML
    private void switchReservation(ActionEvent event) { switchScene("Reservation(new)",event); }
    @FXML
    private void switchRooms(ActionEvent event) { switchScene("Rooms(new)",event); }
    @FXML
    private void switchVisitors(ActionEvent event) { switchScene("Visitors(new)",event); }
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

