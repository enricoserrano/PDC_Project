package gameGUI;

/**
 * This class has the variables that is being used in the ContinueScreen class
 * It is storing the current amount of money earned by the user.
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class ContinueVariables {

    private static int money;

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        ContinueVariables.money = money;
    }

}
