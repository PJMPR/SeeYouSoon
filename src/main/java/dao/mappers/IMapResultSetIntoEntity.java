package dao.mappers;

import dao.model.IHaveId;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapResultSetIntoEntity<TEntity extends IHaveId> {

    public TEntity map(ResultSet rs) throws SQLException;

}
