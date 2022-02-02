package kg.aleksandrov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    static String getResult(Cashier cashier){
        for (BlackList blackList : blackList){
            if (cashier.getPatr() != null){
                int sum;
                int total;
                sum = calculate(blackList.getSurname().toLowerCase(), cashier.getSurname().toLowerCase());
                sum += calculate(blackList.getName().toLowerCase(), cashier.getName().toLowerCase());
                sum += calculate(blackList.getPatr().toLowerCase(), cashier.getPatr().toLowerCase());
                if (sum <= 3){
                    return cashier.getSurname() + " " + cashier.getName() + " " + cashier.getPatr();
                } else {
                    total = calculate(blackList.getBirthDate(), cashier.getBirthDate());
                }
                if (sum + total == sum){
                    return cashier.getSurname() + " " + cashier.getName() + " " + cashier.getPatr();
                }
            } else {
                int sum;
                sum = calculate(blackList.getSurname().toLowerCase(), cashier.getSurname().toLowerCase());
                sum += calculate(blackList.getName().toLowerCase(), cashier.getName().toLowerCase());
                return cashier.getSurname() + " " + cashier.getName() + " " + cashier.getPatr();
            }

        }
        return null;
    }

    private static final List<Cashier> cashiers = new ArrayList<>();
    private static final List<BlackList> blackList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        cashiers.add(new Cashier("Абдурасул", "Кайыпов", "Орозмаматович", "10-01-1977"));
        cashiers.add(new Cashier("Алишер", "Абдрахманов", "Нурланбекович", "10-01-1977"));
        cashiers.add(new Cashier("Алишер", "Абдрахманов", "ТИЛЕВАЛДЫЕВИЧ", "10-01-1987"));
        cashiers.add(new Cashier("ИСМАИЛЖОН", "ИСХАКОВ", "ИСРАИЛОВИЧ", "10-01-1977"));
        cashiers.add(new Cashier("БУРУЛАЙ", "РАХМАНЖАН КЫЗЫ", "", "10-01-1977"));
        cashiers.add(new Cashier("ЭЛБЕК", "ХАЛИЛОВ", "АБДУХАЛИЛОВИЧ", "10-01-1977"));
        cashiers.add(new Cashier("ДИЛШАД", "АРИПОВ", "АДИЛЖАНОВИЧ", "10-01-1977"));
        cashiers.add(new Cashier("Исломжон", "Рахманов", "Дилмуратович", "10-01-1977"));
        cashiers.add(new Cashier("ИЛХОМЖОН", "РАХМАНОВ", "ИКРОМИДИНОВИЧ", "10-01-1979"));
        cashiers.add(new Cashier("Вахиджан", "Кочкаров", "Тахирович", "14-01-1990"));

        blackList.add(new BlackList("Абдурасул", "Кайыпов", "Орозмаматович", "10-01-1977"));
        blackList.add(new BlackList("Алишер", "Абдрахманов", "Нурланбекович", "10-01-1977"));
        blackList.add(new BlackList("Исмаилжан", "Исаков", "Исраилович", "10-01-1944"));
        blackList.add(new BlackList("БУРУЛАЙ", "РАХМАНЖАН КЫЗЫ", "", "10-01-1977"));
        blackList.add(new BlackList("ЭЛБЕК", "ХАЛИЛОВ", "АБДУХАЛИЛОВИЧ", "10-01-1977"));
        blackList.add(new BlackList("ДИЛШАД", "АРИПОВ", "АДИЛЖАНОВИЧ", "10-01-1977"));
        blackList.add(new BlackList("Исломжон", "Рахманов", "Дилмуратович", "10-01-1977"));
        blackList.add(new BlackList("Вахиджон", "Кочкаров", "Тахиржанович", "14-01-1990"));

        System.out.println(calculate("Вахиджан", "Вахиджон"));
        System.out.println(calculate("Кочкаров", "Кочкаров"));
        System.out.println(calculate("Тахирович", "Тахиржанович"));
        System.out.println(calculate("14-01-1990", "14-01-1990"));

        for (Cashier cashier : cashiers){
            String resultString = getResult(cashier);
            if (resultString != null){
                System.out.println(resultString);
            }
        }
    }
}
