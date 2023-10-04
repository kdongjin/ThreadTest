import java.awt.Toolkit;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		// 스레드 1번방식 ==================
		// Thread thread = new BeepTask();
		// thread.start();
		// 스레드 2번방식===================
		// Runnable runnable = new BeepTask2();
		// Thread thread = new Thread(runnable);
		// thread.start();
		// 스레드 3번방식(Thread 임시객체)===========
		Thread thread = new Thread() {
			@Override
			public void run() {
				super.run();
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				try {
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				} finally {
					System.out.println("작업스레드 종료");
				}
			}
		};
		// thread.start();
		// 스레드 4번방식(Runnable 임시객체)===========
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				try {
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
					Thread.sleep(1000); // 1초간 지연
					toolkit.beep();
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				} finally {
					System.out.println("작업스레드 종료");
				}
			}
		});
		// thread1.start();
		// 스레드 5번방식(Runnable 임시객체 람다식)=======
		Thread thread2 = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			try {
				toolkit.beep();
				Thread.sleep(1000); // 1초간 지연
				toolkit.beep();
				Thread.sleep(1000); // 1초간 지연
				toolkit.beep();
				Thread.sleep(1000); // 1초간 지연
				toolkit.beep();
				Thread.sleep(1000); // 1초간 지연
				toolkit.beep();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			} finally {
				System.out.println("작업스레드 종료");
			}
		});
		thread2.start();
		// 출력을 다섯번 진행하는 업무를 맡아서 한다.(5초)
		System.out.println("땡");
		Thread.sleep(1000); // 1초간 지연
		System.out.println("땡");
		Thread.sleep(1000); // 1초간 지연
		System.out.println("땡");
		Thread.sleep(1000); // 1초간 지연
		System.out.println("땡");
		Thread.sleep(1000); // 1초간 지연
		System.out.println("땡");

		// 종을 다섯번 울리는 일 맡아서 한다.(5초)
		System.out.println("메인스레드 종료");
	}
}