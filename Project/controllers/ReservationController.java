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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import project.classes.App;
import project.classes.Reservation;
import project.classes.Room;
import project.classes.Visitor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {
    @FXML
    private Label totalNumberReservations;

    @FXML
    private Label reservationsDidToday;

    @FXML
    private Label lastReservedVisitor;

    @FXML
    private TableView<Reservation> reservationTable;

    @FXML
    private TableColumn<Reservation, Integer> reservationIdColumn;

    @FXML
    private TableColumn<Reservation, String> visitorFullNameColumn;

    @FXML
    private TableColumn<Reservation, Integer> visitorRoomColumn;

    @FXML
    private TableColumn<Reservation, Date> visitorCheckInColumn;

    @FXML
    private TableColumn<Reservation, Date> visitorCheckOutColumn;


    @FXML
    private TableColumn deleteColumn;

    @FXML
    private Label deleteBtnMsg;

    private ArrayList<Button> editButtons = new ArrayList<>();
    private ArrayList<Button> deleteButtons = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        totalNumberReservations.setText(Integer.toString(App.getReservationsList().size()));
        reservationsDidToday.setText(Integer.toString(App.getReservationsList().size()));
        if (App.getReservationsList().isEmpty()) {
            lastReservedVisitor.setText("Null");
        } else {
            lastReservedVisitor.setText(App.getReservationsList().get(App.getReservationsList().size() - 1).getVisitor().getName());
        }

        try {
            if (!App.getReservationsList().isEmpty()) {

                reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));
                visitorFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("visitor"));
                visitorRoomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
                visitorCheckInColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
                visitorCheckOutColumn.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
                deleteColumn.setCellValueFactory(new PropertyValueFactory<>("delete"));

                for (Reservation r : App.getReservationsList()) {
                    r.getDelete().setOnAction(e -> deleteReservationFromTable(r));
                }
                ObservableList<Reservation> listOfReservations = FXCollections.observableArrayList(App.getReservationsList());
                reservationTable.setItems(listOfReservations);
                reservationTable.getColumns().addAll(reservationIdColumn, visitorFullNameColumn, visitorRoomColumn, visitorCheckInColumn, visitorCheckOutColumn,  deleteColumn);

            } else {


            }
        }
        catch (java.lang.IllegalStateException e){
            /*
             * If IllegalStateException happens, it is because titles of columns.
             * I wrote it before in SceneBuilder.
             * */
            e.printStackTrace();

            System.out.println("Exception");

        }


    }

    private void deleteReservationFromTable(Reservation r){
        deleteBtnMsg.setText("First of all,select reservation!");
        reservationTable.getItems().remove(reservationTable.getSelectionModel().getSelectedItem());
        App.deleteFromReservationList(r);
        /*
        * if it deletes from table,it will delete from database,
        * so room will be available.
        * */
        r.getRoom().setAvailable(true);
    }

//    private void editReservationFromTable(Reservation r){
//
//    }














    @FXML
    private void switchMainPage(ActionEvent event){
        switchScene("Project",event);
    }
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
    private void switchRooms(ActionEvent event) {

        switchScene("Rooms(new)",event);
    }
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
