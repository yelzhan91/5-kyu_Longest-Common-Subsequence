public class CODEWARS {
    public static void main(String[] args) {
        String x = "a";
        String y = "b";
        String res = "";
        res = lcs(x, y);
        System.out.println(res);//""
        x = "abcdef";
        y = "abc";
        res = lcs(x, y);
        System.out.println(res);//abc
    }
    public static String lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] nums = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = nums[i-1][j-1] + (x.charAt(i-1) == y.charAt(j-1) ? 1 : 0);
                nums[i][j] = Math.max(nums[i][j], nums[i-1][j]);
                nums[i][j] = Math.max(nums[i][j], nums[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (nums[m][i] - nums[m][i-1] == 1) {
                sb.append(y.charAt(i-1));
            }
        }
        return sb.toString();
    }
}