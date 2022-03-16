package com.m07.javafx1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }




    public static Scene scene;
    public static Scene sceneMarketing;
    public static Scene sceneDistribution;
    public static Scene sceneCost;
    String distribution="Distribution";

    public static Stage stageOriginal;//haciendo este general y usandolo en los cambios, no se crean ventanas nuevas
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("primary.fxml"));
         //scene = new Scene(fxmlLoader.load(), 500, 500);
        stageOriginal=stage;


        stageOriginal.setTitle("Ventana Sales");
        stageOriginal.setWidth(800);
        stageOriginal.setHeight(600);


        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());
        addStackPane(hbox);
        border.setCenter(addAnchorPane(addGridPane("Sales:", "Goods","Services")));
        border.setRight(addFlowPaneSales());

        //distribution
        BorderPane borderMarketing = new BorderPane();
        HBox hboxMarketing = addHBox();
        borderMarketing.setTop(hboxMarketing);
        borderMarketing.setLeft(addVBox());
        addStackPane(hboxMarketing);
        borderMarketing.setCenter(addAnchorPane(addGridPane("Marketing:","Internet","Local")));
        borderMarketing.setRight(addFlowPaneMarketing());
        sceneMarketing =new Scene(borderMarketing);

        //distribution
        BorderPane borderDistribution = new BorderPane();
        HBox hboxDistribution = addHBox();
        borderDistribution.setTop(hboxDistribution);
        borderDistribution.setLeft(addVBox());
        addStackPane(hboxDistribution);
        borderDistribution.setCenter(addAnchorPane(addGridPane("Distribution:","Internat","External")));
        borderDistribution.setRight(addFlowPaneSales());
        sceneDistribution =new Scene(borderDistribution);

        //distribution
        BorderPane borderCost = new BorderPane();
        HBox hboxCost = addHBox();
        borderCost.setTop(hboxCost);
        borderCost.setLeft(addVBox());
        addStackPane(hboxCost);
        borderCost.setCenter(addAnchorPane(addGridPane("Cost:","Goods","Services")));
        borderCost.setRight(addFlowPaneSales());
        sceneCost =new Scene(borderCost);


        scene=new Scene(border);
        scene.getStylesheets().add(getClass().getResource("CSS/estilo.css").toExternalForm());
        sceneDistribution.getStylesheets().add(getClass().getResource("CSS/estilo.css").toExternalForm());
        sceneMarketing.getStylesheets().add(getClass().getResource("CSS/estilo.css").toExternalForm());
        sceneCost.getStylesheets().add(getClass().getResource("CSS/estilo.css").toExternalForm());



        stageOriginal.setScene(scene);
        stageOriginal.show();
    }



//-------------------------

    public HBox addHBox() {//top
        HBox hboxTop = new HBox();
        hboxTop.setId("hboxTop");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setId("buttonCurrent");

        Button buttonProjected = new Button("Projected");
        buttonProjected.setId("buttonProjected");

            buttonProjected.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                        HelloController.changeToScene2(actionEvent);
                }
            });



        hboxTop.getChildren().addAll(buttonCurrent, buttonProjected);




        return hboxTop;

        //pre css styleshet

        //hbox
        //hboxTop.setStyle("-fx-background-color: #336699;");
        //hboxTop.setPadding(new Insets(15, 12, 15, 12));
        //hboxTop.setSpacing(10);

        //boton
        //buttonCurrent.setPrefSize(80, 20);
        //buttonProjected.setPrefSize(80, 20);///TAMAÑO BOTON
    }

    public VBox addVBox() {//izq
        VBox vboxLeft = new VBox();
        vboxLeft.setId("vboxLeft");
        //todo
        //por alguna razon al apretar al siguiente enlace esto desaparece, al igual que el icono de ?

        //vboxLeft.setSpacing(8);
        //vboxLeft.setPadding(new Insets(10));
        //vbox.setStyle("-fx-background-color: #b5c4f5;");//fondo

        Text title = new Text("Data");
        title.setId("Data");
        vboxLeft.getChildren().add(title);

        //title.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Hyperlink sales=new Hyperlink("Sales");
        sales.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageOriginal.setTitle("Ventana Sales");
                stageOriginal.setScene(scene);
                stageOriginal.show();
            }
        });


        Hyperlink Marketing=new Hyperlink("Marketing");
        Marketing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageOriginal.setTitle("Ventana Marketing");
                stageOriginal.setScene(sceneMarketing);
                stageOriginal.show();
            }
        });

        Hyperlink Distribution=new Hyperlink("Distribution");
        Distribution.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageOriginal.setTitle("Ventana Distribution");
                stageOriginal.setScene(sceneDistribution);
                stageOriginal.show();
            }
        });

        Hyperlink Costs=new Hyperlink("Costs");
        Costs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageOriginal.setTitle("Ventana Costs");
                stageOriginal.setScene(sceneCost);
                stageOriginal.show();
            }
        });


        Hyperlink options[] = new Hyperlink[] {
                sales,
                Marketing,
                Distribution,
                Costs};



        for (int i=0; i<4; i++) {
            options[i].setId("hijoOption");
            //VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vboxLeft.getChildren().add(options[i]);
        }

        return vboxLeft;
    }

    public void addStackPane(HBox hb) {//icono ?
        StackPane stack = new StackPane();
        stack.setId("stack");

        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setId("helpIcon");

//        helpIcon.setFill(new LinearGradient(0,0,0,1,
//                true,
//                CycleMethod.NO_CYCLE,
//                new Stop[]{
//                        new Stop(0, Color.web("#4977A3")),
//                        new Stop(0.5, Color.web("#B0C6DA")),
//                        new Stop(1,Color.web("#9CB6CF")),}));

        //helpIcon.setStroke(Color.web("#D0E6FA"));
//        helpIcon.setArcHeight(3.5);
//        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setId("helpText");
        helpText.setFill(Color.WHITE);

        //helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        //helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);
        //stack.setAlignment(Pos.CENTER_RIGHT);

        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

        hb.getChildren().add(stack);            // Add stack pane to HBox object
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }


    public GridPane addGridPane(String texto, String porcentaje1, String porcentaje2) {//medio
        GridPane grid = new GridPane();
        grid.setId("gridMedio");

//        grid.setHgap(10);
//        grid.setVgap(10);//emtre sales y good services
//        grid.setPadding(new Insets(0, 10, 0, 10));

        //-----------------------

        Text category = new Text(texto);
        category.setId("category");
        grid.add(category, 1, 0);//add to grid

        Text chartTitle = new Text("Current Year");
        chartTitle.setId("chartTitle");
        grid.add(chartTitle, 2, 0);//add to grid

        Text chartSubtitle = new Text("Goods and Services");
        chartSubtitle.setId("chartSubtitle");
        grid.add(chartSubtitle, 1, 1, 2, 1);//add to grid


        //category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //chartSubtitle.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        //-----------------------


        // casa
        ImageView imageHouse = new ImageView(
                new Image(HelloApplication.class.getResourceAsStream("graphics/house-noBG.png")));
        imageHouse.setId("imageHouse");

        imageHouse.setFitHeight(50);
        imageHouse.setFitWidth(50);
        //no se puede poner en css lo del tamaño

        grid.add(imageHouse, 0, 0, 1, 2);//add to grid


        //-----------------------
        Text goodsPercent = new Text(porcentaje1+"\n80%");
        goodsPercent.setId("goodsPercent");
        GridPane.setValignment(goodsPercent, VPos.BOTTOM);
        grid.add(goodsPercent, 0, 2);//add to grid

        //goodsPercent.setFont(Font.font("Helvetica", FontPosture.ITALIC,14));

        //-----------------------
        // grafico
        ImageView imageChart = new ImageView(
                new Image(HelloApplication.class.getResourceAsStream("graphics/piechart-orig-noBG.png")));
        imageChart.setId("imageChart");
        imageChart.setFitWidth(250);//tamaño
        imageChart.setFitHeight(250);//tamaño
        grid.add(imageChart, 1, 2, 2, 1);//add to grid



//-----------------------
        Text servicesPercent = new Text(porcentaje2+"\n20%");
        servicesPercent.setId("servicesPercent");
        GridPane.setValignment(servicesPercent, VPos.TOP);
        grid.add(servicesPercent, 3, 2);

        //servicesPercent.setFont(Font.font("Helvetica", FontPosture.ITALIC,14));



        return grid;
    }

    public FlowPane addFlowPaneSales() {//der
        FlowPane flow = new FlowPane();
        flow.setId("flow");
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        //flow.setStyle("-fx-background-color: DAE6F3;");
        //flow.setPadding(new Insets(5, 10, 5, 10));
        //flow.setVgap(4);
        //flow.setHgap(4);

        //------------------
        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            String archivoRuta2="graphics/chart_"+(i+1)+"-No-bg.png";

            //buscar la imagen
            ImageView imagen=new ImageView(new Image(HelloApplication.class.getResourceAsStream(
                    archivoRuta2)));

            //asignar
            pages[i] = imagen;


            //tamaño
            pages[i].setFitHeight(80);
            pages[i].setFitWidth(80);

            //add
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }

    public FlowPane addFlowPaneMarketing() {//der
        FlowPane flow = new FlowPane();
        flow.setId("flow");
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        //flow.setStyle("-fx-background-color: DAE6F3;");
        //flow.setPadding(new Insets(5, 10, 5, 10));
        //flow.setVgap(4);
        //flow.setHgap(4);

        //------------------
        ImageView pages[] = new ImageView[8];
        for (int i=0; i<6; i++) {
            String archivoRuta="graphics/chart_marketing-"+(i+1)+".png";

            //buscar la imagen
            ImageView imagen=new ImageView(new Image(HelloApplication.class.getResourceAsStream(
                    archivoRuta)));

            //asignar
            pages[i] = imagen;


            //tamaño
            pages[i].setFitHeight(80);
            pages[i].setFitWidth(80);

            //add
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }


    public AnchorPane addAnchorPane(GridPane grid) {
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.setId("anchorPane");


        Button buttonSave = new Button("Save");
        buttonSave.setId("buttonSave");

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setId("buttonCancel");

        HBox hb = new HBox();
        hb.setId("HboxBottom");

//        hb.setPadding(new Insets(0, 10, 10, 10));
//        hb.setSpacing(10);
        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }

    /* static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/




}

