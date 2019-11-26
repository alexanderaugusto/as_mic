package as_mic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *                           - Classe Registers - 
 * A classe Registers é responsável por determinar e manipular os registardores na memória. 
 * 
 * A arquitetura AS-MIC é composta por 8 registradores de uso geral determinados com 5 bits, sendo eles:
 *                               AS0 - 00000
 *                               AS1 - 00001
 *                               AS2 - 00010
 *                               AS3 - 00011
 *                               AS4 - 00100
 *                               AS5 - 00101
 *                               AS6 - 00110
 *                               AS7 - 00111
 * e 3 registradores temporários, também determinados com 5bits:
 *                               temp0 - 01000
 *                               temp1 - 01001
 *                               temp2 - 01010
 *  
 */
public class Registers { 
    // Pedaço da memória para armazenar os registadores, o acesso é por meio de uma chave. 
    // A chave é o valor em 5bits que representa o registrador, por exemplo: A chave de AS0 = "00000"
    public Map<String, Integer> registerMemory = new HashMap<String, Integer>();

    public Registers(){
        // Registradores de uso geral
        registerMemory.put("00000", 5);  // AS0
        registerMemory.put("00001", 10); // AS1
        registerMemory.put("00010", 5);  // AS2
        registerMemory.put("00011", 3);  // AS3
        registerMemory.put("00100", 24); // AS4
        registerMemory.put("00101", 33); // AS5
        registerMemory.put("00110", 45); // AS6
        registerMemory.put("00111", 1);  // AS7
        
        // Registradores temporarios
        registerMemory.put("01000", 0); // temp0 
        registerMemory.put("01001", 0); // temp1
        registerMemory.put("01010", 0); // temp2
    }
    
    /**
     * - Método Load -
     * O método load é responsável por buscar na memória o dado armazenado na posição em que a chave é igual ao valor passado por parâmetro.    
     * @param key  
     * @return o dado armazenado na memoria 
     */
    public Integer load(String key){
        
        return registerMemory.get(key);
    }
    /**
     * - Método Store -
     * O método store é responsável por armazenar o parâmetro value na posição da memória em que a chave é igual ao parâmetro key 
     * @param key
     * @param value 
     */
    public void store(String key, int value){
        registerMemory.put(key, value);
    }
    
}
