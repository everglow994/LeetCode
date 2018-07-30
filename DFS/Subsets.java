package DFS;

import java.util.*;

public class Subsets {

//    // *********** 1 *************
//    // dfs 写法1
//    public List<List<Integer>> subsets(int[] nums) {
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if(nums == null || nums.length == 0) {
//            return result;
//        }
//
//        Arrays.sort(nums);
//
//        helper(result, new ArrayList<>(), nums, 0);
//
//        return result;
//    }
//
//
//    // 递归三要素
//    // 递归的定义 （参数，内容）
//
//    private void helper(List<List<Integer>> result,
//                        List<Integer> subset,
//                        int[] nums,
//                        int startIndex) {
//
//        result.add(new ArrayList<>(subset));
//
//        for(int i = startIndex; i < nums.length; i++) {
//            subset.add(nums[i]);
//
//            helper(result, subset, nums, i + 1);
//
//            subset.remove(subset.size() - 1);
//        }
//
//
//    }


//    // *********** 2 *************
//    // dfs 写法2
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        Arrays.sort(nums);
//        dfs(nums, 0, new ArrayList<Integer>(), results);
//        return results;
//    }
//
//    // 1. 递归的定义
//    // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
//    private void dfs(int[] nums,
//                     int index,
//                     List<Integer> subset,
//                     List<List<Integer>> results) {
//        // 3. 递归的出口
//        if (index == nums.length) {
//            results.add(new ArrayList<Integer>(subset));
//            return;
//        }
//
//        // 2. 递归的拆解
//        // (如何进入下一层)
//
//        // 选了 nums[index]
//        subset.add(nums[index]);
//        dfs(nums, index + 1, subset, results);
//
//        // 不选 nums[index]
//        subset.remove(subset.size() - 1);
//        dfs(nums, index + 1, subset, results);
//    }


    // *********** 3 *************
    // bfs
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(new ArrayList<>());

        while(!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            results.add(list);

            for(int i = 0; i < nums.length; i++) {
                if(list.size() == 0 || list.get(list.size() - 1) < nums[i]) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(nums[i]);
                    queue.offer(temp);
                }
            }

        }

        return results;
    }


}

