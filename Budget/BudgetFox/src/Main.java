import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n--- BudgetFox : Smart Spend Manager ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Expenses by Category");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. Check Spending Status");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter Amount (Rs.): ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Notes: ");
                    String notes = sc.nextLine();
                    Expense e = new Expense(cat, amt, date, notes);
                    manager.addExpense(e);
                    break;

                case 2:
                    manager.viewAllExpenses();
                    break;

                case 3:
                    System.out.print("Enter Category: ");
                    String c = sc.nextLine();
                    manager.viewByCategory(c);
                    break;

                case 4:
                    System.out.print("Enter Month (e.g., July): ");
                    String m = sc.nextLine();
                    System.out.print("Enter Budget Limit (Rs.): ");
                    double b = sc.nextDouble();
                    sc.nextLine();
                    manager.setBudget(m, b);
                    break;

                case 5:
                    System.out.print("Enter Month (e.g., July): ");
                    String mon = sc.nextLine();
                    double total = manager.getTotalForMonth(mon);
                    double limit = manager.getBudgetForMonth(mon);
                    System.out.println("Total spent in " + mon + ": Rs." + total);
                    System.out.println("Budget limit: Rs." + limit);
                    if (total > limit)
                        System.out.println("Alert: You have exceeded your budget.");
                    else
                        System.out.println("Status: You are within budget.");
                    break;

                case 6:
                    System.out.println("Exiting. Stay smart with BudgetFox.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
