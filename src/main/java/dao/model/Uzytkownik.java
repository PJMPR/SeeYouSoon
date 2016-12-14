
package dao.model;

import java.sql.Date;

public class Uzytkownik implements IHaveId{

    private int id;
    private String login;
    private String haslo;
    private String email;
    private Date data_rejestracji;

    @Override
    public Integer getId() {
        return id;
    }

    

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getEmail() {
        return email;
    }

    public Date getData_rejestracji() {
        return data_rejestracji;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setData_rejestracji(Date data_rejestracji) {
        this.data_rejestracji = data_rejestracji;
    }
    
    
    
    
}
