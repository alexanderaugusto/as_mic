/**
 * Arquitetura AS-MIC
 *
 * @author Alexander Augusto Silva Fernandes
 * @author Vanessa Swerts Esteves
 * @version 1.0
 *
 */
package as_mic;

public class AS_MIC {

    public static void main(String[] args) {
        // Instanciando objeto do tipo MainMemory (Memória Principal)
        MainMemory mainMemory = new MainMemory();
        // Instanciando objeto do tipo CacheMemory (Memória Cache)
        CacheMemory cacheMemory = new CacheMemory();
        // Instanciando objeto do tipo Processor (Processador)
        Processor processor = new Processor();

        while (processor.pc < mainMemory.mainMemory.length && mainMemory.mainMemory[processor.pc] != null) {
            boolean isValid = cacheMemory.isValid();
            
            if (isValid) {
                if (processor.pc < cacheMemory.tag) {
                    System.out.println("\nCache Hit!");
                    processor.aluExec(cacheMemory.cache[processor.pc - (cacheMemory.tag - 4)]); 
                } else {
                    System.out.println("\nCache Miss!");
                    cacheMemory.tag = processor.pc + 4;
                    cacheMemory.getDataForMainMemory(mainMemory);
                    processor.aluExec(cacheMemory.cache[processor.pc - (cacheMemory.tag - 4)]);
                }
            } else {
                System.out.println("\nCache Miss!");
                cacheMemory.tag = processor.pc + 4;
                cacheMemory.getDataForMainMemory(mainMemory);
                processor.aluExec(cacheMemory.cache[processor.pc - (cacheMemory.tag - 4)]);
            }

            // Busca proxima instrução
            processor.pc = processor.pc + 1;
        }
    }

}
