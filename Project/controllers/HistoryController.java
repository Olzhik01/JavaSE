package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import project.classes.App;
import project.classes.History;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {
    @FXML
    private Label date;

    @FXML
    private Label historyMessage;

    @FXML
    private ListView<String> historyListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(App.getHistoryList().isEmpty()){

        }
        else {

            for(History h:App.getHistoryList()){
                historyListView.getItems().addAll(h.getLog());
            }

        }
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
