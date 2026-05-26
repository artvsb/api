Discente: Arthur Vinicio da Silva Barbosa

Projeto: **Aluno Online**

O Aluno Online é um sistema de controle escolar que relaciona alunos e professores, disciplinas, matrículas e notas. Através do sistema Aluno Online, o Aluno registra dados pessoais como nome e data de nascimento, recebendo um ID que o identifica de forma única no sistema.

O mesmo acontece com o Professor, que registra seus dados pessoais e as notas dos alunos, na(s) disciplina(s) da(s) qual(is) for docente. As notas do aluno são administradas pelo professor designado para cada disciplina e devidamente cadastrado como tal no banco de dados.

O aluno tem a opção de se cadastrar em uma determinada disciplina, assim como trancá-la posteriormente, caso não esteja aprovado nem reprovado. O aluno estará aprovado se atingir a média **7.0**, caso contrário será automaticamente reprovado no sistema.

**Estrutura do Projeto**

```text
.
├── insomnia
│   └── aluno_online-wrk_f82b80e81110447babc2fb01fd790f61.yaml
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
│   │   │                   │   ├── DisciplinaController.java
│   │   │                   │   ├── MatriculaAlunoController.java
│   │   │                   │   └── ProfessorController.java
│   │   │                   ├── dtos
│   │   │                   │   └── AtualizarNotasRequestDTO.java
│   │   │                   ├── enums
│   │   │                   │   └── MatriculaStatusEnum.java
│   │   │                   ├── model
│   │   │                   │   ├── Aluno.java
│   │   │                   │   ├── Disciplina.java
│   │   │                   │   ├── MatriculaAluno.java
│   │   │                   │   └── Professor.java
│   │   │                   ├── repository
│   │   │                   │   ├── AlunoRepository.java
│   │   │                   │   ├── DisciplinaRepository.java
│   │   │                   │   ├── MatriculaAlunoRepository.java
│   │   │                   │   └── ProfessorRepository.java
│   │   │                   └── service
│   │   │                       ├── AlunoService.java
│   │   │                       ├── DisciplinaService.java
│   │   │                       ├── MatriculaAlunoService.java
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
    │                   │   ├── DisciplinaController.class
    │                   │   ├── MatriculaAlunoController.class
    │                   │   └── ProfessorController.class
    │                   ├── enums
    │                   │   └── MatriculaStatusEnum.class
    │                   ├── model
    │                   │   ├── Aluno.class
    │                   │   ├── Disciplina.class
    │                   │   ├── MatriculaAluno.class
    │                   │   └── Professor.class
    │                   ├── repository
    │                   │   ├── AlunoRepository.class
    │                   │   ├── DisciplinaRepository.class
    │                   │   ├── MatriculaAlunoRepository.class
    │                   │   └── ProfessorRepository.class
    │                   └── service
    │                       ├── AlunoService.class
    │                       ├── DisciplinaService.class
    │                       ├── MatriculaAlunoService.class
    │                       └── ProfessorService.class
    └── generated-sources
        └── annotations
```

**Detalhamento do código**

1. **Aluno** - model.Aluno, alunoController, alunoService, alunoRepository
    
    Salva informações básicas do aluno, sejam elas: id, nome, e-mail, CPF. O ID é gerado automaticamente pelo sistema com base na ordem numérica (soma-se 1 ao último ID gerado) e deve ser único, para garantir a integridade dos dados armazenados; nome, e-mail e CPF são fornecidos pelo usuário. 

2. **Professor** - model.Professor, professorController, professorService, professorRepository

    Salva as informações básicas coletadas do professor (id, nome, e-mail, CPF). O ID do professor é unico assim como o ID do aluno, porém armazenado em tabela diferente daquele, de modo que um professor pode ter ID = 1 ao mesmo tempo que existe um aluno com ID = 1, já que ambos os 'ID' pertencem cada um à sua respectiva entidade. O professor também deverá ser vinculado a sua respectiva disciplina e lançar as notas de cada aluno no sistema periodicamente.

3. **Disciplina** - model.Disciplina, disciplinaController, disciplinaService, disciplinaRepository

    Salva as informações básicas da disciplina: id, nome, carga horária, professor responsável. O ID é gerado com a mesma estratégia das entidades anteriores. Ao criar uma nova disciplina, deve-se referenciar o objeto Professor dentro do objeto Disciplina. Assim, esse professor estará vinculado à disciplina e estará encarregado de preencher as notas dos alunos.

4. **Matricula** - model.matriculaAluno, matriculaAlunoController, matriculaAlunoService, matriculaAlunoRepository

   Esta entidade é responsável por relacionar todas as anteriromente citadas. Seus atributos são: id, aluno, disciplina, nota1, nota2, status. Ao ser criada, deve-se referenciar o aluno a uma disciplina, que por sua vez está vinculada a um professor. Ao se matricular um aluno, surgirá uma matrícula com ID próprio e com status "MATRICULADO" automaticamente. As notas dos alunos serão preenchidas pelo professor responsável pela disciplina ao final da realização das provas. Assim que ambas forem impostadas no sistema, o Back End calculará a média dos valores e determinará se o aluno foi aprovado ou reprovado. Se o aluno não atingir média **7.0**, será automaticamente reprovado.

**Arquitetura do Projeto**

O Aluno Online é uma API REST baseada em arquitetura em camadas, sendo uma aplicação com o framework Spring, linguagem Java, com dependências gerenciadas pelo Apache Maven e utilizando PostgreSQL para persistência de dados. 

Cada entidade do sistema possui as camadas Model, Controller, Service, Repository. Porém, além das camadas, há a presença de pacotes importantes, como enums e dtos.

A camada **Model** é responsábel por elencar os dados a serem coletados na aplicação, assim como criar os métodos construtores, getters e setters. É nesta camada que se definem os tipos de cada dado a ser armazenado no BD, como nome e CPF.

A camada **Controller** é a orquestradora das chamadas do sistema, pois lida diretamente com o usuário e coordena o fluxo da requisição com base nos dados fornecidos por ele, interpreta-os e aciona a próxima camada - Service, através da injeção de dependência, para que esta execute a regra de negócio determinada internamente através de seus métodos. Esta camada é processada na máquina do usuário e NÃO deve conter a regra de negócio do sistema, para fins de segurança. 

Ao passo que o usuário acessa o endpoint respectivo de sua entidade (aluno, professor), os métodos utilizados por ele estarão designados em, respectivamente, alunoController e professorController. 

A camada **Service**, por sua vez, implementa as regras de negócio definidas pela equipe para o correto funcionamento do sistema. Após o devido processamento das chamadas do usuário e das regras de negócio, o Service acessa a camada Repository, que vai promover a integração do Back End com o Banco de Dados através da camada Repository. Esta camada contém a regra de negócio da aplicação, sendo responsável por controlar a forma como cada informação é processada de acordo com seus métodos internos (em alunoService, professorService).

A camada **Repository** é responsável pela persistência de dados, realizando operações de CRUD no banco de dados. No projeto, ela é implementada com o Spring Data Jpa. Através dessa camada e suas interfaces, os dados processados pelo Controller e Service conseguem chegar ao BD e lá ficam armazenados. 

Além das camadas supracitadas, destaca-se a importancia dos pacotes enums e dtos. Os **enums** são responsáveis por criar um "menu de opções" para definir o comportamento do sistema a depender de determinada característica ou status presente nesse menu. Servem principalmente para evitar erros de sistema derivados de mau comportamento do usuário (erros de digitação, letra maiúscula/minúscula, etc). 
O pacote **dtos** elenca classes Java chamadas DTO (Data Transfer Object), que servirão para intercambiar dados entre usuário/sistema sem que seja necessário fornecer todos os dados necessários à criação da classe objeto. Por exemplo, uma matriculaAluno tem dados como id do aluno, id do professor, id da matrícula; mas não é viável o professor ter que fornecer ou saber todos esses dados na hora de preencher as notas do aluno. O DTO é uma classe transitória, que carrega apenas os dados necessários para determinada requisição ou resposta e junta tais dados ao BD de acordo com a regra de negócio.

Por fim, os dados são persistidos em banco de dados PostgreSQL, através das chamadas da camada Repository, que se conecta com cada entidade: alunoRepository, professorRepository, etc. 
    
**Funcionamento**

Seguem prints demonstrando funcionamento do código implementado no Insomnia, DBeaver para cada um dos métodos apresentados

1. Método **criarAluno()** - inclui um novo aluno no BD<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 09 59 14" src="https://github.com/user-attachments/assets/340b2b32-c009-4cfd-a372-410ae1c932bf" /><br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 02 43" src="https://github.com/user-attachments/assets/86a55409-0ef2-485c-bcc5-6d110190f696" /><br>

2. Método **buscarTodosAlunos()** - retorna todos os alunos cadastrados<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 04 18" src="https://github.com/user-attachments/assets/0b0a2089-d0a2-4654-b4b5-5ad0940ac0e3" /><br>

3. Método **buscarAlunoPorId()** - retorna um aluno com ID específico<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 05 25" src="https://github.com/user-attachments/assets/d5b735c9-4be8-4c37-ba42-e93eb1a31e3c" /><br>

4. Método **deletarAlunoPorId()** - deleta um aluno específico do BD<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 06 49" src="https://github.com/user-attachments/assets/25b80352-2220-485b-9f56-ba9666636524" /><br>

5. Método **atualizarAlunoPorId()** - atualiza as informações de um aluno específico<br>

Antes:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 08 11" src="https://github.com/user-attachments/assets/2067df85-b4f6-4b14-8fb6-7c3ce3a8264c" /><br>

Depois:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 11 07" src="https://github.com/user-attachments/assets/0e50994f-bd68-4164-868c-ccfb0d1f4edd" /><br>

6. Método **criarProfessor()** - inclui um novo professor no BD<br>

Antes:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 12 25" src="https://github.com/user-attachments/assets/0c4e920d-95ea-4dd0-8c44-847391649e91" /><br>

Depois:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 15 53" src="https://github.com/user-attachments/assets/9ffd6b2c-e877-444e-9b54-24fce315af61" /><br>

7. Método **buscarTodosProfessores()** - retorna todos os professores cadastrados<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 16 53" src="https://github.com/user-attachments/assets/48663d4f-353a-4447-9e89-0345b6ce4033" /><br>

8. Método **buscarProfessorPorId()** - retorna um professor específico<br>

<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 17 43" src="https://github.com/user-attachments/assets/2c0ade84-9f5f-47c1-88f8-bea91508c78b" /><br>

9. Método **deletarProfessorPorId()** - deleta um professor específico<br>

Antes:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 19 15" src="https://github.com/user-attachments/assets/fdb65f5a-5758-447d-9494-ccf955e5ab39" /><br>

Depois:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 19 57" src="https://github.com/user-attachments/assets/b93193c1-843f-4c73-a434-ac0424e6f3cb" /><br>

10. Método **atualizarProfessorPorId()** - atualiza os dados de um professor específico<br>

Antes:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 21 00" src="https://github.com/user-attachments/assets/c475e24e-3ce4-414d-8a12-406419ac39a6" /><br>

Depois:<br>
<img width="1920" height="1080" alt="Captura de Tela 2026-04-07 às 10 22 08" src="https://github.com/user-attachments/assets/c52b83b4-ac8b-4984-b303-418294cc628b" />

11. Método **criarDisciplina()** - cria uma nova disciplina no banco<br>

<img width="1920" height="970" alt="image" src="https://github.com/user-attachments/assets/87a39e58-4e42-4a70-8e80-54705646fccf" />
<br>

12. Método **buscarTodasDisciplinas()** - busca todas as disciplinas no banco<br>

<img width="1918" height="972" alt="image" src="https://github.com/user-attachments/assets/77d62d95-d5dd-4ca1-a5c4-d3a58ec8c5e5" /><br>

13. Método **buscarDisciplinaPorId()** - busca disciplina específica pelo seu ID<br>

<img width="1918" height="968" alt="image" src="https://github.com/user-attachments/assets/21b0e418-e821-4b83-90e4-0282f0da3bed" />
<br>

14. Método **deletarDisciplinaPorId()** - deleta uma disciplina cadastrada no banco, pelo seu ID<br>

<img width="1920" height="968" alt="image" src="https://github.com/user-attachments/assets/a931ba51-d4bb-4716-868e-ee7a55075dfd" /><br>

15. Método **atualizarDisciplinaPorId()** - método que atualiza uma disciplina do banco

<img width="1919" height="968" alt="image" src="https://github.com/user-attachments/assets/d35d9427-3989-437d-8658-7a225ce42e78" /><br>

16. Método **matricular()** - matricula um aluno em uma determinada disciplina

<img width="1919" height="975" alt="image" src="https://github.com/user-attachments/assets/4d43f3ec-a258-41a2-875b-3d6e48d8d69f" /><br>

17. Método **trancarMatricula()** - transforma o status da matricula MATRICULADO em TRANCADO, o que não pode ser feito se a matrícula estiver APROVADO ou REPROVADO

<img width="1916" height="970" alt="image" src="https://github.com/user-attachments/assets/e09daded-af5b-4388-a91a-17bdf243ad4b" /><br>


