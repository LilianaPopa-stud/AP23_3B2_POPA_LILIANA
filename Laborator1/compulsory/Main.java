package compulsory;

/**
 * Compulsory
 *
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        int d = Integer.parseInt("10101", 2);
        int h = Integer.parseInt("FF", 16);
        n = (n + d + h) * 6;
        int result = 0;

        while (n > 0) {
            result = result + n % 10;
            n = n / 10;
        }
        int newResult = 0;

        if (result > 9) {
            while (result > 0) {
                newResult = newResult + result % 10;
                result = result / 10;
            }
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[newResult]);
    }

}
