
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ProdutoController controller1 = new ProdutoController();
        int opcao;

        do {
            System.out.println("-------------MENU-----------");
            System.out.println("1 - Cadastrar Produtos"); 	 	
            System.out.println("2 - Listar Produtos");	        
            System.out.println("3 - Procurar produtos por id");	
            System.out.println("4 - Procurar produtos por nome");
            System.out.println("5 - Alterar produto");          
            System.out.println("6 - Apagar produto");          
            System.out.println("0 - Sair");
            System.out.println("----------------------------");
            System.out.println("Digite sua opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    controller1.cadastrarProduto(entrada);
                    break;

                case 2:
                    controller1.listarProdutos();
                    break;

                case 3:
                    controller1.procurarProdutoPorID(entrada);
                    break;

                case 4:
                    controller1.procurarProdutoPorNome(entrada);
                    break;

                case 5:
                    controller1.alterarProduto(entrada);

                    break;

                case 6:
                    controller1.apagarProduto(entrada);
                    break;

                case 0:
                    System.out.println("Encerrando o Programa");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

        } while (opcao != 0);
        entrada.close();

    }
}
