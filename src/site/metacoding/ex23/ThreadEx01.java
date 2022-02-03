package site.metacoding.ex23;

public class ThreadEx01 {

    // main 스레드 시작
    public static void main(String[] args) {
        System.out.println(1);
        try {
            Thread.sleep(2000);// = 2초동안 깨우지마(ms 1/1000초)
        } catch (Exception e) { // 야 너 지금 잠잘 때가 아니야!
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
