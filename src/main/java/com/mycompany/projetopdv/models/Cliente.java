package com.mycompany.projetopdv.models;

/**
 *
 * @author aleht
 */
/**
 * Representa um cliente.
 */
public class Cliente {
    
    private int idCliente;
    private String nomeCliente;
    private String emailCliente;
    private String CPF;
    private String ruaCliente;
    private String cidadeCliente;
    private String numeroCliente;
    // Construtores


    public Cliente(int idCliente, String nomeCliente, String emailCliente, String CPF, String ruaCliente, String cidadeCliente, String numeroCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.CPF = CPF;
        this.ruaCliente = ruaCliente;
        this.cidadeCliente = cidadeCliente;
        this.numeroCliente = numeroCliente;
    }

    public Cliente(String nomeCliente, String emailCliente, String CPF, String ruaCliente, String cidadeCliente, String numeroCliente) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.CPF = CPF;
        this.ruaCliente = ruaCliente;
        this.cidadeCliente = cidadeCliente;
        this.numeroCliente = numeroCliente;
    }
    
    // Getters e Setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    } 
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }
    
    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    } 

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}