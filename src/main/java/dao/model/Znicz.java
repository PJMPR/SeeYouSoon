package dao.model;

import java.sql.Date;

public class Znicz implements IHaveId {

    private int id;
    private int idZmarlego;
    private Date dataStartu;
    private Date dataZakonczenia;

    @Override
    public Integer getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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


}