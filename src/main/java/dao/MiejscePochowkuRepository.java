package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.MiejscePochowku;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

public class MiejscePochowkuRepository extends RepositoryBase<MiejscePochowku> {

    public MiejscePochowkuRepository(Connection connection, IMapResultSetIntoEntity<dao.model.MiejscePochowku> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    public String tableName() {
        return "MiejscaPochowku";
    }

    @Override
    public String createTableSql() {

        return "create table "
                + tableName()
                + " id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + " czy_wolne boolean,"
                + "id_zmarlego int ,"
                + "FOREIGN KEY (id_zmarlego) REFERENCES Zmarli(ID))";
    }

    @Override
    public String insertSql() {
        return "insert into "
                + tableName()
                + " (czy_wolne,id_zmarlego) "
                + "values (?,?) ";
    }

    @Override
    public String updateSql() {
        return "update "
                + tableName()
                + " set (czy_wolne,id_zmarlego)= "
                + "(?,?) "
                + "where id=?";
    }

    @Override
    public void insertPrepare(MiejscePochowku entity) throws SQLException {
        insert.setBoolean(1, entity.isCzyWolne());
        insert.setInt(2, entity.getIdZmarlego());
    }

    @Override
    public void updatePrepare(MiejscePochowku entity) throws SQLException {
        update.setBoolean(1, entity.isCzyWolne());
        update.setInt(2, entity.getIdZmarlego());
        update.setInt(3, entity.getId());
    }

}
