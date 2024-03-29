import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MainTest {

    public static void main(String[] args) {
        /*String str = "onnline";
        int i = str.indexOf(str.charAt(1), 2);
        System.out.println(i);*/
        Duration between = Duration.between(LocalDateTime.of(2024, 1, 9, 0, 0), LocalDateTime.of(2025, 1, 9, 0, 0));
        System.out.println(between.toDays());
        // 计算两个日期相差的天数
        LocalDate start = LocalDate.of(2024, 1, 9);
        LocalDate end = LocalDate.of(2025, 1, 9);
        System.out.println(Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nNumSum(nums, 3, 0, 0);
    }

    /**
     * 递归求解n数之和
     *
     * @param nums   数组
     * @param num    n数之和
     * @param index  开始的索引
     * @param target 求和的目标
     * @return 返回的数组
     */
    private static List<List<Integer>> nNumSum(int[] nums, int num, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num < 2) {
            return result;
        }
        if (num == 2) {
            int lIndex = index;
            int rIndex = nums.length - 1;
            while (lIndex < rIndex) {
                int left = nums[lIndex];
                int right = nums[rIndex];
                int sum = left + right;
                if (sum < target) {
                    while (lIndex < rIndex && nums[lIndex] == left) {
                        lIndex++;
                    }
                } else if (sum > target) {
                    while (lIndex < rIndex && nums[rIndex] == right) {
                        rIndex--;
                    }
                } else {
                    result.add(new ArrayList<>(Arrays.asList(left, right)));
                    // 去重
                    while (lIndex < rIndex && nums[lIndex] == left) {
                        lIndex++;
                    }
                    while (lIndex < rIndex && nums[rIndex] == right) {
                        rIndex--;
                    }
                }
            }

        } else {
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> lists = nNumSum(nums, num - 1, i + 1, target - nums[i]);
                for (List<Integer> integers : lists) {
                    integers.add(nums[i]);
                    result.add(integers);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
        return result;
    }

}


