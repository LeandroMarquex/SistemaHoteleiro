/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.util.Date;

/**
 *
 * @author Leandro Marques
 */
public class VReservas {
    
    private int idReserva;
    private int idQuartos;
    private int idCliente;
    private int idFuncionario;
    private String tipo_reserva;
    private Date data_reserva;
    private Date data_entrada;
    private Date data_saida;
    private Double valor_quarto;
    private String estado;

    public VReservas() {
    }

    public VReservas(int idReserva, int idQuartos, int idCliente, int idFuncionario, String tipo_reserva, Date data_reserva, Date data_entrada, Date data_saida, Double valor_quarto, String estado) {
        this.idReserva = idReserva;
        this.idQuartos = idQuartos;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.tipo_reserva = tipo_reserva;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.valor_quarto = valor_quarto;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdQuartos() {
        return idQuartos;
    }

    public void setIdQuartos(int idQuartos) {
        this.idQuartos = idQuartos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Double getValor_quarto() {
        return valor_quarto;
    }

    public void setValor_quarto(Double valor_quarto) {
        this.valor_quarto = valor_quarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
