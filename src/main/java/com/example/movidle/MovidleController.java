package com.example.movidle;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.*;
import java.util.*;

public class MovidleController {
    @FXML
    private Label nameText;
    @FXML
    private Label yearText;
    @FXML
    private Label genreText;
    @FXML
    private Label originText;
    @FXML
    private Label directorText;
    @FXML
    private Label starText;
    @FXML
    private TextField tf1 = new TextField();
    @FXML
    GridPane gridPane = new GridPane();

    int guessCount = 0;

    String[] information;
    public static String[][] array;

    static {
        try {
            array = readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            information = Choice();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    String correctName = information[1];
    String correctDate = information[2];
    String correctGenre = information[3];
    String correctOrigin = information[4];
    String correctDirector = information[5];
    String correctStar = information[6];

    @FXML
    protected void onCheckButtonClick() throws IOException {
        System.out.println(correctName);
        nameText = new Label();
        yearText = new Label();
        genreText = new Label();
        originText = new Label();
        directorText = new Label();
        starText = new Label();
        nameText.setAlignment(Pos.CENTER);
        nameText.setFont(Font.font(13));
        nameText.setPrefWidth(100);
        nameText.setPrefHeight(30);
        yearText.setAlignment(Pos.CENTER);
        yearText.setFont(Font.font(13));
        yearText.setPrefWidth(100);
        yearText.setPrefHeight(30);
        nameText.setPrefHeight(30);
        genreText.setAlignment(Pos.CENTER);
        genreText.setFont(Font.font(13));
        genreText.setPrefWidth(100);
        genreText.setPrefHeight(30);
        originText.setAlignment(Pos.CENTER);
        originText.setFont(Font.font(13));
        originText.setPrefWidth(100);
        originText.setPrefHeight(30);
        directorText.setAlignment(Pos.CENTER);
        directorText.setFont(Font.font(13));
        directorText.setPrefWidth(100);
        directorText.setPrefHeight(30);
        starText.setAlignment(Pos.CENTER);
        starText.setFont(Font.font(13));
        starText.setPrefWidth(100);
        starText.setPrefHeight(30);

        String tahmin = tf1.getText();
        if(guessCount > 10){
            MovidleApplication.warningWindow();
        }

        if(Check(tahmin).length == 0){
            nameText.setText("Listede Yok");
            yearText.setText("Listede yok");
            genreText.setText("Listede yok");
            originText.setText("Listede yok");
            directorText.setText("Listede yok");
            starText.setText("Listede yok");
            nameText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            yearText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            genreText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            originText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            directorText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            starText.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            if (Check(tahmin)[1].equals(correctName)) {
                MovidleApplication.winWindow();
                nameText.setText(Check(tahmin)[1]);
                nameText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                nameText.setText(Check(tahmin)[1]);
                nameText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if (Check(tahmin)[2].equals(correctDate)){
                yearText.setText(Check(tahmin)[2]);
                yearText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else {
                yearText.setText(Check(tahmin)[2]);
                yearText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if (Check(tahmin)[3].equals(correctGenre)){
                genreText.setText(Check(tahmin)[3]);
                genreText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else {
                genreText.setText(Check(tahmin)[3]);
                genreText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if (Check(tahmin)[4].equals(correctOrigin)){
                originText.setText(Check(tahmin)[4]);
                originText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else {
                originText.setText(Check(tahmin)[4]);
                originText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if (Check(tahmin)[5].equals(correctDirector)){
                directorText.setText(Check(tahmin)[5]);
                directorText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else {
                directorText.setText(Check(tahmin)[5]);
                directorText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            if (Check(tahmin)[6].equals(correctStar)){
                starText.setText(Check(tahmin)[6]);
                starText.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else {
                starText.setText(Check(tahmin)[6]);
                starText.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
        gridPane.add(nameText,0, guessCount);
        gridPane.add(yearText,1, guessCount);
        gridPane.add(genreText,2, guessCount);
        gridPane.add(originText,3, guessCount);
        gridPane.add(directorText,4, guessCount);
        gridPane.add(starText,5, guessCount);
        guessCount ++;
    }

    public static String[] Choice() throws IOException {
        Random r = new Random();
        int a = r.nextInt(251);

        return array[a];
    }

    public static String[] Check(String t){
        String[] guess = new String[0];
        for (String[] strings : array) {
            if (t.equals(strings[1])) {
                guess = strings;
            }
        }
        return guess;
    }

    public static String[][] readCSV() throws Exception
    {
        Collection<String[]> lines = new ArrayList<>();
        Scanner sc = new Scanner(new File("imdb_top_250.csv"));

        while (sc.hasNext())
        {
            String line = sc.nextLine();
            lines.add(line.split(";"));
        }
        sc.close();
        return lines.toArray(new String[lines.size()][]);
    }

}