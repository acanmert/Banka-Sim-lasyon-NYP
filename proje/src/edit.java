import java.io.*;
import java.util.Scanner;

public class edit {
    private static Scanner x;

    public edit(String filepath, String s, String valueOf, int i) {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String filepath="records.txt";

    }

    public static void editle(String filepath,String editterm,String yenibakiye,int islem) {
        String tempFile="temp1.txt";
        File oldfile=new File(filepath);
        File newfile=new File(tempFile);
        String ID; String tlbakiye;String dbakiye;

        try {
            FileWriter fw =new FileWriter(tempFile,true);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            x =new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                ID =x.next();
                tlbakiye=x.next();
                dbakiye=x.next();
                //System.out.println("w"+ID+"BAK "+tlbakiye);
                if(ID.equals(editterm)){
                    if(islem==1) {
                        //System.out.println("if"+ID+"BAK "+tlbakiye);
                        int a = (Integer.parseInt(yenibakiye) + Integer.parseInt(tlbakiye));
                        //System.out.println("equals :" + ID + " bakiye ");
                        pw.print(ID + "," + a +","+dbakiye+"\n");
                        System.out.println("Bakiyeniz: "+a+" TL");

                    }
                    else if(islem==2){
                        int cikartma=(Integer.valueOf(tlbakiye)-Integer.valueOf(yenibakiye));
                        pw.print(ID + "," + cikartma+","+dbakiye+"\n");
                        System.out.println("Bakiyeniz: "+cikartma+" TL");

                    }
                    else if(islem==3){

                        pw.print(ID + "," + tlbakiye+","+dbakiye+"\n");
                        System.out.println("TL BAKIYENIZ:  "+tlbakiye+  " Dolar bakiyeniz: "+dbakiye);
                    } else if (islem==4) {
                        Integer top= Integer.parseInt(dbakiye)+Integer.parseInt(yenibakiye);
                        System.out.println("Dolar Miktari: "+yenibakiye+" Dolar");
                        System.out.println("BAKIYENİZ: "+top+" Dolar");
                        pw.print(ID + "," + tlbakiye+","+top+"\n");
                    }
                    else if (islem==5) {

                        int cik= Integer.parseInt(dbakiye)-Integer.parseInt(yenibakiye);
                        System.out.println("BAKİYENİZ: "+cik+" Dolar");
                        pw.print(ID + "," + tlbakiye+","+cik+"\n");

                    }

                }
                else{
                    pw.print(ID + "," + tlbakiye+","+dbakiye+"\n");
                    // System.out.println("ID "+ID+" name "+bakiye);
                }
                //System.out.println("ID DON :"+ID+" bakiye: "+bakiye);
            }
            x.close();
            pw.flush();
            pw.close();

            oldfile.delete();

            File dump=new File(filepath);

            newfile.renameTo(dump);
        }
        catch (Exception e){

            System.out.println("error");
        }
    }

}