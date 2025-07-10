# Trabalho de Orientação a Objetos 2025.1
## Sistema de Reservas
Trabalho feito por Laura Ester Fernandes Silva Goulart, matrícula 232021795 e por Letícia Vitória Gomes, matrícula 241011967. Este sistema tem como objetivo gerenciar a *reserva de espaços físicos* dentro de uma universidade, como salas de aula, laboratórios e auditórios. Ele foi desenvolvido com base nos princípios da *Programação Orientada a Objetos em Java, aplicando os conceitos de **modularidade, herança, polimorfismo, encapsulamento e tratamento de exceções personalizadas*.

Usuários (alunos, professores e servidores técnicos) podem reservar espaços com base em regras específicas de permissão e disponibilidade, garantindo agendamentos organizados e sem conflitos.

### Estrutura do projeto: 

- entidades/: Modelos do domínio (Usuário, Professor, Aluno, Reserva, Espaço Físico etc.)
- servico/: Regras de negócio (cadastro, listagem, agendamento, busca)
- excecoes/: Exceções personalizadas
- menu/: Interface com o usuário (JOptionPane)
- Main.java: Inicialização do sistema

### Funcionalidades: 
O sistema permite o gerenciamento completo de reservas de espaços físicos da universidade. As funcionalidades incluem:

#### Cadastro de usuários
- *Alunos*: com nome, email, telefone, senha, matrícula, curso e semestre.
- *Professores*: com nome, email, telefone, senha, matrícula institucional, curso ministrado e cargo acadêmico.
- *Servidores Administrativos*: com nome, email, telefone, senha, matrícula institucional, cargo e departamento.

#### Cadastro de Espaços Físicos 
- Cadastro de *salas de aula, **laboratórios* e *salas de estudo*.
- Definição da *capacidade, **localização, **tipo* e *equipamentos disponíveis* em cada espaço.

#### Agendamento de Espaços
- *Alunos*: podem agendar apenas em um único dia e em horários permitidos.
- *Servidores e Professores*: podem agendar por períodos maiores, sem restrição de dias.
- O sistema *impede reservas duplicadas* (conflito de horários).

#### Relatórios
- Visualização do *histórico de reservas de um usuário*.
- Relatório de *uso de um espaço físico* em um período determinado.

#### Tratamento de Exceções
- Cadastro de usuários e espaços com validação de campos obrigatórios.
- Lançamento de exceções customizadas:
  - HorarioIndisponivelException: impede agendamentos em horários já ocupados.
  - DiasExcedidosException: impede alunos de reservar espaços por mais de um dia.
  - CampoObrigatorioException:  impede que o usuário deixe espaços em branco.
 
## Conclusão: 
O sistema implementado atende aos requisistos propostos, aplicando os princípios de *orientação a objetos*. A interface gráfica com JOptionPane permite *interação intuitiva* com o usuário, facilitando cadastros, agendamentos e relatórios. O projeto garante *validação de dados, **tratamento de erros* e *controle de conflitos de agendamento*, oferecendo uma solução robusta para gestão de espaços físicos universitários.
