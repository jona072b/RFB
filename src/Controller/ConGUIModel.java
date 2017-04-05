package Controller;

import Model.Barn;
import Model.Lister;
import javafx.collections.ObservableList;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class ConGUIModel {

    public ConGUIModel(){}

    public ObservableList<Barn> getBørn(){
        Lister list = new Lister();
        return list.getBørn();
    }
    public void save(ObservableList<Barn> list){
        Lister lister = new Lister();
        lister.toFile(list);

    }
    public void addBarn(Barn b){
        Lister lister = new Lister();
        lister.addBarn(b);
    }

    public ObservableList<Barn> getVenteliste (){
       Lister lister = new Lister();
       return lister.getVenteliste();
    }



}

