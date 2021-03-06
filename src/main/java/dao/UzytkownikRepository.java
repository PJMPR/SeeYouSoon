
package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.model.Uzytkownik;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;


public class UzytkownikRepository extends RepositoryBase<Uzytkownik> {

    public UzytkownikRepository(Connection connection, IMapResultSetIntoEntity<Uzytkownik> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    @Override
    public String tableName() {
        return "Uzytkownicy";
    }

    @Override
    public String createTableSql() {
        return "create table "
                + tableName()
                + " id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + " login varchar(20),"
                + " haslo varchar(20),"
                + " email varchar(20),"
                + " data_rejestracji date)";

    }

    @Override
    public String insertSql() {
        return "insert into "
                + tableName()
                + " (login,haslo,email,data_rejestracji) "
                + "values (?,?,?,?) ";
    }

    @Override
    public String updateSql() {
        return "update "
                + tableName()
                + " set (login,haslo,email,data_rejestracji)= "
                + "(?,?,?) "
                + "where id=?";
    }

    @Override
    public void insertPrepare(Uzytkownik entity) throws SQLException {
        insert.setString(1, entity.getLogin());
        insert.setString(2, entity.getHaslo());
        insert.setString(3, entity.getEmail());
        insert.setDate(4, entity.getData_rejestracji());
    }

    @Override
    public void updatePrepare(Uzytkownik entity) throws SQLException {
        update.setString(1, entity.getLogin());
        update.setString(2, entity.getHaslo());
        update.setString(3, entity.getEmail());
        update.setDate(4, entity.getData_rejestracji());
        update.setInt(5, entity.getId());
    }

}
