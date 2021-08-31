public class BinarySearch {
    
    static int[] array = {6,41,7,9,1,2,5,7,93,1};
    public static void main(String[] args) {
        boolean order;

        order = orderCheck();
        if (!order) {
            orderArray();
        }
        int target = 6;
        for (int i : array)
            System.out.println(i);
        // Enter target number in first parameter
        int counter = binarySearchAlg(target);
    }

    private static boolean orderCheck(){
        
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }

        return true;
    }

    private static void orderArray(){
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
    }

    private static int binarySearchAlg(int target, int min, int max){
        int check = (min + max + 1)/2;
        if(array[check] > target)
            min = check;
        if(array[check] < target)
            max = check;
        if (array[check] == target)
            return 1;

        return 1 + binarySearchAlg(target, min, max);
    }

    private static int binarySearchAlg(int target){
        int counter = 0;
        int min = 0;
        int max = array.length-1;
        int i = max / 2;
        while (array[i] != target) {
            if (array[i] < target)
                max = i;
            else
                min = i;
            i = (max + min)/2;
            
            if (counter >= Math.sqrt(array.length) + 1){
                System.out.println("The number is not in the array!");
                System.exit(0);
            }
            counter++;
        }

        return i;
    }
}
