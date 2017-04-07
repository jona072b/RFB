package DAO;

import Model.Barn;
import Model.Forældre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class Read {

    public Read(){}

    public ObservableList<Barn> fromFile(){
        ObservableList<Barn> list = FXCollections.observableArrayList();
        try{
            Scanner fileScan = new Scanner(new File("børn.txt"));
            while(fileScan.hasNextLine()){
                Scanner lineScan = new Scanner(fileScan.nextLine());
                String fornavn = lineScan.next();
                String efternavn = lineScan.next();
                String cpr = lineScan.next();
                String stue = lineScan.next();
                String forældre1Navn = lineScan.next() + " " + lineScan.next();
                String forældre1Tlf = lineScan.next();
                String forældre2Navn = lineScan.next() + " " + lineScan.next();
                String forældre2Tlf = lineScan.next();
                String kontaktMail = lineScan.next();

                Barn b1 = new Barn(fornavn,efternavn,cpr,stue,new Forældre(forældre1Navn,forældre1Tlf),new Forældre(forældre2Navn,forældre2Tlf),kontaktMail);
                list.add(b1);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }


        //list.addAll(b1,b2);

        return list;
    }
}
