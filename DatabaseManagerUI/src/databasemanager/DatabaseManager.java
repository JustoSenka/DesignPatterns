
package databasemanager;

import java.util.List;
import point.Point3D;

/**
 *
 * @author JustInG
 */
public interface DatabaseManager {
    public void connect();
    public void close();
    public void createTable();
    public void insert(Point3D p);
    public Point3D selectById(int id);
    public List<Point3D> selectAll();
    public void delete(int id);
    public void update(Point3D p, int id);
}
