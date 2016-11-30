package dao.repositories;

import dao.model.IHaveId;
import java.sql.SQLException;
import java.util.List;

public interface IRepository<TEntity extends IHaveId> {

    public TEntity get(TEntity entity) throws SQLException;

    public List<TEntity> getAll();

    public void delete(TEntity entity) throws SQLException;

    public void update(TEntity entity) throws SQLException;

    public void insert(TEntity entity) throws SQLException;

    public void createTableIfnotExists() throws SQLException;

}
