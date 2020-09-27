package cadastro.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private String nome;
    private Sexo sexo;
    private LocalDate dataDeNasc;
    private String responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNasc() {
        return formatarData(dataDeNasc);
    }

    public void setDataDeNasc(LocalDate dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public String getSexo() {
        return sexo.getDescricao();
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + getNome() + '\'' +
                ", dataDeNasc=" + getDataDeNasc() +
                ", sexo=" +  sexo.getDescricao() +
                ", responsavel='" + getResponsavel() + '\'' +
                '}';
    }
    public String  formatarData(LocalDate data){
        if(data != null){
            String dataFormatada;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return dataFormatada = data.format(formatter);
        }
        return null;
    }

//    public void setSexo(String value) {
//        this.sexo = Sexo.valueOf(value);
//    }
}
