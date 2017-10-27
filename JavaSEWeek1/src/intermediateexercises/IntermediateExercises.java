package intermediateexercises;

public class IntermediateExercises {
    public static void main(String[] args){
        System.out.println(blackJack(12, 21));
        System.out.println(uniqueSum(1, 1, 2));
        System.out.println(tooHot(91, true));
        peopleTask();
        // For garage exercise see garage package - garageExercise();
        paintWizard(500);
        filesIO();
    }

    public static int blackJack(int a, int b){

        if (a > 21 && b > 21){
            return 0;
        }
        else if (a > 21 && b <= 21){
            return b;
        }
        else if (b > 21 && a <= 21){
            return a;
        }
        else if (a > b){
            return a;
        }
        else {
            return b;
        }
    }

    public static int uniqueSum(int a, int b, int c){

        if (a == b && b == c){
            return 0;
        }
        else if (a == b && a != c){
            return a + c;
        }
        else if (a != b && a == c){
            return a + b;
        }
        else{
            return a + b + c;
        }

    }

    public static boolean tooHot(int temperature, boolean isSummer){
        if (isSummer){
            if (temperature >= 60 && temperature <= 100){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (temperature >= 60 && temperature <= 90){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void peopleTask(){
        Person a = new Person("John", 32, "manager");
        Person b = new Person("Susan", 56, "accountant");
        Person c = new Person("Anthony", 22, "consultant");
        PersonManager m = new PersonManager();

        m.addToList(a);
        m.addToList(b);
        m.addToList(c);

        System.out.println(m.personSearch("John"));
    }


    public static void paintWizard(int areaToPaint){

        PaintWizrd wiz = new PaintWizrd(areaToPaint);
        Paint cheapo = new Paint(19.99, 10, 20, "CheapoMax");
        Paint avgJoes = new Paint(17.99, 11, 15, "AverageJoes");
        Paint dulux = new Paint(25, 20, 10, "DuluxourousPaints");

        wiz.addToList(cheapo);
        wiz.addToList(avgJoes);
        wiz.addToList(dulux);

        wiz.doCompleteCalculation();
    }

    public static void filesIO(){
        Person a = new Person("John", 32, "manager");
        Person b = new Person("Susan", 56, "accountant");
        Person c = new Person("Anthony", 22, "consultant");
        Person d = new Person("Elliott", 23, "trainer");
        Person e = new Person("Matt", 35, "editor");
        PersonManager m = new PersonManager();

        m.addToList(a);
        m.addToList(b);
        m.addToList(c);
        m.addToList(d);
        m.addToList(e);

        m.savePersonList();

        m.loadPerson();
    }
}
