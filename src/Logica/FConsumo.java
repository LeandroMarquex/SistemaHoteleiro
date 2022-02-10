/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VConsumo;
import Dados.VProdutos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro Marques
 */
public class FConsumo {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;
    public Double totalConsumo;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID CONSUMO", "ID RESERVA", "ID PRODUTO", "PRODUTO", "QUANTIDADE", "PREÇO VENDA", "ESTADO"};
        String[] registros = new String[7];
        totalRegistros = 0;
        totalConsumo = 0.0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select  c.id_consumo, c.id_reserva, c.id_produto, p.nome, c.quantidade, c.preco_venda"
                + ",c.estado from tb_consumo c inner join tb_produtos p on c.id_produto=p.id_produto"
                + " where c.id_reserva = " + buscar + " order by c.id_consumo desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_consumo");
                registros[1] = rs.getString("id_reserva");
                registros[2] = rs.getString("id_produto");
                registros[3] = rs.getString("nome");
                registros[4] = rs.getString("quantidade");
                registros[5] = rs.getString("preco_venda");
                registros[6] = rs.getString("estado");

                totalRegistros = totalRegistros + 1;
                totalConsumo = totalConsumo + (rs.getDouble("quantidade") * rs.getDouble("preco_venda"));
                modelo.addRow(registros);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return null;
        }

    }

    public boolean inserir(VConsumo dts) {

        sSQL = "insert into tb_consumo ( id_reserva, id_produto, quantidade,  preco_venda, estado)"
                + "values( ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdResertva());
            pst.setInt(2, dts.getIdProduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());

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

    public boolean editar(VConsumo dts) {
        sSQL = " update tb_consumo set id_reserva = ?, id_produto = ?, quantidade = ?, preco_venda = ?, estado = ?  where id_consumo = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdResertva());
            pst.setInt(2, dts.getIdProduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());

            pst.setInt(6, dts.getIdConsumo());

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

    public boolean deletar(VConsumo dts) {

        sSQL = "delete from tb_consumo where id_consumo = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdConsumo());
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
