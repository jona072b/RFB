package GUI;

import Controller.ConGUIModel;
import Model.Barn;
import Model.Forældre;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Scanner;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class AdminBarn {
    public static Scene scene;

    private static TextField tfNavn;
    private static TextField tfCPR;
    private static TextField tfStue;
    private static TextField tfForældre1Navn;
    private static TextField tfForældre1Tlf;
    private static TextField tfForældre2Navn;
    private static TextField tfForældre2Tlf;
    private static TextField tfKontaktMail;


    public static Scene buttonClicked(){
        VBox vbox = new VBox(50);
        Label lblAdmin = new Label("Administrer Barn");
        lblAdmin.setId("H1");
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20,25,35,25));

        ConGUIModel controller = new ConGUIModel();
        ObservableList<Barn> list = controller.getBørn();
        HBox hBox = new HBox(10);
        TableView tableView = new TableView();
        tableView.itemsProperty().setValue(list);


        TableColumn<Barn,String> navn = new TableColumn("Navn");
        TableColumn<Barn,String> stue = new TableColumn<>("Stue");

        navn.setCellValueFactory(e -> e.getValue().navnProperty());
        stue.setCellValueFactory(e -> e.getValue().stueProperty());

        tableView.getColumns().addAll(navn,stue);

        tableView.getSelectionModel().setCellSelectionEnabled(false);
        ObservableList selectedCells = tableView.getSelectionModel().getSelectedCells();


        GridPane gp = new GridPane();
        gp.setHgap(25);
        gp.setVgap(11.2);
        Label lblNavn = new Label("Navn: ");
        Label lblCPR = new Label("CPR: ");
        Label lblStue = new Label("Stue: ");
        Label lblForældre1Navn = new Label("Forældre 1, navn: ");
        Label lblForældre1Tlf = new Label("Forældre 1, Tlf: ");
        Label lblForældre2Navn = new Label("Forældre 2, navn: ");
        Label lblForældre2Tlf = new Label("Forældre 2, tlf: ");
        Label lblKontaktMail = new Label("Kontaktmail: ");
        gp.addColumn(1,lblNavn,lblCPR,lblStue,lblForældre1Navn,lblForældre1Tlf,lblForældre2Navn,lblForældre2Tlf,lblKontaktMail);

        tfNavn = new TextField();
        tfCPR = new TextField();
        tfStue = new TextField();
        tfForældre1Navn = new TextField();
        tfForældre1Tlf = new TextField();
        tfForældre2Navn = new TextField();
        tfForældre2Tlf = new TextField();
        tfKontaktMail = new TextField();
        tfEditable(false);

        //Barn b1 = null;

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                Barn b1 = (Barn) tableView.getSelectionModel().getSelectedItem();
                tfNavn.setText(b1.getFornavn() + " " + b1.getEfternavn());
                tfCPR.setText(b1.getCpr());
                tfStue.setText(b1.getStue());
                tfForældre1Navn.setText(b1.getForældre1().getNavn());
                tfForældre1Tlf.setText(b1.getForældre1().getTlf());
                tfForældre2Navn.setText(b1.getForældre2().getNavn());
                tfForældre2Tlf.setText(b1.getForældre2().getTlf());
                tfKontaktMail.setText(b1.getKontaktMail());
            }
        });

        //Buttons
        HBox buttons = new HBox(20);

        Button btnBack = new Button("Tilbage");
        btnBack.setId("BackButton");
        btnBack.setOnAction(event -> MainLogin.window.setScene(MainLogin.scene));

        Button btnSave = new Button("Gem");
        btnSave.setId("SaveButton");

        Button btnEdit = new Button("Redigér");
        btnEdit.setId("ActionButton");

        Button btnCancel = new Button("Annuller");
        btnCancel.setId("BackButton");
        btnCancel.setOnAction(event -> {
            MainLogin.window.setScene(scene);
            tfEditable(false);
            buttons.getChildren().clear();
            buttons.getChildren().addAll(btnEdit,btnBack);
        });


        btnEdit.setOnAction(event -> {
            tfEditable(true);
            buttons.getChildren().clear();
            buttons.getChildren().addAll(btnSave,btnCancel);

        });

        btnSave.setOnAction(event -> {
            Barn b1 = (Barn) tableView.getSelectionModel().getSelectedItem();
            Scanner navnScanner = new Scanner(tfNavn.getText());
            b1.setFornavn(navnScanner.next());
            b1.setEfternavn(navnScanner.next());
            b1.setCpr(tfCPR.getText());
            b1.setStue(tfStue.getText());
            b1.setForældre1(new Forældre(tfForældre1Navn.getText(),tfForældre1Tlf.getText()));
            b1.setForældre2(new Forældre(tfForældre2Navn.getText(),tfForældre2Tlf.getText()));
            b1.setKontaktMail(tfKontaktMail.getText());

            controller.save(list);
            tableView.refresh();

            buttons.getChildren().clear();
            buttons.getChildren().addAll(btnEdit,btnBack);
            tfEditable(false);
        });


        buttons.getChildren().addAll(btnEdit,btnBack);

        gp.addColumn(2,tfNavn,tfCPR,tfStue,tfForældre1Navn,tfForældre1Tlf,tfForældre2Navn,tfForældre2Tlf,tfKontaktMail,buttons);

        hBox.getChildren().addAll(tableView,gp);



        vbox.getChildren().addAll(lblAdmin,hBox);

        scene = new Scene(vbox,700,500);
        scene.getStylesheets().addAll("StyleAF.css");
        return scene;

    }
        public static void tfEditable(boolean edit) {
            tfNavn.setEditable(edit);
            tfCPR.setEditable(edit);
            tfStue.setEditable(edit);
            tfForældre1Navn.setEditable(edit);
            tfForældre1Tlf.setEditable(edit);
            tfForældre2Navn.setEditable(edit);
            tfForældre2Tlf.setEditable(edit);
            tfKontaktMail.setEditable(edit);

        }
}

