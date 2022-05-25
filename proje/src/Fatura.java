import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Fatura {
    static Kisi kisi = new Kisi();
    static FaturaClass faturaClass = new FaturaClass();
    String filepath3="records.txt";
    String d="0";

    Fatura() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Fatura Odeme Secildi");
        System.out.println("1-) Elektrik Faturasi Odemek icin");
        System.out.println("2-) Su Faturasi Odemek icin");
        System.out.println("3-) Cikis Yapmak icin");
        String secim = s.nextLine();

        if(secim.equals("1")){
            if(faturaClass.elekodendimi==false){
                System.out.println("Guncel Elektrik Faturanız : " +faturaClass.getElekOdenecekfatura() +" TL" );
                System.out.println("Odemek Istiyorsanız 1-) Basınız");
                String sec = s.nextLine();
                if(sec.equals("1")) {
                    //kisi.setBakiye(kisi.getBakiye());
                    kisi.paraCekme(faturaClass.getElekOdenecekfatura());
                    faturaClass.setElekOdenecekfatura(0);
                    edit.editle(filepath3,kisi.getTcno(),d,3);
                    System.out.println("Faturanız Odenmistir");
                    faturaClass.elekodendimi = true;

                }

            }else {
                System.out.println("Zaten odendi");
            }
            new Fatura();
        }
        if(secim.equals("2")){
            if(faturaClass.suodendimi==false){
                System.out.println("Guncel Su Faturanız : " +faturaClass.getSuOdenecekfatura() +" TL" );
                System.out.println("Odemek Istiyorsanız 1-) Basınız");
                String sec = s.nextLine();
                if(sec.equals("1")) {
                    //kisi.setBakiye(kisi.getBakiye());
                    kisi.paraCekme(faturaClass.getSuOdenecekfatura());
                    faturaClass.setSuOdenecekfatura(0);
                    edit.editle(filepath3,kisi.getTcno(),d,3);
                    System.out.println("Faturanız Odenmistir");
                    faturaClass.suodendimi = true;

                }

            }else {
                System.out.println("Faturanız Zaten Odenmistir");
            }
            new Fatura();
        }
        if(secim.equals("3")){
            new UserAccount();
        }
    }


    public static void main(String[] args) throws IOException {
        new Fatura();
    }
}
