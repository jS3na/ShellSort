import java.util.Scanner;
import java.util.Random;
import java.util.Stack;

class ShellsortAtiv {

    public static int tamVet;
    public static int h;
    public static int temp, op;

    public static Scanner scan = new Scanner(System.in);

    public static void ShellsortVetor() {
        Random escolha = new Random();

        int listaNum[] = new int[tamVet];

        for (int i = 0; i < tamVet; i++) {
            listaNum[i] = escolha.nextInt(100) + 1;
        }

        h = 1;

        while (h <= tamVet / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            for (int i = h; i < tamVet; i++) {

                temp = listaNum[i];
                int temp2 = i;

                while (temp2 >= h && listaNum[temp2 - h] > temp) {
                    listaNum[temp2] = listaNum[temp2 - h];
                    temp2 -= h;
                }

                listaNum[temp2] = temp;
            }

            h /= 3;
        }

        for (int i : listaNum) {
            System.out.println(i);
        }
    }

    public static void ShellsortStack() {
        Stack<Integer> shellStack = new Stack<>();

        for (int s = 0; s < tamVet; s++) {
            System.out.printf("Digite o %d número da pilha: ", s + 1);
            shellStack.push(scan.nextInt());
        }

        System.out.println(shellStack);

        h = 1;

        while (h <= tamVet / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            Stack<Integer> shellStackTEMP = new Stack<>();

            for(int i = 0; i<tamVet; i++) shellStackTEMP.push(shellStack.pop());


            

        System.out.println(shellStack);
    }

  //public static void Shellsort


    public static void main(String[] args) {

        System.out.println("Escolha o que deseja fazer com o método de ordenação ShellSort:\n1 - Ordenação de um VETOR aleatório\n2 - Ordenação de uma STACK");
        op = scan.nextInt();

        switch (op) {

            case 1:
                while (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12) {
                    System.out.println("Selecione o tamanho do Vetor:\n4\n6\n10\n12");
                    tamVet = scan.nextInt();

                    if (tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12)
                        System.out.println("Opção inválida!Digite novamente!\n");
                }
                ShellsortVetor();
                break;

            case 2:

                while(tamVet<4){
                    System.out.println("Selecione o tamanho da Stack (4 mín.)");
                    tamVet = scan.nextInt();

                    if(tamVet < 4){
                        System.out.println("Tamanho inválido! Digite novamente\n");
                    } 
                }

                ShellsortStack();
                break;

        }
    }
}
