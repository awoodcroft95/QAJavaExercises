public class BasicExercises {
    public static void main(String[] args){
        System.out.println("Hello World!");
        String helloWorld = "Hello World!";
        System.out.println(helloWorld);
        BasicExercises.outputString(helloWorld);
        System.out.println(returnHelloWorld());
        System.out.println(returnInt(1, 2, false));
        iteration();
        arrays();
        iterationOverArrays();
        iterationOverArrays2();
    }

    public static void outputString(String input){
        System.out.println(input);
    }

    public static String returnHelloWorld(){
        return "Hello World!";
    }

    public static int returnInt(int a, int b, boolean c){
        if (a == 0){
            return b;
        }
        else if (b == 0){
            return a;
        }
        else if (c){
            return a + b;
        }
        else {
            return a * b;
        }
    }

    public static void iteration(){
        for (int i = 0; i < 10; i++){
            System.out.println(returnInt(i, 3, true));
        }
    }

    public static void arrays(){
        int[] arrayOfInts = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(returnInt(arrayOfInts[2], arrayOfInts[5], true));
    }

    public static void iterationOverArrays(){
        int[] arrayOfInts = {0,1,2,3,4,5,6,7,8,9};
        for(int i : arrayOfInts){
            System.out.println(i);
        }
    }

    public static void iterationOverArrays2(){
        int[] iterationFilledArray = new int[10];
        for(int i = 0; i < 10; i++){
            iterationFilledArray[i] = i;
            System.out.println(iterationFilledArray[i]);
        }
        for(int j = 0; j < 10; j++){
            iterationFilledArray[j] = iterationFilledArray[j] * 10;
            System.out.println(iterationFilledArray[j]);
        }
    }
}
