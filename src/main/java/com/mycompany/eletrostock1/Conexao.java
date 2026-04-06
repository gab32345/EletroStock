package com.mycompany.eletrostock1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConexao() {
        try {
            // ATENÇÃO: No lugar de 'suasenha', coloque a senha que você usa no MySQL Workbench
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eletrostock_db", 
                    "root", 
                    "0000" 
            );
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}