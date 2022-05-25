import java.util.Random;

public class FaturaClass {
    boolean elekodendimi;
    boolean suodendimi;
    int elekodenecekfatura = getRandomNumberInRange(30,500);
    int sudenecekfatura = getRandomNumberInRange(30,500);

    public int getElekOdenecekfatura() {
        return elekodenecekfatura;
    }
    public void setElekOdenecekfatura(int odenecekfatura) {
        this.elekodenecekfatura = odenecekfatura;
    }
    public int getSuOdenecekfatura() {
        return sudenecekfatura;
    }
    public void setSuOdenecekfatura(int sudenecekfatura) {
        this.sudenecekfatura = sudenecekfatura;
    }
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }
}