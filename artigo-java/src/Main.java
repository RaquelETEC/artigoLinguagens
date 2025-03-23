import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdicionarEPercorrerPilha();

    }

    public static void AdicionarEPercorrerPilha(){
        System.out.println("Teste: Adicionar Itens e Percorrer Pilha");
        System.out.println("\n=== Iniciando ===");

        Runtime runtime = Runtime.getRuntime();

        //cálcula memória sendo utilizada atualmente pela máquina virtual do Java - a quantidade de memória disponível no JVM
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tempoInicio = System.nanoTime();

        System.out.println("Memória Atual: " + memoriaAntes);
        System.out.println("Tempo atual: " + tempoInicio + " ns");

        Stack<Integer> pilha = new Stack<>();
        for (int i = 0; i < 10000; i++) {
            pilha.push(i);
        }
        while (!pilha.isEmpty()) {
            pilha.pop();
        }

        // Captura o tempo e a memória após a execução
        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long tempoFim = System.nanoTime();

        System.out.println("\n=== Finalizando  ===");
        System.out.println("Memória Final: " + memoriaDepois + " bytes");
        System.out.println("Tempo Final: " + tempoFim + " ns");

        // Calcula os totais
        long tempoTotal = tempoFim - tempoInicio;
        long memoriaConsumida = memoriaDepois - memoriaAntes;

        System.out.println("\n---- RESULTADOS ----");
        System.out.println("Tempo Total: " + tempoTotal + " ns");
        System.out.println("Memória Consumida: " + memoriaConsumida + " bytes");
    }
}