import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;
import static java.nio.file.StandardOpenOption.APPEND;
public class UserAccount {
    Scanner s = new Scanner(System.in);
    String dosya = "kayitlar.txt";
    static Kisi kisi = new Kisi();
    Path path = Paths.get(dosya.toString());
    OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
    InputStream input=Files.newInputStream(path);
    BufferedReader reader=new BufferedReader(new InputStreamReader(input));
    public UserAccount() throws IOException {
        try{
            System.out.println("***************************************");
            System.out.println("            OZTURK   BANK\n1-) Uye Olmak Icin \n2-) Giris Yapmak Icin");
            System.out.println("***************************************");
            System.out.print("Secim Yapiniz\n");
            String secim = s.nextLine();
            if(secim.equals("1")){
                CreateAccount();
            } else if (secim.equals("2")) {
                Login();
            }else{
                System.out.println("Gecersiz Secim . .");
                new UserAccount();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void Login(){
        try{
            System.out.println("\n_ G I R I S _");
            System.out.println("TC NO GIRINIZ = ");
            String tcno = s.nextLine();
            kisi.setTcno(tcno);
            System.out.println("SIFRE GIRINIZ = ");
            String sifre = s.nextLine();
            String _temp = null;
            String _user;
            String _pass;
            String _isim;
            String _soyisim;
            String _dogumyili;
            String _email;
            String _cepno;

            boolean found = false;

            while ((_temp=reader.readLine())  != null){
                //   System.out.println(_temp);
                String[] account = _temp.split(",");
                _isim = account[0];kisi.setIsim(_isim);
                _soyisim = account[1];kisi.setSoyisim(_soyisim);
                _user = account[2];
                _pass = account[3];kisi.setSifre(kisi.filepath, _pass);
                _dogumyili=account[5];
                _email=account[6];kisi.setEmailadresi(_email);
                _cepno=account[8];kisi.setEmailadresi(_cepno);

                if(_user.equals(tcno) && _pass.equals(sifre)){
                    System.out.println("=============================");
                    System.out.println("Hosgeldiniz "+ _isim +" "+_soyisim);
                    System.out.println("Dogum Yili :"+_dogumyili);
                    System.out.println("Email :"+_email);
                    System.out.println("Cep NO :"+_cepno);
                    System.out.println("=============================\n");
                    found=true;
                    Menu();
                } else if (_user.equals(tcno) && !_pass.equals(sifre)) {
                    System.out.println("sifre hatalı");
                }
            }

            if(found==true){
                //System.out.println("Giris Basarili :|");
                // SECENEKLER KISMI ACILACAK
                Menu();
            }
            else{
                System.out.println("H a t a");
            }
            reader.close();
            System.out.println("Herhangi bir tusa basınız ... ");
            String proc = s.nextLine();
            new UserAccount();

        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }
    void Menu() throws IOException {
        Scanner s= new Scanner(System.in);
        try{
            System.out.println("_____________________________");
            System.out.println("1. PARA YATIRMA");
            System.out.println("2. PARA CEKME");
            System.out.println("3. BAKIYE GOSTER");
            System.out.println("4. SIFRE Degistir");
            System.out.println("5. ESKI ISLEMLERI GOSTER "); // buglı
            System.out.println("6. DOLAR HESABINA PARA YATIR ");
            System.out.println("7. DOLAR HESABINDAN PARA CEK ");
            System.out.println("8. FATURA ODEME ");
            System.out.println("9. KREDI BASVURUSU ");
            System.out.println("10. CIKIS YAP ");
            System.out.println("_____________________________");
            System.out.println(" _ Secim yapınız _ ");
            String secim = s.nextLine();

            if(secim.equals("1")){
                System.out.println("Para Yatirma Secildi");
                System.out.println("Lutfen Eklenecek Tutari Giriniz : ");
                String secim2= s.nextLine();

                 //System.out.println("Eski Bakiye : "+kisi.getBakiye()); //0
                kisi.paraYatırma(Integer.parseInt(secim2)); //+500
                //System.out.println(kisi.getTcno());
              //   kisi.goster(Integer.parseInt(secim2));
                //System.out.println("Yeni Bakiye : "+ kisi.gosBakiye()); //500
                //String bakiye = String.valueOf(kisi.getBakiye());
                Menu();

            }
            if(secim.equals("2")){
                System.out.println("Para Cekme Secildi");
                System.out.println("Lutfen Cekilecek Tutarı Giriniz : ");
                String secim2= s.nextLine();
                //System.out.println("Eski Bakiye : "+kisi.getBakiye()); //0
                /*if(kisi.getBakiye()>0 && ((kisi.getBakiye()-Integer.parseInt(secim2))>0)){
                    kisi.paraCekme(Integer.parseInt(secim2)); //+500
                    //    String bakiye = String.valueOf(kisi.getBakiye());
                    System.out.println("Yeni Bakiye : "+kisi.getBakiye()); //500

                }else{
                    System.out.println("Bakiyeniz Yetersizdir");
                    Menu();


                }*/

                kisi.paraCekme(Integer.parseInt(secim2));
               // System.out.println("Yeni Bakiye : "+ kisi.gosBakiye());
                Menu();




            }
            if(secim.equals("3")){
                System.out.println("Bakiye Goster Secildi");
                edit.editle(kisi.filepath, kisi.getTcno(),"0",3);
                Menu();
            }
            if(secim.equals("4")){

                System.out.println(" Sifrenizi giriniz : ");
                String secim2= s.next();
                kisi.setSifre(kisi.filepath2, secim2);
                //System.out.println("Yeni Sifreniz : "+kisi.getSifre());
                Menu();

            }
            if(secim.equals("5")){ // Sıkıntılı
                System.out.println("Eski Islemleri Gosteriniz");
                System.out.println("---ARIZALI---");
                String _temp = null;
                int islem1,islem2,islem3,islem4;
               /* while ((_temp=reader2.readLine())  != null){
                    System.out.println(_temp);
                    String[] account = _temp.split(" ");
                    islem1 = Integer.parseInt(account[0]);
                    islem2 = Integer.parseInt(account[1]);
                    islem3 = Integer.parseInt(account[2]);
                    islem4 = Integer.parseInt(account[3]);
                    System.out.println("Islemi yapildi 23/09/2031: "+islem1);
                    System.out.println("Islemi yapildi 23/09/2031: "+(islem2-islem1));
                    System.out.println("Islemi yapildi 23/09/2031: "+(islem3-islem2));
                    System.out.println("Islemi yapildi 23/09/2031: "+(islem4-islem3));
                 */
                    Menu();
                }
            if(secim.equals("6")){
                System.out.println("DOLAR HESABINA PARA YATIR Secildi");
               // System.out.println("TL Bakiyeniz : "+kisi.getBakiye());
               // kisi.getaDolarbakiye();
                System.out.println("Guncel Dolar Kuru : 20.00 TL");
                System.out.print("Yatırmak istediginiz tutarı TL olarak giriniz : ");
                String miktar1 = s.nextLine();; //800
                int miktar = Integer.parseInt(miktar1); //500
                int dolarmiktarı = miktar/20;

                edit.editle(kisi.filepath, kisi.getTcno(), String.valueOf(dolarmiktarı),4);
                   // kisi.paraCekme(miktar);
                    //System.out.println("Yeni TL Miktariniz : "+kisi.getBakiye());
                    //kisi.dolarparaYatırma(dolarmiktarı);
                    //kisi.getaDolarbakiye();





                Menu();
            }
            if(secim.equals("7")){
                System.out.println("DOLAR HESABINDAN PARA CEK Secildi");


                System.out.println("Guncel Dolar Kuru : 20.00 TL");
                System.out.print("Cekmek istediginiz tutarı DOLAR olarak giriniz : ");
                String miktar1 = s.nextLine();
                edit.editle(kisi.filepath, kisi.getTcno(),miktar1.toString(),5);


                Menu();
            }
            if(secim.equals("8")){
                new Fatura();
            }  if(secim.equals("9")){
                Kredi kredi = new Kredi();
                kredi.deneme();
            }
            if(secim.equals("10")){
                new UserAccount();
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("sadasd");

        }
    }
    void CreateAccount(){
        try{
            Scanner t =new Scanner(System.in);
            System.out.println("\n_ K A Y I T _");
            System.out.println("ISMINIZI GIRINIZ    = "); //0
            String isim = s.nextLine();

            System.out.println("SOYISMINIZI GIRINIZ   = "); //1
            String soyisim = s.nextLine();
            System.out.println("TC NO GIRINIZ    = "); //2
            String tcno = s.nextLine();
            String tc =tcno;
            System.out.println("SIFRE OLUSTURUNUZ = "); //3
            String sifre = s.nextLine();
            System.out.println("DOGUM YERINIZI GIRINIZ    = "); //4
            String dogumyeri = s.nextLine();
            System.out.println("DOGUM TARIHINIZIN GUNUNU GIRINIZ = "); //5
            String dogumtarihigün = s.nextLine();
            System.out.println("DOGUM TARIHINIZIN AYINI GIRINIZ = "); //6
            String dogumtarihiay = s.nextLine();
            System.out.println("DOGUM TARIHINIZIN YILINI GIRINIZ = "); //7
            String dogumtarihiyıl = s.nextLine();
            System.out.println("EMAIL ADRESINIZI YAZINIZ = "); //8
            String emailadresi = s.nextLine();
            System.out.println("ANNE KIZLIK SOYADINIZIN SON 2 HARFI = "); //9
            String soniki = s.nextLine();
            System.out.println("CEP TELEFONU NUMARANIZ     = "); //9
            String cepno = s.nextLine();

            System.out.println("----------------");
            kisi.setIsim(isim);
            kisi.setSoyisim(soyisim);
            kisi.setTcno(tcno);
            kisi.setSifre(kisi.filepath,sifre);
            kisi.setDogumyeri(dogumyeri);
            kisi.setDogumtarihigunu(dogumtarihigün);
            kisi.setDogumtarihiayı(dogumtarihiay);
            kisi.setDogumtarihiyılı(dogumtarihiyıl);
            kisi.setEmailadresi(emailadresi);
            kisi.setSoniki(soniki);
            kisi.setCepno(cepno);
            System.out.println(kisi.getIsim()+" - "+kisi.getSoyisim());
            System.out.println("-----------------");
            kisi.ekleme(tc);
            writer.write(isim+","+soyisim+","+tcno + "," + sifre + "," +dogumyeri+ "," + dogumtarihigün+"."+dogumtarihiay+"."+dogumtarihiyıl+","+emailadresi+","+soniki+","+cepno);
            writer.newLine();
            System.out.println("Kayit basariyla tamanlandi ! ");
            writer.close();
            output.close();
            System.out.println("Herhangi bir tusa basınız ... ");
            String proc = s.nextLine();
            new UserAccount();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args) throws IOException {
        new UserAccount();
    }
}


