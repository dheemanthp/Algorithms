/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include<math.h>
#include <stdbool.h>

int main()
{
    
    //input array
    //int arr[] = {100,600,1000,1000,200,200,900,300,800,400,700,500,600,600};
    int arr[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4}; 
    //int arr[] = {100,100,200,400,400,500};
    //int arr[] = {1,2,3,4,5};
    //int arr[] = {1,1,1,1,1};
    //int arr[] = {0};
    //length
    int len = sizeof(arr)/sizeof(arr[0]);
    //in place quick sort
    //quickSort(arr,0,len-1);
    
    quicksort_3way(arr,0,len-1);
    //shift the duplicate elements to the end OR
    //retain the unique elements at the beginning of the array
    //custom_shift_unique_elements(arr,len-1);
    //print
    print(arr,len-1);
    return 0;
}


/*
Helper Function : print the array
*/
print(int* arr, int len) {
    for(int i = 0; i <= len ;i ++) {
        printf(" \nthe values are %d\n",arr[i]);
    }
}

// A utility function to print an array 
void printarr(int a[], int n) 
{ 
    for (int i = 0; i < n; ++i) 
        printf("%d  ", a[i]); 
    printf("\n"); 
} 

/*
Helper Function : swap the elements using efficient XOR swap
*/
bool swap(int* arr, int i, int j) {
    if(arr == NULL) return false;
    if( (i == j )||arr[i] == arr[j]) {
        return false;
    }
    //printf(" index %d , and %d\n",i,j);
    //printf(" swap %d , and %d\n",arr[i],arr[j]);
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
    return true;    
}



//paritioning with equal keys
//3 parts
// a[low to left]    contains all elements smaller than pivot 
// a[left+1 to right-1] contains all occurrences of pivot 
// a[right to high] contains all elements greater than pivot
void partiton_3way(int a[], int low, int high)
{
    if (high <= low) return;
    //int arr[] = {100,600,1000,1000,200,200,900,300,800,400,700,500,600,600};
    int left = low;
    int right = high;
    int p = low - 1, q = high; 
    int pivot_item = a[high];
    printf(" the pivot item is %d with index %d\n",pivot_item,high);

while (left < right)
{
    //Move from left until the first element is greater than or equal to pivot item 
    while( a[left] < pivot_item) left++;
    //Move from right until the first element is smaller than
    while( a[right] >= pivot_item ) {
        //boundry check
        if(right == low) break;
        right--;
    }
    //if left and right cross , then break
    if (left >= right) break;
    //swap such that smaller goes to the left , and larger goes to the right 
    //printf(" left index %d and right index are %d\n",left,right);
    //printf(" swap left value %d and right value are %d\n",a[left],a[right]);
    swap(a,left,right);
    //move all same left occurance of pivot to beginning of array using left count
    if (a[left] == pivot_item) 
    { 
        //printf(" both a[left] and pivot are equal %d\n",pivot_item);
      p++; 
      swap(a,p,left);
    }
    //move all right occurance of pivot to ending of array using right count
    if (a[right] == pivot_item) 
        { 
            //printf(" both a[right] and pivot are equal %d\n",pivot_item);
        q--; 
        swap(a,q,right);
    }
}
//move pivot element to correct index 
swap(a,left,high);


//move all left same occurances from beginning to adjacent to arr[low]
right = left-1; 
for (int k = low; k < p; k++, right--) {
    swap(a,k,right);    
}


//move all right same occurances from end to adjacent to arr[low]
left = left+1;
for (int k = high-1; k > q; k--, left++){
    swap(a,left,k);
}

    printf("\n=========================\n");

    printarr(a,high);
    printf("\n=========================\n");

quicksort_3way(a, low, right);
quicksort_3way(a, left, high);
}




  /*
  QuickSort function
  arr[] --> Array to be sorted, 
  low  --> Starting index, 
  high  --> Ending index 
  */
void quickSort(int arr[], int low, int high) 
{ 
    if (low < high) 
    { 
        //pivot is partitioning index, arr[p] is now at right place
        int pivot = partiton_3way(arr, low, high); 
        // sort elements before partition and after partition 
        quicksort_3way(arr, low, pivot - 1); 
        quicksort_3way(arr, pivot + 1, high); 
    } 
} 









/*
Helper Function : InPlace Quick Sort paritioner
1) fix the pivot as the first element in the sub array
2) left points to the beginning and right points to the end of the sub array
3) Move left until item < pivot
4) Move right while item > pivot
5) once left and right are marked , swap custom_shift_unique_elements
6) Keep repeating step 3 to 5 , until Left >= right
7)Now finally put the piviot in its correct place which is pointed by "right"
*/

int partition( int *a, int low, int high )
  {
  int left =  low;
  int right = high;
   //pivot element 
  int pivot_item = a[low];

  while ( left < right ) {
    //Move left while item < pivot
    while( a[left] <= pivot_item ) left++;
    //Move right while item > pivot
    while( a[right] > pivot_item ) right--;
    if ( left <= high && left < right) swap(a,left,right);
    }
      //right is final position for the pivot
      if(right <= high) {
          a[low] = a[right];
          a[right] = pivot_item;
      }
  return right;
  }
  
  
  
  
  
  /*
  QuickSort function
  arr[] --> Array to be sorted, 
  low  --> Starting index, 
  high  --> Ending index 
  */
void quickSort(int arr[], int low, int high) 
{ 
    if (low < high) 
    { 
        //pivot is partitioning index, arr[p] is now at right place
        int pivot = partition(arr, low, high); 
        // sort elements before partition and after partition 
        quickSort(arr, low, pivot - 1); 
        quickSort(arr, pivot + 1, high); 
    } 
} 
  
/*
Custom Shift Unique elements to the beginning of the array
and duplicates move to the end of the array
i points to a place holder for the unique value at the front of the array
j points to a first unique value as we iterates , and j ensures to skip duplicates

example {100,100,200,400,400,500}
when i = 0 , and j = 0 , we dont swap
when i = 1, and  j = 2 we swap
hence it becomes 100,200, 100,400,400,500
when i = 2 and j = 3 we swap again
hence it becomes 100,200,400,100,400,500
when i = 3 and j = 5 , we swap again
hence it becomes 100,200,400,500,400,100
end here
*/

void custom_shift_unique_elements(int* arr, int len) {
    
    if(arr == NULL) return;
    if(len == 0 || len == 1) return;
    int i  = 0, j = 0;
    while( j <= len) {
        //i points to a place holder for the unique value at the front of the array
        //j points to a first unique value as it iterates
        //swap both arr[i] and arr[j] , so that the unique value moves to the front portion of the array
        swap(arr,i,j);
        j++;

        //if we hit duplicates , keep moving j until we find the next unique value    
        while( j <= len && arr[i] == arr[j]) {
            j++;
        }
        //Advance i , which will point to the next place holder for the unique value
        i++;

    }
}


    









