# 🏥 Voll.med - API Médica Completa

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.0-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-4.2.1-black)](https://github.com/auth0/java-jwt)

Uma **API REST robusta** desenvolvida em Spring Boot para o gerenciamento completo de clínicas médicas, com sistema de agendamento inteligente, autenticação JWT e arquitetura DDD (Domain-Driven Design).

## 🎯 Sobre o Projeto

**Voll.med** é uma aplicação backend moderna que implementa um sistema completo de gestão médica, desenvolvida seguindo as melhores práticas de desenvolvimento Java e arquitetura limpa.

### ⭐ **Funcionalidades Principais**

| Módulo | Descrição | Status |
|--------|-----------|---------|
| 👨‍⚕️ **Médicos** | CRUD completo + especialidades | ✅ Completo |
| 👥 **Pacientes** | Gestão completa de pacientes | ✅ Completo |
| 📅 **Consultas** | Agendamento inteligente | ✅ Completo |
| 🔐 **Autenticação** | JWT + Spring Security | ✅ Completo |
| 📍 **Endereços** | Gestão de endereços completos | ✅ Completo |
| ✅ **Validações** | Bean Validation personalizada | ✅ Completo |

### 🏆 **Especialidades Médicas Suportadas**
- 🦴 **Ortopedia** - Especialista em ossos e articulações
- ❤️ **Cardiologia** - Especialista em coração  
- 👩‍⚕️ **Ginecologia** - Especialista em saúde feminina
- 🌟 **Dermatologia** - Especialista em pele

## 🛠️ Stack Tecnológica

### **🔧 Backend Core**
```
☕ Java 17                    → Linguagem base
🍃 Spring Boot 3.0.0-M5      → Framework principal  
📊 Spring Data JPA           → Persistência ORM
🔒 Spring Security           → Segurança
✅ Spring Validation         → Validação de dados
🚀 Spring DevTools           → Hot reload
```

### **💾 Persistência**
```
🗄️ MySQL 8.0+                → Banco principal
🚀 Flyway                    → Migrations
🏗️ Hibernate                 → ORM
```

### **🔐 Segurança & Auth**
```
🎫 JWT (Java-JWT 4.2.1)      → Tokens
🔐 BCrypt                    → Hash senhas
🛡️ Spring Security           → Autorização
```

### **🛠️ Ferramentas**
```
📦 Maven                     → Build tool
🏷️ Lombok                   → Boilerplate reduction
📋 Bean Validation           → Validações
```

## 🏗️ Arquitetura DDD

```
📁 med.voll.api/
├── 🎮 controller/           ← Camada de Apresentação (REST)
│   ├── AutenticacaoController
│   ├── ConsultaController
│   ├── MedicoController  
│   ├── PacienteController
│   └── HelloController
├── 🧠 domain/              ← Camada de Domínio (Business Logic)
│   ├── 📅 Consulta/
│   │   ├── AgendaDeConsultas.java      ← Service
│   │   ├── Consulta.java               ← Entity
│   │   ├── ConsultaRepository.java     ← Repository
│   │   ├── DadosAgendamentoConsulta    ← DTO
│   │   └── DadosDetalhamentoConsulta   ← DTO
│   ├── 👨‍⚕️ medico/
│   │   ├── Medico.java                 ← Entity
│   │   ├── Especialidade.java          ← Enum
│   │   ├── MedicoRepository.java       ← Repository
│   │   └── Dados*.java                 ← DTOs
│   ├── 👥 paciente/         ← Módulo Pacientes
│   ├── 📍 endereco/         ← Value Object
│   ├── 👤 usuario/          ← Autenticação
│   └── ⚠️ ValidacaoException ← Domain Exception
├── 🔧 infra/               ← Infraestrutura
│   ├── exception/          ← Global Exception Handler
│   └── security/           ← JWT + Security Config
│       ├── SecurityConfigurations
│       ├── SecurityFilter
│       ├── TokenService
│       └── DadosTokenJWT
└── 📊 resources/
    ├── application.properties
    └── db/migration/       ← Flyway Scripts
```

## 🚀 Guia de Instalação

### 📋 **Pré-requisitos**
| Ferramenta | Versão | Obrigatório |
|------------|--------|-------------|
| ☕ **Java JDK** | 17+ | ✅ Sim |
| 📦 **Maven** | 3.6+ | ✅ Sim |
| 🗄️ **MySQL** | 8.0+ | ✅ Sim |
| 🔧 **IDE** | VS Code/IntelliJ | ⚡ Recomendado |

### ⚙️ **Configuração Passo a Passo**

#### 1️⃣ **Clone o Repositório**
```bash
git clone https://github.com/alexatp/api-volmed.git
cd api-volmed
```

#### 2️⃣ **Configure o Banco MySQL**
```sql
-- Conecte no MySQL como root
mysql -u root -p

-- Crie o banco e usuário
CREATE DATABASE vollmed_api CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'vollmed_user'@'localhost' IDENTIFIED BY 'VollMed123!';
GRANT ALL PRIVILEGES ON vollmed_api.* TO 'vollmed_user'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

#### 3️⃣ **Configure as Variáveis de Ambiente**
```bash
# Windows (PowerShell)
$env:JWT_SECRET = "vollmed-api-jwt-secret-key-2024-super-secure"
$env:DB_PASSWORD = "VollMed123!"

# Linux/Mac (Terminal)
export JWT_SECRET="vollmed-api-jwt-secret-key-2024-super-secure"
export DB_PASSWORD="VollMed123!"
```

#### 4️⃣ **Execute a Aplicação**
```bash
# Compilar e executar
./mvnw clean install
./mvnw spring-boot:run

# Ou com Maven global
mvn clean install
mvn spring-boot:run
```

🎉 **Aplicação rodando em:** http://localhost:8080

### 🐳 **Docker (Alternativa)**
```yaml
# docker-compose.yml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root123
      MYSQL_DATABASE: vollmed_api
      MYSQL_USER: vollmed_user
      MYSQL_PASSWORD: VollMed123!
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

  api:
    build: .
    ports:
      - "8080:8080"
    environment:
      DB_HOST: mysql
      JWT_SECRET: vollmed-api-jwt-secret-key-2024-super-secure
    depends_on:
      - mysql

volumes:
  mysql_data:
```

```bash
docker-compose up -d
```

## 📚 Documentação da API

### 🔐 **Autenticação**

#### **Login**
```http
POST /login
Content-Type: application/json

{
  "login": "admin@vollmed.com.br",
  "senha": "123456"
}

# Response
{
  "tokenJWT": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

#### **Headers para Requests Autenticados**
```http
Authorization: Bearer {seu-jwt-token}
Content-Type: application/json
```

### 👨‍⚕️ **Endpoints - Médicos**

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| `GET` | `/medicos` | Lista médicos paginados | ✅ |
| `POST` | `/medicos` | Cadastra novo médico | ✅ |
| `PUT` | `/medicos` | Atualiza dados médico | ✅ |
| `DELETE` | `/medicos/{id}` | Inativa médico | ✅ |
| `GET` | `/medicos/{id}` | Busca médico por ID | ✅ |

#### **Cadastrar Médico**
```http
POST /medicos
Authorization: Bearer {token}

{
  "nome": "Dr. João Silva",
  "email": "joao.silva@vollmed.com.br",
  "telefone": "11999887766",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua das Palmeiras, 123",
    "bairro": "Centro",
    "cep": "12345-678",
    "cidade": "São Paulo",
    "uf": "SP",
    "numero": "123",
    "complemento": "Sala 201"
  }
}
```

### 👥 **Endpoints - Pacientes**

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| `GET` | `/pacientes` | Lista pacientes paginados | ✅ |
| `POST` | `/pacientes` | Cadastra novo paciente | ✅ |
| `PUT` | `/pacientes` | Atualiza dados paciente | ✅ |
| `DELETE` | `/pacientes/{id}` | Inativa paciente | ✅ |
| `GET` | `/pacientes/{id}` | Busca paciente por ID | ✅ |

#### **Cadastrar Paciente**
```http
POST /pacientes
Authorization: Bearer {token}

{
  "nome": "Maria Santos",
  "email": "maria.santos@email.com",
  "telefone": "11888776655",
  "cpf": "123.456.789-00",
  "endereco": {
    "logradouro": "Av. Brasil, 500",
    "bairro": "Jardins",
    "cep": "01234-567",
    "cidade": "São Paulo", 
    "uf": "SP",
    "numero": "500"
  }
}
```

### 📅 **Endpoints - Consultas**

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| `POST` | `/consultas` | Agenda nova consulta | ✅ |

#### **Agendar Consulta**
```http
POST /consultas
Authorization: Bearer {token}

# Com médico específico
{
  "idPaciente": 1,
  "idMedico": 2,
  "data": "2024-12-15T14:30:00"
}

# Seleção automática por especialidade
{
  "idPaciente": 1,
  "especialidade": "CARDIOLOGIA", 
  "data": "2024-12-15T14:30:00"
}
```

## 🔍 **Funcionalidades Avançadas**

### 🤖 **Seleção Automática de Médicos**
O sistema implementa um **algoritmo inteligente** que:

```java
// Lógica de seleção automática
@Query("""
    select m from Medico m
    where m.ativo = true
    and m.especialidade = :especialidade  
    and m.id not in(
        select c.medico.id from Consulta c
        where c.data = :data
    )
    order by rand()
    limit 1
""")
```

**Critérios:**
- ✅ Médico ativo
- ✅ Especialidade correspondente
- ✅ Disponível na data/hora
- 🎲 Seleção aleatória entre disponíveis

### ✅ **Sistema de Validações**

| Campo | Validação | Exemplo |
|-------|-----------|---------|
| **CPF** | Formato + dígitos verificadores | `123.456.789-00` |
| **CRM** | Formato por estado | `123456-SP` |
| **Email** | RFC 5322 compliant | `medico@vollmed.com.br` |
| **Telefone** | Formato brasileiro | `(11) 99999-9999` |
| **CEP** | Formato brasileiro | `12345-678` |
| **Data Consulta** | Future only | `2024-12-15T14:30:00` |

### 🔒 **Segurança JWT**

```java
// Token contém:
{
  "sub": "admin@vollmed.com.br",    // Subject (usuário)
  "iss": "API Voll.med",            // Issuer
  "exp": 1703025600,                // Expiration (2h)
  "iat": 1703018400                 // Issued at
}
```

**Configurações:**
- ⏰ **Expiração**: 2 horas
- 🔐 **Algoritmo**: HMAC SHA256
- 🎫 **Header**: `Authorization: Bearer {token}`

## 💾 **Banco de Dados**

### 📊 **Modelo Relacional**
```sql
-- Principais entidades
medicos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  crm VARCHAR(6) NOT NULL,
  especialidade ENUM('ORTOPEDIA','CARDIOLOGIA','GINECOLOGIA','DERMATOLOGIA'),
  ativo BOOLEAN DEFAULT TRUE,
  -- Endereço embedded
  logradouro VARCHAR(100),
  bairro VARCHAR(100),
  cep VARCHAR(9),
  numero VARCHAR(20),
  complemento VARCHAR(100),
  cidade VARCHAR(100),
  uf CHAR(2)
);

pacientes (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL, 
  cpf VARCHAR(14) UNIQUE NOT NULL,
  telefone VARCHAR(20),
  ativo BOOLEAN DEFAULT TRUE,
  -- Endereço embedded --
);

consultas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  medico_id BIGINT NOT NULL,
  paciente_id BIGINT NOT NULL,
  data DATETIME NOT NULL,
  FOREIGN KEY (medico_id) REFERENCES medicos(id),
  FOREIGN KEY (paciente_id) REFERENCES pacientes(id)
);

usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(100) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL  -- BCrypt hash
);
```

### 🚀 **Migrações Flyway**
| Versão | Descrição | Arquivo |
|--------|-----------|---------|
| V1 | Tabela médicos base | `V1__create-table-medicos.sql` |
| V2 | Campo telefone médicos | `V2__alter-table-medicos-add-column-telefone.sql` |
| V3 | Tabela pacientes | `V3__create-table-pacientes.sql` |
| V4 | Soft delete médicos | `V4__alter-table-medicos-add-column-ativo.sql` |
| V5 | Sistema autenticação | `V5__create-table-usuarios.sql` |
| V6 | Sistema consultas | `V6__create-table-consultas.sql` |

## 🧪 **Testes**

```bash
# Executar todos os testes
./mvnw test

# Testes com relatório de cobertura
./mvnw test jacoco:report

# Testes de integração
./mvnw verify

# Executar teste específico
./mvnw test -Dtest=MedicoControllerTest
```

### 🎯 **Cobertura de Testes**
- ✅ **Controllers**: Testes de integração REST
- ✅ **Services**: Lógica de negócio
- ✅ **Repositories**: Queries customizadas  
- ✅ **Security**: Autenticação JWT

## 🔧 **Configurações**

### 🌍 **Profiles**
```properties
# application-dev.properties
spring.profiles.active=dev
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.springframework.security=DEBUG

# application-prod.properties  
spring.profiles.active=prod
spring.jpa.show-sql=false
server.error.include-stacktrace=never
logging.level.root=WARN
```

### 📊 **Monitoramento (Actuator)**
```properties
# Endpoints disponíveis
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=when-authorized
```

**URLs de Monitoramento:**
- 🔍 `/actuator/health` - Status da aplicação
- 📈 `/actuator/metrics` - Métricas de performance  
- ℹ️ `/actuator/info` - Informações da build

## 🚧 **Roadmap - Próximas Features**

- [ ] 📧 **Notificações por Email** - Confirmação de consultas
- [ ] 📱 **API WhatsApp** - Lembretes automáticos  
- [ ] 📄 **Relatórios PDF** - Prontuários e relatórios
- [ ] 📊 **Dashboard Admin** - Métricas e analytics
- [ ] 🔄 **Consultas Recorrentes** - Agendamentos periódicos
- [ ] 📋 **Histórico Médico** - Prontuário completo
- [ ] 🔍 **API de Busca Avançada** - Elasticsearch
- [ ] 🐳 **Kubernetes Deploy** - Orquestração containers

## 🤝 **Contribuição**

### **Como Contribuir**

1. **🍴 Fork** o projeto
2. **📥 Clone** seu fork:
   ```bash
   git clone https://github.com/seu-usuario/api-volmed.git
   ```
3. **🌿 Crie** uma branch:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
4. **💻 Implemente** sua funcionalidade
5. **✅ Teste** suas mudanças:
   ```bash
   ./mvnw test
   ```
6. **📝 Commit** seguindo padrões:
   ```bash
   git commit -m "feat: adiciona endpoint de cancelamento de consultas"
   ```
7. **🚀 Push** para sua branch:
   ```bash
   git push origin feature/nova-funcionalidade  
   ```
8. **📬 Abra** um Pull Request

### **📝 Padrão de Commits**
```
feat: nova funcionalidade
fix: correção de bug  
docs: atualização documentação
style: formatação código
refactor: refatoração
test: adição/correção testes
chore: tarefas de build/config
```

### **🎯 Guidelines**
- ✅ Seguir convenções Java/Spring
- ✅ Cobertura de testes > 80%
- ✅ Documentação atualizada
- ✅ Code review obrigatório

## 📄 **Licença**

Este projeto está sob a licença **MIT**. Desenvolvido como projeto educacional durante os cursos da [**Alura**](https://www.alura.com.br/).

```
MIT License

Copyright (c) 2024 Alex Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...
```

## 📞 **Suporte & Contato**

<div align="center">

### 🔗 **Links Úteis**
[![Portfolio](https://img.shields.io/badge/Portfolio-FF5722?style=for-the-badge&logo=web&logoColor=white)](https://seu-portfolio.com)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/seu-perfil)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:seu-email@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/alexatp)

### 🐛 **Reportar Bugs**
[📋 Abrir Issue](https://github.com/alexatp/api-volmed/issues/new?template=bug_report.md)

### 💡 **Sugerir Feature** 
[🚀 Request Feature](https://github.com/alexatp/api-volmed/issues/new?template=feature_request.md)

---

### ⭐ **Gostou do projeto? Deixe uma estrela!**

**Desenvolvido com ❤️ durante o curso Spring Boot da [Alura](https://www.alura.com.br/)**

</div>

---

<div align="center">
  <sub>Made with ☕ and 💻 by <a href="https://github.com/alexatp">Alex Silva</a></sub>
</div>
}
```

### **👨‍⚕️ Médicos**
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/medicos` | Lista médicos paginados |
| `POST` | `/medicos` | Cadastra novo médico |
| `PUT` | `/medicos` | Atualiza dados do médico |
| `DELETE` | `/medicos/{id}` | Exclusão lógica (inativa) |
| `GET` | `/medicos/{id}` | Busca médico específico |

### **👥 Pacientes**
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/pacientes` | Lista pacientes paginados |
| `POST` | `/pacientes` | Cadastra novo paciente |
| `PUT` | `/pacientes` | Atualiza dados do paciente |
| `DELETE` | `/pacientes/{id}` | Exclusão lógica |
| `GET` | `/pacientes/{id}` | Busca paciente específico |

### **� Consultas**
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/consultas` | Agenda nova consulta |
| `GET` | `/consultas` | Lista consultas |
| `DELETE` | `/consultas/{id}` | Cancela consulta |

## 🔍 Recursos Avançados

### **🤖 Seleção Automática de Médicos**
O sistema possui um algoritmo inteligente que:
- Seleciona automaticamente um médico disponível da especialidade solicitada
- Verifica conflitos de horário
- Escolhe aleatoriamente entre médicos disponíveis

### **📝 Validações Implementadas**
- ✅ **CPF**: Validação de formato e dígitos verificadores
- ✅ **CRM**: Validação de formato por estado
- ✅ **Email**: Formato válido obrigatório
- ✅ **Telefone**: Formato brasileiro
- ✅ **CEP**: Formato válido
- ✅ **Dados obrigatórios**: Campos essenciais validados

### **🔒 Segurança**
- 🛡️ **JWT Tokens**: Autenticação stateless
- 🔐 **Senha criptografada**: BCrypt
- ⏰ **Expiração de tokens**: Controle de sessão
- 🚫 **CORS configurado**: Política de origem

## 💾 Banco de Dados

### **📊 Modelo de Dados**
```sql
-- Principais tabelas
medicos (id, nome, email, crm, especialidade, ativo, ...)
pacientes (id, nome, email, cpf, telefone, ativo, ...)  
consultas (id, medico_id, paciente_id, data)
usuarios (id, login, senha)
```

### **🔄 Migrações Flyway**
- `V1` → Criação da tabela médicos
- `V2` → Adição do campo telefone
- `V3` → Criação da tabela pacientes  
- `V4` → Campo ativo para soft delete
- `V5` → Tabela de usuários
- `V6` → Sistema de consultas

## 🧪 Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com relatório
mvn test jacoco:report

# Testes de integração
mvn verify
```

## 🔧 Configurações Avançadas

### **🌍 Profiles de Ambiente**
```properties
# application-dev.properties (Desenvolvimento)
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.springframework.security=DEBUG

# application-prod.properties (Produção)
spring.jpa.show-sql=false
server.error.include-stacktrace=never
logging.level.root=WARN
```

### **📊 Monitoramento**
```properties
# Actuator endpoints
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=when-authorized
```

## 🐳 Docker (Opcional)

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

```yaml
# docker-compose.yml
version: '3.8'
services:
  api:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - mysql
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_DATABASE: vollmed_api
      MYSQL_ROOT_PASSWORD: 123456
```

## � Próximas Funcionalidades

- [ ] Sistema de notificações
- [ ] Relatórios em PDF
- [ ] API de integração com WhatsApp
- [ ] Dashboard administrativo
- [ ] Agendamento recorrente
- [ ] Histórico médico dos pacientes

## 🤝 Contribuição

Contribuições são muito bem-vindas! Siga estes passos:

1. **Fork** o projeto
2. **Clone** seu fork: `git clone https://github.com/seu-usuario/api-volmed.git`
3. **Crie** uma branch: `git checkout -b feature/nova-funcionalidade`
4. **Commit** suas mudanças: `git commit -m 'Add: nova funcionalidade'`
5. **Push** para a branch: `git push origin feature/nova-funcionalidade`
6. **Abra** um Pull Request

### **� Padrões do Projeto**
- Seguir convenções Java
- Testes unitários obrigatórios
- Documentação atualizada
- Commits semânticos

## 📄 Licença

Este projeto está sob a licença MIT. Desenvolvido como projeto educacional durante os cursos da **Alura**.

## 📞 Contato e Suporte

- 📧 **Email**: seu-email@exemplo.com
- 💼 **LinkedIn**: [Seu Perfil](https://linkedin.com/in/seu-perfil)
- 🐛 **Issues**: [GitHub Issues](https://github.com/seu-usuario/api-volmed/issues)

---

<div align="center">

### ⭐ **Desenvolvido com ❤️ durante os cursos da Alura**

**Se este projeto foi útil, deixe uma ⭐!**

</div>
