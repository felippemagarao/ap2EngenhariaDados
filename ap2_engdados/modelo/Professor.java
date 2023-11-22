package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Professor {
    private String cpf;
    private String nome;
    private LocalDate dataEfetivacao;
    private String tipoAula;
    private String turno;
    private Double salario;
    
    public Professor(String cpf, String nome, LocalDate dataEfetivacao, String tipoAula, String turno, Double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataEfetivacao = dataEfetivacao;
        this.tipoAula = tipoAula;
        this.turno = turno;
        this.salario = salario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataEfetivacao() {
        return dataEfetivacao;
    }
    public void setDataEfetivacao(LocalDate dataEfetivacao) {
        this.dataEfetivacao = dataEfetivacao;
    }
    public String getTipoAula() {
        return tipoAula;
    }
    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
   
}