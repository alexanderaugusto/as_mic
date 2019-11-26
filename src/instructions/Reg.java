package instructions;

import as_mic.Registers;

/**
 *
 *                             - Classe Reg -
 * A classe Reg é responsável por decodicar e realizar as operações das instruções do tipo Reg, que são caracterizadas
 * por operações entre dois registradors. Este tipo de instrução contém 5 campos, sendo eles: 
 *          - op(op-code) que indica ao processador qual instrução ele irá executar e possui tamanho de 8bits;
 *          - dest que indica o registrador responsável por armazenar o resultado da operação e possui tamanho de 5bits;
 *          - var1 que indica o primeiro registrador da operação em 5bits;
 *          - var2 que indica o segundo registrador da operação em 5bits;
 *          - func que indica o tipo de operação a ser executada e possui tamanho de 9bits.
 * 
 */


public class Reg {
    // Atributos
    public final String op = "00000000";
    public String dest;
    public String var1;
    public String var2;
    public String func;
    public Registers memoryRegister = new Registers();

    /**
     * Cosntrutor Reg realiza a atribuição dos parâmetros a serem decodificados. 
     * 
     * @param dest
     * @param var1
     * @param var2
     * @param func
     * @param memoryRegister 
     */
    public Reg(String dest, String var1, String var2, String func, Registers memoryRegister) {
        this.dest = dest;
        this.var1 = var1;
        this.var2 = var2;
        this.func = func;
        this.memoryRegister = memoryRegister;
        
        // Define a operação a ser realizada de acordo com o func
        if (func.equals("000010001")) {
            this.soma();
        } else if (func.equals("000100010")) {
            this.mult();
        }
    }
    
    /**
     * Método responsável por realizar a operação soma. 
     * Este método chama os métodos load e store da Classe Registers.
     */
    public void soma() {
        // Realiza a operação, após buscar na memória o valor armazenador na posição var1 e var2;
        Integer value = memoryRegister.load(var1) + memoryRegister.load(var2);
        // Salva na memória, na posição indicada por dest, o valor da operação.
        memoryRegister.store(dest, value);
    }
    
    /**
     * Método responsável por realizar a operação mult. 
     * Este método chama os métodos load e store da Classe Registers.
     */
    public void mult() {
        Integer value = memoryRegister.load(var1) * memoryRegister.load(var2);
        memoryRegister.store(dest, value);
    }
}
