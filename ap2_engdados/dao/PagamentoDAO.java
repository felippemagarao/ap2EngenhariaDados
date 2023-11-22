package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Pagamento;

public class PagamentoDAO {

    private Connection connection;

    public PagamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Pagamento pagamento) {
        try {
            String sql = "INSERT INTO pagamento (idPagamento, data, valor, tipoPlano, tipoPagamento, alunoCpf) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, pagamento.getIdPagamento());
                pstm.setDate(2, pagamento.getData);
                pstm.setFloat(3, pagamento.getValor());
                pstm.setString(4, pagamento.getTipoPlano());
                pstm.setString(5, pagamento.getTipoPagamento());
                pstm.setString(6, pagamento.getAlunocCpf());
                
                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        pagamento.setIdPagamento(rst.getString(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
