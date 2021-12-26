/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class FProdutos {
    
 private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRODUTO", "DESCRIÇÃO", "UNIDADE DE MEDIDA", "PREÇO"};
        String[] registros = new String[5];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from tb_produtos where nome like '%" + buscar + "%' order by id_produto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_produto");
                registros[1] = rs.getString("nome");
                registros[2] = rs.getString("descricao");
                registros[3] = rs.getString("unidade_medida");
                registros[4] = rs.getString("preco_venda");
               

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

    public boolean inserir(VProdutos dts) {

        sSQL = "insert into tb_produtos ( nome, descricao, unidade_medida,  preco_venda)" +
                "values( ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNomeProduto());
            pst.setString(2, dts.getDescricaoProduto());
            pst.setString(3, dts.getUnidade_medida());
            pst.setDouble(4, dts.getValorProduto());
          
           

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

    public boolean editar(VProdutos dts) {
        sSQL = " update tb_produtos set nome = ?, descricao = ?, unidade_medida = ?, preco_venda = ? where id_produto = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNomeProduto());
            pst.setString(2, dts.getDescricaoProduto());
            pst.setString(3, dts.getUnidade_medida());
             pst.setDouble(4, dts.getValorProduto());
            pst.setInt(5, dts.getIdProduto());
           
            

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

    public boolean deletar(VProdutos dts) {

        sSQL = "delete from tb_produtos where id_produto = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdProduto());
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
