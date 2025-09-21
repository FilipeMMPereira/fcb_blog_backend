# FCB Blog Backend

API RESTful para sistema de blog desenvolvida com Spring Boot, oferecendo endpoints seguros para gerenciamento de conteúdo e autenticação de usuários.

## 📋 Funcionalidades

- **API RESTful** completa para sistema de blog
- **Autenticação e Autorização** com Spring Security
- **Documentação Interativa** com Swagger/OpenAPI
- **Validação de Dados** integrada
- **Persistência de Dados** com JPA/Hibernate
- **Banco de Dados MySQL**
- **Estrutura Modular** e escalável

## 🚀 Tecnologias

- **Java** 21
- **Spring Boot** 3.5.5
- **Spring Security** (Autenticação e Autorização)
- **Spring Data JPA** (Persistência)
- **Spring Validation** (Validação de dados)
- **MySQL** (Banco de dados)
- **Lombok** (Redução de código boilerplate)
- **Swagger/OpenAPI** 2.8.13 (Documentação)
- **Maven** (Gerenciamento de dependências)

## ⚙️ Pré-requisitos

- **Java JDK 21** ou superior
- **Maven 3.6+**
- **MySQL 8.0+**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 🛠️ Configuração e Instalação

### 1. Clone o Repositório
```bash
git clone [URL_DO_REPOSITORIO]
cd fcb_blog_backend
```

### 2. Configure o Banco de Dados MySQL
```sql
-- Crie o banco de dados
CREATE DATABASE fcb_blog;

-- Crie um usuário (opcional)
CREATE USER 'blog_user'@'localhost' IDENTIFIED BY 'sua_senha';
GRANT ALL PRIVILEGES ON fcb_blog.* TO 'blog_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure o arquivo `application.properties`
```properties
# Configuração do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/fcb_blog
spring.datasource.username=blog_user
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true

# Configuração do Servidor
server.port=8080

# Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

### 4. Execute a Aplicação
```bash
# Usando Maven
mvn spring-boot:run

# Ou compile e execute o JAR
mvn clean package
java -jar target/fcb_blog_backend-0.0.1-SNAPSHOT.jar
```

## 🌐 Acesso à Aplicação

### Swagger UI (Documentação Interativa)
```
http://localhost:8080/swagger-ui/index.html
```

### API Base URL
```
http://localhost:8080
```

### Endpoints Públicos
```
http://localhost:8080/public/
```

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger UI. Lá você pode:

- Visualizar todos os endpoints disponíveis
- Testar as APIs diretamente no navegador
- Ver os modelos de dados (DTOs)

**URL**: `http://localhost:8080/swagger-ui/index.html`

## 🔧 Comandos Maven Úteis

```bash
# Executar a aplicação
mvn spring-boot:run

# Compilar o projeto
mvn clean compile

# Executar testes
mvn test

# Gerar o JAR
mvn clean package

# Pular testes durante o build
mvn clean package -DskipTests

# Executar com profile específico
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/fcb_blog_backend/
│   │   ├── config/          # Configurações (Security, Swagger, etc.)
│   │   ├── controller/      # Controllers REST
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── moodel/         # Entidades JPA
│   │   ├── repository/     # Repositórios Spring Data
│   │   ├── service/        # Camada de serviços
│   │   ├── security/       # Configurações de segurança
│   │   └── FcbBlogBackendApplication.java
│   └── resources/
│       ├── application.properties
│       └── application-{profile}.properties
└── test/
    └── java/               # Testes unitários e integração
```

## 🔐 Segurança

O projeto utiliza Spring Security para:
- **Autenticação de usuários** via JWT/Session
- **Autorização baseada em roles** (USER, ADMIN)
- **Proteção de endpoints** sensíveis
- **Endpoints públicos** para acesso sem autenticação (`/public/*`)
- **Criptografia de senhas** com BCrypt

## 🚀 Deploy

### Variáveis de Ambiente para Produção
```bash
export SPRING_PROFILES_ACTIVE=prod
export DB_URL=jdbc:mysql://seu-servidor:3306/fcb_blog
export DB_USERNAME=seu_usuario
export DB_PASSWORD=sua_senha
```

### Docker (Opcional)
```dockerfile
FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/fcb_blog_backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## 📝 Contribuição

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/nova-feature`)
3. Commit as mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 🐛 Troubleshooting

### Problemas Comuns

**Erro de Conexão MySQL:**
- Verifique se o MySQL está rodando
- Confirme as credenciais no `application.properties`
- Teste a conexão manualmente

**Porta 8080 já em uso:**
```properties
server.port=8081
```

**Problema com Lombok:**
- Instale o plugin do Lombok na sua IDE
- Habilite o processamento de anotações

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).

## 📞 Suporte

Para dúvidas ou suporte, entre em contato:

- **Email**: filipepereira977@gmail.com
- **Telefone**: +258 849013127 ou +258 868011729
- **Desenvolvedor**: Filipe Pereira

Ou abra uma issue no repositório para reportar bugs ou sugerir melhorias.

---

**Desenvolvido com ❤️ por Filipe Pereira usando Spring Boot**
