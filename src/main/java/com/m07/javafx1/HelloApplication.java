package com.m07.javafx1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

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
        borderCost.setCenter(addAnchorPaneCost(addGridPaneCost("Cost","Goods","Services")));
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

    }

    public VBox addVBox() {//izq
        VBox vboxLeft = new VBox();
        vboxLeft.setId("vboxLeft");


        Text title = new Text("Data");
        title.setId("Data");
        vboxLeft.getChildren().add(title);


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


        Text helpText = new Text("?");
        helpText.setId("helpText");
        helpText.setFill(Color.WHITE);

        stack.getChildren().addAll(helpIcon, helpText);

        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

        hb.getChildren().add(stack);            // Add stack pane to HBox object
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }


    public GridPane addGridPane(String texto, String porcentaje1, String porcentaje2) {//medio
        GridPane grid = new GridPane();
        grid.setId("gridMedio");

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




        return grid;
    }

    public FlowPane addFlowPaneSales() {//der
        FlowPane flow = new FlowPane();
        flow.setId("flow");
        flow.setPrefWrapLength(170); // preferred width allows for two columns

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


    //------------------------------------
    public AnchorPane addAnchorPane(GridPane grid) {
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.setId("anchorPane");


        Button buttonSave = new Button("Save");
        buttonSave.setId("buttonSave");

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setId("buttonCancel");

        HBox hb = new HBox();
        hb.setId("HboxBottom");

        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }


    //---------------------------

    public GridPane addGridPaneCost(String texto, String porcentaje1, String porcentaje2) {//medio
        GridPane grid = new GridPane();
        grid.setId("gridMedio");

        //-----------------------

        Text category = new Text(texto);
        category.setId("category");
        grid.add(category, 0, 0);//add to grid

        Text chartTitle = new Text("Calculate services and goods");
        chartTitle.setId("chartSubtitle");
        grid.add(chartTitle, 0, 1);//add to grid


        //------------

        CostClase costClase=new CostClase();

        Slider slider=new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(costClase.getCosteFinal());

        slider.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                        costClase.setCosteFinal(newValue.doubleValue())
        );

        grid.add(slider, 0, 3);//add to grid


        Text textoCalcCost=new Text("Goods base cost ");
        textoCalcCost.setId("goodsPercent");
        grid.add(textoCalcCost, 0, 4);//add to grid

        Label textoCalcCost2=new Label();
        textoCalcCost2.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());

        textoCalcCost2.setId("goodsPercent");
        grid.add(textoCalcCost2, 1, 4);//add to grid



        Label calculoCost2=new Label("Goods base*1.5 of benefits - 10% of production:");
        calculoCost2.setId("goodsPercent");
        grid.add(calculoCost2, 0, 5);//add to grid


        Text calculoCost=new Text();

        costClase.resultCost.bind(Bindings.createDoubleBinding(//con esto hace update
                () -> (costClase.getCosteFinal()*1.5)-costClase.getCosteFinal()*0.1,//la operacion
                costClase.costeFinalProperty()));//lo que observa por cambios

        calculoCost.textProperty().bindBidirectional(costClase.resultCost, NumberFormat.getNumberInstance());



        calculoCost.setId("goodsPercent");
        grid.add(calculoCost, 1, 5);//add to grid



//----------

        Slider sliderServices=new Slider();
        sliderServices.setMin(0);
        sliderServices.setMax(100);
        sliderServices.setValue(costClase.getServiceFinal());

        sliderServices.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                        costClase.setServiceFinal(newValue.doubleValue())//damos el valor del slider a la var de la clase
        );

        grid.add(sliderServices, 0, 6);//add to grid


        Text textoCalcServices=new Text("Services base cost ");
        textoCalcServices.setId("goodsPercent");
        grid.add(textoCalcServices, 0, 7);//add to grid

        Label textoCalcServices2=new Label();
        textoCalcServices2.textProperty().bindBidirectional(sliderServices.valueProperty(), NumberFormat.getNumberInstance());

        textoCalcServices2.setId("goodsPercent");
        grid.add(textoCalcServices2, 1, 7);//add to grid


        Label calculoServices2=new Label("Service base*0.7 of benefits:");
        calculoServices2.setId("goodsPercent");
        grid.add(calculoServices2, 0, 8);//add to grid


        Text calculoServices=new Text();

        costClase.resultServices.bind(Bindings.createDoubleBinding(//con esto hace update
                () -> costClase.getServiceFinal()*0.7,//la operacion
                costClase.serviceFinalProperty()));//lo que observa por cambios

        calculoServices.textProperty().bindBidirectional(costClase.resultServices, NumberFormat.getNumberInstance());



        calculoServices.setId("goodsPercent");
        grid.add(calculoServices, 1, 8);//add to grid






        return grid;
    }

    public AnchorPane addAnchorPaneCost(GridPane grid) {
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.setId("anchorPane");

        Button buttonSave = new Button("Save");
        buttonSave.setId("buttonSave");

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setId("buttonCancel");

        HBox hb = new HBox();
        hb.setId("HboxBottom");

        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }


    public class CostClase{

        private final DoubleProperty costeFinal = new SimpleDoubleProperty(50.0);

        private final DoubleProperty serviceFinal = new SimpleDoubleProperty(70.0);
        public  DoubleProperty resultServices = new SimpleDoubleProperty();
        public  DoubleProperty resultCost = new SimpleDoubleProperty();

        public double getResultServices() {
            return resultServices.get();
        }

        public DoubleProperty resultServicesProperty() {
            return resultServices;
        }

        public double getResultCost() {
            return resultCost.get();
        }

        public DoubleProperty resultCostProperty() {
            return resultCost;
        }

        public void setResultCost(double resultCost) {
            this.resultCost.set(resultCost);
        }

        public void setResultServices(double resultServices) {
            this.resultServices.set(resultServices);
        }

        public double getServiceFinal() {
            return serviceFinal.get();
        }

        public DoubleProperty serviceFinalProperty() {
            return serviceFinal;
        }

        public void setServiceFinal(double serviceFinal) {
            this.serviceFinal.set(serviceFinal);
        }


        public double getCosteFinal() {
            return costeFinal.get();
        }

        public DoubleProperty costeFinalProperty() {
            return costeFinal;
        }

        public void setCosteFinal(double costeFinal) {
            this.costeFinal.set(costeFinal);
        }
    }



}

