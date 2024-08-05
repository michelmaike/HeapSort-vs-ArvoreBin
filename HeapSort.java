public class HeapSort {
    public void ordenar(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    void heapify(int arr[], int n, int i){
        int maior = i;
        int esq = 2*i + 1;
        int dir = 2*i + 2;

        if (esq< n && arr[esq] > arr[maior])
            maior = esq;
        if (dir < n && arr[dir] > arr[maior])
            maior = dir;
        if (maior != i) {
            int troca = arr[i];
            arr[i] = arr[maior];
            arr[maior] = troca;
            heapify(arr, n, maior);
        }
    }
}
