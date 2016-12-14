package dao.mappers;

import dao.model.Znicz;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZniczRepositoryMapper implements IMapResultSetIntoEntity<Znicz> {

    @Override
    public Znicz map(ResultSet rs) throws SQLException {
        Znicz zn = new Znicz();
        zn.setDataStartu(rs.getDate("data_startu"));
        zn.setDataZakonczenia(rs.getDate("data_zakonczenia"));
        zn.setId(rs.getInt("id"));
        zn.setIdZmarlego(rs.getInt("id_zmarlego"));

        return zn;
    }

}
