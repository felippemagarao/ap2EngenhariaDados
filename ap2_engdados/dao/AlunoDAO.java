package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

public class AlunoDAO {

    private Connection connection;

    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Aluno aluno) {
        try {
            String sql = "INSERT INTO aluno (cpf, nome, dataNascimento, endereco, email, aulasCadastradas) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, aluno.getCpf());
                pstm.setString(2, aluno.getNome());
                pstm.setObject(3, aluno.getDataNascimento());
                pstm.setString(4, aluno.getEndereco());
                pstm.setString(5, aluno.getEmail());
                pstm.setString(6, aluno.getAulasCadastradas());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        aluno.setCpf(rst.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Aluno aluno) {
        try {
            String sql = "UPDATE aluno SET nome=?, dataNascimento=?, endereco=?, email=?, aulasCadastradas=? WHERE cpf=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, aluno.getNome());
                pstm.setObject(2, aluno.getDataNascimento());
                pstm.setString(3, aluno.getEndereco());
                pstm.setString(4, aluno.getEmail());
                pstm.setString(5, aluno.getAulasCadastradas());
                pstm.setString(6, aluno.getCpf());

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cpf) {
        try {
            String sql = "DELETE FROM aluno WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno getAlunoByCpf(String cpf) {
        try {
            String sql = "SELECT * FROM aluno WHERE cpf = ?";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);

                try (ResultSet rst = pstm.executeQuery()) {
                    if (rst.next()) {
                        return extractAlunoFromResultSet(rst);
                    } else {
                        return null; // Nenhum aluno encontrado com o CPF especificado
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM aluno";
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rst = stmt.executeQuery(sql)) {
                    while (rst.next()) {
                        alunos.add(extractAlunoFromResultSet(rst));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    private Aluno extractAlunoFromResultSet(ResultSet rst) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setCpf(rst.getString("cpf"));
        aluno.setNome(rst.getString("nome"));
        aluno.setDataNascimento(rst.getObject("dataNascimento", LocalDate.class));
        aluno.setEndereco(rst.getString("endereco"));
        aluno.setEmail(rst.getString("email"));
        aluno.setAulasCadastradas(rst.getString("aulasCadastradas"));
        return aluno;
    }
}
