package dao.model;

public class Sprzatanie implements IHaveId {

    private int id;
    private int idZmarlego;
    private int idZnicza;

    private boolean statusZnicza;

    @Override
    public Integer getId() {
        return id;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }

    public int getIdZnicza() {
        return idZnicza;
    }

    public boolean isStatusZnicza() {
        return statusZnicza;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

    public void setIdZnicza(int idZnicza) {
        this.idZnicza = idZnicza;
    }

    public void setStatusZnicza(boolean statusZnicza) {
        this.statusZnicza = statusZnicza;
    }

}
