public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int store;
        int j;
        for(int i = 0; i < array.length>>1; i++){
            j = 1 + i;
            store = array[i]; 
            array[i] = array[array.length -j];
            array[array.length -j] = store;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }
}
