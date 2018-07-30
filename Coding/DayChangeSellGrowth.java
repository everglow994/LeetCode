package Coding;

public class DayChangeSellGrowth {
    /**
     * int[] dayChange(int[] cells, int days),
     * cells 数组，有8个元素，每天的变化情况是
     * 当前位置 cell = (cell[i - 1] == cell[i + 1]) ? 0 : 1, 左右相等，当前位置为0， 不等为1，
     * 默认 cells[0]左边 和 cells[cells.length - 1]右边的位置元素都是0， 求days天后的变化.
     */


    public int[] Solution(int[] days, int n) {
        if(n <= 0 || days == null) {
            return days;
        }
        int N = days.length;

        for(int i = 0; i < n; i++) {

            int[] temp = days;
            temp[0] = days[1];
            temp[N - 1] = days[N - 2];

            for(int j = 1; j < N - 1; j++) {
                temp[j] = days[j - 1] == days[j + 1] ? 0 : 1;
            }

            days = temp;
        }

        return days;
    }

}
