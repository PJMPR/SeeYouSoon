
package dao.model;

public class ZakupZnicza implements IHaveId{
    
    private int id;
    private int iloscZniczy;
    private int cenaZaSztuke;
    private int idUsera;
    private int idZmarlego;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIloscZniczy(int iloscZniczy) {
        this.iloscZniczy = iloscZniczy;
    }

    public void setCenaZaSztuke(int cenaZaSztuke) {
        this.cenaZaSztuke = cenaZaSztuke;
    }

    public void setIdUsera(int idUsera) {
        this.idUsera = idUsera;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

    public int getIloscZniczy() {
        return iloscZniczy;
    }

    public int getCenaZaSztuke() {
        return cenaZaSztuke;
    }

    public int getIdUsera() {
        return idUsera;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }
    
    
    
    
            
    
}
