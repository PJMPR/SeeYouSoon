package dao.mappers;

import dao.model.Zmarly;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZmarlyRepositoryMapper implements IMapResultSetIntoEntity<Zmarly> {

    @Override
    public Zmarly map(ResultSet rs) throws SQLException {

        Zmarly zm = new Zmarly();

        zm.setDataSmierci(rs.getDate("data_smierci"));
        zm.setDataUrodzenia(rs.getDate("data_urodzenia"));
        zm.setId(rs.getInt("id"));
        zm.setIdUzytkownika(rs.getInt("id_usera"));
        zm.setImie(rs.getString("imie"));
        zm.setNazwisko(rs.getString("nazwisko"));

        return zm;
    }

}
