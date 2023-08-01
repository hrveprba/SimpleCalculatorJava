import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        float a,b, result;
        char operator;
        Scanner inputUser;
        Timer timer = new Timer();
        
        System.out.println("Simple Calculator App \n");
        System.out.println("Today, this app only supported 4 math operators, are: \n1. addition\t\t(+) \n2. subtraction\t\t(-) \n3. multiplication\t(x) \n4. division\t\t(:)\n");

        inputUser = new Scanner(System.in);
        System.out.print("Value of variable a = ");
        a = inputUser.nextFloat();
        System.out.print("Math operator => ");
        operator = inputUser.next().charAt(0);
        System.out.print("Value of variable b = ");
        b = inputUser.nextFloat();

        // operator available : +,-,x,:

        if (operator == '+'){
            result = a + b;
            System.out.printf("\n%f %c %f = %f \n\n", a,operator,b,result);
        } else if (operator == '-'){
            result = a - b;
            System.out.printf("\n%f %c %f = %f \n\n", a,operator,b,result);
        } else if (operator == 'x'){
            result = a * b;
            System.out.printf("\n%f %c %f = %f \n\n", a,operator,b,result);
        } else if (operator == ':'){
            if (b==0){
                System.out.println("\nDIV/0! ERORR \n");
            } else{
                result = a / b;
                System.out.printf("\n%f %c %f = %f \n\n", a,operator,b,result);    
            }
        } else{
            System.out.println("\nMath operator that you've input not supported, sorry :( \n\n");
        }
        inputUser.close();
        timer.scheduleAtFixedRate(new TimerTask() {
            int timeLeftOver = 5;
            public void run(){
                System.out.printf("This app will be close in %ds \n", timeLeftOver);
                timeLeftOver--;
                if (timeLeftOver<0){
                    timer.cancel();
                    System.out.println("\nThank you for using this app, User! \n");
                    System.exit(0);
                }
            }
        }, 0, 1000);
    }
}
