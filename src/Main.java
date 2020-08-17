public class Main{



    //МЕТОД 1


    //1) Создают одномерный длинный массив +

    //2) Заполняют этот массив единицами +

    //3) Засекают время выполнения: long a

    //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:+

    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));


    //5) Проверяется время окончания метода System.currentTimeMillis(); +

    //6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);




    public static void main(String[] args){

        Ropes ropes =new Ropes();

        Thread thread = new Thread((Runnable) ropes);


        thread.start();

        class Ropes implements Runnable{


            @Override
            public void run() {

            }
        }


    }



}




