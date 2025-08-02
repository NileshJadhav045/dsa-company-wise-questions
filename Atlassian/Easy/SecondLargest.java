public class SecondLargest {

    public static int secondLargest(int arr[]) { // brute force
        int n = arr.length;
        int largest = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                largest = arr[i];
                break;
            }
        }
        return largest;
    }

    public static int secondLargestEle(int arr[]) { // O(2n)
        int largest = arr[0];
        int slargest = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > slargest && arr[i] != largest) {
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static int secondGreater(int arr[]) {
        int largest = arr[0];
        int slargest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] > slargest && arr[i] < largest) {
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 6, 7, 8, 3, 2, 9 };
        // System.out.println(secondLargestEle(nums));
        System.out.println(secondGreater(nums));
    }
}
