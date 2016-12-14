
package dao;

import dao.mappers.UzytkownikRepositoryMapper;
import dao.mappers.ZmarlyRepositoryMapper;
import dao.mappers.ZniczRepositoryMapper;
import dao.uow.IUnitOfWork;
import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryCatalog {
    IUnitOfWork uow;
    Connection connection;

    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        this.uow = uow;
        this.connection = connection;
    }
    
    
    public UzytkownikRepository uzytkownikRepository(){
        return new UzytkownikRepository(connection, new UzytkownikRepositoryMapper(), uow);
    }
    
    public ZniczRepository zniczRepository(){
        return new ZniczRepository(connection, new ZniczRepositoryMapper(), uow);
    }
    
    public ZmarlyRepository zmarlyRepository(){
        return new ZmarlyRepository(connection,new ZmarlyRepositoryMapper(), uow);
    }
    
    
    public void saveAndClose() {
        try{
            uow.saveChanges();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }
    
    
    
}
