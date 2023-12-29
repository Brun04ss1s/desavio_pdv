package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Bdfuncoes {
    public Bdfuncoes() {
    }
    //Criando conexão com o banco de dados.
    public Connection conectar_no_bd() {
        String nome_banco = "desafio_tecnico";
        String usuario = "postgres";
        String senha = "12345678";
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nome_banco, usuario, senha);

            //Teste para saber se está conectando com o banco de dados
       /*     if (con != null) {
                System.out.println("Conectado!");
            } else {
                System.out.println("Não conectou!");
            }*/
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

    //Função que será chamado no setProduto.
    public void inserir_produto(Connection con, String nome, String valor, String quantidade){
        try {
            String sql = String.format("INSERT INTO Produtos (nome_produto, preco_produto, quantidade) values ('%s','%s','%s')", nome, valor, quantidade);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
