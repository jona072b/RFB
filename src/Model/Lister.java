package Model;

import DAO.Read;
import DAO.Write;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class Lister {
    private ObservableList<Barn> list;

    public Lister(){
        Read reader = new Read();
        list = reader.fromFile();
    }
    public void toFile(ObservableList<Barn> børn){
        list = børn;
        Write write = new Write();
        write.toFile(list);
    }
    public void addBarn(Barn b){
        list.add(b);
        toFile(list);
    }

    public ObservableList<Barn> getBørn() {
        ObservableList<Barn> indmeldt = FXCollections.observableArrayList();
        for (Barn b: list){
            if (!b.getStue().equalsIgnoreCase("Venteliste")) {
                indmeldt.add(b);
            }
        }
        return indmeldt;
    }

    public ObservableList<Barn> getVenteliste() {
        ObservableList <Barn> venteListe = FXCollections.observableArrayList();

        for (Barn b: list){
            if (b.getStue().equalsIgnoreCase("Venteliste")){
                venteListe.add(b);
            }
        }
        return venteListe;
    }

}
