/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VReservas;

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
public class FReservas {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID RESERVAS", "ID QUARTOS", "NÚMERO", "ID CLIENTES", "CLIENTE", "ID FUNCIONÁRIOS", "FUNCIONÁRIO", "TIPO RESERVA", "DATA RESERVA", "DATA ENTRADA", "DATA SAÍDA", "VALOR QUARTO", "ESTADO"};
        String[] registros = new String[13];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
          sSQL="select r.id_reserva,r.id_quartos,q.numero,r.id_cliente,"+
               "(select nome_pessoa from tb_pessoas where id_pessoa=r.id_cliente)as clienten,"+
               "r.id_funcionario,(select nome_pessoa from tb_pessoas where id_pessoa=r.id_funcionario)as funcionarion,"+
               "r.tipo_reserva,r.data_reserva,r.data_entrada,r.data_saida,"+
               "r.valor_quarto,r.estado from tb_reservas r inner join tb_quartos q on r.id_quartos=q.id_quartos where r.data_reserva like '%"+ buscar + "%' order by id_reserva desc";
      /*  sSQL = "select r.id_reserva, r.id_quartos, q.numero, r.id_cliente,"
                + "(select nome_pessoa from tb_pessoas where id_pessoa=r.id_cliente) as clienten, "
                + "r.id_funcionario, (select nome_pessoa from tb_pessoas where id_pessoa=r.id_funcionario) as funcionarion,"
                + "r.tipo_reserva, r.data_reserva, r.data_entrada, r.data_saida,"
                + "r.valor_quarto, r.estado from tb_reservas r inner join tb_quartos q on r.id_quartos=q.id_quartos where r.data_reserva like '%'" + buscar + "%' order by id_reserva desc";
*/
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_reserva");
                registros[1] = rs.getString("id_quartos");
                registros[2] = rs.getString("numero");
                registros[3] = rs.getString("id_cliente");
                registros[4] = rs.getString("clienten");
                registros[5] = rs.getString("id_funcionario");
                registros[6] = rs.getString("funcionarion");
                registros[7] = rs.getString("tipo_reserva");
                registros[8] = rs.getString("data_reserva");
                registros[9] = rs.getString("data_entrada");
                registros[10] = rs.getString("data_saida");
                registros[11] = rs.getString("valor_quarto");
                registros[12] = rs.getString("estado");

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

    public boolean inserir(VReservas dts) {

        sSQL = "insert into tb_reservas ( id_quartos, id_cliente,  id_funcionario, tipo_reserva, data_reserva, data_entrada, data_saida, valor_quarto, estado)"
                + "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdQuartos());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdFuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, (java.sql.Date) dts.getData_reserva());
            pst.setDate(6, (java.sql.Date) dts.getData_entrada());
            pst.setDate(7, (java.sql.Date) dts.getData_saida());
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());

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

    public boolean editar(VReservas dts) {
        sSQL = " update tb_reservas set id_cliente = ?, id_quartos = ?, id_funcionario = ?,tipo_reserva = ?, data_reserva = ?, data_entrada = ?, data_saida = ?, valor_quarto = ?, estado = ? where id_reserva = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdQuartos());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdFuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, (java.sql.Date) dts.getData_reserva());
            pst.setDate(6, (java.sql.Date) dts.getData_entrada());
            pst.setDate(7, (java.sql.Date) dts.getData_saida());
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());
            pst.setInt(10, dts.getIdReserva());

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
     public boolean pagar(VReservas dts) {
        sSQL = " update tb_reservas set estado = 'PAGA' where id_reserva = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

         
          //  pst.setString(1, dts.getEstado());
            pst.setInt(1, dts.getIdReserva());

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

    public boolean deletar(VReservas dts) {

        sSQL = "delete from tb_reservas where id_reserva = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdReserva());
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
