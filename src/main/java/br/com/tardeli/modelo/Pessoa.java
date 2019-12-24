package br.com.tardeli.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Pessoa{

    private Long codigo;
    private String nome;
    
    String getTipo(){
        return "Pessoa";
    }

    @Override
    public String toString() {
        return getTipo() +"(codigo = "+codigo+ ", nome = "+nome;
    }
    
    

}
