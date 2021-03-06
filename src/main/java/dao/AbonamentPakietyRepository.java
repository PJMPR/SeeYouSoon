package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.AbonamentPakiety;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

public class AbonamentPakietyRepository extends RepositoryBase<AbonamentPakiety> {

    public AbonamentPakietyRepository(Connection connection, IMapResultSetIntoEntity<AbonamentPakiety> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    public String tableName() {
        return "abonament_pakiety";
    }

    @Override
    public String createTableSql() {

        return "create table "
                + tableName()
                + " id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + " id_usera int,"
                + "cena int ,"
                + "id_zmarlego int ,"
                + "ilosc_miesiecy int,"
                + "FOREIGN KEY (id_zmarlego) REFERENCES Zmarli(ID),"
                + "FOREIGN KEY (id_usera) REFERENCES userzy(ID))";
    }

    @Override
    public String insertSql() {
        return "insert into "
                + tableName()
                + " (id_usera,cena,id_zmarlego,ilosc_miesiecy) "
                + "values (?,?,?,?) ";
    }

    @Override
    public String updateSql() {
        return "update "
                + tableName()
                + " set (id_usera,cena,id_zmarlego,ilosc_miesiecy)= "
                + "(?,?,?,?) "
                + "where id=?";
    }

    @Override
    public void insertPrepare(AbonamentPakiety entity) throws SQLException {
        insert.setInt(1, entity.getIdUsera());
        insert.setInt(2, entity.getCena());
        insert.setInt(3, entity.getIdZmarlego());
        insert.setInt(4, entity.getCena());
    }

    @Override
    public void updatePrepare(AbonamentPakiety entity) throws SQLException {
        update.setInt(1, entity.getIdUsera());
        update.setInt(2, entity.getCena());
        update.setInt(3, entity.getIdZmarlego());
        update.setInt(4, entity.getCena());
        update.setInt(5, entity.getId());

    }

}
