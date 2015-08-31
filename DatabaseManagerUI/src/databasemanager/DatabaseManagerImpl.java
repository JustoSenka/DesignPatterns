package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import point.Point3D;

/**
 *
 * @author JustInG
 */
public class DatabaseManagerImpl implements DatabaseManager {

    private final String user = "testuser181716";
    private final String pass = "testpass";
    private final String dbClass = "com.mysql.jdbc.Driver";
    private final String dbDriver = "jdbc:mysql://db4free.net:3306/";
    private final String dbName = "testdb181716";
    
    /*
    private final String user = "u296770372_test";
    private final String pass = "testpass";
    private final String dbClass = "com.mysql.jdbc.Driver";
    private final String dbDriver = "jdbc:mysql://mysql.serversfree.com:3306/";
    private final String dbName = "u296770372_test";    
    */
    private Connection connection = null;

    @Override
    public void createTable() {
        Statement statement = null;
 
        try {
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS point (id int primary key unique auto_increment, x int, y int, z int)");
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void insert(Point3D p) {
        PreparedStatement preparedStatement = null;
 
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO point (x, y, z) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, p.getX());
            preparedStatement.setInt(2, p.getY());
            preparedStatement.setInt(3, p.getZ());
            preparedStatement.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Point3D selectById(int id) {
        Point3D p = new Point3D();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
 
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM point WHERE id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
 
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setX(rs.getInt("x"));
                p.setY(rs.getInt("y"));
                p.setZ(rs.getInt("z"));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return p;
    }

    @Override
    public List<Point3D> selectAll() {
        List<Point3D> list = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
 
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM point");
           
            while (rs.next()) {
                Point3D p = new Point3D();
                p.setId(rs.getInt("id"));
                p.setX(rs.getInt("x"));
                p.setY(rs.getInt("y"));
                p.setZ(rs.getInt("z"));
                list.add(p);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
 
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM point WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Point3D p, int id) {
        PreparedStatement preparedStatement = null;
 
        try {
            preparedStatement = connection.prepareStatement("UPDATE point SET " +
                    "x = ?, y = ?, z = ? WHERE id = ?");
 
            preparedStatement.setInt(1, p.getX());
            preparedStatement.setInt(2, p.getY());
            preparedStatement.setInt(3, p.getZ());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void connect() {
        connection = null;

        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try {
            Class.forName(dbClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        try {
            connection = DriverManager.getConnection(dbDriver + dbName, user, pass);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Connected to JDBC");
        } else {
            System.out.println("Failed to make connection!");
        }        
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
    }
}
