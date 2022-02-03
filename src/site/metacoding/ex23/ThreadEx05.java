// package site.metacoding.ex23;

// import javax.sql.rowset.spi.SyncResolver;

// //스레드가 컨텍스트 스위칭할 때는 내부적으로 0.0000001초라도 졸고 넘어간다.

// //하나의 프로세스 안에 여러개의 스레드가 동작한다.
// // 스레드 일시정지하는 법

// // 2초씩 자고 움직인다.
// class Monster implements Runnable {
// int x = 10; // 좌표
// int speed = 1; // 1초마다
// boolean isActive = true;

// @Override
// public void run() {
// while (isActive) {
// x = x + speed;
// System.out.println("도망가라 몬스터 : " + x);
// try {
// Thread.sleep(2000);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }

// }

// class Host implements Runnable {
// int x = 0;
// int speed = 2; // 1초마다
// boolean isActive = true;

// @Override
// public void run() {
// while (isActive) {
// x = x + speed;
// System.out.println("쫓아라 캐릭터 : " + x);
// try {
// Thread.sleep(1000);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }

// }
// }

// // 실습 -> Monster와 Host는 1초마다 각자의 speed만큼 움직이는 run()을 가진다.
// // -> 둘의 x좌표가 동일해지면 게임은 종료된다.

// public class ThreadEx05 {
// public static void main(String[] args) {
// Monster m = new Monster();
// Host h = new Host();

// Thread t0 = new Thread(new Runnable() {

// @Override
// public void run() {
// boolean isActive = true;
// while (isActive) {
// if (m.x <= h.x) {
// System.out.println("바이비");
// m.isActive = false;
// h.isActive = false;
// isActive = false;
// try {
// Thread.sleep(1000);
// } catch (Exception e) {
// e.printStackTrace();
// }
// break;
// }
// }

// }

// });
// Thread tmon = new Thread(m);
// Thread thos = new Thread(h);

// t0.start();
// tmon.start();
// thos.start();

// }

// }
