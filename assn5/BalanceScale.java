package assn5;

import java.util.Scanner;

public class BalanceScale {
    static final int MAX_SIZE = 1000;
    static int[] masses = {1,2,5,10,20,50,100};
    static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestcase = sc.nextInt();

        for (int i = 0; i < numTestcase; i++) {
            int numData = sc.nextInt();
            int[] dataArray = new int[MAX_SIZE];

            for (int j = 0; j < numData; j++) {
                dataArray[j] = sc.nextInt();
            }
                num = 0;
                balanceScale(dataArray, numData);
            }
    }

    static void balanceScale(int[] dataArray, int n) {
        int sub = 0;

        for (int i = 0; i < n; i++) {
            int data = dataArray[i];
            if (sub > data)
                sub -= data;
            else
                sub = data - sub;
        }

        //System.out.println(left + ":" + right);
        balanceMass(sub, 6);
        System.out.println(num);
    }

    static void balanceMass(int sub, int massNum) {
        if(sub == 0)
            return;

        int mass = masses[massNum];
        num += sub / mass;
        sub %=  mass;

        balanceMass(sub, --massNum);
    }
}
