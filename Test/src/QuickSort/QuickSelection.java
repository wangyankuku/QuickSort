package QuickSort;

public class QuickSelection {
	public int getKthLargestElements(int[] nums, int k) {

		if (nums == null)
			throw new RuntimeException("Input array is null.");

		int len = nums.length;

		if (k > len || k <= 0)
			throw new RuntimeException("The value k is invalid.");

		int i = 0;
		int j = len - 1;
		k--;

		while (i < j) {
			int idx = quickSelect(nums, i, j);

			if (idx == k)
				return nums[idx];

			if (idx < k) {
				i = idx + 1;
			} else {
				j = idx - 1;
			}
		}

		return nums[i];

	}

	public void quickSort(int[] nums) {
		if (nums == null)
			throw new RuntimeException("Input array is null.");

		quickSortHelper(nums, 0, nums.length - 1);

		return;
	}

	private void quickSortHelper(int[] nums, int start, int end) {

		if (start >= end)
			return;

		int idx = quickSelect(nums, start, end);

		quickSortHelper(nums, start, idx - 1);
		quickSortHelper(nums, idx + 1, end);

		return;
	}

	private int quickSelect(int[] nums, int start, int end) {

		int pivot = nums[end];

		int i = start;
		int j = end - 1;

		while (true) {
			while (i <= j && nums[i] < pivot)
				i++;
			while (i <= j && nums[j] > pivot)
				j--;

			if (i >= j)
				break;

			swap(nums, i, j);
			i++;
			j--;
		}

		swap(nums, i, end);

		return i;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		QuickSelection qs = new QuickSelection();
		int[] nums = { 1, 1, 1, 3, 3, 3, 2 };
		int k = 6;
		int res = qs.getKthLargestElements(nums, k);

		System.out.println(res);
	}
}
