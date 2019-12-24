package br.com.tardeli.json;

import br.com.tardeli.modelo.Vereador;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class Executar_From_Json {

    public static void main(String[] args) {
        Gson gson = new Gson();

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("vereador.json") );

            Vereador[] vereadorArray = gson.fromJson(bufferedReader, Vereador[].class);

            for (Vereador vereador : vereadorArray) {
                System.out.println(vereador.toString());
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
