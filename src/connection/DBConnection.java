/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import controller.PanelController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gazi
 */
public class DBConnection {

    private static DBConnection instance = null;
    public Connection connection = null;

    private DBConnection() {
    }

    public static DBConnection getInstance() throws Exception {
        if (instance == null) {
            instance = new DBConnection();
            instance.connect();
        }
        return instance;
    }

    public void connect() throws Exception {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String pass = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, pass);
    }

    public Long executeInsert(String query) {
        Statement st = null;
        try {
            st = connection.createStatement();
            int rowcount = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            if (rowcount == 0) {
                throw new SQLException("Inserting entity failed, no rows affected.");
            }

            try ( ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    return -1L;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1L;
        } finally {
            close(null, st, null);
        }
    }

    public boolean executeUpdate(String query) {
        Statement st = null;
        boolean signal = false;
        try {
            st = connection.createStatement();
            int rowcount = st.executeUpdate(query);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    public void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
