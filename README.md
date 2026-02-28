# 🎵 Screen Sound Músicas

![Java](https://img.shields.io/badge/Java-25-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.11-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![Build](https://img.shields.io/badge/Maven-Build-success)
![Status](https://img.shields.io/badge/Status-Production-ready-green)

**Screen Sound** é um sistema completo de **gerenciamento e pesquisa de músicas e artistas**, desenvolvido em **Java 25** com **Spring Boot**, integrando **Spring Data JPA**, **PostgreSQL** e consumo de **API externa** para dados de artistas.  

Este projeto demonstra **profissionalismo**, arquitetura limpa, modularidade e boas práticas de desenvolvimento backend.

---

## 💡 Funcionalidades Principais

- ✅ Cadastro de artistas e músicas
- ✅ Listagem completa de músicas
- ✅ Pesquisa de músicas por artista
- ✅ Consulta de artistas via API externa (biografia, país, gênero)
- ✅ Menu interativo no console
- ✅ Persistência de dados com **JPA/Hibernate**
- ✅ Conexão com banco **PostgreSQL** usando pool **HikariCP**
- ✅ Logging estruturado com **SLF4J/Logback**

---

## 🛠 Tecnologias Utilizadas

| Camada          | Tecnologias                                     |
|-----------------|------------------------------------------------|
| Backend         | Java 25, Spring Boot 3.5.11                     |
| Persistência    | Spring Data JPA, Hibernate, PostgreSQL         |
| Conexão Banco   | HikariCP                                        |
| API/JSON        | Jackson Databind                                |
| Logging         | SLF4J, Logback                                  |
| Build           | Maven                                           |
| IDE             | IntelliJ IDEA Community Edition 2025            |

---
## 📂 Estrutura do Projeto


src/
├─ main/
│ ├─ java/
│ │ └─ br.com.ezequiel.screensound/
│ │ ├─ ScreensoundApplication.java # Classe principal
│ │ ├─ model/ # Entidades JPA
│ │ ├─ repository/ # Interfaces de repositório
│ │ ├─ service/ # Lógica de negócio
│ │  # Consumo de API externa
│ └─ resources/
│ └─ application.properties # Configurações Spring Boot
└─ test/
└─ java/ # Testes unitários futuros

---

## 🚀 Como Rodar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/ezequielmacedo9/Screen-Sound-M-sicas.git
cd Screen-Sound-M-sicas

spring.datasource.url=jdbc:postgresql://localhost:5432/screensound
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

mvn clean install
mvn spring-boot:run

Screen Sound Músicas
------------------------
1 - Cadastrar Artista
2 - Cadastrar Música
3 - Listar Músicas
4 - Buscar Músicas por Artista
5 - Pesquisar sobre o Artista
9 - Sair
------------------------
Digite sua opção:


Exemplo de uso:
Digite sua opção: 5
Digite o nome do Artista: Michael Jackson

Nome: Michael Jackson
Gênero: Pop
País: Indiana, USA
Biografia: Michael Joseph Jackson, (Gary, Indiana, Estados Unidos, 29 de Agosto de 1958 - Los Angeles, 25 de Junho de 2009), foi um grande cantor, compositor, dançarino, ator, produtor, empresário e filantropo...

Navegação totalmente interativa

Dados do artista e músicas exibidos com formatação clara

Menu retorna automaticamente após cada ação

Boas Práticas Aplicadas

Arquitetura modular (model, repository, service, dto)

Uso de Spring Data JPA para persistência

Integração com API externa usando DTOs

Tratamento de JSON com @JsonIgnoreProperties e Jackson

Pool de conexões eficiente com HikariCP

Logging estruturado com SLF4J/Logback

Código pronto para testes unitários futuro
