package Array;

/**
 * Created by km on 6/7/18.
 */
public class BitonicArray {

    private int[] data = new int[20];

    public void algo() {

        int max = 0;
        int len = 0;

        for (int i = 0; i < data.length; i++) {

            len = 1;

            // increasing
            while (data[i] < data[i + 1]) {
                i++;
                len++;
            }

            // decreasing
            while (data[i] > data[i + 1]) {
                i++;
                len++;
            }

            if (max < len) {
                max = len;
            }

        }
    }


    int findBitonicPoint( int arr[], int n, int l, int r ){
        int mid;

        mid = (r + l) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findBitonicPoint(arr, n, mid, r);
        } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return findBitonicPoint(arr, n, l, mid);
        }
        return 0;
    }

}
