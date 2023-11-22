package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pagamento {
  
    private String idPagamento;
    private LocalDateTime data;
    private float valor;
    private String tipoPlano;
    private String tipoPagamento;
    private String alunocCpf;
    public Pagamento(String idPagamento, LocalDate localDate, float valor, String tipoPlano, String tipoPagamento,
        String alunocCpf) {
      this.idPagamento = idPagamento;
      this.data = localDate;
      this.valor = valor;
      this.tipoPlano = tipoPlano;
      this.tipoPagamento = tipoPagamento;
      this.alunocCpf = alunocCpf;
    }
    public String getIdPagamento() {
      return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
      this.idPagamento = idPagamento;
    }
    public LocalDateTime getData() {
      return data;
    }
    public void setData(LocalDateTime data) {
      this.data = data;
    }
    public float getValor() {
      return valor;
    }
    public void setValor(float valor) {
      this.valor = valor;
    }
    public String getTipoPlano() {
      return tipoPlano;
    }
    public void setTipoPlano(String tipoPlano) {
      this.tipoPlano = tipoPlano;
    }
    public String getTipoPagamento() {
      return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
      this.tipoPagamento = tipoPagamento;
    }
    public String getAlunocCpf() {
      return alunocCpf;
    }
    public void setAlunocCpf(String alunocCpf) {
      this.alunocCpf = alunocCpf;
    }
    
}
