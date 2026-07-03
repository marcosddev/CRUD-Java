
import java.util.InputMismatchException;
import java.util.Scanner;
//SEMPRE VAI PEGAR AS INFORMAÇÕES DO USUARIO AQUI

public class ProdutoController {

    ProdutoRepository repositorio = new ProdutoRepository();

    void cadastrarProduto(Scanner entrada) {
        try {
            Produto produto1 = new Produto();

            System.out.print("Digite o id do Produto: ");
            produto1.id = entrada.nextInt();
            /* SEMPRE QUE VOCÊ PEDIR PRO USUÁRIO UM NUMERO
                SEJA ELE INT OU DOUBLE, PRECISA LIMPAR A ENTRADA
                PARA RECONHECER AS STRINGS.
             */
            entrada.nextLine();

            System.out.print("Digite o nome do Produto: ");
            produto1.nome = entrada.nextLine();

            System.out.print("Digite o preço do Produto: ");
            produto1.preco = entrada.nextDouble();

            System.out.print("Digite a quantidade do Produto: ");
            produto1.quantidade = entrada.nextInt();

            repositorio.salvar(produto1);
        } catch (InputMismatchException erro) {
            System.out.println("ERRO: VALOR INVÁLIDO");
            System.out.println("ERRO: ID e quantidade precisam ser números inteiros");
            System.out.println("ERRO: Preço precisa ser um valor. Ex. 10,59");
            entrada.nextLine();
        }

    }

    void listarProdutos() {
        repositorio.listarProdutos();
    }

    void procurarProdutoPorID(Scanner entrada) {
        try {
            System.out.println("Digite o ID do produto: ");
            int id = entrada.nextInt();

            Produto produto1 = repositorio.buscarPorID(id);

            if (produto1 == null) {
                System.out.println("Produto não encontrado");
                System.out.println("-----------------------");
            } else {
                System.out.println("Produto encontrado");
                produto1.listar();
            }

        } catch (InputMismatchException erro) {
            System.out.println("ERRO: ID inválido. Digite um número inteiro");
            entrada.nextLine();
        }

    }

    void procurarProdutoPorNome(Scanner entrada) {
        entrada.nextLine();

        System.out.println("Digite o nome ou parte do nome do produto: ");
        String nome = entrada.nextLine();

        Produto produto1 = repositorio.buscarPorNome(nome);

        if (produto1 == null) {
            System.out.println("Produto não encontrado");
            System.out.println("-----------------------");
        } else {
            System.out.println("Produto encontrado");
            produto1.listar();
        }
    }

    void alterarProduto(Scanner entrada) {
        try {
            System.out.println("Digite o ID do produto que deseja alterar");
            int id = entrada.nextInt();
            Produto produto1 = repositorio.buscarPorID(id);

            if (produto1 == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            System.out.println("Produto Encontrado: ");
            produto1.listar();
            menuAlterarProduto(entrada, id);

        } catch (InputMismatchException erro) {
            System.out.println("ERRO: ID inválido. Digite um número inteiro");
            entrada.nextLine();
        }
    }

    void menuAlterarProduto(Scanner entrada, int id) {
        int opcaoAlteracao;

        do {
            System.out.println("----ALTERAR PRODUTO-----");
            System.out.println("1. ALTERAR NOME");
            System.out.println("2. ALTERAR PREÇO");
            System.out.println("3. ALTERAR QUANTIDADE");
            System.out.println("4. ALTERAR TUDO");
            System.out.println("0. CANCELAR ALTERAÇÃO");
            System.out.println("-----------------------");
            System.out.println("Digite a opção desejada: ");
            opcaoAlteracao = entrada.nextInt();

            switch (opcaoAlteracao) {
                case 1:
                    alterarNome(entrada, id);
                    break;

                case 2:
                    alterarPreco(entrada, id);
                    break;

                case 3:
                    alterarQtde(entrada, id);
                    break;

                case 4:
                    alterarTudo(entrada, id);
                    break;

                case 0:
                    System.out.println("Alteração Cancelada");
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }

            if (opcaoAlteracao != 0) {
                Produto produtoAtualizado = repositorio.buscarPorID(id);
                if (produtoAtualizado != null) {
                    System.out.println("Produto atualizado");
                    produtoAtualizado.listar();
                }
            }
        } while (opcaoAlteracao != 0);
    }

    void alterarNome(Scanner entrada, int id) {
        entrada.nextLine();
        System.out.println("Digite o novo nome: ");
        String novoNome = entrada.nextLine();

        boolean alterou = repositorio.alterarNome(id, novoNome);

        if (alterou == true) {
            System.out.println("Nome do produto alterado com sucesso");
        } else {
            System.out.println("Erro ao alterar o nome");
        }
    }

    void alterarPreco(Scanner entrada, int id) {
        System.out.println("Digite o novo preço: ");
        double novoPreco = entrada.nextDouble();

        boolean alterou = repositorio.alterarPreco(id, novoPreco);

        if (alterou == true) {
            System.out.println("Preço do produto alterado com sucesso");
        } else {
            System.out.println("Erro ao alterar o preço");
        }

    }

    void alterarQtde(Scanner entrada, int id) {
        System.out.println("Digite a nova quantidade: ");
        int novaQtde = entrada.nextInt();

        boolean alterou = repositorio.alterarPreco(id, novaQtde);

        if (alterou == true) {
            System.out.println("Preço do produto alterado com sucesso");
        } else {
            System.out.println("Erro ao alterar o preço");
        }

    }

    void alterarTudo(Scanner entrada, int id) {
        System.out.println("Digite o novo nome: ");
        String novoNome = entrada.nextLine();
        entrada.nextLine();

        System.out.println("Digite o novo preço: ");
        double novoPreco = entrada.nextDouble();

        System.out.println("Digite a nova quantidade: ");
        int novaQtde = entrada.nextInt();

        boolean alterou = repositorio.alterarTudo(id, novoNome, novoPreco, novaQtde);

        if (alterou == true) {
            System.out.println("Produto alterado com sucesso");
        } else {
            System.out.println("Erro ao alterar o produto");
        }

    }

    void apagarProduto(Scanner entrada) {
            System.out.println("Digite o ID do produto que deseja apagar");
            int id = entrada.nextInt();
            Produto produto1 = repositorio.buscarPorID(id);

            if (produto1 == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            System.out.println("Produto Encontrado: ");
            produto1.listar();

            System.out.println("Deseja realmente apagar este produto? (S/N)");
            String confirmacao = entrada.next();

            if (confirmacao.equalsIgnoreCase("S")) {
                boolean apagou = repositorio.apagarProduto(id);
                if (apagou) {
                    System.out.println("Produto apagado com sucesso.");
                } else {
                    System.out.println("Erro ao apagar o produto.");
                }
            } else {
                System.out.println("Operação de exclusão cancelada.");
            }

        }
            
}
