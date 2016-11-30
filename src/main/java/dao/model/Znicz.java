package dao.model;

import java.sql.Date;

public class Znicz implements IHaveId {

    private int id;
    private int idUsera;
    private int idZmarlego;
    private Date dataStartu;
    private Date dataZakonczenia;
    private boolean czySiePali;
    private boolean czyStoiNaGrobie;

    @Override
    public Integer getId() {
        return id;
    }

    public int getIdUsera() {
        return idUsera;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }

    public Date getDataStartu() {
        return dataStartu;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public boolean isCzySiePali() {
        return czySiePali;
    }

    public boolean isCzyStoiNaGrobie() {
        return czyStoiNaGrobie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsera(int idUsera) {
        this.idUsera = idUsera;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

    public void setDataStartu(Date dataStartu) {
        this.dataStartu = dataStartu;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setCzySiePali(boolean czySiePali) {
        this.czySiePali = czySiePali;
    }

    public void setCzyStoiNaGrobie(boolean czyStoiNaGrobie) {
        this.czyStoiNaGrobie = czyStoiNaGrobie;
    }

}
