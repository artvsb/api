Discente: Arthur Vinicio da Silva Barbosa

Projeto: Aluno Online

O projeto acima é um sistema de controle escolar que relaciona alunos, professores, disciplinas e notas. Através do sistema Aluno Online, o Aluno registra dados pessoais como nome e data de nascimento, recebendo um ID que o identifica de forma única no sistema.

O mesmo acontece com o Professor, que registra seus dados pessoais e as notas dos alunos, na(s) disciplina(s) da(s) qual(is) for docente. 

Estrutura do Projeto

.
├── mvnw
├── mvnw.cmd
├── pom.xml
├── readme.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── alunoonline
│   │   │               └── api
│   │   │                   ├── AlunoOnlineApplication.java
│   │   │                   ├── controller
│   │   │                   │   ├── AlunoController.java
│   │   │                   │   └── ProfessorController.java
│   │   │                   ├── model
│   │   │                   │   ├── Aluno.java
│   │   │                   │   └── Professor.java
│   │   │                   ├── repository
│   │   │                   │   ├── AlunoRepository.java
│   │   │                   │   └── ProfessorRepository.java
│   │   │                   └── service
│   │   │                       ├── AlunoService.java
│   │   │                       └── ProfessorService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── br.com.alunoonline.api
│               └── com
│                   └── alunoonline
│                       └── api
│                           └── AlunoOnlineApplicationTests.java
└── target
    ├── classes
    │   ├── application.properties
    │   └── br
    │       └── com
    │           └── alunoonline
    │               └── api
    │                   ├── AlunoOnlineApplication.class
    │                   ├── controller
    │                   │   ├── AlunoController.class
    │                   │   └── ProfessorController.class
    │                   ├── model
    │                   │   ├── Aluno.class
    │                   │   └── Professor.class
    │                   ├── repository
    │                   │   ├── AlunoRepository.class
    │                   │   └── ProfessorRepository.class
    │                   └── service
    │                       ├── AlunoService.class
    │                       └── ProfessorService.class
    └── generated-sources
        └── annotations

Detalhamento do código

1. Aluno
    
    Salva informações básicas do aluno, sejam elas: id, nome, e-mail, CPF. O ID é gerado automaticamente pelo sistema com base na ordem numérica (adiciona-se 1 ao último ID gerado) e deve ser único, para garantir a integridade dos dados armazenados; nome, e-mail e CPF são fornecidos pelo usuário.

2. Professor

    Salva as mesmas informações coletadas do aluno (id, nome, e-mail, CPF). O ID do professor é unico assim como o ID do aluno, porém armazenado em tabela diferente daquele, de modo que um professor pode ter ID = 1 ao mesmo tempo que existe um aluno com ID = 1, já que ambos os 'ID' pertencem cada um à sua respectiva entidade. O professor também deverá ser vinculado a sua respectiva disciplina.