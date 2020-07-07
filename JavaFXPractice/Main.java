package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Application {
    public Rectangle rectangle = getRectangle();
    public Pane paneForRectangles = new Pane(rectangle);
    public RectangleProp table = new RectangleProp();
    public TextField tfFileName = new TextField();
    public TextArea taTextFile = new TextArea();

    @FXML
    private TextField answerTF;

    @FXML
    private Label label;

    private double firstNumber;
    private double secondNumber;
    private char operation;


    String answer = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("20_2.fxml"));



        /**------------------------------------------------Task1JavaFX-----------------------------------------------------*/
/*
        BorderPane borderPane = new BorderPane();




        ClockPane clock = new ClockPane(4,20,45);
//        ClockPane clock = new ClockPane(22,46,15);
        String timeString  = clock.getHour() + ":" + clock.getMinute() + ":" +clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(lblCurrentTime);

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().add(clock);


        borderPane.setCenter(stackPane1);
        borderPane.setBottom(stackPane);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
        BorderPane.setAlignment(clock, Pos.CENTER);

        primaryStage.setTitle("Clock");
        primaryStage.setScene(new Scene(borderPane,250,250));
        primaryStage.show();

*/

/**------------------------------------------------Task3JavaFX-----------------------------------------------------*/

/*
        StackPane stackPane = new StackPane();
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        ObservableList<Double> list = polygon.getPoints();

        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;

        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }

        Text text = new Text("STOP");
        text.setFont(Font.font("Roboto", FontWeight.BOLD, 35));
        polygon.setRotate(23);
        text.setFill(Color.WHITE);
        stackPane.getChildren().addAll(polygon,text);

        primaryStage.setTitle("Octagon");
        primaryStage.setScene(new Scene(stackPane,WIDTH,HEIGHT));
        primaryStage.show();
*/




        /**------------------------------------------------Task3JavaFX-----------------------------------------------------*/
/*


        paneForRectangles.getChildren().addAll(
                table.getRectangle1(), table.getRectangle2());


        Button btRedrawCircles = new Button("Redraw Rectangles");


        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(intersect(), paneForRectangles,
                table, btRedrawCircles);


        btRedrawCircles.setOnAction(e -> {
            table.redraw();
            pane.getChildren().remove(0);
            pane.getChildren().add(0, intersect());
        });




        Scene scene = new Scene(pane);
        primaryStage.setTitle("Rectangles Intersect");
        primaryStage.setScene(scene);
        primaryStage.show();

*/

/**------------------------------------------------Task4JavaFX-----------------------------------------------------*/
/*
        tfFileName.setPrefColumnCount(23);

        Button btView = new Button("View");

        HBox paneForTextField = new HBox();
        paneForTextField.getChildren().addAll(new Label("Filename"),
                tfFileName, btView);


        taTextFile.setEditable(false);
        taTextFile.setWrapText(true);


        ScrollPane scrollPane = new ScrollPane(taTextFile);


        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(scrollPane, paneForTextField);


        btView.setOnAction(e -> {
            try {
                getTextFile();
            }
            catch (Exception ex) {
                taTextFile.setText("Error! File Not Found.");
            }
        });


        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Text Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
*/


/**------------------------------------------------Task5JavaFX-----------------------------------------------------*/

/*
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));



        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

*/


    }

    @FXML
    void clearTF(ActionEvent event) {
        answer = "";
        answerTF.setText(answer);
        firstNumber=0;
        secondNumber=0;
        label.setText("");
    }

    @FXML
    void divide(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer);
        answerTF.setText("");
        label.setText(answer+"/");
        operation = '/';
    }

    @FXML
    void dot(ActionEvent event) {
        answer = answerTF.getText();
        answer+='.';
        answerTF.setText(answer);
    }

    @FXML
    void eight(ActionEvent event) {
        answer = answerTF.getText();
        answer+='8';
        answerTF.setText(answer);
    }



    @FXML
    void five(ActionEvent event) {
        answer = answerTF.getText();
        answer+='5';
        answerTF.setText(answer);
    }

    @FXML
    void four(ActionEvent event) {
        answer = answerTF.getText();
        answer+='4';
        answerTF.setText(answer);
    }

    @FXML
    void minus(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer);
        answerTF.setText("");
        label.setText(answer+"-");
        operation = '-';
    }

    @FXML
    void multiply(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer);
        answerTF.setText("");
        label.setText(answer+"*");
        operation = '*';
    }

    @FXML
    void nine(ActionEvent event) {
        answer = answerTF.getText();
        answer+='9';
        answerTF.setText(answer);
    }

    @FXML
    void one(ActionEvent event) {
        answer = answerTF.getText();
        answer+='1';
        answerTF.setText(answer);
    }

    @FXML
    void percent(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer)/100;
        answerTF.setText(String.valueOf(firstNumber));
    }

    @FXML
    void plus(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer);
        answerTF.setText("");
        label.setText(answer+"+");
        operation = '+';
    }

    @FXML
    void plusMinus(ActionEvent event) {
        answer = answerTF.getText();
        firstNumber = Double.parseDouble(answer);
        answerTF.setText(String.valueOf(0-firstNumber));

    }

    @FXML
    void seven(ActionEvent event) {
        answer = answerTF.getText();
        answer+='7';
        answerTF.setText(answer);
    }

    @FXML
    void six(ActionEvent event) {
        answer = answerTF.getText();
        answer+='6';
        answerTF.setText(answer);
    }

    @FXML
    void three(ActionEvent event) {
        answer = answerTF.getText();
        answer+='3';
        answerTF.setText(answer);
    }

    @FXML
    void two(ActionEvent event) {
        answer = answerTF.getText();
        answer+='2';
        answerTF.setText(answer);
    }

    @FXML
    void zero(ActionEvent event) {
        answer = answerTF.getText();
        answer+='0';
        answerTF.setText(answer);
    }


    @FXML
    void equal(ActionEvent event) {
        if(operation=='+'){
            answer = answerTF.getText();
            secondNumber = Double.parseDouble(answer);
            answerTF.setText(String.valueOf(firstNumber+secondNumber));
            String oldLabel = label.getText();
            label.setText(oldLabel+answer);
        }
        if(operation=='-'){
            answer = answerTF.getText();
            secondNumber = Double.parseDouble(answer);
            answerTF.setText(String.valueOf(firstNumber-secondNumber));
            String oldLabel = label.getText();
            label.setText(oldLabel+answer);
        }
        if(operation=='/'){
            answer = answerTF.getText();
            secondNumber = Double.parseDouble(answer);
            answerTF.setText(String.valueOf(firstNumber/secondNumber));
            String oldLabel = label.getText();
            label.setText(oldLabel+answer);
        }
        if(operation=='*'){
            answer = answerTF.getText();
            secondNumber = Double.parseDouble(answer);
            answerTF.setText(String.valueOf(firstNumber*secondNumber));
            String oldLabel = label.getText();
            label.setText(oldLabel+answer);
        }
    }


    private void getTextFile() throws Exception {
        File file = new File(tfFileName.getText());
        if (!file.exists()) {
            taTextFile.setText(tfFileName.getText() + " does not exist");
        }
        else {
            String text = "";
            try (

                    Scanner input = new Scanner(file);
            ) {
                while (input.hasNext()) {
                    text += input.nextLine();
                    text += "\n";
                }
                taTextFile.setText(text);
            }
        }
    }




        private Text intersect() {
            if(isIntersect()){
                return new Text("Two circles intersect? Yes");
            }
            else{
                return new Text("Two circles intersect? No");
            }

        }


        private boolean isIntersect() {

                   if( (getDistance(table.getRectangle2X(), table.getRectangle1X() + table.getRectangle1Width()) < table.getRectangle1Width() + table.getRectangle2Width() && (getDistance(table.getRectangle2Y(), table.getRectangle1Y() + table.getRectangle1Height()) < table.getRectangle1Height() + table.getRectangle2Height())) &&
                            (getDistance(table.getRectangle1X(), table.getRectangle2X() +
                                    table.getRectangle2Width()) <
                                    table.getRectangle1Width() + table.getRectangle2Width() &&
                                    (getDistance(table.getRectangle1Y(), table.getRectangle2Y() +
                                            table.getRectangle2Height()) <
                                            table.getRectangle1Height() + table.getRectangle2Height()))){
                       return true;
                   }
                   else{
                       return false;
                   }
        }


        private double getDistance(double p1, double p2) {
            return Math.sqrt(Math.pow(p2 - p1, 2));
        }


        private Rectangle getRectangle() {
            Rectangle r = new Rectangle(0, 0, 280, 110);
            r.setStroke(Color.WHITE);
            r.setFill(Color.WHITE);
            return r;
        }


    public static void main(String[] args) {
        launch(args);
    }
}
