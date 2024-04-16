package com.mycompany.projetopdv.dao;

import com.mycompany.projetopdv.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleht
 */
public class ClienteDAO {
    
    static String URL = "jdbc:mysql://localhost:3306/projetopdv";
    static String login = "root";
    static String senha = "admin";
    
    public static boolean alterar(Cliente obj) {
        Connection conexao = null;
        
        boolean retorno = false;
        
        try {
            
            // 1.Carregar o driver do mysql      
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2.Fazer conexão com o banco 
            conexao = DriverManager.getConnection(URL, login, senha);
            
            // 3.Preparar comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                  "UPDATE cliente SET nomeCliente=?, emailCliente=? WHERE idCliente = ?;"
            );
                    
           instrucaoSQL.setString(1, obj.getNomeCliente());
           instrucaoSQL.setString(2, obj.getEmailCliente()); 
           instrucaoSQL.setInt(3, obj.getIdCliente());
           instrucaoSQL.setString(4, obj.getRuaCliente());
           instrucaoSQL.setString(5, obj.getCidadeCliente());
           instrucaoSQL.setString(6, obj.getNumeroCliente());
 
           // 4.Executar comando
           int linhasAfetadas = instrucaoSQL.executeUpdate();
           
           if (linhasAfetadas > 0){
               retorno = true;
           }
                      
            // Conexao com banco
        
        } catch(ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
          if(conexao!=null) {
              try {
                  conexao.close();
              } catch (SQLException ex) {
                  Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
          }  
        }
        
        return retorno;
         
    }
    
    public static ArrayList<Cliente>  lista(){
        ArrayList<Cliente> listaRetorno = new ArrayList<> ();
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            // 1.Carregar o driver do mysql      
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2.Fazer conexão com o banco 
            conexao = DriverManager.getConnection(URL, login, senha);
            
            // 3.Preparar comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                  "SELECT * FROM Cliente"  
            );
            
            // 4.Executar comando
            rs = instrucaoSQL.executeQuery();
            
            if(rs !=null){
                
                while(rs.next()){
                    
                    int id = rs.getInt("IdCliente");
                    String nome = rs.getString("nomeCliente");
                    String CPF = rs.getString("CPF");
                    String email = rs.getString("emailCliente");
                    String rua = rs.getString("ruaCliente");
                    String cidade = rs.getString("cidadeCliente");
                    String numero = rs.getString("numeroCliente");
           
                    Cliente item = new Cliente(id, nome, email, CPF, rua, cidade, numero);
                    listaRetorno.add(item);                  
                }
                
            }
            
        } catch (Exception e) {
            listaRetorno = null;
        } finally {
            
            if(conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        return listaRetorno;
    }
    
     public static boolean salvar(Cliente obj) {
        Connection conexao = null; 
        boolean retorno = false;
        
        try {
            
            // 1.Carregar o driver do mysql      
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2.Fazer conexão com o banco 
            conexao = DriverManager.getConnection(URL, login, senha);
            
            // 3.Preparar comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                  "INSERT INTO cliente (nomeCliente, cpf, emailCliente, ruaCliente, cidadeCliente, numeroCliente) VALUES(?,?,?,?,?,?)"
            );
                    
           instrucaoSQL.setString(1, obj.getNomeCliente());
           instrucaoSQL.setString(2, obj.getCPF()); 
           instrucaoSQL.setString(3, obj.getEmailCliente());
           instrucaoSQL.setString(4, obj.getRuaCliente());
           instrucaoSQL.setString(5, obj.getCidadeCliente());
           instrucaoSQL.setString(6, obj.getNumeroCliente());
      
           // 4.Executar comando
           int linhasAfetadas = instrucaoSQL.executeUpdate();
           
           if (linhasAfetadas > 0){
               retorno = true;
           }
                      
            // Conexao com banco
        
        } catch(ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
          if(conexao!=null) {
              try {
                  conexao.close();
              } catch (SQLException ex) {
                  Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
          }  
        
        }
        return retorno; 
     }

 public static boolean excluir(int idExcluir) {
    Connection conexao = null;
    boolean retorno = false;
    
    try {
        // 1.Carregar o driver do mysql      
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2.Fazer conexão com o banco 
        conexao = DriverManager.getConnection(URL, login, senha);
        
        // 3.Preparar comando SQL
        PreparedStatement instrucaoSQL = conexao.prepareStatement(
                "DELETE FROM Cliente WHERE idCliente = ?;"
        );
             
        // Definir o parâmetro do ID a ser excluído
        instrucaoSQL.setInt(1, idExcluir);
     
        // 4.Executar comando
        int linhasAfetadas = instrucaoSQL.executeUpdate();
       
        if (linhasAfetadas > 0){
            retorno = true;
        } else {
            System.out.println("Nenhum cliente foi excluído.");
        }
                      
        // Conexao com banco
        
    } catch(ClassNotFoundException e) {
        System.out.println("Driver não encontrado");
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        if(conexao!=null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }  
    return retorno;
}}
