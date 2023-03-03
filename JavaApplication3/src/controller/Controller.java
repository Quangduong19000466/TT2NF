/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static common.AccountController.getJDBCConnection;
import model.Account;

/**
 *
 * @author Admin
 */
public class Controller {
    
    public boolean login(String username, String password){
        
       Connection conn = getJDBCConnection();
       String sql = "SELECT* FROM account WHERE username =? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void sigup(Account account){
        Connection conn = getJDBCConnection();
        String sql = "INSERT INTO account (username, password, fullname, address) VALUE (?, ?, ?, ?)";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,account.getUsername());
              ps.setString(2,account.getPassword());
                ps.setString(3,account.getFullname());
                  ps.setString(4,account.getAddress());
            int rs = ps.executeUpdate();
            if(rs != 0){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
