import java.security.KeyStore.PasswordProtection;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Academia;
import modelo.Aluno;
import modelo.Professor;
import modelo.TipoAula;
import modelo.Funcionario;
import modelo.Pagamento;
import dao.AcademiaDAO;
import dao.AlunoDAO;
import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import dao.PagamentoDAO;
import dao.ProfessorDAO;
import dao.TipoAulaDAO;


public class Principal {

    public static void main(String[] args) throws SQLException {

        Professor professor1 = new Professor("12345678912", "Patrick", LocalDate.of(2023, 1, 30), "Spinning", "Noite", 3550.5);
        
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        Connection connection = fabricaDeConexao.recuperaConexao();

        ProfessorDAO pdao = new ProfessorDAO(connection);

        pdao.create(professor1);
       

        Aluno aluno1 = new Aluno("74125896321", "Maycon", LocalDate.of(2021, 10, 20), "Rua Joaquim, 34", "99874521", "maycon@gmail.com", "Boxing");

        AlunoDAO adao = new AlunoDAO(connection);
        adao.create(aluno1);

        Funcionario funcionario1 = new Funcionario("47856941211", "João", "Colaborador",2000);

        FuncionarioDAO fdao = new FuncionarioDAO(connection);
        fdao.create(funcionario1);
        
        
        Academia academia1 = new Academia("874","Fitdays","Rua. Laranjas, 76", "6:00-21:00", "184635296001","197");

        AcademiaDAO acdao = new AcademiaDAO(connection);
        acdao.create(academia1);

        TipoAula tipoAula1 = new TipoAula("340", "Mayara", "18:00-19:00", "Rua Marechal Hermes 61", 40, "87669543318", "18856635519");

        TipoAulaDAO tdao = new TipoAulaDAO(connection);
        tdao.create(tipoAula1);

        Pagamento pagamento1 = new Pagamento("010023012", LocalDate.of(2023, 11, 21), 200, "Premmium", "credito", "74125896321");

        PagamentoDAO pagdao = new PagamentoDAO(connection);
        pagdao.create(pagamento1);







        // ArrayList<Professor> pessoas = pdao.retriveAllComTelefone();

        // System.out.println("Comecei a printar os objetos de pessoa criados a partir dos dados do BD\n");
        // for (Professor pessoa : pessoas) {
        //     System.out.println(pessoa);
        //     for (Telefone telefone : pessoa.getTelefones()) {
        //         System.out.println(telefone);
        //     }
        // }
        // System.out.println("Acabei de printar os objetos de pessoa criados a partir dos dados do BD\n\n\n");

        // Funcionario evento1 = new Funcionario(LocalDate.of(2023, 11, 10), "Pagar Contas");
        // Funcionario evento2 = new Funcionario(LocalDate.of(2023, 11, 16), "Reunião de Acompanhamento");
        // evento2.addPessoa(pessoa1);
        // evento2.addPessoa(pessoa2);
        // Funcionario evento3 = new Funcionario(LocalDate.of(2023, 11, 16), "Apresentação dos Resultados");
        // evento3.addPessoa(pessoa1);
        // evento3.addPessoa(pessoa2);
        // evento3.addPessoa(pessoa3);

        // System.out.println("Comecei a printar os objetos de evento criados em memoria\n");
        // System.out.println(evento1);
        // System.out.println(evento2);
        // System.out.println(evento3);
        // System.out.println("Acabei de printar os objetos de evento em memoria\n\n\n");

        // FuncionarioDAO edao = new FuncionarioDAO(connection);

        // edao.createComPessoa(evento1);
        // edao.createComPessoa(evento2);
        // edao.createComPessoa(evento3);

        // ArrayList<Funcionario> eventos = edao.retriveAllComPessoaComTelefone();

        // System.out.println("Comecei a printar os objetos de evento criados a partir dos dados do BD\n");
        // for (Funcionario evento : eventos) {
        //     System.out.println(evento);
        //     for (Professor pessoa : evento.getPessoas()) {
        //         System.out.println(pessoa);
        //         for (Telefone telefone : pessoa.getTelefones()) {
        //             System.out.println(telefone);
        //         }
        //     }
        // }
        // System.out.println("Acabei de printar os objetos de evento criados a partir dos dados do BD\n\n\n");

        // /*
        //  * //Exemplo de Injection
        //  * Pessoa pessoa10 = new Pessoa("%",
        //  * "%' UNION SELECT cpf FROM Pessoa WHERE nome LIKE '%", LocalDate.of(2002, 9,
        //  * 05));
        //  * ArrayList<Pessoa> pessoas2 = pdao.retrieveInjection(pessoa10);
        //  * for (Pessoa pessoa : pessoas2) {
        //  * System.out.println(pessoa);
        //  * }
        //  */

    }

}