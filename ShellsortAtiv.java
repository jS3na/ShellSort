class ShellsortAtiv {

    public static int tamVet = 4;
    public static int h = 1;
    public static int temp;

    public static void main(String[] args) {

        int listaNum[] = {3, 9, 10, 1};

        while (h <= tamVet / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            for (int i = h; i < tamVet; i++) {

                temp = listaNum[i];
                int j = i;

                while (j >= h && listaNum[j - h] > temp) {
                    listaNum[j] = listaNum[j - h];
                    j -= h;
                }

                listaNum[j] = temp;
            }

            h /= 3;
        }

        for (int i : listaNum) {
            System.out.println(i);
        }
    }
}
