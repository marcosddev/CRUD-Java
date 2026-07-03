<h1 align="center">Sistema CRUD em Java </h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
</p>

# Sistema de Gestão e Persistência (CRUD) em Java
Este repositório contém a implementação de um sistema robusto de gerenciamento de dados focado na entidade de Produtos, utilizando exclusivamente a linguagem Java sem a dependência de frameworks externos. O software implementa as operações completas de CRUD (Create, Read, Update e Delete), servindo como uma demonstração prática da construção de camadas e separação de lógica de negócios.
O sistema foi arquitetado de modo a separar claramente o acesso aos dados do fluxo de controle, facilitando a escalabilidade, manutenção contínua e a aplicação de testes unitários.
## Funcionalidades do Sistema
* **Criação (Create):** Instanciação, validação de regras e inserção de novos produtos na base de dados (memória/arquivo).
* **Leitura (Read):** Recuperação total (lista completa) ou recuperação direcionada (por identificador único) dos produtos armazenados.
* **Atualização (Update):** Interface para localizar e modificar os atributos de um produto existente de forma segura.
* **Exclusão (Delete):** Remoção controlada e assertiva de registros do repositório.

# Abordagem Técnica
* Separação de Preocupações (SoC): A lógica está compartimentada. A entidade apenas armazena seu estado, o repositório efetua ações de I/O, e o controlador lida com as validações de input.
* Coesão: Ausência de acoplamento excessivo; a manutenção de um fluxo não impacta gravemente os demais.
* Linguagem Base: Java (JDK) puro, evidenciando domínio das estruturas base da linguagem antes da inserção de frameworks maiores como Spring Boot.

## Estrutura e Arquitetura do Projeto
O código-fonte aplica uma estrutura fortemente inspirada no padrão de arquitetura de software em camadas, adotando de forma simplificada o uso de Controllers e Repositories. Essa escolha garante que as classes possuam alta coesão e mantenham a responsabilidade única (Single Responsibility Principle do SOLID).
```text
CRUD/
│
├── src/
│   ├── Main.java               # Classe de inicialização (Entry Point) responsável por gerir o menu e fluxo de interação
│   ├── Produto.java            # Entidade de Domínio (Model) contendo os atributos primários e regras de estado
│   ├── ProdutoController.java  # Controlador que valida as entradas do usuário e executa o intermédio lógico
│   └── ProdutoRepository.java  # Camada de persistência, que lida unicamente com as operações de gravação e consulta de dados
│
├── CONTROLLER.txt              # Arquivo de documentação/auditoria das ações do controlador do sistema
├── REPOSITORIO.txt             # Arquivo de documentação/auditoria das persistências no repositório de dados
├── .gitignore                  # Configuração para isolar o repositório de binários do compilador (.class) e arquivos de IDE
└── README.md                   # Documentação principal e instruções do projeto
