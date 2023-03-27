import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

/**
 * Class used to make the connection between the java code and the MySql Server
 */
public class DbConnection {


    Connection c;
    Statement s;

    public DbConnection() {

        try {
            c  = (Connection) DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","parola");
            s = ((java.sql.Connection) c).createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
