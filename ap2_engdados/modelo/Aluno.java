package modelo;

import java.time.LocalDate;

public class Aluno {
    public Aluno(String cpf, String nome, LocalDate dataNascimento, String endereco, String telefone, String email,
      String aulasCadastradas) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.telefone = telefone;
    this.email = email;
    this.aulasCadastradas = aulasCadastradas;
  }
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private String aulasCadastradas;
    
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
    public LocalDate getDataNascimento() {
      return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
      this.dataNascimento = dataNascimento;
    }
    public String getEndereco() {
      return endereco;
    }
    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }
    public String getTelefone() {
      return telefone;
    }
    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public String getAulasCadastradas() {
      return aulasCadastradas;
    }
    public void setAulasCadastradas(String aulasCadastradas) {
      this.aulasCadastradas = aulasCadastradas;
    }

}
