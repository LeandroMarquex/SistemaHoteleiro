/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author Administrator
 */
public class VQuartos {
    
    private int idQuartos;
    private String numero;
    private String andar;
    private String descricao;
    private String caracteristicas;
    private Double precoDiaria;
    private String estado;
    private String tipoQuarto;

    public VQuartos(int idQuartos, String numero, String andar, String descricao, String caracteristicas, Double precoDiaria, String estado, String tipoQuarto) {
        this.idQuartos = idQuartos;
        this.numero = numero;
        this.andar = andar;
        this.descricao = descricao;
        this.caracteristicas = caracteristicas;
        this.precoDiaria = precoDiaria;
        this.estado = estado;
        this.tipoQuarto = tipoQuarto;
    }

    public VQuartos() {
        
    }

    public int getIdQuartos() {
        return idQuartos;
    }

    public void setIdQuartos(int idQuartos) {
        this.idQuartos = idQuartos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    
    
    
}
