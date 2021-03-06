package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.Sprzatanie;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;


public class SprzatanieRepository extends RepositoryBase<Sprzatanie> {

    public SprzatanieRepository(Connection connection, IMapResultSetIntoEntity<Sprzatanie> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    public String tableName() {
        return "Sprzatania";
    }

    @Override
    public String createTableSql() {

        return "create table "
                + tableName()
                + " id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + " id_znicza int,"
                + "id_zmarlego int ,"
                + "status_znicza boolean,"
                + "FOREIGN KEY (id_znicza) REFERENCES Znicze(ID),"
                + "FOREIGN KEY (id_zmarlego) REFERENCES Zmarli(ID))";
    }

    @Override
    public String insertSql() {
        return "insert into "
                + tableName()
                + " (id_znicza,id_zmarlego,status_znicza) "
                + "values (?,?,?) ";
    }

    @Override
    public String updateSql() {
        return "update "
                + tableName()
                + " set (id_znicza,id_zmarlego,status_znicza)= "
                + "(?,?,?) "
                + "where id=?";
    }

    @Override
    public void insertPrepare(Sprzatanie entity) throws SQLException {
        insert.setInt(1, entity.getIdZnicza());
        insert.setInt(2, entity.getIdZmarlego());
        insert.setBoolean(3, entity.isStatusZnicza());
    }

    @Override
    public void updatePrepare(Sprzatanie entity) throws SQLException {
        update.setInt(1, entity.getIdZnicza());
        update.setInt(2, entity.getIdZmarlego());
        update.setBoolean(3, entity.isStatusZnicza());
        update.setInt(4, entity.getId());
    }

}
