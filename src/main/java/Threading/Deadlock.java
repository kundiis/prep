package Threading;

public class Deadlock {

    Thread t1;
    Thread t2;

    String a = "first";
    String b = "second;";

    public void produceDeadlock(){
        t1 = new Thread("first"){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("Thread 01 got a");

                    synchronized (b){
                        System.out.println("Thread 01 got b");

                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t2 = new Thread("second"){
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("Thread 02 got b");

                    synchronized (a){
                        System.out.println("Thread 02 got a");

                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        deadlock.produceDeadlock();
    }
}
