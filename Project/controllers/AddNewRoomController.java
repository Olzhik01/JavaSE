package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.classes.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddNewRoomController implements Initializable {

    private ArrayList<Room> rooms = new ArrayList<>();

    @FXML
    private TextField newRoomNumber;

    @FXML
    private TextField newRoomType;

    @FXML
    private TextArea newRoomDescription;

    @FXML
    private TextField newRoomPrice;

    @FXML
    private CheckBox newOneBedRoom;

    @FXML
    private CheckBox newTwoBedRoom;

    @FXML
    private CheckBox newThreeBedRoom;

    @FXML
    private CheckBox newRoomCleanService;

    @FXML
    private CheckBox newRoomFreeWifi;

    @FXML
    private CheckBox newRoomPets;

    @FXML
    private Button newRoomCreateBtn;

    @FXML
    private Label newRoomError;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void createNewRoom(ActionEvent event) {
        if(!newRoomValidate()){
            newRoomError.setText("*Please fill all inputs correctly!");
            newRoomError.setTextFill(Color.RED);
        }
        else{

            if(newOneBedRoom.isSelected()) {
                OneBedded oneBeddedRoom = new OneBedded();
                oneBeddedRoom.setRoomsCapacity(1);
                oneBeddedRoom.setFamilyRoom(false);
                setRoom(oneBeddedRoom);
            }
            else if(newTwoBedRoom.isSelected()) {
                TwoBedded twoBeddedRoom = new TwoBedded();
                twoBeddedRoom.setRoomsCapacity(2);
                twoBeddedRoom.setFamilyRoom(true);
                setRoom(twoBeddedRoom);
            }
            else if(newThreeBedRoom.isSelected()) {
                ThreeBedded threeBeddedRoom = new ThreeBedded();
                threeBeddedRoom.setRoomsCapacity(2);
                threeBeddedRoom.setFamilyRoom(true);
                setRoom(threeBeddedRoom);
            }

        }

    }
    private boolean newRoomValidate(){
        boolean validate = true;
        if(newRoomNumber.getText().trim().equals("") || newRoomType.getText().trim().equals("") || newRoomDescription.getText().trim().equals("")
                || newRoomPrice.getText().trim().equals("")|| (!newOneBedRoom.isSelected() && !newTwoBedRoom.isSelected() && !newThreeBedRoom.isSelected())
        ){
            validate = false;
        }
        return validate;
    }

    private void setRoom(Room room){
        room.setRoomNumber(Integer.parseInt(newRoomNumber.getText()));
        room.setRoomType(newRoomType.getText());
        room.setDescription(newRoomDescription.getText());
        room.setPrice(Integer.parseInt(newRoomPrice.getText()));
        room.setAvailable(true);
        if(newRoomCleanService.isSelected()){
            room.setHasCleaningServices(true);
        }
        if(!newRoomCleanService.isSelected()){
            room.setHasCleaningServices(false);
        }
        if(newRoomFreeWifi.isSelected()){
            room.setHasFreeWifi(true);
        }
        if(!newRoomFreeWifi.isSelected()){
            room.setHasFreeWifi(false);
        }
        if(newRoomPets.isSelected()){
            room.setPetsAllowed(true);
        }
        if(!newRoomPets.isSelected()){
            room.setPetsAllowed(false);
        }
        App.addRoom(room);
        newRoomError.setText("*New room created successfully!");
        newRoomError.setTextFill(Color.GREEN);
        newRoomNumber.setText("");
        newRoomDescription.setText("");
        newRoomType.setText("");
        newRoomPrice.setText("");

    }


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
