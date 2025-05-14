package test;

import lotto.ch02.LottoRandomNumber;

import java.util.Arrays;
import java.util.Random;

public class MainTest {

    final int LOTTO = 6;

    {

        int forCount = 0;

        int[] lottoWinnum = new int[LOTTO];
        Random random = new Random();

        for (int i = 0; i < lottoWinnum.length; i++) {
            lottoWinnum[i] = random.nextInt(45) + 1;
            for (int j = 0; j < i; i++) {
                if (lottoWinnum[j] == lottoWinnum[i]) {
                    i--;
                }
            }
            forCount++;
        }
        System.out.println("outer for 테스트 : " + forCount);
        Arrays.sort(lottoWinnum);

    }

    public void main(String[] args) {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();
        int[] result = lottoRandomNumber.createNumber();
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }

}

