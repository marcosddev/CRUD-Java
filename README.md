<h1 align="center">Sistema CRUD em Java 📦</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
</p>

Projeto implementando o padrão **CRUD** (Create, Read, Update, Delete) em Java Puro para gestão de Produtos.

## 📋 Sobre o Projeto

O projeto demonstra a separação de responsabilidades utilizando um padrão de arquitetura simples:
- **Model:** Representação da entidade (`Produto`).
- **Repository:** Classe responsável pelo armazenamento em memória ou persistência (`ProdutoRepository`).
- **Controller:** Lógica de negócio e intermediação entre o usuário e o repositório (`ProdutoController`).

## 🗂️ Estrutura do Projeto

* `src/`: Códigos fonte em Java (`Main`, `Produto`, controllers, etc).
* `CONTROLLER.txt` / `REPOSITORIO.txt`: Documentação ou logs do sistema.

## 🚀 Como Executar

Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.

1. Clone o repositório:
   ```bash
   git clone https://github.com/marcosddev/CRUD-Java.git
   ```
2. Navegue até a pasta do projeto e depois para a pasta src:
   ```bash
   cd CRUD/src
   ```
3. Compile os arquivos Java:
   ```bash
   javac *.java
   ```
4. Execute a classe principal:
   ```bash
   java Main
   ```

---
Feito com ☕ por [Marcos Davi](https://github.com/marcosddev).
