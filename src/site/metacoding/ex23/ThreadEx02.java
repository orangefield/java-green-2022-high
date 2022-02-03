package site.metacoding.ex23;

//main queue와 run queue가 타임 슬라이싱
class NewWorker implements Runnable {

    // 얘가 타겟
    @Override
    public void run() { // 동적 바인딩(target.run), 이 코드의 수명이 실의 길이

        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("뉴워커스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

public class ThreadEx02 {// 메인스레드는 뉴워커를 뽑고나서 start 때리고 밑으로 쭉쭉 내려가고, 뉴워커는 런 메서드 때리러 갔다 (비동기=순서가 없음)

    // MainThread의 타겟은 main 메서드
    public static void main(String[] args) {

        // NewWorker 생성
        Thread newWorker = new Thread(new NewWorker()); // 실의 길이는 결정됐지만 새로운 일꾼이 생성된게 아니라 CPU가 왔다갔다
        newWorker.start(); // run()을 직접적으로 호출하지 않지만 메서드가 호출 된다->CPU가 Context switching 시작(10와 32)

        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("메인스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
