package closure;

public class MikeConsole {
    public static void main(String[] args) {
        Milk m = new Milk();

        Active haveMeals = m.HaveMeals();

        haveMeals.drink();
        haveMeals.drink();

        m.currentNum();
    }
}
