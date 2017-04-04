package DAO;

import Model.Barn;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class Write {

    public void toFile(ObservableList<Barn> list){
        try {
            FileWriter fw = new FileWriter(new File("børn.txt"),false);
            for(Barn b: list){
                fw.write(b.print() + "\n");
            }
            fw.close();


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
