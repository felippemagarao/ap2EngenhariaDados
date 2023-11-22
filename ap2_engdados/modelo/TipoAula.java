package modelo;

public class TipoAula {

    private String idTipoAula;
    private String nome;
    private String horario;
    private String local;
    private int capacidade;
    private String alunoCpf;
    private String professorCpf;
    
    public TipoAula(String idTipoAula, String nome, String horario, String local, int capacidade, String alunoCpf,
        String professorCpf) {
      this.idTipoAula = idTipoAula;
      this.nome = nome;
      this.horario = horario;
      this.local = local;
      this.capacidade = capacidade;
      this.alunoCpf = alunoCpf;
      this.professorCpf = professorCpf;
    }
    public String getIdTipoAula() {
      return idTipoAula;
    }
    public void setIdTipoAula(String idTipoAula) {
      this.idTipoAula = idTipoAula;
    }
    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public String getHorario() {
      return horario;
    }
    public void setHorario(String horario) {
      this.horario = horario;
    }
    public String getLocal() {
      return local;
    }
    public void setLocal(String local) {
      this.local = local;
    }
    public int getCapacidade() {
      return capacidade;
    }
    public void setCapacidade(int capacidade) {
      this.capacidade = capacidade;
    }
    public String getAlunoCpf() {
      return alunoCpf;
    }
    public void setAlunoCpf(String alunoCpf) {
      this.alunoCpf = alunoCpf;
    }
    public String getProfessorCpf() {
      return professorCpf;
    }
    public void setProfessorCpf(String professorCpf) {
      this.professorCpf = professorCpf;
    }
   
    
}