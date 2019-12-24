package br.com.tardeli.modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@XmlRootElement(name = "projeto")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@XmlType(propOrder = {"codigo", "nome", "aprovado", "apresentado"})
public class Projeto{

    private Long codigo;
    private String nome;
    private boolean aprovado;
    private boolean apresentado;
    

 

}
