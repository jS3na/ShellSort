import java.util.Scanner;
import java.util.Random;
import java.util.Stack;
import java.util.LinkedList;

class ShellsortAtiv {

    //variáveis globais
    public static int tamVet;
    public static int h;
    public static int temp, temp2, op;

    public static Scanner scan = new Scanner(System.in);

    //função para organizar um VETOR usando o algoritmo Shellsort
    public static void ShellsortVetor() {
        Random escolha = new Random();

        //criação e validação do vetor com números aleatórios
        int shellVetor[] = new int[tamVet];
        for (int i = 0; i < tamVet; i++) shellVetor[i] = escolha.nextInt(100) + 1;

        //impressão do vetor gerado
        System.out.print("\nVETOR GERADO: ");
        for (int i = 0; i < tamVet; i++) System.out.print(shellVetor[i] + " ");
        System.out.println();

        //inicialização da "condição de parada" do shellsort
        h = 1;

        //cálculo do h máximo
        while (h <= tamVet / 3) h = h * 3 + 1;

        //aplicação do shellsort para organizar o VETOR
        while (h > 0) {

            for (int i = h; i < tamVet; i++) {

                //armazenando temporariamente o vetor que vai ser comparado
                temp = shellVetor[i];
                temp2 = i;

                while (temp2 >= h && shellVetor[temp2 - h] > temp) {
                    //movimenta os elementos para a posição correta, usando a lógica do shellsort
                    shellVetor[temp2] = shellVetor[temp2 - h];
                    temp2 -= h;
                }

                //coloca o elemento temporário na posição certa
                shellVetor[temp2] = temp;
            }

            h /= 3;
        }

        System.out.print("VETOR ORDENADO: ");
        for (int i = 0; i < tamVet; i++) System.out.print(shellVetor[i] + " ");
        System.out.println();
    }

    //método responsável por ordenar uma pilha(stack) usando o algoritmo shellsort
    public static void ShellsortStack() {

        //criação da pilha original e de um vetor temporário para armazenar os elementos
        Stack<Integer> shellStack = new Stack<>();
        int[] shellStackTEMP = new int[tamVet];

        //preenche a pilha com números que o usuário digita
        for (int s = 0; s < tamVet; s++) {
            System.out.printf("Digite o %d número da pilha: ", s + 1);
            shellStack.push(scan.nextInt());
        }

        System.out.println("\nSTACK INFORMADA: "+shellStack);

        h = 1;

        while (h <= tamVet / 3) h = h * 3 + 1;

        //popula o vetor temporário com os números que o usuário digitou na stack
        int indice2 = 0;
        while(!shellStack.isEmpty()) shellStackTEMP[indice2++] = shellStack.pop();

        while (h > 0) {

            for (int i = h; i < tamVet; i++) {
                int temp = shellStackTEMP[i];
                int j = i;
    
                //loop para comparar e mover elementos, usando a lógica do shellsort
                while (j >= h && shellStackTEMP[j - h] > temp) {
                    shellStackTEMP[j] = shellStackTEMP[j - h];
                    j -= h;
                }
    
                //coloca o número temporário na posição correta da stack original
                shellStackTEMP[j] = temp;
            }

            h/=3;
            
        }

        //popula a pilha original com os número já ordenadors do vetor temporário
        for (int i : shellStackTEMP) shellStack.push(i);

        System.out.println("STACK ORDENADA: "+shellStack);

}

//método usado para ordenar uma lista encadeada(LinkedList) usando shellsort
public static void ShellsortLinkedList() {
    //criação de uma LinkedList para armazenar os elementos a serem ordenados
    LinkedList<Integer> shellList = new LinkedList<>();

    for (int s = 0; s < tamVet; s++) {
        System.out.printf("Digite o %d número da lista encadeada: ", s + 1);
        shellList.add(scan.nextInt());
    }

    System.out.println("\nLISTA ENCADEADA INFORMADA: " + shellList);

    h = 1;

    while (h <= tamVet / 3) h = h * 3 + 1;

    //converte a LinkedList para um vetor de inteiros (não consigo me lembrar pq usei esse vetor assim ao invés de um int normal, mas funcionou)
    Integer[] shellListTEMP = shellList.toArray(new Integer[0]);

    while (h > 0) {
        for (int i = h; i < tamVet; i++) {
            Integer temp = shellListTEMP[i];
            int j = i;

            //loop para comparar e mover elementos, usando a lógica do shellsort
            while (j >= h && shellListTEMP[j - h] > temp) {
                shellListTEMP[j] = shellListTEMP[j - h];
                j -= h;
            }

            //coloca o número temporário na posição correta no linkedlist temporário
            shellListTEMP[j] = temp;
        }

        h /= 3;
    }

    //limpa a lista original e preenche ela do início, trazendo os números do vetor temporário
    shellList.clear();
    for (Integer item : shellListTEMP) shellList.add(item);

    System.out.println("LISTA ENCADEADA ORDENADA: " + shellList);
}


    //principal  
    public static void main(String[] args) {

        //variável criada para o jogador poder escolher entre sair ou continuar jogando
        boolean sair = false;

        //loop principal
        while(!sair){
            //menu e opção do usuário
            System.out.println("\nEscolha o que deseja fazer com o método de ordenação ShellSort:\n1 - Ordenação de um VETOR aleatório\n2 - Ordenação de uma STACK\n3 - Ordenação de um LINKED LIST\n4 - Sair");
            op = scan.nextInt();

            //switch usado para agir de acordo com a escolha do usuário
            switch (op) {

                //VETOR (Questão 01)
                case 1:

                    tamVet = 0;
                    while (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12) {
                        System.out.println("\nSelecione o tamanho do Vetor:\n4\n6\n10\n12");
                        tamVet = scan.nextInt();

                        if (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12)
                            System.out.println("Opção inválida! Digite novamente!");
                    }
                    ShellsortVetor();
                    break;

                //STACK (Questão 02)
                case 2:

                    tamVet = 0;
                    while(tamVet<4){
                        System.out.println("\nSelecione o tamanho da Stack (4 mín.)");
                        tamVet = scan.nextInt();

                        if(tamVet < 4) System.out.println("Tamanho inválido! Digite novamente");
                    }

                    ShellsortStack();
                    break;

                //LINKEDLIST (Questão 03)
                case 3: 

                    tamVet = 0;
                    while(tamVet<4){
                            System.out.println("\nSelecione o tamanho do LinkedList (4 mín.)");
                            tamVet = scan.nextInt();

                            if(tamVet < 4) System.out.println("Tamanho inválido! Digite novamente");
                        }

                        ShellsortLinkedList();
                        break;

                //caso o usuário queira sair
                case 4:

                    System.out.println("\nSaindo do programa...");
                    sair = true;
                    break;

                //caso o usuário digite uma opção que não exista no menu
                default:

                    System.out.println("Opção inválida! Digite novamente!");

            }

        }
    }
}
