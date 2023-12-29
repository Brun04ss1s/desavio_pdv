package entities;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Venda extends Produto {
    private Integer quantidade_a_ser_vendida;
    private Double desconto;

    public Venda() {
    }

    public Venda(String nome, Double preco, Integer quantidade, Integer quantidade_a_ser_vendida, Double desconto) {
        super(nome, preco, quantidade);
        this.quantidade_a_ser_vendida = quantidade_a_ser_vendida;
        this.desconto = desconto;
    }

    public void setVenda(Scanner tc) {
        //Pedir o nome do produto a ser vendido.
        System.out.print("Informe o nome do produto: ");
        String nome_produto = tc.nextLine();
        int id_produto = 0;
        //Fazer a busca no banco de dados.
        try {
            String sql = String.format("SELECT * FROM produtos WHERE nome_produto ='%s'", nome_produto);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                id_produto = Integer.parseInt(rs.getString("id_produto"));
                nome = rs.getString("nome_produto");
                preco = Double.valueOf(rs.getString("preco_produto"));
                quantidade = Integer.valueOf(rs.getString("quantidade"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        //Se o produto existir e o estoque for maior que zero, venda aprovada e diminui o estoque, usando o UPDATE.
        try {
            if (nome != null) {
                if (quantidade > 0) {
                    System.out.print("Informe a quantidade a ser vendida: ");
                    quantidade_a_ser_vendida = tc.nextInt();
                    tc.nextLine();
                    quantidade = quantidade - quantidade_a_ser_vendida;

                    String sql = String.format("UPDATE produtos SET quantidade='%s' WHERE id_produto='%s' ", String.valueOf(quantidade), String.valueOf(id_produto));
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    System.out.println("Venda aprovada!");
                }
            } else {
                System.out.println("Produto não cadastrado.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String getVenda() {
        //Mostrar o último produto vendido já com o estoque atualizado.
        if (nome != null) {
            return "\nÚltimo produto vendido: " + nome + "\nNova quantidade em estoque deste produto: " + quantidade;
        } else {
            return "\nNenhuma venda feita atualmente.";
        }
    }
}
