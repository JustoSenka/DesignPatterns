
package databasemanager;

/**
 *
 * @author JustInG
 */
public class DatabaseManagerFactory {
    public static DatabaseManager create(){
        return new DatabaseManagerImpl();
    }
}
