package br.com.tardeli.modelo;

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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@XmlRootElement(name = "partido")
@XmlType(propOrder = {"numero", "nome"})
public class Partido{
    private Long numero;
    private String nome;
    
}
