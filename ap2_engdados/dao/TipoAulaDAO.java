package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.TipoAula;


public class TipoAulaDAO {

    private Connection connection;

    public TipoAulaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(TipoAula tipoAula) {
        try {
            String sql = "INSERT INTO tipoAula (idTipoAula, nome, horario, local, capacidade) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, tipoAula.getIdTipoAula());
                pstm.setString(2, tipoAula.getNome());
                pstm.setString(3, tipoAula.getHorario());
                pstm.setString(4, tipoAula.getLocal());
                pstm.setInt(5, tipoAula.getCapacidade());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        tipoAula.setIdTipoAula(rst.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}