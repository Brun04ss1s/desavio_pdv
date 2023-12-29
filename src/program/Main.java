package program;

import entities.Bdfuncoes;
import entities.Produto;
import entities.Venda;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int resp = 0;
        Produto pr = new Produto();
        Scanner sc = new Scanner(System.in);
        Venda venda = new Venda();
        //Repetição criada para que o programa encerre apenas quando deserjarmos.
        try {
            do {
                System.out.println("------------------------------------------------------------");
                System.out.println("Escolha uma das opções: ");
                System.out.println("1 - Adicionar produto ");
                System.out.println("2 - Vender produto ");
                System.out.println("3 - Visualizar o último produto cadastrado ");
                System.out.println("4 - Visualizar a última venda");
                System.out.println("5 - Encerrar ");
                System.out.println("------------------------------------------------------------");
                resp = sc.nextInt();
                sc.nextLine();
                //Estrutura de decisão com base nos números apresentados no "menu principal".

                if (resp == 1) {
                    adicionar_produto(sc, pr);
                    System.out.println();
                    System.out.println("Deseja ir ao menu iniciar (y or n)?");
                    char esc = sc.next().charAt(0);
                    if (esc == 'n' || esc == 'N') {
                        break;
                    } else if (esc != 'y') {
                        while (esc != 'y') {
                            System.out.println("\nPor favor, digite uma opção válida (y or n): ");
                            esc = sc.next().charAt(0);
                        }
                    }

                } else if (resp == 2) {
                    venda.setVenda(sc);
                    System.out.println();
                    System.out.println("Deseja ir ao menu iniciar(y or n)?");
                    char esc = sc.next().charAt(0);
                    if (esc == 'n' || esc == 'N') {
                        break;
                    } else if (esc != 'y') {
                        while (esc != 'y') {
                            System.out.println("\nPor favor, digite uma opção válida (y or n): ");
                            esc = sc.next().charAt(0);
                        }
                    }
                } else if (resp == 3) {
                    System.out.println(pr.getProduto());
                    System.out.println();
                    System.out.println("Deseja ir ao menu iniciar(y or n)?");
                    char esc = sc.next().charAt(0);
                    if (esc == 'n' || esc == 'N') {
                        break;
                    } else if (esc != 'y') {
                        while (esc != 'y') {
                            System.out.println("\nPor favor, digite uma opção válida (y or n): ");
                            esc = sc.next().charAt(0);
                        }
                    }
                } else if (resp == 4) {
                    System.out.println(venda.getVenda());
                    System.out.println();
                    System.out.println("Deseja ir ao menu iniciar(y or n)?");
                    char esc = sc.next().charAt(0);
                    if (esc == 'n' || esc == 'N') {
                        break;
                    } else if (esc != 'y') {
                        while (esc != 'y') {
                            System.out.println("\nPor favor, digite uma opção válida (y or n): ");
                            esc = sc.next().charAt(0);
                        }
                    }
                }
                //Este último else evita que digitem uma opção inválida.
                else {
                    System.out.println("Digite uma das opções válidas: ");
                    resp = sc.nextInt();
                    sc.nextLine();
                }

            } while (resp != 5);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        sc.close();
    }

    //Função que será chamada quando for inserir um produto novo.
    public static void adicionar_produto(Scanner sc, Produto pr) {

        Bdfuncoes bd = new Bdfuncoes();
        String name, value, quantity;
        System.out.print("Nome do produto: ");
        name = sc.nextLine();
        System.out.print("Valor do produto: ");
        value = sc.nextLine();
        System.out.print("Quantidade em estoque: ");
        quantity = sc.nextLine();

        String[] data = new String[]{name, value, quantity};
        pr.setProduto(data);

    }

}

