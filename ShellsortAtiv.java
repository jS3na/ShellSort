import java.util.Scanner;
import java.util.Random;

class ShellsortAtiv {

    public static int tamVet;
    public static int h = 1;
    public static int temp, op;

    public static void ShellsortVetor(){

        Random escolha = new Random();

        int listaNum[] = new int[tamVet];

        for (int i = 0; i < tamVet; i++) {
            listaNum[i] = escolha.nextInt(100) + 1;
        }

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

        System.out.println("\n");

        for (int i : listaNum) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha o que deseja fazer com o método de ordenação ShellSort:\n1 - Ordenação de um VETOR aleatório");
        op = scan.nextInt();

        switch(op){

            case 1:

                while(true){
                    System.out.println("Selecione o tamanho do vetor:\n4\n6\n10\n12");
                    tamVet = scan.nextInt();

                    if(tamVet != 4 && tamVet != 6 && tamVet != 10 && tamVet != 12) System.out.println("Opção inválida!Digite novamente!\n");
                    else {ShellsortVetor(); break;}
                }
    }
    }
}
