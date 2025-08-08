public class Expense {
    private String category;
    private double amount;
    private String date;
    private String notes;

    // This is a constructor used to initialize a new Expense object with specific values.
    public Expense(String category, double amount, String date, String notes) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.notes = notes;
    }
    //There are no setter methods here because the object is treated as read-only once created
    public String getCategory() { 
        return category; 
    }
    public double getAmount() { 
        return amount; 
    }
    public String getDate() { 
        return date; 
    }
    public String getNotes() { 
        return notes; 
    }
}

