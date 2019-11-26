package instructions;

import as_mic.Registers;

/**
 *
 *                      - Classe Const - 
 * A classe Const é responsável por decodicar e realizar as
 * operações das instruções do tipo const, que são caracterizadas por operações
 * entre um registrador e um valor imediato(constante). Este tipo de instrução
 * contém 4 campos, sendo eles: 
 * 
 * - op(op-code) que indica ao processador qual operação ele irá executar e possui tamanho de 8bits;
 * - dest que indica o registrador responsável por armazenar o resultado da operação e possui tamanho de 5bits; 
 * - var que indica o registrador em 5bits; 
 * - cte que armazena a constante em 14bits.
 *
 */
public class Const {

    //Atributos
    public String op;
    public String dest;
    public String var;
    public String cte;
    public Registers registerBank = new Registers();

    /**
     * Cosntrutor Const realiza a atribuição dos parâmetros a serem
     * decodificados.
     *
     * @param op
     * @param dest
     * @param var
     * @param cte
     * @param memoryRegister
     */
    public Const(String op, String dest, String var, String cte, Registers memoryRegister) {
        this.op = op;
        this.dest = dest;
        this.var = var;
        this.cte = cte;
        this.registerBank = memoryRegister;

        // Define a operação a ser realizada de acordo com o OP
        if (op.equals("00010111")) {
            this.somai();
        } else if (op.equals("00010011")) {
            this.multi();
        } else if (op.equals("00100101")) {
            this.load();
        } else if (op.equals("00100111")) {
            this.store();
        }
    }

    /**
     * Método responsável por realizar a operação somai.
     */
    public void somai() {
        // Registrador temporário
        String temp0 = "01000";
        // Converte o número binário (cte) em número decimal. 
        Integer immediateValue = Integer.parseInt(cte, 2);
        //Salva na memória, na posição indicada por temp0, o valor em decimal calculado. 
        registerBank.store(temp0, immediateValue);
        // Realiza a operação, após buscar na memória o valor armazenador na posição var e temp0;
        Integer value = registerBank.load(var) + registerBank.load(temp0);
        // Salva na memória, na posição indicada por dest, o valor da operação. 
        registerBank.store(dest, value);
    }

    /**
     * Método responsável por realizar a operação multi.
     */
    public void multi() {
        String temp0 = "01000";

        Integer immediateValue = Integer.parseInt(cte, 2);
        registerBank.store(temp0, immediateValue);
        Integer value = registerBank.load(var) * registerBank.load(temp0);
        registerBank.store(dest, value);
    }
    /**
     * Método responsável por realizar a operação load. 
     */
    public void load() {
        String temp0 = "01000";
        Integer immediateValue1 = Integer.parseInt(cte, 2);
        registerBank.store(temp0, immediateValue1);

        String temp1 = "01001";
        Integer immediateValue2 = Integer.parseInt(var, 2);
        registerBank.store(temp1, immediateValue2);
        // Após a soma, converte o número decimal (immediateValue3) em número binário.
        Integer immediateValue3 = immediateValue1 + immediateValue2;
        String binaryValue = Integer.toBinaryString(immediateValue3);
        // Setando o binaryValue em 5bits
        if (binaryValue.length() < 5) {
            if (binaryValue.length() == 1) {
                binaryValue = "0000" + binaryValue;
            } else if (binaryValue.length() == 2) {
                binaryValue = "000" + binaryValue;
            } else if (binaryValue.length() == 3) {
                binaryValue = "00" + binaryValue;
            } else if (binaryValue.length() == 4) {
                binaryValue = "0" + binaryValue;
            }
        }
        
        registerBank.store(dest, registerBank.load(binaryValue));
    }
    /**
     * Método responsável por realizar a operação store.
     */
    public void store() {
        String temp0 = "01000";
        Integer immediateValue1 = Integer.parseInt(cte, 2);
        registerBank.store(temp0, immediateValue1);

        String temp1 = "01001";
        Integer immediateValue2 = Integer.parseInt(var, 2);
        registerBank.store(temp1, immediateValue2);

        String temp3 = "01011";
        Integer immediateValue3 = immediateValue1 + immediateValue2;
        String binaryKey = Integer.toBinaryString(immediateValue3);
        
        if (binaryKey.length() < 5) {
            if (binaryKey.length() == 1) {
                binaryKey = "0000" + binaryKey;
            } else if (binaryKey.length() == 2) {
                binaryKey = "000" + binaryKey;
            } else if (binaryKey.length() == 3) {
                binaryKey = "00" + binaryKey;
            } else if (binaryKey.length() == 4) {
                binaryKey = "0" + binaryKey;
            }
        }
                      
        registerBank.store(binaryKey,registerBank.load(dest));
    }
}
