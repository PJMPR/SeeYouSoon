package dao.mappers;

import dao.model.Uzytkownik;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UzytkownikRepositoryMapper implements IMapResultSetIntoEntity<Uzytkownik> {

    @Override
    public Uzytkownik map(ResultSet rs) throws SQLException {
        Uzytkownik uz = new Uzytkownik();

        uz.setData_rejestracji(rs.getDate("data_rejestracji"));
        uz.setEmail(rs.getString("email"));
        uz.setHaslo(rs.getString("haslo"));
        uz.setLogin(rs.getString("login"));
        uz.setId(rs.getInt("id"));

        return uz;
    }

}
