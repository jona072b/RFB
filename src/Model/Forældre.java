package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class Forældre {
    private StringProperty navn;
    private StringProperty tlf;

    public Forældre(StringProperty navn, StringProperty tlf) {
        this.navn = navn;
        this.tlf = tlf;
    }

    public Forældre(String navn, String tlf){
        this.navn = new SimpleStringProperty(navn);
        this.tlf = new SimpleStringProperty(tlf);
    }

    @Override
    public String toString() {
        return  "Navn = " + navn +
                ", Tlf = " + tlf;
    }
    public String print(){
        return getNavn() + " " + getTlf();
    }



    public String getNavn() {
        return navn.get();
    }

    public StringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getTlf() {
        return tlf.get();
    }

    public StringProperty tlfProperty() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf.set(tlf);
    }
}
