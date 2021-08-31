public class OrderArray {
    public static void main(String[] args) {
        int[] array = {5,1,2,7,2,4,9,0,1};
        int i = 0;
        int store;
        boolean check = true;
        do{
            if(array[i] > array[i + 1]) {
                store = array[i];
                array[i] = array[i+1];
                array[i+1] = store;
                i = 0;
                check = false;
            }else
                i++;

            if ((i + 1) == array.length) {
                check = true;
            }

        }while(!check);

        for (int j : array) {
            System.out.println(j);
        }
    }
}
