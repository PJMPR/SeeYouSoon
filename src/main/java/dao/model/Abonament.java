package dao.model;

import java.sql.Date;

public class Abonament implements IHaveId {

    private int id;
    private int idUsera;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    private int idZmarlego;

    public Abonament() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public int getIdUsera() {
        return idUsera;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsera(int idUsera) {
        this.idUsera = idUsera;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

}
