/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.VFuncionarios;
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
public class FFuncionarios {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;
      public Integer totalRegistrosLogin;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "NOME", "NOME PAI", "NOME MÃE", "DOCUMENTO", "NÚMERO DO DOCUMENTO", "ENDEREÇO", "TELEFONE", "EMAIL", "SALÁRIO", "ACESSO", "LOGIN", "SENHA", "ESTADO"};
        String[] registros = new String[15];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.id_pessoa,p.nome_pessoa,p.nome_pai,p.nome_mae,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,f.salario,f.acesso,f.login,f.password,f.estado from tb_pessoas p inner join tb_funcionarios f "
                + "on p.id_pessoa=f.id_pessoa where num_documento like '%"
                + buscar + "%' order by id_pessoa desc";

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
                registros[9] = rs.getString("salario");
                registros[10] = rs.getString("acesso");
                registros[11] = rs.getString("login");
                registros[12] = rs.getString("password");
                registros[13] = rs.getString("estado");

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

    public boolean inserir(VFuncionarios dts) {

        sSQL = "insert into tb_pessoas (nome_pessoa, nome_pai, nome_mae, tipo_documento, num_documento, endereco, telefone, email)"
                + "values(?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into tb_funcionarios (id_pessoa, salario, acesso, login, password, estado)"
                + "values((select id_pessoa from tb_pessoas order by id_pessoa desc limit 1),?,?,?,?,?)";
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());

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

    public boolean editar(VFuncionarios dts) {
        sSQL = " update tb_pessoas set nome_pessoa = ?, nome_pai = ?, nome_mae = ?, tipo_documento = ?, num_documento = ?, endereco = ?, telefone = ?, email = ?  where id_pessoa = ?";
        sSQL2 = " update tb_funcionarios set salario = ?, acesso = ?, login = ?, password = ?, estado = ? where id_pessoa = ?";
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdPessoa());

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

    public boolean deletar(VFuncionarios dts) {

        sSQL = "delete from tb_funcionarios where id_pessoa = ?";
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

    public DefaultTableModel login(String login, String password) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nome", "Nome Pai", "Nome Mãe", "Acesso", "Login", "Senha", "Estado"};
        String[] registro = new String[8];
        totalRegistrosLogin = 0;

        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.id_pessoa,p.nome_pessoa,p.nome_pai,p.nome_mae,"
                + "f.acesso,f.login,f.password,f.estado from tb_pessoas p inner join tb_funcionarios f "
                + "on p.id_pessoa=f.id_pessoa where f.login='"
                + login + "' and f.password='" + password + "' and f.estado='ATIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id_pessoa");
                registro[1] = rs.getString("nome_pessoa");
                registro[2] = rs.getString("nome_pai");
                registro[3] = rs.getString("nome_mae");
                registro[4] = rs.getString("acesso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalRegistrosLogin = totalRegistrosLogin + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
