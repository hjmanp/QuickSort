import java.util.Random;

public class QuickSortPruebas {

    // Método principal de Quick Sort
    public static void quickSort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            // Obtener el índice de partición (Pivote y Partición)
            int pi = particion(arr, bajo, alto);

            // Ordenar elementos antes y después de la partición recursivamente
            quickSort(arr, bajo, pi - 1);
            quickSort(arr, pi + 1, alto);
        }
    }

    // Mecánica: Particiona la lista alrededor de un pivote
    private static int particion(int[] arr, int bajo, int alto) {
        int pivote = arr[alto]; 
        int i = (bajo - 1); 

        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Escenarios de prueba para Quick Sort (n log n)
        // Usamos valores más grandes porque Quick Sort es muy rápido
        int[] escenarios = {10000, 50000, 100000, 200000};
        
        System.out.println("\n--- PRUEBA DE RENDIMIENTO: QUICK SORT ---");
        System.out.println("n (Elementos)\t|\tTiempo (ms)");
        System.out.println("---------------------------------------");

        for (int n : escenarios) {
            int[] datos = generarArregloAleatorio(n);

            long inicio = System.currentTimeMillis();
            quickSort(datos, 0, datos.length - 1);
            long fin = System.currentTimeMillis();

            System.out.println(n + "\t\t|\t" + (fin - inicio));
        }
        System.out.println("---------------------------------------\n");
    }

    private static int[] generarArregloAleatorio(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(1000000);
        }
        return arr;
    }
}