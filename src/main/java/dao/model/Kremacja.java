package dao.model;

public class Kremacja implements IHaveId {

    private int id;
    private int idZmarlego;
    private boolean czySkremowany;

    @Override
    public Integer getId() {
        return id;
    }

    public int getIdZmarlego() {
        return idZmarlego;
    }

    public boolean isCzySkremowany() {
        return czySkremowany;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdZmarlego(int idZmarlego) {
        this.idZmarlego = idZmarlego;
    }

    public void setCzySkremowany(boolean czySkremowany) {
        this.czySkremowany = czySkremowany;
    }

}
