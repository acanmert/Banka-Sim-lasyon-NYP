import java.io.IOException;
import java.util.Scanner;


public class Kredi {
    Scanner sec = new Scanner(System.in);


    public void deneme() throws InterruptedException, IOException {

        System.out.println("Kredi Islemleri Secildi");
        System.out.print("Islemlere Devam Etmeden Once Lutfen Brut Maasınızı Giriniz : ");
        String maas = sec.nextLine();
        if (Integer.valueOf(maas) < 5000) {
            System.out.println("yok sana kredi");
            new UserAccount();
        } else if (Integer.valueOf(maas) >= 5000 && 10000 > Integer.valueOf(maas)) {
            System.out.println("Alabileceginiz Krediler \n------------");
            System.out.println("1-) 5000  Tl Kredi 2(cikis ");
            String secim = sec.nextLine();
            if (secim.equals("1")) {
                System.out.println("1-) 3ay odeme(%1.54 faiz)\n2-) 6ay odeme(1.65 faiz)");
                String secim1 = sec.nextLine();
                if (secim1.equals("1")) {
                    System.out.println("lutfen bekle");
                    Thread.sleep(2000);
                    System.out.println("5000tl kredi aylik " + (((5000 * 1.54) / 100) + 5000 / 3) + " odemeyle verilmistir");

                } else if (secim1.equals("2")) {
                    System.out.println("lutfen bekle");
                    Thread.sleep(2000);
                    System.out.println("5000tl kredi aylik " + (((5000 * 1.65) / 100) + 5000 / 6) + " odemeyle verilmistir");

                } else {
                    deneme();
                }
                new UserAccount();
            }


        } else if (Integer.valueOf(maas) >= 10000) {

            System.out.println("Alabileceginiz Krediler \n------------");
            System.out.println("1-) 5000  Tl Kredi ");
            System.out.println("2-) 10000  Tl Kredi ");
            System.out.println("3-) CİKİS");
            String secim = sec.nextLine();
            if (secim.equals("1")) {
                System.out.println("1-) 3ay ödeme(%1.54 faiz)\n2-) 6ay ödeme(1.65 faiz)");
                String secim1 = sec.nextLine();
                if (secim1.equals("1")) {
                    System.out.println("lütfen bekle");
                    Thread.sleep(2000);
                    System.out.println("5000tl kredi aylık " + (((5000 * 1.54) / 100) + 5000 / 3) + " ödemeyle verilmiştir");

                } else if (secim1.equals("2")) {
                    System.out.println("lütfen bekle");
                    Thread.sleep(2000);
                    System.out.println("5000tl kredi aylık " + (((5000 * 1.65) / 100) + 5000 / 6) + " ödemeyle verilmiştir");

                } else {
                    deneme();
                }
                new UserAccount();
            } else if (secim.equals("2")) {
                System.out.println("1-) 3ay ödeme(%1.54 faiz)\n2-) 6ay ödeme(1.65 faiz)\n3-) 12 ay odeme(1.75 faiz)");
                String secim2 = sec.nextLine();
                if (secim2.equals("1")) {
                    System.out.println("lutfen bekleyiniz...");
                    Thread.sleep(2000);
                    System.out.println("10000tl kredi aylık " + (((10000 * 1.54) / 100) + 10000 / 3) + " odemeyle verilmistir");

                } else if (secim2.equals("2")) {
                    System.out.println("lutfen bekleyiniz...");
                    Thread.sleep(2000);
                    System.out.println("10000tl kredi aylik " + (((10000 * 1.65) / 100) + 10000 / 6) + " odemeyle verilmistir");

                } else if (secim2.equals("3")) {
                    System.out.println("lutfen bekleyiniz...");
                    Thread.sleep(2000);
                    System.out.println("10000tl kredi aylik " + (((10000 * 1.75) / 100) + 10000 / 12) + " odemeyle verilmistir");

                }
                else{
                    deneme();
                }
                new UserAccount();
            }


        }


    }
}


