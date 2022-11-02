import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner myObj = new Scanner(System.in);
        System.out.println(calc(myObj.nextLine()));
    }
    public static String calc(String input)
    {
        String [] rome0 = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String [] rome1 ={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] rome2 ={"","C"};
        String[] num = input.split(" ");
        String out = null;
        Boolean isRome= false;
        if(!num[0].chars().allMatch(x -> Character.isDigit(x)) &&
                !num[2].chars().allMatch(x -> Character.isDigit(x))) {
            num[0] = String.valueOf(Arrays.asList(rome0).indexOf(num[0]));
            num[2]= String.valueOf(Arrays.asList(rome0).indexOf(num[2]));
            isRome=true;
        }
        if((1 >= Integer.parseInt(num[0]) || Integer.parseInt(num[0]) <= 10)
            && (1 >= Integer.parseInt(num[2]) || Integer.parseInt(num[2]) <= 10)
         && num.length<4)
        {
            switch (num[1].charAt(0)) {
                case '+' -> out = String.valueOf(Integer.parseInt(num[0]) + Integer.parseInt(num[2]));
                case '-' -> out = String.valueOf(Integer.parseInt(num[0]) - Integer.parseInt(num[2]));
                case '*' -> out = String.valueOf(Integer.parseInt(num[0]) * Integer.parseInt(num[2]));
                case '/' -> out = String.valueOf(Integer.parseInt(num[0]) / Integer.parseInt(num[2]));
                default -> out = "Не удовлетворяет условию";
            }
            if (isRome)
                out = new StringBuilder()
                        .append(rome2[Integer.parseInt(out) % 1000 / 100])
                        .append(rome1[Integer.parseInt(out) % 100 / 10])
                        .append(rome0[Integer.parseInt(out) % 10])
                        .toString();
        }
        else throw new RuntimeException("Не удовлетворяет условию");

            return out;

    }
}