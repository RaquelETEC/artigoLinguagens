import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste: Adicionar Itens e Percorrer Pilha");
        System.out.println("\n=== Iniciando ===");

        Runtime runtime = Runtime.getRuntime();

        //cálcula memória sendo utilizada atualmente pela máquina virtual do Java - a quantidade de memória disponível no JVM
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tempoInicio = System.nanoTime();

        System.out.println("Memória Atual: " + memoriaAntes);
        System.out.println("Tempo atual: " + tempoInicio);

        System.out.println(String.format("Memória inicial: %.2f MB", bytesParaMB(memoriaAntes)));
        System.out.println(String.format("Tempo inicial: %d ns", tempoInicio));


        Stack<Integer> pilha = new Stack<>();
        for (int i = 0; i < 10; i++) {
            pilha.push(i);
        }
        while (!pilha.isEmpty()) {
            pilha.pop();
        }

        // Captura o tempo e a memória após a execução
        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long tempoFim = System.nanoTime();

        System.out.println("\n=== Finalizando  ===");
        System.out.println(String.format("Memória final: %.2f MB", bytesParaMB(memoriaDepois)));
        System.out.println(String.format("Tempo final: %d ns", tempoFim));

        // Calcula os totais
        long tempoTotal = tempoFim - tempoInicio;
        long memoriaConsumida = memoriaDepois - memoriaAntes;

        System.out.println("\n---- RESULTADOS ----");
        System.out.println(String.format("Tempo total: %.3f ms", nanosParaMillis(tempoTotal)));
        System.out.println(String.format("Memória consumida: %.2f MB", bytesParaMB(memoriaConsumida)));

    }

    private static double bytesParaMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

    private static double nanosParaMillis(long nanos) {
        return nanos / 1_000_000.0;
    }
}