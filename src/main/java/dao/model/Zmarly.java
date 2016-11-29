package dao.model;

import java.sql.Date;

public class Zmarly implements IHaveId {

    private int id;
    private int idUzytkownika;
    private Date dataSmierci;
    private Date dataUrodzenia;
    private String imie;
    private String Nazwisko;
    private int idMiejscaPochowku;
    private boolean czyWZiemie;
    private boolean abonamentStatus;
    private boolean czySkremowany;

    @Override
    public Integer getId() {
        return id;
    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public Date getDataSmierci() {
        return dataSmierci;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public int getIdMiejscaPochowku() {
        return idMiejscaPochowku;
    }

    public boolean isCzyWZiemie() {
        return czyWZiemie;
    }

    public boolean isAbonamentStatus() {
        return abonamentStatus;
    }

    public boolean isCzySkremowany() {
        return czySkremowany;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public void setDataSmierci(Date dataSmierci) {
        this.dataSmierci = dataSmierci;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public void setIdGrobu(int idGrobu) {
        this.idMiejscaPochowku = idMiejscaPochowku;
    }

    public void setCzyWZiemie(boolean czyWZiemie) {
        this.czyWZiemie = czyWZiemie;
    }

    public void setAbonamentStatus(boolean abonamentStatus) {
        this.abonamentStatus = abonamentStatus;
    }

    public void setCzySkremowany(boolean czySkremowany) {
        this.czySkremowany = czySkremowany;
    }

}
