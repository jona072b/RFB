package GUI;

import Controller.ConGUIModel;
import Model.Barn;
import Model.Forældre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Jonathan on 04-04-2017.
 */
public class OpretBarn {
    public static Scene scene;

    public static Scene buttonClicked() {
        VBox all = new VBox(25);
        Label headline = new Label("Opret Barn");
        headline.setId("H1");

        all.setAlignment(Pos.TOP_CENTER);
        all.setPadding(new Insets(20,15,25,15));

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(25);
        gp.setVgap(10);

        Label lblForNavn = new Label("Fornavn:");
        Label lblEfterNavn = new Label("Efternavn:");
        Label lblCPR = new Label("CPR:");
        Label lblStue = new Label("Stue:");
        Label lblF1N = new Label("Forældre1, Navn:");
        Label lblF1TLF = new Label("Forældre1, TLF:");
        Label lblF2N = new Label("Forældre2, Navn:");
        Label lblF2TLF = new Label("Forældre2, TLF:");
        Label lblKontakt = new Label("Kontaktmail:");
        gp.addColumn(1,lblForNavn,lblEfterNavn,lblCPR,lblStue,lblF1N,lblF1TLF,lblF2N,lblF2TLF,lblKontakt);

        TextField tfFornavn = new TextField();
        TextField tfEfterNavn = new TextField();
        TextField tfCPR = new TextField();
        TextField tfStue = new TextField();
        TextField tfF1N = new TextField();
        TextField tfF1TLF = new TextField();
        TextField tfF2N = new TextField();
        TextField tfF2TLF = new TextField();
        TextField tfKontakt = new TextField();


        tfFornavn.setPromptText("Fornavn");
        tfEfterNavn.setPromptText("Efternavn");
        tfCPR.setPromptText("CPR(xxxxxx-xxxx)");
        tfStue.setPromptText("Stue");
        tfF1N.setPromptText("Forældre1 Navn");
        tfF1TLF.setPromptText("Forældr1 TLF");
        tfF2N.setPromptText("Forældre2 Navn");
        tfF2TLF.setPromptText("Forældre2 TLF");
        tfKontakt.setPromptText("Kontaktmail");

        HBox buttons = new HBox(15);

        Button btnSave = new Button("Opret");
        btnSave.setId("SaveButton");
        btnSave.setOnAction(event -> {

            Barn b = new Barn(tfFornavn.getText(),tfEfterNavn.getText(),tfCPR.getText(),tfStue.getText(), new Forældre(tfF1N.getText()
                                        ,tfF1TLF.getText()),new Forældre(tfF2N.getText(),tfF2TLF.getText()),tfKontakt.getText());

            ConGUIModel controller = new ConGUIModel();
            controller.addBarn(b);
            tfFornavn.clear();
            tfEfterNavn.clear();
            tfCPR.clear();
            tfStue.clear();
            tfF1N.clear();
            tfF1TLF.clear();
            tfF2N.clear();
            tfF2TLF.clear();
            tfKontakt.clear();

        });
        Button btnBack = new Button("Tilbage");
        btnBack.setId("BackButton");
        btnBack.setOnAction(event -> {
            MainLogin.window.setScene(MainLogin.scene);
        });
        buttons.getChildren().addAll(btnSave,btnBack);
        gp.addColumn(2, tfFornavn, tfEfterNavn,tfCPR,tfStue,tfF1N,tfF1TLF,tfF2N,tfF2TLF,tfKontakt,buttons);
        all.getChildren().addAll(headline, gp);
        scene = new Scene(all, 700, 500);

        scene.getStylesheets().addAll("StyleAF.css");
        return scene;
    }
}
