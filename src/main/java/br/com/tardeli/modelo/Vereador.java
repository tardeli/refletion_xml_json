package br.com.tardeli.modelo;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@XmlRootElement(name = "vereador")
public class Vereador extends Pessoa{

    private Date dataAssociacao;
    private Partido partido;
    private float desempenho;
    private Projetos projetos = new Projetos();

    public Vereador(Date dataAssociacao, Partido partido, Long codigo, String nome) {
        super(codigo, nome);
        this.dataAssociacao = dataAssociacao;
        this.partido = partido;
    }

    public int qtdeProjetosApresentados() {
        int aux = 0;
        for (Projeto projeto : projetos.projeto) {
            if(projeto.isApresentado()){
                aux++;
            }
        }
        return aux;
    }

    public int qtdeProjetosAprovados() {
        int aux = 0;
        for (Projeto projeto : projetos.projeto) {
            if(projeto.isAprovado()){
                aux++;
            }
        }
        return aux;
    }

    public void adicionaProjeto(Projeto projeto) {
        this.getProjetos().getProjeto().add(projeto);
        this.desempenho = desempenho();
    }

    public float desempenho() {
        if(qtdeProjetosAprovados()!=0 && qtdeProjetosApresentados()!=0 ){
            return (float) qtdeProjetosAprovados() / qtdeProjetosApresentados() * 100;
        }
        return 0;
    }

    @Override
    String getTipo() {
        return "Vereador";
    }

    public String projetos() {
        NumberFormat numberFormat = new DecimalFormat("0.00");
        String dados = "";
        for (Projeto projeto : projetos.projeto) {          
            dados += "\n  Projeto{" + "codigo=" + projeto.getCodigo() + ", nome=" + projeto.getNome() + ", aprovado=" + projeto.isAprovado() + ", apresentado=" + projeto.isApresentado() + '}';
        }
        dados += "]";
        dados += "\n    QTDE de projetos apresentados: "+qtdeProjetosApresentados();
        dados += "\n    QTDE de projetos aprovados: "+qtdeProjetosAprovados();
        dados += "\n    DESEMPENHO: "+numberFormat.format(desempenho())+"%";
        dados += ")";
        dados += "\n===============================================================================================================================";
        return dados;
    }

    @Override
    public String toString() {
        return super.toString() + ", dataAssociacao=" + dataAssociacao + ", partido=" + partido + ", Projetos [" + projetos();
    }

}
