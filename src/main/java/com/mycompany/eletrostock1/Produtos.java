package com.mycompany.eletrostock1;

public class Produtos {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    // --- GETTERS (Para o DAO ler os dados) ---
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    // --- SETTERS (Para a Tela colocar os dados) ---
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}