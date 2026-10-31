# AplicacaoWebCRUD

Aplicação web para cadastro, listagem, edição e exclusão de produtos, desenvolvida com Spring Boot, Spring Data JPA, Thymeleaf e MySQL.

## Requisitos

- JDK 21 ou superior
- Maven 3.6.3 ou superior
- MySQL em execução

## Configuração do banco de dados

A aplicação usa o banco `sales`. O usuário pode ser configurado pela variável de ambiente `DB_USERNAME` (padrão: `root`) e a senha por `DB_PASSWORD` (padrão: vazia).

No PowerShell, configure a senha antes de iniciar:

```powershell
$env:DB_PASSWORD = "sua-senha"
```

O Hibernate cria ou atualiza a tabela `product` automaticamente. A aplicação conecta por padrão em `localhost:3306`; para alterar o endereço, edite `spring.datasource.url` em `src/main/resources/application.properties`.

## Executar

Na pasta do projeto, rode:

```powershell
mvn spring-boot:run
```

Acesse [http://localhost:8080/products](http://localhost:8080/products).

## Testes

```powershell
mvn test
```
