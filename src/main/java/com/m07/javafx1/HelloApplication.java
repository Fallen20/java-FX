package com.m07.javafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Ejercicio 1");
        stage.setWidth(700);
        stage.setHeight(600);

//        Button currentButton=new Button("Current");
//        Button proyectButton=new Button("Proyect");
//        Button boton2=new Button("2");
//        Button boton3=new Button("3");
//        Button boton4=new Button("4");
//        Button boton5=new Button("5");
//
//        BorderPane border = new BorderPane();
//        border.setTop(currentButton);
////        border.setTop(proyectButton);
//        border.setCenter(boton3);
//        border.setRight(boton4);
//        border.setBottom(boton5);
//
//        BorderPane.setAlignment(currentButton, Pos.TOP_LEFT);
//        BorderPane.setAlignment(proyectButton, Pos.TOP_LEFT);

        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());
        addStackPane(hbox);         // Add stack to HBox in top region

        border.setCenter(addAnchorPane(addGridPane()));
        border.setRight(addFlowPane());

        Scene scene=new Scene(border);
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

    public HBox addHBox() {//top
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(80, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(80, 20);///TAMAÑO BOTON
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    public VBox addVBox() {//izq
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #b5c4f5;");//fondo

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Sales"),
                new Hyperlink("Marketing"),
                new Hyperlink("Distribution"),
                new Hyperlink("Costs")};


        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

        return vbox;
    }

    public void addStackPane(HBox hb) {//icono ?
        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop[]{
                        new Stop(0, Color.web("#4977A3")),
                        new Stop(0.5, Color.web("#B0C6DA")),
                        new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"

        hb.getChildren().add(stack);            // Add stack pane to HBox object
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }


    public GridPane addGridPane() {//medio
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);//emtre sales y good services
        grid.setPadding(new Insets(0, 10, 0, 10));
                                         //der               //izq


        // Category in column 2, row 1
        Text category = new Text("Sales:");
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 1, 0);

        // Title in column 3, row 1
        Text chartTitle = new Text("Current Year");
        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(chartTitle, 2, 0);

        // Subtitle in columns 2-3, row 2
        Text chartSubtitle = new Text("Goods and Services");
        chartSubtitle.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        grid.add(chartSubtitle, 1, 1, 2, 1);

        // casa
        ImageView imageHouse = new ImageView(
                new Image(HelloApplication.class.getResourceAsStream("graphics/house-noBG.png")));
        imageHouse.setFitHeight(50);
        imageHouse.setFitWidth(50);
        grid.add(imageHouse, 0, 0, 1, 2);

        // Left label in column 1 (bottom), row 3
        Text goodsPercent = new Text("Goods\n80%");
        goodsPercent.setFont(Font.font("Helvetica", FontPosture.ITALIC,14));
        GridPane.setValignment(goodsPercent, VPos.BOTTOM);
        grid.add(goodsPercent, 0, 2);

        // grafico
        ImageView imageChart = new ImageView(
                new Image(HelloApplication.class.getResourceAsStream("graphics/piechart-orig-noBG.png")));
        imageChart.setFitWidth(250);//tamaño
        imageChart.setFitHeight(250);//tamaño
        grid.add(imageChart, 1, 2, 2, 1);
        //Package.getPackages().getClass().getResourceAsStream("graphics/piechart.png")
       // Package.getPackage("graphics").getClass().getResourceAsStream("piechart.png")
        //getClass().getResource("/JavaFX1/src/main/java/com/m07/javafx1/graphics/icon.png").toString()
        // getClass().getClassLoader().getResourceAsStream("piechart.png")
//HelloApplication.class.getResourceAsStream("graphics/piechart.png")




        // Right label in column 4 (top), row 3
        Text servicesPercent = new Text("Services\n20%");
        servicesPercent.setFont(Font.font("Helvetica", FontPosture.ITALIC,14));
        GridPane.setValignment(servicesPercent, VPos.TOP);
        grid.add(servicesPercent, 3, 2);

        return grid;
    }

    public FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 10, 5, 10));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            pages[i] = new ImageView(
                    new Image(HelloApplication.class.getResourceAsStream(
                            "graphics/chart_"+(i+1)+".png")));
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }


    public AnchorPane addAnchorPane(GridPane grid) {
        AnchorPane anchorpane = new AnchorPane();
        Button buttonSave = new Button("Save");
        Button buttonCancel = new Button("Cancel");

        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
}

