/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Dados.VPago;

import Dados.VQuartos;
import Dados.VReservas;
import Logica.Conexao;
import Logica.FConsumo;
import Logica.FPago;
import Logica.FQuartos;
import Logica.FReservas;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.io.File;

/**
 *
 * @author Leandro Marques
 */
public class Frm_pagamentos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_produtos
     *
     */
    private String acao = "salvar";
    public static String id_reserva;
    public static String clientes;
    public static String id_quarto;
    public static String quarto;
    public static Double total_reserva;

    public Frm_pagamentos() {
        initComponents();
        desativar();
        mostrar(id_reserva);
        txt_id_reservas.setText(id_reserva);
        txt_cliente.setText(clientes);
        txt_numero_quarto.setText(quarto);
        txt_id_quartos.setText(id_quarto);
        txt_total_reserva.setText(Double.toString(total_reserva));

        FConsumo func = new FConsumo();
        func.mostrar(id_reserva);
        txt_total_pagamento.setText(Double.toString(total_reserva * func.totalConsumo));

    }

    void ocultar_coluna_consumo() {
        tb_lista_consumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(0).setMinWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tb_lista_consumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(1).setMinWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        tb_lista_consumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(2).setMinWidth(0);
        tb_lista_consumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void ocultar_coluna() {
        tb_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_lista.getColumnModel().getColumn(0).setMinWidth(0);
        tb_lista.getColumnModel().getColumn(0).setPreferredWidth(0);

        tb_lista.getColumnModel().getColumn(1).setMaxWidth(0);
        tb_lista.getColumnModel().getColumn(1).setMinWidth(0);
        tb_lista.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void desativar() {
        txt_id_pagaemntos.setVisible(false);
        txt_id_reservas.setVisible(false);
        txt_id_quartos.setVisible(false);
        cb_tipo_comprovante.setEnabled(true);
        txt_cliente.setEnabled(false);
        txt_total_pagamento.setEnabled(false);
        txt_numero_quarto.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(true);
        txt_data_pagamento.setEnabled(true);
        txt_numero_comprovante.setEnabled(true);
        txt_taxa.setEnabled(true);

        btn_salvar.setEnabled(false);

        btn_cancelar.setEnabled(false);

    }

    void ativar() {

        txt_id_pagaemntos.setVisible(false);
        txt_id_reservas.setVisible(false);
        txt_id_quartos.setVisible(false);
        cb_tipo_comprovante.setEnabled(true);
        txt_cliente.setEnabled(false);
        txt_total_pagamento.setEnabled(false);
        txt_numero_quarto.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(true);
        txt_data_pagamento.setEnabled(true);
        txt_numero_comprovante.setEnabled(true);
        txt_taxa.setEnabled(true);

        btn_salvar.setEnabled(true);

        btn_cancelar.setEnabled(true);

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            FPago func = new FPago();
            modelo = func.mostrar(buscar);
            tb_lista.setModel(modelo);
            ocultar_coluna();
            lb_registros.setText("Total registros: " + Integer.toString(func.totalRegistros));

            // Mostrar os dados do consumos
            FConsumo func2 = new FConsumo();
            modelo = func2.mostrar(buscar);
            tb_lista_consumo.setModel(modelo);
            ocultar_coluna_consumo();

            lb_registros_consumos.setText("Total Consumos " + func2.totalRegistros);
            lb_total_consumo.setText("Consumo Total: R$ " + func2.totalConsumo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    void limpar() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_lista_consumo = new javax.swing.JTable();
        lb_registros_consumos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_lista = new javax.swing.JTable();
        btn_apagar1 = new javax.swing.JButton();
        btn_sair1 = new javax.swing.JButton();
        lb_registros = new javax.swing.JLabel();
        btn_nota = new javax.swing.JButton();
        lb_total_consumo = new javax.swing.JLabel();
        cb_tipo_comprovante = new javax.swing.JComboBox<>();
        txt_id_pagaemntos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_novo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        txt_taxa = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        txt_id_reservas = new javax.swing.JTextField();
        txt_id_quartos = new javax.swing.JTextField();
        txt_numero_quarto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_numero_comprovante = new javax.swing.JTextField();
        txt_total_pagamento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_data_emissao = new com.toedter.calendar.JDateChooser();
        txt_data_pagamento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txt_total_reserva = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de PAGAMENTOS");

        tb_lista_consumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_lista_consumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_lista_consumoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_lista_consumo);

        lb_registros_consumos.setText("Registros de Consumo:");
        lb_registros_consumos.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Lista de Pagamentos");

        tb_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_lista);

        btn_apagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_apagar1.setLabel("Apagar");
        btn_apagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagar1ActionPerformed(evt);
            }
        });

        btn_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_sair1.setLabel("Sair");
        btn_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sair1ActionPerformed(evt);
            }
        });

        lb_registros.setText("Registros:");
        lb_registros.setToolTipText("");

        btn_nota.setText("Nota Fiscal");
        btn_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(btn_apagar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sair1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_apagar1)
                    .addComponent(btn_sair1)
                    .addComponent(btn_nota))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lb_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        lb_total_consumo.setText("Consumo Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_total_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(lb_registros_consumos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_total_consumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_registros_consumos, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        cb_tipo_comprovante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOTA", "FATURA", "TICKET", "OUTRO" }));
        cb_tipo_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipo_comprovanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Comprovante:");
        jLabel7.setToolTipText("");

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/novo.GIF"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cadastro de Pagamentos");

        jLabel3.setText("Cliente:");

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        txt_taxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_taxaActionPerformed(evt);
            }
        });

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Consumos");

        jLabel5.setText("Número Quarto:");

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_numero_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_quartoActionPerformed(evt);
            }
        });

        jLabel8.setText("Número Comprovante:");
        jLabel8.setToolTipText("");

        jLabel12.setText("Taxa:");
        jLabel12.setToolTipText("");

        jLabel13.setText("Total Pagamento:");
        jLabel13.setToolTipText("");

        txt_numero_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_comprovanteActionPerformed(evt);
            }
        });

        txt_total_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pagamentoActionPerformed(evt);
            }
        });

        jLabel14.setText("Data Emissão:");
        jLabel14.setToolTipText("");

        jLabel15.setText("Data Pagamento:");
        jLabel15.setToolTipText("");

        jLabel6.setText("Total Reserva:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_id_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_id_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_id_pagaemntos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_numero_comprovante))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_cliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_total_reserva)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cb_tipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_numero_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_taxa)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_data_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_total_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addComponent(btn_salvar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_cancelar)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_novo)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_pagaemntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_numero_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_total_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_tipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_numero_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_total_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_data_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_novo)
                            .addComponent(btn_salvar)
                            .addComponent(btn_cancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_lista_consumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_lista_consumoMouseClicked


    }//GEN-LAST:event_tb_lista_consumoMouseClicked

    private void cb_tipo_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipo_comprovanteActionPerformed
        // TODO add your handling code here:
        cb_tipo_comprovante.transferFocus();
    }//GEN-LAST:event_cb_tipo_comprovanteActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        // TODO add your handling code here:
        ativar();
        btn_salvar.setText("Salvar");
        acao = "salvar";
        btn_novo.setEnabled(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
        txt_cliente.transferFocus();
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_taxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_taxaActionPerformed
        // TODO add your handling code here:
        txt_taxa.transferFocus();
    }//GEN-LAST:event_txt_taxaActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // TODO add your handling code here:
        if (txt_cliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o NOME do CLIENTE");
            txt_cliente.requestFocus();
            return;
        }

        VPago dts = new VPago();
        FPago func = new FPago();

        dts.setIdReserva(Integer.parseInt(txt_id_reservas.getText()));
        dts.setNum_comprovante(txt_numero_comprovante.getText());
        dts.setTaxa(Double.parseDouble(txt_taxa.getText()));
        dts.setTotal_pagamento(Double.parseDouble(txt_total_pagamento.getText()));

        Calendar cal;
        int d, m, a;
        cal = txt_data_emissao.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setData_emissao(new Date(a, m, d));

        cal = txt_data_pagamento.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setData_pagamento(new Date(a, m, d));

        int selecionaMedida = cb_tipo_comprovante.getSelectedIndex();
        dts.setTipo_comprovante((String) cb_tipo_comprovante.getItemAt(selecionaMedida));

        if (acao.equals("salvar")) {
            if (func.inserir(dts)) {
                JOptionPane.showMessageDialog(rootPane, "O PAGAMENTO foi EFETUADO com SUCESSO");
                mostrar(id_reserva);
                desativar();

                // Desocupar o quarto
                FQuartos func2 = new FQuartos();
                VQuartos dts2 = new VQuartos();

                dts2.setIdQuartos(Integer.parseInt(txt_id_quartos.getText()));
                func2.desocupar(dts2);

                // Cancelar ou pagar a reserva
                FReservas func3 = new FReservas();
                VReservas dts3 = new VReservas();

                dts3.setIdReserva(Integer.parseInt(txt_id_reservas.getText()));
                func3.pagar(dts3);

            }

        } else if (acao.equals("editar")) {
            dts.setIdPagamento(Integer.parseInt(txt_id_pagaemntos.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "O PAGAMENTO foi EDITADO com SUCESSO");
                mostrar(id_reserva);
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void tb_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listaMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar1.setEnabled(true);
        acao = "editar";
        
        int linha = tb_lista.rowAtPoint(evt.getPoint());
        
        
        txt_id_pagaemntos.setText(tb_lista.getValueAt(linha, 0).toString());
        txt_id_reservas.setText(tb_lista.getValueAt(linha, 1).toString());
        cb_tipo_comprovante.setSelectedItem(tb_lista.getValueAt(linha, 2).toString());
        txt_numero_comprovante.setText(tb_lista.getValueAt(linha, 3).toString());
        txt_taxa.setText(tb_lista.getValueAt(linha, 4).toString());
        txt_total_pagamento.setText(tb_lista.getValueAt(linha, 5).toString());
        txt_data_emissao.setDate(Date.valueOf(tb_lista.getValueAt(linha, 6).toString()));
        txt_data_pagamento.setDate(Date.valueOf(tb_lista.getValueAt(linha, 7).toString()));


    }//GEN-LAST:event_tb_listaMouseClicked

    private void btn_apagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagar1ActionPerformed
        // TODO add your handling code here:
        if (!txt_id_pagaemntos.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro", "Exluir", 2);
            if (confirmacao == 0) {
                FPago func = new FPago();
                VPago dts = new VPago();
                dts.setIdPagamento(Integer.parseInt(txt_id_pagaemntos.getText()));
                func.deletar(dts);
                mostrar(id_reserva);
                desativar();
            }
        }
    }//GEN-LAST:event_btn_apagar1ActionPerformed

    private void btn_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sair1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sair1ActionPerformed

    private void txt_id_pagaemntos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pagaemntos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pagaemntos2ActionPerformed

    private void txt_numero_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_quartoActionPerformed

    private void txt_numero_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_comprovanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_comprovanteActionPerformed

    private void txt_total_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagamentoActionPerformed
    //   private Connection connection = new Conexao.conectar();
    private Connection connection = new Conexao().conectar();

    private void btn_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notaActionPerformed
        // TODO add your handling code here:
        if (!txt_id_pagaemntos.getText().equals("")) {
            Map p = new HashMap();

            p.put("id_pagamento", txt_id_pagaemntos.getText());
            
            JasperReport relatorio;
            JasperPrint impressao;

            try {

                relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Relatorios/rel_nota.jrxml");

                impressao = JasperFillManager.fillReport(relatorio, p, connection);
                JasperViewer view = new JasperViewer(impressao, false);
                view.setTitle("Relatório de Notas");
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_notaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_pagamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_apagar1;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_nota;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair1;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cb_tipo_comprovante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_registros;
    private javax.swing.JLabel lb_registros_consumos;
    private javax.swing.JLabel lb_total_consumo;
    private javax.swing.JTable tb_lista;
    private javax.swing.JTable tb_lista_consumo;
    private javax.swing.JTextField txt_cliente;
    private com.toedter.calendar.JDateChooser txt_data_emissao;
    private com.toedter.calendar.JDateChooser txt_data_pagamento;
    public static javax.swing.JTextField txt_id_pagaemntos;
    public static javax.swing.JTextField txt_id_quartos;
    public static javax.swing.JTextField txt_id_reservas;
    private javax.swing.JTextField txt_numero_comprovante;
    private javax.swing.JTextField txt_numero_quarto;
    private javax.swing.JTextField txt_taxa;
    private javax.swing.JTextField txt_total_pagamento;
    private javax.swing.JTextField txt_total_reserva;
    // End of variables declaration//GEN-END:variables
}
