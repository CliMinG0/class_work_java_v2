package lotto.ch02;


import java.util.Arrays;
import java.util.Random;

/**
 * SRP - 클래스를 설계할 때의 원칙중에 하나이다.
 * 단일 책임에 원칙 (클래스는 가능한 단 하나의 책임을 가지는 것이 좋다)
 */
public class LottoRandomNumber {

    final int LOTTO_NUMBER_COUNT = 6;

    // 메서드 : 6개의 랜덤번호가 필요(중복제거, 정렬)
    public int[] createNumber() {
        // for 문이 돌아간 횟수 확인해 보기
        int forCount = 0;

        int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
        Random random = new Random();

        for(int i = 0; i < lottoWinNum.length; i++)  {
            lottoWinNum[i] = random.nextInt(45) + 1;
            for(int j = 0; j < i; j++) {
                if(lottoWinNum[j] == lottoWinNum[i]) {
                    // 값이 중복된 상태라면 외부 for 구문에 i값을 -1 해서 한번더 반복문을 수행 시키게 한다.
                    i--;
                }
            }
            forCount++;
        } // outer for

        System.out.println("outer for 테스트 : " + forCount);
        // 정렬 방법 (오름차순)
        Arrays.sort(lottoWinNum);
        return lottoWinNum;
    }

    // 테스크 코드 작성
    public static void main(String[] args) {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();
        int[] result = lottoRandomNumber.createNumber();
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}

