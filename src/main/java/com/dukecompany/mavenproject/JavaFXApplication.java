package com.dukecompany.mavenproject;

import com.dukecompany.controllers.ScatterChartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class JavaFXApplication extends Application {


    static File executionFile;
    public static final String fxmlPath = "src/main/resources/fxml/myfxml.fxml";
    private Object Parent;

    @Override
    public void start(Stage primaryStage) throws MalformedURLException, IOException {
        primaryStage.setTitle("Release Tool");
        URL url = new File(fxmlPath).toURI().toURL();
        System.out.println(url);

        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {

//TODO: move into test Class for checking the parsed or calculated data

//        DataReader dr = new DataReader();
//        dr.ReadData();
//
//        System.out.println("check time list = " + dr.timeList);
//
//        Calculate cal = new Calculate();
//
//
////TODO: move into test Class ^^

        launch(args);
    }

}
