package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Jonathan on 03-04-2017.
 */
public class Barn {
    private StringProperty fornavn;
    private StringProperty efternavn;
    private StringProperty cpr;
    private StringProperty stue;
    private Forældre forældre1;
    private Forældre forældre2;
    private StringProperty kontaktMail;

    public Barn(StringProperty fornavn, StringProperty efternavn, StringProperty cpr, StringProperty stue, Forældre forældre1, Forældre forældre2, StringProperty kontaktMail) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.cpr = cpr;
        this.stue = stue;
        this.forældre1 = forældre1;
        this.forældre2 = forældre2;
        this.kontaktMail = kontaktMail;
    }
    public Barn(String fornavn, String efternavn, String cpr, String stue, Forældre forældre1, Forældre forældre2, String kontaktMail){
        this.fornavn = new SimpleStringProperty(fornavn);
        this.efternavn = new SimpleStringProperty(efternavn);
        this.cpr = new SimpleStringProperty(cpr);
        this.stue = new SimpleStringProperty(stue);
        this.forældre1 = forældre1;
        this.forældre2 = forældre2;
        this.kontaktMail = new SimpleStringProperty(kontaktMail);
    }

    @Override
    public String toString() {
        return  "fornavn = " + getFornavn() +
                ", efternavn = " + getEfternavn() +
                ", cpr = " + getCpr() +
                ", stue = " + getStue() +
                ", forældre1 = " + forældre1 +
                ", forældre2 = " + forældre2 +
                ", kontaktMail = " + getKontaktMail();
    }

    public String print(){
        return getFornavn() + " " + getEfternavn() + " " + getCpr() + " " + getStue() + " " + getForældre1().print() + " " + getForældre2().print() + " " + getKontaktMail();
    }
    public StringProperty navnProperty(){
        SimpleStringProperty navn = new SimpleStringProperty(getFornavn() + " " + getEfternavn());
        return navn;
    }

    public String getFornavn() {
        return fornavn.get();
    }

    public StringProperty fornavnProperty() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEfternavn() {
        return efternavn.get();
    }

    public StringProperty efternavnProperty() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn.set(efternavn);
    }

    public String getCpr() {
        return cpr.get();
    }

    public StringProperty cprProperty() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr.set(cpr);
    }

    public String getStue() {
        return stue.get();
    }

    public StringProperty stueProperty() {
        return stue;
    }

    public void setStue(String stue) {
        this.stue.set(stue);
    }

    public Forældre getForældre1() {
        return forældre1;
    }

    public void setForældre1(Forældre forældre1) {
        this.forældre1 = forældre1;
    }

    public Forældre getForældre2() {
        return forældre2;
    }

    public void setForældre2(Forældre forældre2) {
        this.forældre2 = forældre2;
    }

    public String getKontaktMail() {
        return kontaktMail.get();
    }

    public StringProperty kontaktMailProperty() {
        return kontaktMail;
    }

    public void setKontaktMail(String kontaktMail) {
        this.kontaktMail.set(kontaktMail);
    }
}
