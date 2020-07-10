
//https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/

#include <stdio.h>
#include<math.h>
#include <stdbool.h>

/*
3 way paritioning approach , modified quick sort 
ensures the duplicate pivot elements are slotted into their respective correct 
positions while paritioning
hence will process all occurances of the pivot

Inplace quick sort
Running time : nlogn + O(n) = nlogn
*/

/*
Helper Function : print the array
*/
void print (int a[], int n)
{
  for (int i = 0; i < n; ++i) {
    printf ("%d  ", a[i]);
  }
  printf ("\n");
}


/*
Helper Function : swap the elements using efficient XOR swap
*/
bool swap (int *arr, int i, int j)
{
  if (arr == NULL)
    return false;
  if ((i == j) || arr[i] == arr[j])
    {
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
void partition (int arr[], int low, int high, int *left, int *right)
{
  *left = low - 1, *right = high;
  int p = low - 1, q = high;
  int pivot_item = arr[high];

  while (*left < *right)
    {
      //Move from left until the first element is greater than or equal to pivot item 
      while (arr[++*left] < pivot_item)
	{
	  if (*left == high)
	    break;
	}
      //Move from right until the first element is smaller than or equal to pivot item
      while (arr[--*right] > pivot_item)
	{
	  if (*right == low)
	    break;
	}
      //if left and right cross , then break
      if (*left >= *right)
	break;

      //swap such that smaller goes to the left , and larger goes to the right 
      swap (arr, *left, *right);

      // Move all same left occurrence of pivot to beginning of 
      // array and keep count using p 
      if (arr[*left] == pivot_item)
	{
	  p++;
	  swap (arr, p, *left);
	}
      // Move all same right occurrence of pivot to end of array 
      // and keep count using q 
      if (arr[*right] == pivot_item)
	{
	  q--;
	  swap (arr, q, *right);
	}
    }
  // Move pivot element to its correct index 
  swap (arr, *left, high);

  // Move all left same occurrences from beginning 
  // to adjacent to arr[i] 
  *right = *left - 1;
  for (int k = low; k < p; k++, *right--)
    {
      swap (arr, k, *right);
    }

  // Move all right same occurrences from end 
  // to adjacent to arr[i] 
  *left = *left + 1;
  for (int k = high - 1; k > q; k--, *left++)
    {
      swap (arr, k, *left);
    }
}

// 3-way partition based quick sort 
void quicksort (int arr[], int low, int high)
{
  if (high <= low)
    return;
  //passed a references to parition
  int left, right;
  partition (arr, low, high, &left, &right);

  // recurrence 
  quicksort (arr, low, right);
  quicksort (arr, left, high);
}


void custom_shift_unique_elements (int *arr, int len)
{

  if (arr == NULL)
    return;
  if (len == 0 || len == 1)
    return;
  int i = 0, j = 0;

  while (j < len)
    {
      swap (arr, i, j);
      //loop until you find the first unique element
      //i will always point to unique element
      j++;
      while (j < len && arr[i] == arr[j])
	{
	  j++;
	}
      i++;
    }
  printf (" beginning of the array there are %d unique elements \n", i);
}


// Driver program 
/*
 Input : 1  1  2  3  3  3  6  6  5  5  5  9  8  8  7  7  4                                                                                                                   
 Output Sorted: 1  1  2  3  3  3  4  5  5  5  6  6  7  7  8  8  9                                                                                                            
 Output Unique Elements to the front of the Array:                                                                                                                           
 beginning of the array there are 9 unique elements                                                                                                                          
1  2  3  4  5  6  7  8  9  5  3  6  1  7  3  8  5
*/
int main ()
{
  //int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
  //int a[] = {0}; 
  //int a[] = {1,2,3,4,5}; 
  //int a[] = {5,4,3,2,1};
  //int arr[] = {0,0,0,2,2,2,1,1,1};
  int arr[] = { 1, 1, 2, 3, 3, 3, 6, 6, 5, 5, 5, 9, 8, 8, 7, 7, 4 };

  int size = sizeof (arr) / sizeof (int);
  printf (" Input : ");
  print (arr, size);
  quicksort (arr, 0, size - 1);
  printf (" Output Sorted: ");
  print (arr, size);
  printf (" Output Unique Elements to the front of the Array: \n");
  custom_shift_unique_elements (arr, size);
  print (arr, size);
  return 0;
}
