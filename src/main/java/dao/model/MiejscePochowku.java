package dao.model;

public class MiejscePochowku implements IHaveId {

    private int id;
    private boolean czyWolne;
    private int idZmarlego;

    @Override
    public Integer getId() {
        return id;
    }

    public boolean isCzyWolne() {
        return czyWolne;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCzyWolne(boolean czyWolne) {
        this.czyWolne = czyWolne;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

}
