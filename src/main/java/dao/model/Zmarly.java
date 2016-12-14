package dao.model;

import java.sql.Date;

public class Zmarly implements IHaveId {

    private int id;
    private int idUzytkownika;
    private Date dataSmierci;
    private Date dataUrodzenia;
    private String imie;
    private String Nazwisko;

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

}
