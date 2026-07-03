
public class ProdutoRepository {

    Produto[] produtos = new Produto[10];

    int totalProdutos = 0;
    //produtos[0] = produto1

    void salvar(Produto produto1) {
        produtos[totalProdutos] = produto1;
        totalProdutos++;
        System.out.println("Produto cadastrado com sucesso");
    }

    void listarProdutos() {
        if (totalProdutos == 0) {
            System.out.println("Sem produtos cadastrados");
        } else {           
            for (int i = 0; i < totalProdutos; i++) {
                produtos[i].listar();

            }

        }
    }

    Produto buscarPorID(int id) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].id == id) {
                return produtos[i];
            }
        }
        return null;
    }

    Produto buscarPorNome(String nomeBuscado) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].nome.toLowerCase().contains(nomeBuscado.toLowerCase())) {
                return produtos[i];
            }
        }
        return null;
    }

    Boolean alterarNome(int id, String novoNome) {
        Produto produto1 = buscarPorID(id);

        if (produto1 == null) {
            return false;
        }

        produto1.nome = novoNome;
        return true;
    }

    Boolean alterarPreco(int id, double novoPreco) {
        Produto produto1 = buscarPorID(id);

        if (produto1 == null) {
            return false;
        }

        produto1.preco = novoPreco;
        return true;
    }

    Boolean alterarQtde(int id, int novaQtde) {
        Produto produto1 = buscarPorID(id);

        if (produto1 == null) {
            return false;
        }

        produto1.quantidade = novaQtde;
        return true;
    }

    Boolean alterarTudo(int id, String novoNome, double novoPreco, int novaQtde) {
        Produto produto1 = buscarPorID(id);

        if (produto1 == null) {
            return false;
        }

        produto1.nome = novoNome;
        produto1.preco = novoPreco;
        produto1.quantidade = novaQtde;

        return true;
    }

    Boolean apagarProduto(int id) {
        Produto produto1 = buscarPorID(id);

        if (produto1 == null) {
            return false;
        }

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].id == id) {
                for (int j = i; j < totalProdutos - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }
                produtos[totalProdutos - 1] = null;
                totalProdutos--;
                return true;
            }
        }
        return false;
    }
}
