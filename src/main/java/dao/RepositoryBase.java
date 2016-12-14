package dao;

import dao.uow.Entity;
import dao.uow.IUnitOfWork;
import dao.uow.IUnitOfWorkRepository;
import dao.model.IHaveId;
import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IUnitOfWorkRepository {

    protected Connection connection;

    protected PreparedStatement insert;
    protected PreparedStatement selectById;
    protected PreparedStatement update;
    protected PreparedStatement delete;
    protected PreparedStatement selectAll;
    protected IUnitOfWork uow;
    protected IMapResultSetIntoEntity<TEntity> mapper;

    public Connection getConnection() {
        return connection;
    }

    protected RepositoryBase(Connection connection,
            IMapResultSetIntoEntity<TEntity> mapper, IUnitOfWork uow) {
        this.connection = connection;
        this.uow = uow;
        try {
            this.mapper = mapper;
            createTableIfnotExists();
            insert = connection.prepareStatement(insertSql());
            selectById = connection.prepareStatement(selectByIdSql());
            update = connection.prepareStatement(updateSql());
            delete = connection.prepareStatement(deleteSql());
            selectAll = connection.prepareStatement(selectAllSql());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void createTableIfnotExists() throws SQLException {

        Statement createTable = this.connection.createStatement();
        boolean tableExists = false;

        ResultSet rs = connection.getMetaData().getTables(null, null, null,
                null);

        while (rs.next()) {
            if (rs.getString("Table_Name").equalsIgnoreCase(tableName())) {
                tableExists = true;
                break;
            }
        }
        if (!tableExists) {
            createTable.executeUpdate(createTableSql());
        }
    }

    @Override
    public List<TEntity> getAll() {
        try {
            ResultSet rs = selectAll.executeQuery();
            List<TEntity> result = new ArrayList<TEntity>();
            while (rs.next()) {
                result.add(mapper.map(rs));
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public TEntity get(TEntity entity) throws SQLException {
        getPrepare(entity);
        return mapper.map(selectById.executeQuery());

    }

    public void add(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsNew(ent);

    }

    @Override
    public void delete(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsDeleted(ent);
    }

    @Override
    public void update(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsChanged(ent);
    }

    @Override
    public void persistUpdate(Entity entity) {
        try {
            updatePrepare((TEntity) entity.getEntity());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void persistAdd(Entity entity) {
        try {
            insertPrepare((TEntity) entity.getEntity());
            insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void persistDelete(Entity entity) {
        try {
            deletePrepare((TEntity) entity.getEntity());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(TEntity entity) throws SQLException {

        insertPrepare(entity);

        insert.execute();
    }

    public String selectAllSql() {
        return "SELECT * FROM " + tableName();
    }

    public String deleteSql() {
        return "DELETE FROM "
                + tableName()
                + " where id = ?";
    }

    public void deletePrepare(TEntity entity) throws SQLException {
        delete.setInt(1, entity.getId());
    }

    public void getPrepare(TEntity entity) throws SQLException {
        selectById.setInt(1, entity.getId());
    }

    public String selectByIdSql() {
        return " select * from "
                + tableName()
                + " where id = ?";
    }

    public abstract String tableName();

    public abstract void insertPrepare(TEntity entity) throws SQLException;

    public abstract void updatePrepare(TEntity entity) throws SQLException;

    public abstract String createTableSql();

    public abstract String insertSql();

    public abstract String updateSql();
}
