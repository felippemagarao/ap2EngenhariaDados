package modelo;

public class Academia {

    private String idAcademia;
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private String FuncionarioCpf;
    private String IdTipoAula;
    public Academia(String idAcademia, String nome, String endereco, String horarioFuncionamento, String funcionarioCpf,
        String idTipoAula) {
      this.idAcademia = idAcademia;
      this.nome = nome;
      this.endereco = endereco;
      this.horarioFuncionamento = horarioFuncionamento;
      FuncionarioCpf = funcionarioCpf;
      IdTipoAula = idTipoAula;
    }
    public String getIdAcademia() {
      return idAcademia;
    }
    public void setIdAcademia(String idAcademia) {
      this.idAcademia = idAcademia;
    }
    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public String getEndereco() {
      return endereco;
    }
    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }
    public String getHorarioFuncionamento() {
      return horarioFuncionamento;
    }
    public void setHorarioFuncionamento(String horarioFuncionamento) {
      this.horarioFuncionamento = horarioFuncionamento;
    }
    public String getFuncionarioCpf() {
      return FuncionarioCpf;
    }
    public void setFuncionarioCpf(String funcionarioCpf) {
      FuncionarioCpf = funcionarioCpf;
    }
    public String getIdTipoAula() {
      return IdTipoAula;
    }
    public void setIdTipoAula(String idTipoAula) {
      IdTipoAula = idTipoAula;
    }
    
}