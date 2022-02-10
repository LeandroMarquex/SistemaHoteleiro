/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VClientes;
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
public class FClientes {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "NOME", "NOME PAI", "NOME MÃE", "DOCUMENTO", "NÚMERO DO DOCUMENTO", "ENDEREÇO", "TELEFONE", "EMAIL", "CÓDIGO CLIENTE"};
        String[] registros = new String[10];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
         sSQL = "select p.id_pessoa,p.nome_pessoa,p.nome_pai,p.nome_mae,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,c.codigo_cliente from tb_pessoas p inner join tb_clientes c "
                + "on p.id_pessoa=c.id_pessoa where num_documento like '%"
                + buscar + "%' order by id_pessoa desc";
      /*  sSQL = "select p.pessoa, p.nome, p.nomepai, p.nomemae, p.tipo_documento, p.num_documento, "
                + "p,endereco, p,telefone, p.mail, c.codigo_cliente from tb_pessoas p inner join tb_clientes c"
                + "on p.id_pessoa = c.idpessoa where num_documento like '%"
                + buscar + "%' order by id_pessoa desc"; */

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("id_pessoa");
                registros[1] = rs.getString("nome_pessoa");
                registros[2] = rs.getString("nome_pai");
                registros[3] = rs.getString("nome_mae");
                registros[4] = rs.getString("tipo_documento");
                registros[5] = rs.getString("num_documento");
                registros[6] = rs.getString("endereco");
                registros[7] = rs.getString("telefone");
                registros[8] = rs.getString("email");
                registros[9] = rs.getString("codigo_cliente");

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

    public boolean inserir(VClientes dts) {

        sSQL = "insert into tb_pessoas (nome_pessoa, nome_pai, nome_mae, tipo_documento, num_documento, endereco, telefone, email)" +
                "values(?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into tb_clientes (id_pessoa, codigo_cliente)" +
                "values((select id_pessoa from tb_pessoas order by id_pessoa desc limit 1),?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNomePessoa());
            pst.setString(2, dts.getNomePai());
            pst.setString(3, dts.getNomeMae());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNumero_documento());
            pst.setString(6, dts.getEnderecoPessoa());
            pst.setString(7, dts.getTelefonePessoa());
            pst.setString(8, dts.getEmialPessoa());

            pst2.setString(1, dts.getCodigo_cliente());

            int n = pst.executeUpdate();
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return false;

        }
    }

    public boolean editar(VClientes dts) {
        sSQL = " update tb_produtos set nome = ?, nome_pai = ?, nome_mae = ?, tipo_documento = ?, num_documento = ?, endereco = ?, telefone = ?, email = ?  where id_pessoa = ?";
        sSQL2 = " update tb_clientes set codigo_cliente = ?  where id_pessoa = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNomePessoa());
            pst.setString(2, dts.getNomePai());
            pst.setString(3, dts.getNomeMae());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNumero_documento());
            pst.setString(6, dts.getEnderecoPessoa());
            pst.setString(7, dts.getTelefonePessoa());
            pst.setString(8, dts.getEmialPessoa());
            pst.setInt(9, dts.getIdPessoa());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getIdPessoa());

            int n = pst.executeUpdate();
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return false;

        }
    }

    public boolean deletar(VClientes dts) {

        sSQL = "delete from tb_clientes where id_pessoa = ?";
        sSQL2 = "delete from tb_pessoas where id_pessoa = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdPessoa());

            pst2.setInt(1, dts.getIdPessoa());

            int n = pst.executeUpdate();
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            return false;

        }
    }

    public DefaultTableModel mostrarClientes(String buscar) {
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
}
