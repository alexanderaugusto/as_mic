package as_mic;

import java.util.ArrayList;

/**
 *                      - Classe MainMemory - 
 * A classe MainMemory cria a memória da Arquitetura AS-MIC, armazenando as instruções a serem executadas.
 *
 */
public class MainMemory {

    // Memória Principal
    String[] mainMemory = new String[16];

    // "Busca os dados" da memória secundária
    public MainMemory() {
        // Instruções iniciais (A gente que escolheu)
        mainMemory[0] = "00010111000000000100000001000000"; // somai AS0, AS1, 64 ----> Resp = 74
        mainMemory[1] = "00000000000010000100010000100010"; // mult AS1, AS1, AS2 ----> Resp = 50
        mainMemory[2] = "00000000000000000000001000010001"; // soma AS0, AS0, AS1 ----> Resp = 124
        mainMemory[3] = "00010011000100001100000000010000"; // multi AS2, AS3, 16 ----> Resp = 48
        mainMemory[4] = "00100101001110000100000000000100"; // load AS7, 4(AS1)   ----> Resp = 33
        mainMemory[5] = "00100111001100000100000000000100"; // store AS6,4(AS1)   ----> Resp = 45
        mainMemory[6] = "00000000001000010100111000010001"; // soma AS4, AS5,AS7  ----> Resp = 78
        mainMemory[7] = "00010011000000000100000000000000";// multi AS0, AS1, 0   ----> Resp = 0
        mainMemory[8] = "00100111001000000000000000000110";// store AS4, 6(AS0)    ----> Resp = 78 
               

    }
}
