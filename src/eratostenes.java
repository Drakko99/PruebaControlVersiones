/*
clase para generar todos los numeros primos desde 1 hasta un numero maximo especificado por el usuario. como algoritmo se usa la criba de eratostenes

el algoritmo es bastante simple, dado in vector de enteros empezando en 2, se tachan todos los multiplos de 2, a contiuacion se encuentra el siguiente entero no tachado y se tachan todos sus multiplos. el proceso se repite hasta que se pasa de la raiz cuadrada del valor maximo. todos los numeros que queden sintachar son numeros primos.
*/

/*
ESTE ES OTRO CAMBIO EN EL CODIGO
*/

public class eratostenes {
    /**
     * generar numeros primos de 1 a max
     * @param max es el valor maximo
     * @return vector de numeros primos
     */
    private static boolean esPrimo[];
    private static int primos[];
    
    private static void inicializarCriba (int max){
        //declaraciones
            int i;
            esPrimo = new boolean[esPrimo.length];
            //inicializar el array
            for(i=0; i<esPrimo.length; i++)
                esPrimo[i] = true;
            // eliminamos el 0 y el 1 que no son primos
            esPrimo[0]=esPrimo[1]= false;
    }
     private static void eliminarMultiplos() {
        //criba
        int i,j;
        for (i=2; i<Math.sqrt(esPrimo.length); i++){
            if(esPrimo[i]){
                //eliminamos los multiplos de i
                for (j=2*i; j<esPrimo.length; j+=i){
                    esPrimo[j]=false;
                }
            }
        }
    }
      private static int[] obtenerCandidatosNoEliminados() {
        int j,i;
        //cuantos primos hay
        int cuenta=0;
        for (i=0; i<esPrimo.length; i++){
            if (esPrimo[i])
                cuenta++;
        }
        //rellenamos el vector de numeros primos
        int[] primos =new int [cuenta];
        for (i=0, j=0; i<esPrimo.length; i++){
            if (esPrimo[i])
                primos [j++]=i;
        }
        return primos;
    }
    public static int [] generarPrimos (int max){
        inicializarCriba(max);
        int i,j;
        if (max>=2){
            
            eliminarMultiplos();
                int[] primos=obtenerCandidatosNoEliminados();
            return primos;
            
        }else{ //el numero max es menor que dim
            return new int [0];//vector vacio
        }
    }  
}
