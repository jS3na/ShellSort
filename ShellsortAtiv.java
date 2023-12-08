import java.util.Scanner;
import java.util.Random;
import java.util.Stack;
import java.util.LinkedList;

class ShellsortAtiv {

    public static int tamVet;
    public static int h;
    public static int temp, temp2, op;

    public static Scanner scan = new Scanner(System.in);

    public static void ShellsortVetor() {
        Random escolha = new Random();

        int shellVetor[] = new int[tamVet];

        for (int i = 0; i < tamVet; i++) shellVetor[i] = escolha.nextInt(100) + 1;

        System.out.print("VETOR GERADO: ");
        for (int i = 0; i < tamVet; i++) {
            System.out.print(shellVetor[i] + " ");
        }
        System.out.println();

        h = 1;

        while (h <= tamVet / 3) h = h * 3 + 1;

        while (h > 0) {

            for (int i = h; i < tamVet; i++) {

                temp = shellVetor[i];
                temp2 = i;

                while (temp2 >= h && shellVetor[temp2 - h] > temp) {
                    shellVetor[temp2] = shellVetor[temp2 - h];
                    temp2 -= h;
                }

                shellVetor[temp2] = temp;
            }

            h /= 3;
        }

        System.out.print("VETOR ORDENADO: ");
        for (int i = 0; i < tamVet; i++) {
            System.out.print(shellVetor[i] + " ");
        }
        System.out.println();
    }

    public static void ShellsortStack() {
        Stack<Integer> shellStack = new Stack<>();
        int[] shellStackTEMP = new int[tamVet];

        for (int s = 0; s < tamVet; s++) {
            System.out.printf("Digite o %d número da pilha: ", s + 1);
            shellStack.push(scan.nextInt());
        }

        System.out.println("STACK INFORMADA: "+shellStack);

        h = 1;

        while (h <= tamVet / 3) h = h * 3 + 1;

        int indice2 = 0;
        while(!shellStack.isEmpty()){
            shellStackTEMP[indice2++] = shellStack.pop();
        }

        while (h > 0) {

            for (int i = h; i < tamVet; i++) {
                int temp = shellStackTEMP[i];
                int j = i;
    
                while (j >= h && shellStackTEMP[j - h] > temp) {
                    shellStackTEMP[j] = shellStackTEMP[j - h];
                    j -= h;
                }
    
                shellStackTEMP[j] = temp;
            }

            h/=3;
            
        }

        for (int i : shellStackTEMP) {
            shellStack.push(i);
        }    
        
        System.out.println("STACK ORDENADA: "+shellStack);

}

public static void ShellsortLinkedList() {
    LinkedList<Integer> shellList = new LinkedList<>();

    for (int s = 0; s < tamVet; s++) {
        System.out.printf("Digite o %d número da lista encadeada: ", s + 1);
        shellList.add(scan.nextInt());
    }

    System.out.println("LISTA ENCADEADA INFORMADA: " + shellList);

    h = 1;

    while (h <= tamVet / 3) h = h * 3 + 1;

    Object[] array = shellList.toArray();

    while (h > 0) {
        for (int i = h; i < tamVet; i++) {
            Object temp = array[i];
            int j = i;

            while (j >= h && ((int) array[j - h]) > (int) temp) {
                array[j] = array[j - h];
                j -= h;
            }

            array[j] = temp;
        }

        h /= 3;
    }

    shellList.clear();
    for (Object item : array) {
        shellList.add((int) item);
    }

    System.out.println("LISTA ENCADEADA ORDENADA: " + shellList);
}


    public static void main(String[] args) {

        boolean sair = false;

        while(!sair){
            System.out.println("\nEscolha o que deseja fazer com o método de ordenação ShellSort:\n1 - Ordenação de um VETOR aleatório\n2 - Ordenação de uma STACK\n3 - Ordenação de um LINKED LIST\n4 - Sair");
            op = scan.nextInt();

            switch (op) {

                case 1:

                    tamVet = 0;
                    while (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12) {
                        System.out.println("Selecione o tamanho do Vetor:\n4\n6\n10\n12");
                        tamVet = scan.nextInt();

                        if (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12)
                            System.out.println("Opção inválida!Digite novamente!\n");
                    }
                    ShellsortVetor();
                    break;

                case 2:

                    tamVet = 0;
                    while(tamVet<4){
                        System.out.println("Selecione o tamanho da Stack (4 mín.)");
                        tamVet = scan.nextInt();

                        if(tamVet < 4) System.out.println("Tamanho inválido! Digite novamente\n");
                    }

                    ShellsortStack();
                    break;

                case 3: 

                    tamVet = 0;
                    while(tamVet<4){
                            System.out.println("Selecione o tamanho da Stack (4 mín.)");
                            tamVet = scan.nextInt();

                            if(tamVet < 4) System.out.println("Tamanho inválido! Digite novamente\n");
                        }

                        ShellsortLinkedList();
                        break;

                case 4:

                    System.out.println("Saindo do programa...");
                    sair = true;
                    break;

                }

        }
    }
}
