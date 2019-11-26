package as_mic;

/**
 *                                - Classe CacheMemory - 
 * A classe CacheMemory cria a memória cache da Arquitetura AS-MIC, armazenando as instruções a serem executadas.
 *
 */

public class CacheMemory {
    // Atributos
    public int tag;
    public String data;
    public boolean valid = false;
    // Memória Cache
    String[]cache = new String[4];
    
    /**
     * - Método isValid -
     * Este método é responsável por conferir se a memória cache está vazia ou não. 
     * @return um valor booleano, no qual true representa que a memória não está vazia.  
     */
    public  boolean isValid(){
        for(int i=0; i<cache.length; i++){
            if(cache[i] != null)
            {
                this.valid = true;
                break;
            }       
        }
        
        return valid;
    }
    /**
     * - Método getDataForMainMemory -
     * Este método é responsável por busca o bloco de instruções da memória principal. 
     * @param mainMemory 
     */
    public void getDataForMainMemory(MainMemory mainMemory){
        System.out.println("Buscando da memória principal...");
        for(int i=0; i<cache.length; i++){
            cache[i] = mainMemory.mainMemory[(tag-4)+i];
        }
    }
}
