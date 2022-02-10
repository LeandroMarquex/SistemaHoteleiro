/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VQuartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FQuartos {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Número", "Andar", "Descrição", "Caracteristicas", "Preço", "Estado", "Tipo de Quarto"};
        String[] registros = new String[8];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from tb_quartos where andar like '%" + buscar + "%' order by id_quartos";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_quartos");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("andar");
                registros[3] = rs.getString("descricao");
                registros[4] = rs.getString("caracteristica");
                registros[5] = rs.getString("preco_diaria");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("tipo_quarto");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return null;
        }

    }
     public DefaultTableModel mostrarQuartos(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Número", "Andar", "Descrição", "Caracteristicas", "Preço", "Estado", "Tipo de Quarto"};
        String[] registros = new String[8];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from tb_quartos where andar like '%" + buscar + "%' and estado='Disponível' order by id_quartos";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_quartos");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("andar");
                registros[3] = rs.getString("descricao");
                registros[4] = rs.getString("caracteristica");
                registros[5] = rs.getString("preco_diaria");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("tipo_quarto");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return null;
        }

    }


    public boolean inserir(VQuartos dts) {

        sSQL = "insert into tb_quartos ( numero, andar, descricao, caracteristica,  preco_diaria, estado, tipo_quarto)" +
                "values( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecoDiaria());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoQuarto());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return false;

        }
    }

    public boolean editar(VQuartos dts) {
        sSQL = " update tb_quartos set numero = ?, andar = ?, descricao = ?, caracteristica = ?, preco_diaria = ?, estado = ?, tipo_quarto = ? where id_quartos = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecoDiaria());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoQuarto());
            pst.setInt(8, dts.getIdQuartos());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public boolean desocupar(VQuartos dts) {
        sSQL = "update tb_quartos set estado='Disponível' where id_quartos=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

           
  //          pst.setString(1, dts.getEstado());
            pst.setInt(1, dts.getIdQuartos());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
     public boolean ocupar(VQuartos dts) {
        sSQL = " update tb_quartos set estado = 'ocupado' where id_quartos = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

           
 //           pst.setString(1, dts.getEstado());
            pst.setInt(1, dts.getIdQuartos());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean deletar(VQuartos dts) {

        sSQL = "delete from tb_quartos where id_quartos = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdQuartos());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
