/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VPago;

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
public class FPago {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID PAGAMENTO", "ID RESERVAS", "TIPO COMPROVANTE", "NUMERO COMPROVANTE", "TAXA", "TOTAL PAGAMENTO", "DATA EMISSÃO", "DATA PAGAMENTO"};
        String[] registros = new String[8];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from tb_pagamentos where id_reserva = " + buscar + " order by id_pagamento ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_pagamento");
                registros[1] = rs.getString("id_reserva");
                registros[2] = rs.getString("tipo_comprovante");
                registros[3] = rs.getString("num_comprovante");
                registros[4] = rs.getString("taxa");
                registros[5] = rs.getString("total_pagamento");
                registros[6] = rs.getString("data_emissao");
                registros[7] = rs.getString("data_pagamento");

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

    public boolean inserir(VPago dts) {

        sSQL = "insert into tb_pagamentos ( id_reserva, tipo_comprovante,  num_comprovante, taxa, total_pagamento, data_emissao, data_pagamento)"
                + "values( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipo_comprovante());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, dts.getData_emissao());
            pst.setDate(7, dts.getData_pagamento());

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

    public boolean editar(VPago dts) {
        sSQL = " update tb_pagamentos set id_reserva = ?, tipo_comprovante = ?,  num_comprovante = ?, taxa, total_pagamento = ?, data_emissao = ?, data_pagamento = ? where id_pagamento = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipo_comprovante());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, dts.getData_emissao());
            pst.setDate(7, dts.getData_pagamento());

            pst.setInt(8, dts.getIdPagamento());

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

    public boolean deletar(VPago dts) {

        sSQL = "delete from tb_pagamentos where id_pagamento = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdPagamento());
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
}
