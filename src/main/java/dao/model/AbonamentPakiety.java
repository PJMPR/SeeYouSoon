package dao.model;

public class AbonamentPakiety implements IHaveId {

    private int id;
    private int idUsera;
    private int idZmarlego;
    private int cena;
    private int iloscMiesiecy;

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

    public int getCena() {
        return cena;
    }

    public int getIloscMiesiecy() {
        return iloscMiesiecy;
    }

    public void setIdUsera(int idUsera) {
        this.idUsera = idUsera;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setIloscMiesiecy(int iloscMiesiecy) {
        this.iloscMiesiecy = iloscMiesiecy;
    }

    public void setId(int id) {
        this.id = id;
    }

}
