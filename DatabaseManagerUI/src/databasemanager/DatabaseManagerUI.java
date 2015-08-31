
package databasemanager;

import java.util.List;
import point.Point3D;

/**
 *
 * @author JustInG
 */
public class DatabaseManagerUI {

    private DatabaseManager db;
    private boolean run = true;
    
    public DatabaseManagerUI() {
        
        db = DatabaseManagerFactory.create();
        
        db.connect();
        db.createTable();
        
        //db.insert(new Point3D(100,250,4));

        List<Point3D> list = db.selectAll();
        Point3D p = list.get(list.size() - 1);
        final int id = p.getId();
        
        new Thread(new Runnable() {

            @Override
            public void run() {

                while (run) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    System.out.println(db.selectById(id).toString());
                }

            }
        }).start();
        
 
        //db.close();
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        new DatabaseManagerUI();
    }
    */
}
