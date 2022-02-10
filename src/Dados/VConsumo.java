/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author Leandro Marques
 */
public class VConsumo {
    
    private int idConsumo;
    private int idResertva;
    private int idProduto;
    private Double quantidade;
    private Double preco_venda;
    private String estado;

    public VConsumo() {
    }

    public VConsumo(int idConsumo, int idResertva, int idProduto, Double quantidade, Double preco_venda, String estado) {
        this.idConsumo = idConsumo;
        this.idResertva = idResertva;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.estado = estado;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdResertva() {
        return idResertva;
    }

    public void setIdResertva(int idResertva) {
        this.idResertva = idResertva;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
