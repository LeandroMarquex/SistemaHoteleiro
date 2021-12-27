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
public class VPessoas {
    
    private int idPessoa;
    private String nomePessoa;
    private String nomePai;
    private String nomeMae;
    private String tipo_documento;
    private String numero_documento;
    private String enderecoPessoa;
    private String telefonePessoa;
    private String emialPessoa;

    public VPessoas() {
    }

    public VPessoas(int idPessoa, String nomePessoa, String nomePai, String nomeMae, String tipo_documento, String numero_documento, String enderecoPessoa, String telefonePessoa, String emialPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.enderecoPessoa = enderecoPessoa;
        this.telefonePessoa = telefonePessoa;
        this.emialPessoa = emialPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getEmialPessoa() {
        return emialPessoa;
    }

    public void setEmialPessoa(String emialPessoa) {
        this.emialPessoa = emialPessoa;
    }
    
    
    
    
}
