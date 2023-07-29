package com.example.movidle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MovidleApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        MovidleApplication.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("movidle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Movidle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {launch();
    }

    public static void warningWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("warning.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,150);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
        primaryStage.hide();
    }
    public static void winWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("win.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,150);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
        primaryStage.hide();

    }

}