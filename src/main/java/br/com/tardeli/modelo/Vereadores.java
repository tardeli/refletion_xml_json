package br.com.tardeli.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Vereadores", namespace = "br.com.tardeli.modelo")
public class Vereadores {

    List<Vereador> vereador = new ArrayList<>();
}
