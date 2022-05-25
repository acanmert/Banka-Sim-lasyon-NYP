import java.io.*;

public class Kisi{
    String isim;String soyisim;String tcno;String sifre;String dogumyeri;String dogumtarihigunu;
    String filepath="records.txt";
    String filepath2 = "kayitlar.txt";

    public String getCepno() {
        return cepno;
    }




    public void paraYatırma(int amount) {
        edit k=new edit(filepath, tcno, String.valueOf(amount), 1);
        k.editle(filepath, UserAccount.kisi.getTcno(),String.valueOf(amount),1);


    }
    public void goster(int amount){
        edit k=new edit(filepath, tcno, String.valueOf(amount), 3);
        k.editle(filepath, UserAccount.kisi.getTcno(),String.valueOf(amount),3);
    }
    public void paraCekme(int amount){
        edit k1=new edit(filepath, tcno, String.valueOf(amount), 2);
        k1.editle(filepath,UserAccount.kisi.getTcno(),String.valueOf(amount),2);


    }
    static public void ekleme(String tc ) throws IOException {
        String filepath = "records.txt";
        FileWriter fw = new FileWriter(filepath, true);
        BufferedWriter bWriter = new BufferedWriter(fw);
        String rtc=tc;
        bWriter.write(rtc);
        bWriter.append(",");
        bWriter.write("0,0");
        bWriter.newLine();
        bWriter.close();




        }




    public void setCepno(String cepno) {
        this.cepno = cepno;

    }

    String cepno;
    String dogumtarihiayı;String dogumtarihiyılı;String emailadresi;String soniki;
    static int bakiye;

    int dolarbakiye;
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getSoyisim() {
        return soyisim;
    }
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    public String getTcno() {
        return tcno;
    }
    public void setTcno(String tcno) {
        this.tcno = tcno;
    }
    public String getSifre() {
        return sifre;
    }
    public void setSifre(String filepath2,String sifre) {
        edit k2=new edit(filepath2, UserAccount.kisi.getTcno(), String.valueOf(5), 0);
    //    k2.sifrele(filepath2, UserAccount.kisi.getTcno(),sifre);

    }
    public String getDogumyeri() {
        return dogumyeri;
    }
    public void setDogumyeri(String dogumyeri) {
        this.dogumyeri = dogumyeri;
    }
    public String getDogumtarihigunu() {
        return dogumtarihigunu;
    }
    public void setDogumtarihigunu(String dogumtarihigunu) {
        this.dogumtarihigunu = dogumtarihigunu;
    }
    public String getDogumtarihiayı() {
        return dogumtarihiayı;
    }
    public void setDogumtarihiayı(String dogumtarihiayı) {
        this.dogumtarihiayı = dogumtarihiayı;
    }
    public String getDogumtarihiyılı() {
        return dogumtarihiyılı;
    }
    public void setDogumtarihiyılı(String dogumtarihiyılı) {
        this.dogumtarihiyılı = dogumtarihiyılı;
    }
    public String getEmailadresi() {
        return emailadresi;
    }
    public void setEmailadresi(String emailadresi) {
        this.emailadresi = emailadresi;
    }
    public String getSoniki() {
        return soniki;
    }
    public void setSoniki(String soniki) {
        this.soniki = soniki;
    }






    /* void BankAccount(String isim2, String soyisim2, String tcno2, String sifre2, String dogumyeri2, String dogumtarihigunu2, String dogumtarihiayı2, String dogumtarihiyılı2, String emailadresi2, String soniki2, int bakiye2){
        isim=isim2;
        soyisim=soyisim2;
        tcno=tcno2;
        sifre=sifre2;
        dogumyeri=dogumyeri2;
        dogumtarihigunu=dogumtarihigunu2;
        dogumtarihiayı=dogumtarihiayı2;
        dogumtarihiyılı=dogumtarihiyılı2;
        emailadresi=emailadresi2;
        soniki=soniki2;
        bakiye=bakiye2;
    }

    void BankAccount(String isim2, String soyisim2){
        isim=isim2;
        soyisim=soyisim2;
    };
    */
}