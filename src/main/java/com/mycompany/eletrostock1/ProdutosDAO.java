package com.mycompany.eletrostock1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    // 1. MÉTODO CADASTRAR (O que você já usa na TelaCadastro)
    public void cadastrar(Produtos produto) {
        String sql = "INSERT INTO produto (id, nome, preco, quantidade) VALUES (?, ?, ?, ?)";
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }

    // 2. MÉTODO LISTAR TODOS (Usado para encher a tabela ao abrir a tela)
    public List<Produtos> listarTodos() {
        String sql = "SELECT * FROM produto";
        List<Produtos> lista = new ArrayList<>();
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro al listar: " + e.getMessage());
        }
        return lista;
    }

    // 3. MÉTODO FILTRAR POR NOME (Para o botão de Pesquisar/Consultar)
    public List<Produtos> listarPorNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        List<Produtos> lista = new ArrayList<>();
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%"); // O % permite achar "Mouse" se digitar "Mous"
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar: " + e.getMessage());
        }
        return lista;
    }

    // 4. MÉTODO EXCLUIR (Para o botão Excluir da tabela)
    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        }
    }
}