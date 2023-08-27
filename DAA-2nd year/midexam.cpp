#include <iostream>
using namespace std;

void bubbleSort(int arr[], int n)
{

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << "  ";
    }
}

void selectionSort(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[min] > arr[j])
            {
                min = j;
            }
            // if(arr[min] > arr[j]){ -->  to get descending order
            //     min = j;
            // }
        }
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << "  ";
    }
}

void insertionSort(int arr[], int n)
{
    int j = 0;
    for (int i = 1; i < n; i++)
    {
        int k = arr[i];
        for (j = i - 1; j >= 0 && arr[j] > k; j--)
        {
            if (arr[j] > k)
            {
                arr[j + 1] = arr[j];
            }
        }
        arr[j + 1] = k;
    }
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << "  ";
    }
}

int main()
{
    int arr[5] = {4, 3, 7, 9, 1};
    int n = sizeof(arr) / sizeof(arr[0]);
    // bubbleSort(arr,n);
    // selectionSort(arr,n);
    insertionSort(arr, n);

    return 0;
}