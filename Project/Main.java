package project;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("FXML/Project.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate =myDateObj.format(myFormatObj);
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println(formattedDate);
        launch(args);

    }
}
