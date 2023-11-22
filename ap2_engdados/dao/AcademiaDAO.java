package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Academia;
public class AcademiaDAO {

    private Connection connection;

    public AcademiaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Academia academia) {
        try {
            String sql = "INSERT INTO academia (idAcademia, nome, endereco, horarioFuncionamento, funcionarioCpf, idTipoAula) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, academia.getIdAcademia());
                pstm.setString(2, academia.getNome());
                pstm.setString(3, academia.getEndereco());
                pstm.setString(4, academia.getHorarioFuncionamento());
                pstm.setString(5, academia.getFuncionarioCpf());
                pstm.setString(6, academia.getIdTipoAula());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        academia.setIdAcademia(rst.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

