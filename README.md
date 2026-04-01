# ERP Migration - Delphi/Firebird → Java REST + MySQL + Front-End Moderno

Este projeto tem como objetivo migrar um sistema legado desenvolvido em **Delphi/Firebird** para uma nova arquitetura em **Java**, utilizando **REST API** e **MySQL** como banco de dados, além de modernizar o front-end com HTML, CSS e JavaScript.

## 🚀 Objetivos
- 🔄 Migrar do Firebird para MySQL
- ☕ Reescrever em Java (Spring Boot + REST API)
- 🐬 Banco de dados MySQL
- 📥 Importar dados via CSV
- 🗂️ Organizar entidades JPA
- 🎨 Modernizar o front-end com HTML/CSS/JS

## 🔗 Arquitetura do Sistema

                 🎨 Front-End
        ┌───────────────────────────┐
        │  HTML / CSS / JS          │
        │  index.html + páginas     │
        └─────────────▲─────────────┘
                      │
                      │ HTTP (REST)
                      │
             🌱 Java / Spring Boot
        ┌───────────────────────────┐
        │  Controllers (REST)       │
        │  Services (Regras)        │
        │  Repositories (JPA)       │
        │  Entities (Cliente, etc.) │
        └─────────────▲─────────────┘
                      │
                      │ JDBC / JPA
                      │
                 🐬 Banco de Dados
        ┌───────────────────────────┐
        │  MySQL                    │
        │  Tabelas migradas         │
        │  (Cliente, Fornecedor,    │
        │   Contas_Pagar, etc.)     │
        └───────────────────────────┘

## 📂 Estrutura
- 📦 `src/main/java/br/com/mpb/erp/entity` → entidades JPA (Cliente, Fornecedor, ContasPagar, etc.)
- 🛠️ `src/main/java/br/com/mpb/erp/util` → utilitários de importação CSV
- 📂 `src/main/java/br/com/mpb/erp/controller` → controladores REST
- 📂 `src/main/java/br/com/mpb/erp/service` → serviços de negócio
- 📂 `src/main/java/br/com/mpb/erp/repository` → repositórios JPA
- 🌐 `front/` → interface moderna
    - 📜 `index.html`
    - 📂 `html/` → páginas adicionais
    - 🎨 `css/` → estilos
    - ⚙️ `js/` → scripts

## 🛠️ Tecnologias
- ☕ Java 17+
- 🌱 Spring Boot
- 🐬 MySQL
- 📊 JPA/Hibernate
- 📥 OpenCSV
- 🎨 HTML, CSS, JS

## 📌 Status
⚙️ Em desenvolvimento: migração gradual das tabelas e funcionalidades do sistema legado, com evolução paralela do front-end.