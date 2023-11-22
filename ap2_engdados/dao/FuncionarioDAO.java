package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
importjava.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario (cpf, nome, cargo, salario) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, funcionario.getCpf());
                pstm.setString(2, funcionario.getNome());
                pstm.setString(3, funcionario.getCargo());
                pstm.setFloat(4, funcionario.getSalario());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        funcionario.setCpf(rst.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario SET nome=?, cargo=?, salario=? WHERE cpf=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, funcionario.getNome());
                pstm.setString(2, funcionario.getCargo());
                pstm.setFloat(3, funcionario.getSalario());
                pstm.setString(4, funcionario.getCpf());

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cpf) {
        try {
            String sql = "DELETE FROM funcionario WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario getFuncionarioByCpf(String cpf) {
        try {
            String sql = "SELECT * FROM funcionario WHERE cpf = ?";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);

                try (ResultSet rst = pstm.executeQuery()) {
                    if (rst.next()) {
                        return extractFuncionarioFromResultSet(rst);
                    } else {
                        return null; // Nenhum funcionário encontrado com o CPF especificado
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM funcionario";
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rst = stmt.executeQuery(sql)) {
                    while (rst.next()) {
                        funcionarios.add(extractFuncionarioFromResultSet(rst));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    private Funcionario extractFuncionarioFromResultSet(ResultSet rst) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(rst.getString("cpf"));
        funcionario.setNome(rst.getString("nome"));
        funcionario.setCargo(rst.getString("cargo"));
        funcionario.setSalario(rst.getFloat("salario"));
        return funcionario;
    }
}
