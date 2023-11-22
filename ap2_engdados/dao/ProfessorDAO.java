package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Professor;

public class ProfessorDAO {

    private Connection connection;

    public ProfessorDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Professor professor) {
        try {
            String sql = "INSERT INTO professor (cpf, nome, dataEfetivacao, tipoAula, turno, salario) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, professor.getCpf());
                pstm.setString(2, professor.getNome());
                pstm.setObject(3, professor.getDataEfetivacao());
                pstm.setString(4, professor.getTipoAula());
                pstm.setString(5, professor.getTurno());
                pstm.setDouble(6, professor.getSalario());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        professor.setCpf(rst.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Professor professor) {
        try {
            String sql = "UPDATE professor SET nome=?, dataEfetivacao=?, tipoAula=?, turno=?, salario=? WHERE cpf=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, professor.getNome());
                pstm.setObject(2, professor.getDataEfetivacao());
                pstm.setString(3, professor.getTipoAula());
                pstm.setString(4, professor.getTurno());
                pstm.setDouble(5, professor.getSalario());
                pstm.setString(6, professor.getCpf());

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cpf) {
        try {
            String sql = "DELETE FROM professor WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Professor getProfessorByCpf(String cpf) {
        try {
            String sql = "SELECT * FROM professor WHERE cpf = ?";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);

                try (ResultSet rst = pstm.executeQuery()) {
                    if (rst.next()) {
                        return extractProfessorFromResultSet(rst);
                    } else {
                        return null; // Nenhum professor encontrado com o CPF especificado
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> getAllProfessores() {
        List<Professor> professores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM professor";
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rst = stmt.executeQuery(sql)) {
                    while (rst.next()) {
                        professores.add(extractProfessorFromResultSet(rst));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return professores;
    }

    private Professor extractProfessorFromResultSet(ResultSet rst) throws SQLException {
        Professor professor = new Professor();
        professor.setCpf(rst.getString("cpf"));
        professor.setNome(rst.getString("nome"));
        professor.setDataEfetivacao(rst.getObject("dataEfetivacao", LocalDate.class));
        professor.setTipoAula(rst.getString("tipoAula"));
        professor.setTurno(rst.getString("turno"));
        professor.setSalario(rst.getDouble("salario"));
        return professor;
    }
}
