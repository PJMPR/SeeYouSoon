package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.Znicz;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

public class ZniczRepository extends RepositoryBase<Znicz> {

    public ZniczRepository(Connection connection, IMapResultSetIntoEntity<Znicz> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    public String tableName() {
        return "znicze";
    }

    @Override
    public String createTableSql() {

        return "create table "
                + tableName()
                + " id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + " id_usera int,"
                + " id_zmarlego int,"
                + " data_startu date,"
                + " data_zakonczenia date,"
                + "czy_sie_pali boolean,"
                + "czy_stoi_na_grobie boolean,"
                + "FOREIGN KEY (id_zmarlego) REFERENCES Zmarli(ID),"
                + "FOREIGN KEY (id_usera) REFERENCES uzytkownicy(ID))";
    }

    @Override
    public String insertSql() {
        return "insert into "
                + tableName()
                + " (id_usera,id_zmarlego,data_startu,data_zakonczenia,czy_sie_pali,czy_stoi_na_grobie) "
                + "values (?,?,?,?,?,?) ";
    }

    @Override
    public String updateSql() {
        return "update "
                + tableName()
                + " set (id_usera,id_zmarlego,data_startu,data_zakonczenia,czy_sie_pali,czy_stoi_na_grobie)= "
                + "(?,?,?,?,?,?) "
                + "where id=?";
    }

    @Override
    public void insertPrepare(Znicz entity) throws SQLException {
        insert.setInt(1, entity.getIdUsera());
        insert.setInt(2, entity.getIdZmarlego());
        insert.setDate(3, entity.getDataStartu());
        insert.setDate(4, entity.getDataZakonczenia());
        insert.setBoolean(5, entity.isCzySiePali());
        insert.setBoolean(6, entity.isCzyStoiNaGrobie());
    }

    @Override
    public void updatePrepare(Znicz entity) throws SQLException {
        update.setInt(1, entity.getIdUsera());
        update.setInt(2, entity.getIdZmarlego());
        update.setDate(3, entity.getDataStartu());
        update.setDate(4, entity.getDataZakonczenia());
        update.setBoolean(5, entity.isCzySiePali());
        update.setBoolean(6, entity.isCzyStoiNaGrobie());
        update.setInt(7, entity.getId());
    }

}