public class Ropes {


    public static void main (String... args){
        long a = System.currentTimeMillis();
        final Rope rope = new Rope();

        Thread isfull = new Thread((Runnable) ()->{
            synchronized (rope){
                for (int i = 0; i <rope.arr.length ; i++) {
                    rope.arr[i]++;
                    rope.notifyAll();
                    try {
                        rope.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        isfull.start();

        Thread count = new Thread((Runnable)()->{
            synchronized (rope){
                for (int i = 0; i < rope.arr.length; i++) {
                    rope.arr[i] = (float) (rope.arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    System.out.println(i + "___Значение новой ячейки" + " \n");
                    try {
                        rope.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() - a + "__Общее вреня окончания метода в миллисекундах");
                    try {
                        rope.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    rope.notifyAll();
                }
            }
        });
        count.start();




    }
    public  static class Rope{
        static final int size = 10000000;
        static final int h = size / 2;
        float[] arr = new float[size];

    }
}


