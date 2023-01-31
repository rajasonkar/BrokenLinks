package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombination {
static int a[] = {1,2,3,4,5,6,7,8,9};
public static void main(String args[])
{
System.out.println(	combinationSum2(a,10).size());}
public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    backTrack(result, list, candidates, target, 0);
    return result;
}
private static void backTrack(List<List<Integer>> result, 
    List<Integer> list, int[] candidates, int target, 
    int position) {
        int sum = 0;
        for (int x: list) {
                sum += x;       }
        if (sum == target) {
                result.add(new ArrayList<Integer>(list));
                return;  }
        if (sum < target) 
        {
            for (int i = position; i < candidates.length; i++) 
            {
                if(position != i 
                    && candidates[i] == candidates[i-1])
                {
                    continue;
                }
                list.add(candidates[i]);
                backTrack(result, list, candidates, target, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}

