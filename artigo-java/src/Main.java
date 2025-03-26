import java.util.*;

public class Main {
    public static void main(String[] args) {
        //AdicionarEPercorrerPilha();

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n=== TESTE " + i + " ===");
            IntersecaoEntreColecoes();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void AdicionarEPercorrerPilha(){
        System.out.println("Teste: Adicionar Itens e Percorrer Pilha");
        System.out.println("\n=== Iniciando ===");

        Runtime runtime = Runtime.getRuntime();
        //cálcula memória sendo utilizada atualmente pela máquina virtual do Java - a quantidade de memória disponível no JVM
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tempoInicio = System.nanoTime();

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

        System.out.println("Memória Atual: " + memoriaAntes);
        System.out.println("Tempo atual: " + tempoInicio + " ns");

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

    public static void IntersecaoEntreColecoes(){
        System.out.println("\n \n ** Teste: Intersecção entre de duas coleções ** ");
        System.out.println("=== Iniciando ===");


        // Criando os conjuntos A, B, C, D
        Set<Integer> A = new HashSet<>(gerarLista(1_000, 1_500)); // Elementos únicos entre 1 e 1.500
        Set<Integer> B = new HashSet<>(gerarLista(500_000, 500_000)); // Elementos únicos entre 1 e 10.000
        Set<Integer> C = new HashSet<>(gerarLista(100, 200)); // Elementos entre 1 e 200
        Set<Integer> D = new HashSet<>(gerarLista(500, 1_000)); // Elementos entre 1 e 1.000


        // Interseção A ⋂ B
        medirInterseccao(A, B, "A ⋂ B");

        // Interseção B ⋂ A
        medirInterseccao(B, A, "B ⋂ A");

        // Interseção C ⋂ D
        medirInterseccao(C, D, "C ⋂ D");

        // Interseção D ⋂ C
        medirInterseccao(D, C, "D ⋂ C");

    }

    // Método para medir interseções e imprimir tempo/memória
    private static void medirInterseccao(Set<Integer> conjunto1, Set<Integer> conjunto2, String nome) {

        Runtime runtime = Runtime.getRuntime();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tempoInicio = System.nanoTime();

        Set<Integer> intersecao = new HashSet<>(conjunto1);
        intersecao.retainAll(conjunto2);

        long memoriaDepoisInterseccao = runtime.totalMemory() - runtime.freeMemory();
        long tempoInterseccaoFim = System.nanoTime();

        System.out.println("Nome,Memória Inicial (bytes),Tempo Inicial (ns),Memória Final (bytes),Tempo Final (ns),Elementos Encontrados");
        System.out.println(nome + "," + memoriaAntes + "," + tempoInicio + "," + memoriaDepoisInterseccao + "," + tempoInterseccaoFim + "," + intersecao.size());
    }


    // Método para gerar listas aleatórias sem repetição
    private static List<Integer> gerarLista(int tamanho, int limite) {
        Random random = new Random();
        Set<Integer> conjunto = new HashSet<>();
        while (conjunto.size() < tamanho) {
            conjunto.add(random.nextInt(limite) + 1);
        }
        return new ArrayList<>(conjunto);
    }
}