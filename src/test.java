import java.util.Scanner;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCaseNum = sc.nextInt();

        for (int i = 0; i < testCaseNum; i++){
            System.out.println(test2(2));
        }
    }

    static int test2(int tmp) {
        return tmp + 1;
    }
}
