# BancoX Security JWT

Este projeto implementa autenticação e autorização com JWT em um ambiente Spring Boot, utilizando PostgreSQL como banco de dados.

## 🚀 Tecnologias Utilizadas
- **Spring Boot** (Spring Security, Spring Data JPA)
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **Lombok**

## 📌 Funcionalidades
- Registro de usuários com roles e departamentos
- Autenticação via JWT
- Controle de acesso baseado em roles (usuários e administradores)
- Proteção de endpoints com Spring Security

## 📂 Estrutura do Projeto

```
├── src/main/java/br/com/bancox_security_jwt
│   ├── controllers      # Controladores REST
│   ├── dtos             # DTOs para requisições e respostas
│   ├── infra            # Configurações de segurança (JWT, Spring Security)
│   ├── models           # Entidades JPA
│   ├── repository       # Interfaces de repositório (Spring Data JPA)
│   ├── services         # Regras de negócio e serviços
│   ├── BancoXSecurityJwtApplication.java  # Classe principal
└── ...
```

## 🔧 Configuração e Execução
### 1️⃣ Configurar Variáveis de Ambiente
Crie um arquivo `.env` com:
```
JWT_SECRET=minhaChaveSecreta
JWT_EXPIRATION=300000
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bancox
SPRING_DATASOURCE_USERNAME=seu_usuario
SPRING_DATASOURCE_PASSWORD=sua_senha
```

### 2️⃣ Rodar a Aplicação
```bash
mvn spring-boot:run
```

## 🔑 Endpoints Principais

### 🔹 Autenticação
- **POST `/api/auth/login`** → Login e geração de token JWT
- **POST `/api/auth/signup`** → Cadastro de novo usuário

### 🔹 Usuários
- **GET `/api/user`** → Obtém informações do usuário autenticado

### 🔹 Admin
- **GET `/api/admin`** → Endpoint protegido para admins apenas

## 🤝 Contribuição
Fique à vontade para abrir PRs e sugerir melhorias! Qualquer dúvida, entre em contato. 🚀

