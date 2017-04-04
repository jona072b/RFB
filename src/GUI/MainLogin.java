package GUI;/**
 * Created by leonemborg on 03/04/2017.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLogin extends Application {
    public static Stage window;
    public static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        VBox vBox = new VBox(50);
        Label LBLVelkommen = new Label("Velkommen til RFB 'Admin'");
        LBLVelkommen.setId("H1");
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(40,25,25,25));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(150);
        gridPane.setVgap(50);

        Button BtnOpr = new Button("Opret barn");
        BtnOpr.setOnAction(event -> {
            window.setScene(OpretBarn.buttonClicked());
        });
        Button BtnAdmins = new Button("Administrer barn");
        BtnAdmins.setOnAction(event -> {
            window.setScene(AdminBarn.buttonClicked());
        });
        Button BtnSeVent = new Button("Se venteliste");
        Button BtnVagt = new Button("Vagtplan");
        Button BtnSeAns = new Button("Se ansatte");
        Button BtnFakt = new Button("Fakturering");
        Button BtnLogUd = new Button("Log ud");
        BtnLogUd.setOnAction(event -> {
            window.setScene(logIn());
        });

        BtnOpr.setId("ActionButton");
        BtnAdmins.setId("ActionButton");
        BtnSeVent.setId("ActionButton");
        BtnVagt.setId("ActionButton");
        BtnSeAns.setId("ActionButton");
        BtnFakt.setId("ActionButton");
        BtnLogUd.setId("BackButton");

        gridPane.addColumn(1,BtnOpr,BtnAdmins,BtnSeVent,BtnLogUd);
        gridPane.addColumn(2,BtnVagt,BtnSeAns,BtnFakt);

        vBox.getChildren().addAll(LBLVelkommen,gridPane);
        scene = new Scene(vBox,700,500);



        scene.getStylesheets().add("StyleAF.css");
        window.setScene(logIn());
        window.show();




    }


    public Scene logIn(){
        BorderPane borderPane = new BorderPane();

        Label labelHL = new Label("Velkommen til Roskilde Frie Børnehave");
        labelHL.setId("H1");

        borderPane.setTop(labelHL);
        borderPane.setAlignment(labelHL, Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(15);
        gridPane.setHgap(10);

        gridPane.setPadding(new Insets(25,25,25,25));

        Label LBUser = new Label("Brugernavn");
        Label LBLPas = new Label("Adgangskode");

        gridPane.addColumn(1,LBUser,LBLPas);
        TextField TxtUser = new TextField();
        TxtUser.setPromptText("Brugernavn");

        PasswordField PS = new PasswordField();
        PS.setPromptText("Adgangskode");

        gridPane.addColumn(2,TxtUser,PS);

        borderPane.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(20);

        Button BtnLogin = new Button("Login");
        BtnLogin.setId("SaveButton");
        BtnLogin.setOnAction(event -> {window.setScene(scene);});


        Button BtnAfslut = new Button("Afslut");
        BtnAfslut.setOnAction(event -> System.exit(1));
        BtnAfslut.setId("BackButton");

        hBox.getChildren().addAll(BtnLogin,BtnAfslut);
        gridPane.add(hBox,2,3);
        Scene logInscene = new Scene(borderPane,400,200);
        logInscene.getStylesheets().add("StyleAF.css");
        return logInscene;
    }


}
