public class RotateArray{

//Input : {1,2,3,4,5,6,7}
//Left shift by 2 Output : {3,4,5,6,7,1,2}
//Right Shift by 2 output : {6,7,1,2,3,4,5}


    void leftRotate(int arr[],int d, int length) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr,length);
        }
    }

//store first element, and keep moving elements to next position
//finally store the first element at the last position
    void leftRotateByOne(int arr[], int length) {
        int temp = arr[0];
        for (int i = 0; i < length-1 ; i++) {
            arr[i] = arr[i+1];
        }
        arr[length-1] = temp;
    }

    void printArray (int arr[],int length) {
        for (int i = 0; i< length; i++) {
            System.out.println(arr[i]);
        }
    }

//start from last and keep swapping, until the last comes to first position
    void rightRotate(int arr[], int order,int length) {
        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
     //Driver Program    
    public static void main(String[] args) {
    RotateArray rotate = new RotateArray();
    int arr[] = {1,2,3,4,5,6,7};
    rotate.leftRotate(arr,2,arr.length);
    System.out.println("=======================");
    System.out.println("Left Rotate");
    rotate.printArray(arr,arr.length);
    System.out.println("=======================");
    int arr1[] = {1,2,3,4,5,6,7};
    rotate.rightRotate(arr1,2,arr1.length);
    System.out.println("=======================");
    System.out.println("Right rotate");
    rotate.printArray(arr1,arr1.length);
    System.out.println("=======================");
    }
}
