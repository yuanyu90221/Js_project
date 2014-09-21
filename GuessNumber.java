package com.YuanyuGuess;

//import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author asus-nb
 */
public class GuessNumber {

    /**
     * @param args the command line arguments
     */
    protected static int Answer[] = {0, 0, 0};
    protected static int Guess_buffer[] = {0, 0, 0};
    protected static int count_B = 0, count_A = 0;
    protected static boolean Number[] = {false, false, false, false, false,
        false, false, false, false};

    public static void main(String[] args) {
        // TODO code application logic here
        String Play_again;
        Scanner in = new Scanner(System.in);
        do {
            generate_number();

            show_answer();
            System.out.println();
            do {
                System.out.print("請輸入"
                        + " number :");
                String number = in.next();
                parser_input(number);
                show_input();
                Find_A();
                Find_B();
                System.out.println();
                if (count_A == 3) {
                    System.out.println("恭喜你猜對了!");
                }
            } while (count_A != 3);
            System.out.print("Would you want to play again?:(Y/N)");
            Play_again = in.next();
        } while (Play_again.equals("Y"));
    }

    private static void generate_number() {
        for (int i = 0; i < Answer.length; i++)//Generate not-repeat 
        {
            Answer[i] = (int) (Math.floor(Math.random() * 9) + 1);
            while (Number[Answer[i] - 1] == true) {
                Answer[i] = (int) (Math.floor(Math.random() * 9) + 1);
            }
            Number[Answer[i] - 1] = true;
        }
    }

    private static void parser_input(String number) {

        int input = Integer.parseInt(number);
        Guess_buffer[0] = input / 100;
        Guess_buffer[1] = (input % 100) / 10;
        Guess_buffer[2] = input % 10;
    }

    private static void Find_A() {
        //show_input();
        count_A = 0;
        for (int i = 0; i < Guess_buffer.length; i++) {
            if (Answer[i] == Guess_buffer[i]) {
                count_A++;
            }
        }
        System.out.print(count_A + "A");
    }

    private static void Find_B() {
        //show_input();
        count_B = 0;
        for (int i = 0; i < Guess_buffer.length; i++) {
            for (int j = 0; j < Answer.length; j++) {
                if (j == i) {
                    continue;
                } else if (Answer[j] == Guess_buffer[i]) {
                    count_B++;
                    break;
                }
            }
        }
        System.out.print(count_B + "B");
    }

    private static void show_input() {
        System.out.print("This is your answer : ");
        for (int i = 0; i < Guess_buffer.length; i++) {
            System.out.print(Guess_buffer[i]);
        }
        System.out.print(" ");
        //System.out.println();
    }

    private static void show_answer() {
        System.out.print("True answer is : ");
        for (int i = 0; i < Answer.length; i++) {
            System.out.print(Answer[i]);
        }
        System.out.println();
    }
}
