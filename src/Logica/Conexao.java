/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Conexao {

    public String db = "bancoreserva";
    public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String user = "root";
    public String pass = "";

    public Conexao() {

    }

    public Connection conectar() {
        Connection link = null;

        try {
            //    Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");

            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }

        return link;

    }

}
