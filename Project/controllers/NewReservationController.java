package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;
import project.classes.*;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class NewReservationController implements Initializable {
    @FXML
    private TextField visitorName;
    @FXML
    private TextField visitorsSurname;
    @FXML
    private TextField visitorEmail;
    @FXML
    private TextField visitorPhone;
    @FXML
    private TextField visitorCheckIn;
    @FXML
    private TextField visitorCheckOut;
    @FXML
    private ComboBox<Room> selectRoom;
    @FXML
    private Label roomDetails;
    @FXML
    private Label errorMessage;
    private static int reservationId = 1;
    private ArrayList<Room> availableSelectRooms = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Room r:App.getRoomsList()) {
            if(r.getIsAvailable()) {
                availableSelectRooms.add(r);
            }
        }
        selectRoom.getItems().addAll(availableSelectRooms);
    }


    @FXML
    private void printRoomDetails(ActionEvent event) {
        roomDetails.setText(selectRoom.getValue().getRoomDetails());
    }

    @FXML
    private void createNewReservation(ActionEvent event) throws Exception{
        if(!newReservationValidate()){
            errorMessage.setText("*Please fill all inputs correctly!");
            errorMessage.setTextFill(Color.RED);
        }
        else{

            Visitor visitor = new Visitor();
            visitor.setName(visitorName.getText());
            visitor.setSurname(visitorsSurname.getText());
            visitor.setEmail(visitorEmail.getText());
            visitor.setPhone(visitorPhone.getText());
            App.addVisitor(visitor);

            Reservation reservation = new Reservation();
            reservation.setReservationNumber(reservationId);
            reservationId++;
            reservation.setRoom(selectRoom.getValue());
            selectRoom.getValue().setAvailable(false);

            reservation.setVisitor(visitor);
            reservation.setPaymentStatus(true);
            reservation.setHasArrived(true);
            reservation.setHasLeaved(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            reservation.setCheckIn(simpleDateFormat.parse(visitorCheckIn.getText()));
            reservation.setCheckOut(simpleDateFormat.parse(visitorCheckOut.getText()));


                /*
                * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String dateInString = "07/06/2013";

                    try {

                        Date date = formatter.parse(dateInString);
                        System.out.println(date);
                        System.out.println(formatter.format(date));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    *
                    * Fri Jun 07 00:00:00 MYT 2013
                        07/06/2013
                * */
                /*LocalDateTime nowTime = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedNowTime = nowTime.format(format);
                String checkIn = simpleDateFormat.format(simpleDateFormat.parse(visitorCheckIn.getText()));
                String checkOut = simpleDateFormat.format(simpleDateFormat.parse(visitorCheckOut.getText()));

                if(formattedNowTime.equals(checkIn)){
                    reservation.setHasArrived(true);
                    reservation.setPaymentStatus(true);
                }
                else if(!formattedNowTime.equals(checkIn)){
                    reservation.setHasArrived(false);
                    reservation.setPaymentStatus(false);

                }
                else if(formattedNowTime.equals(checkOut)){
                    reservation.setHasLeaved(true);
                    reservation.setPaymentStatus(true);
                }
                else{
                    reservation.setHasArrived(false);
                    reservation.setHasLeaved(false);
                }
            */

            App.addReservation(reservation);
            History history = new History();
            history.setLog("Visitor "+reservation.getVisitor().getSurname()+" "+reservation.getVisitor().getName()
                    +" reserved a room with: \n"+reservation.getRoom().getRoomDetails()+"At created date "+visitorCheckIn.getText());
            history.setDate(simpleDateFormat.parse(visitorCheckIn.getText()));
            App.addHistory(history);
            errorMessage.setText("*New reservation created successfully!");
            errorMessage.setTextFill(Color.GREEN);
            visitorName.setText("");
            visitorsSurname.setText("");
            visitorPhone.setText("");
            visitorEmail.setText("");
            visitorCheckOut.setText("");
            visitorCheckIn.setText("");
            roomDetails.setText("");
            selectRoom.getSelectionModel().clearSelection();
        }
    }

    private boolean newReservationValidate(){
        boolean validate = true;
        if(visitorName.getText().trim().equals("") || visitorsSurname.getText().trim().equals("") || visitorEmail.getText().trim().equals("")
                || visitorPhone.getText().trim().equals("") || visitorCheckIn.getText().trim().equals("") || visitorCheckOut.getText().trim().equals("")
                 ||selectRoom.getSelectionModel().isEmpty()){
            validate = false;
        }
        return validate;
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
