package as_mic;

import instructions.Const;
import instructions.Reg;
/**
 * - Classe Processador - A classe processador é responsável pelo controle de execução das intruções. 
 *
 * A arquitetura possui o registrador PC (Contador de Programa), que é
 * responsável por indicar a próxima instrução a ser executada.
 *
 */

public class Processor {

    // Registrador especifico PC
    int pc;
    Registers registers = new Registers();  
    
    public void aluExec(String instruction) {
        // Printando a instrução que será executada
        System.out.println("Instrução a ser executada: " + instruction);
        
        // A varivável op irá receber os 8 primeiros números da instrução (OP é de 8bits)  
        String op = instruction.substring(0, 8);

        // Verificação do tipo de OP para determina o tipo da instrução. 
        if (op.equals("00000000")) {
            // Separando a instrução em seus respectivos numeros de bits
            String dest = instruction.substring(8, 13);
            String var1 = instruction.substring(13, 18);
            String var2 = instruction.substring(18, 23);
            String func = instruction.substring(23, 32);

            // Instanciando objeto do tipo Reg
            Reg reg = new Reg(dest, var1, var2, func, this.registers);
        } else {
            String dest = instruction.substring(8, 13);
            String var = instruction.substring(13, 18);
            String cte = instruction.substring(18, 32);

            // Instanciando objeto do tipo Const
            Const constante = new Const(op, dest, var, cte, this.registers);
        }
        
        this.printResults();
    }
    
    public void printResults(){
        // Printando os valores armazenados nos registradores
        System.out.println("Registradores: ");
        System.out.println("AS0 = " + registers.load("00000"));
        System.out.println("AS1 = " + registers.load("00001"));
        System.out.println("AS2 = " + registers.load("00010"));
        System.out.println("AS3 = " + registers.load("00011"));
        System.out.println("AS4 = " + registers.load("00100"));
        System.out.println("AS5 = " + registers.load("00101"));
        System.out.println("AS6 = " + registers.load("00110"));
        System.out.println("AS7 = " + registers.load("00111"));
    }
}
