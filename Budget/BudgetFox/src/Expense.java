public class Expense {
    private String category;
    private double amount;
    private String date;
    private String notes;

    public Expense(String category, double amount, String date, String notes) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.notes = notes;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getNotes() { return notes; }
}
