package com.akash.day9;

//subset
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
	}
	//solution 1
	private List<List<Integer>> solution1(int[] arr) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> addList = new ArrayList<Integer>();
		findSubset(list, addList, arr, 0);
		return list;
	}

	private void findSubset(List<List<Integer>> list, List<Integer> addList, int[] arr, int i) {
		list.add(new ArrayList<Integer>(addList));
		for (int j = i; j < arr.length; j++) {
			addList.add(arr[j]);// 1
			findSubset(list, addList, arr, j + 1);
			addList.remove(addList.size() - 1);
		}
	}
	//solution 2
	public List<List<Integer>> solution2(int[] arr) {
		List<List<Integer>> subset = new ArrayList<>();
		subset.add(new ArrayList());
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				List<Integer> list = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					list.add(arr[k]);
				}
				subset.add(list);
			}
		}

		return subset;
	}

}
