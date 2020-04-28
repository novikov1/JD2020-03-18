package by.it.tolstik.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Shop {
    public static void main(String[] args){
        System.out.println("Магазин открылся");
        int number = 1;
        List<Buyer> buyers = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(number++);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000, 1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрылся. Кол-во посетителей: " + number);
    }
}


