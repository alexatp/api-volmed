# 🏥 Voll.med API

Uma API REST desenvolvida em **Spring Boot** para o gerenciamento de uma clínica médica, permitindo o cadastro, listagem, atualização e exclusão de médicos e pacientes, além de sistema de autenticação e autorização.

## 📋 Sobre o Projeto

O Voll.med é uma aplicação backend que simula o sistema de gestão de uma clínica médica. A API oferece funcionalidades completas para:

- **Gestão de Médicos**: Cadastro, listagem, atualização e exclusão lógica
- **Gestão de Pacientes**: Operações CRUD completas
- **Autenticação**: Sistema de login com JWT
- **Validações**: Validação de dados de entrada
- **Paginação**: Listagens paginadas para melhor performance

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0.0-M5**
- **Spring Data JPA**
- **Spring Security**
- **Spring Validation**
- **MySQL**
- **Flyway** (Migrações de banco)
- **JWT** (Java JWT 4.2.1)
- **Lombok**
- **Maven**

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── med/voll/api/
│   │       ├── controller/          # Controladores REST
│   │       ├── domain/              # Domínio da aplicação
│   │       │   ├── endereco/        # Entidades de endereço
│   │       │   ├── medico/          # Entidades e regras de médicos
│   │       │   ├── paciente/        # Entidades e regras de pacientes
│   │       │   └── usuario/         # Entidades e serviços de usuário
│   │       └── infra/               # Infraestrutura
│   │           ├── exception/       # Tratamento de exceções
│   │           └── security/        # Configurações de segurança
│   └── resources/
│       ├── application.properties   # Configurações da aplicação
│       └── db/migration/           # Scripts de migração Flyway
└── test/                           # Testes automatizados
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- MySQL 8.0 ou superior

### Configuração do Banco de Dados

1. Crie um banco de dados MySQL chamado `vollmed_api`:
```sql
CREATE DATABASE vollmed_api;
```

2. Configure as credenciais no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost/vollmed_api
spring.datasource.username=root
spring.datasource.password=123456
```

### Executando a Aplicação

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd api
```

2. Execute a aplicação:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📚 Endpoints da API

### Autenticação
- `POST /login` - Realiza login e retorna token JWT

### Médicos
- `GET /medicos` - Lista médicos (paginado)
- `POST /medicos` - Cadastra novo médico
- `PUT /medicos` - Atualiza dados do médico
- `DELETE /medicos/{id}` - Exclusão lógica do médico
- `GET /medicos/{id}` - Busca médico por ID

### Pacientes
- `GET /pacientes` - Lista pacientes (paginado)
- `POST /pacientes` - Cadastra novo paciente
- `PUT /pacientes` - Atualiza dados do paciente
- `DELETE /pacientes/{id}` - Exclusão lógica do paciente
- `GET /pacientes/{id}` - Busca paciente por ID

## 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)** para autenticação. Para acessar os endpoints protegidos:

1. Faça login no endpoint `/login` com credenciais válidas
2. Inclua o token retornado no header `Authorization: Bearer <token>`

### Configuração do JWT

Configure a chave secreta através da variável de ambiente:
```bash
JWT_SECRET=sua_chave_secreta_aqui
```

## 💾 Banco de Dados

O projeto utiliza **Flyway** para versionamento do banco de dados. As migrações estão localizadas em `src/main/resources/db/migration/`:

- `V1` - Criação da tabela de médicos
- `V2` - Adição do campo telefone na tabela médicos
- `V3` - Criação da tabela de pacientes
- `V4` - Adição do campo ativo na tabela médicos
- `V5` - Criação da tabela de usuários

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

## 📝 Validações

A API implementa validações robustas usando **Bean Validation**:

- Campos obrigatórios
- Formato de email válido
- CRM válido para médicos
- CPF válido para pacientes
- Telefone e CEP no formato correto

## 🔧 Configurações

### Profiles de Ambiente

Configure diferentes ambientes através dos profiles do Spring:

```properties
# Desenvolvimento
spring.profiles.active=dev

# Produção
spring.profiles.active=prod
```

### Logs

Os logs SQL estão habilitados para desenvolvimento:
```properties
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 📄 Licença

Este projeto foi desenvolvido como parte do curso da **Alura** e é destinado para fins educacionais.

## 👥 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📞 Contato

Para dúvidas ou sugestões, entre em contato através do GitHub.

---

⭐ **Desenvolvido durante o curso de Spring Boot da Alura**
