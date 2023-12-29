package entities;

import java.sql.Connection;


public class Produto {

    protected String nome;
    protected Double preco;
    protected Integer quantidade;

    public Produto(String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {

    }

    //Criando conexão com o banco de dados para fazer o insert do produto no próprio.
    Bdfuncoes bd = new Bdfuncoes();
    Connection con = bd.conectar_no_bd();

    public void setProduto(String[] data) {
        nome = data[0];
        preco = Double.valueOf(data[1]);
        quantidade = Integer.valueOf(data[2]);
        bd.inserir_produto(con, nome, data[1], data[2]);
    }

    //Função para mostrar o último produto cadastrado.
    public String getProduto() {
        if (nome != null) {
            return "Produto atualmente cadastrado: " +
                    "\nNome: " + nome
                    + "\nPreço: R$ " + String.format("%.2f", preco)
                    + "\nQuantidade: " + quantidade + " unidades";
        } else {
            return "Nenhum produto cadastrado atualmente.";
        }
    }
}
