package domain;

import dao.RepositoryCatalog;
import dao.model.Uzytkownik;
import dao.model.Zmarly;
import dao.model.Znicz;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        Connection connection=null;
        RepositoryCatalog repositoryCatalog=null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            repositoryCatalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setData_rejestracji(new Date(2016, 10, 10));
        uzytkownik.setEmail("Jakis@gmail.com");
        uzytkownik.setLogin("jakis");
        uzytkownik.setHaslo("jakis");
          
        Uzytkownik uzytkownik2 = new Uzytkownik();
        uzytkownik2.setData_rejestracji(new Date(150, 11, 5));
        uzytkownik2.setEmail("nowy@gmail.com");
        uzytkownik2.setLogin("nowy");
        uzytkownik2.setHaslo("nowy");
        
        
        repositoryCatalog.uzytkownikRepository().add(uzytkownik);
        repositoryCatalog.uzytkownikRepository().add(uzytkownik2);
        
        Zmarly zmarly =  new Zmarly();
        zmarly.setDataSmierci(new Date(116, 10, 10));
        zmarly.setDataUrodzenia(new Date(10,10,10));
        zmarly.setIdUzytkownika(0);
        zmarly.setImie("Jan");
        zmarly.setNazwisko("Janowski");
        
        
        Zmarly zmarly2 =  new Zmarly();
        zmarly2.setDataSmierci(new Date(99, 10, 10));
        zmarly2.setDataUrodzenia(new Date(10,10,10));
        zmarly2.setIdUzytkownika(1);
        zmarly2.setImie("JanNowy");
        zmarly2.setNazwisko("JanowskiNowy");
        
        
        repositoryCatalog.zmarlyRepository().add(zmarly);
        repositoryCatalog.zmarlyRepository().add(zmarly2);
        
        
        Znicz znicz1 = new Znicz();
        
        znicz1.setDataStartu(new Date(116,12,12));
        znicz1.setDataZakonczenia(new Date(117, 12, 12));
        znicz1.setIdZmarlego(0);
        
        Znicz znicz2 = new Znicz();
        
        znicz2.setDataStartu(new Date(116,12,12));
        znicz2.setDataZakonczenia(new Date(117, 12, 12));
        znicz2.setIdZmarlego(1);
        
        repositoryCatalog.zniczRepository().add(znicz2);
        repositoryCatalog.zniczRepository().add(znicz1);
        repositoryCatalog.saveAndClose();
        

    }
}
