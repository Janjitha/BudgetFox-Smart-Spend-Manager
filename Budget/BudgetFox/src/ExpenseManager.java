import java.sql.*;

public class ExpenseManager {

    public void addExpense(Expense e) {
        String sql = "INSERT INTO expenses (category, amount, date, notes) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getCategory());
            ps.setDouble(2, e.getAmount());
            ps.setString(3, e.getDate());
            ps.setString(4, e.getNotes());
            ps.executeUpdate();
            System.out.println("Expense added successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewAllExpenses() {
        String sql = "SELECT * FROM expenses ORDER BY date DESC";
        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n All Expenses:");
            while (rs.next()) {
                System.out.println("[" + rs.getString("date") + "] Rs" + rs.getDouble("amount") + " - " + rs.getString("category") + " (" + rs.getString("notes") + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewByCategory(String cat) {
        String sql = "SELECT * FROM expenses WHERE category = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cat);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nExpenses in category: " + cat);
            while (rs.next()) {
                System.out.println("[" + rs.getString("date") + "] Rs" + rs.getDouble("amount") + " - " + rs.getString("notes"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public double getTotalForMonth(String month) {
        String sql = "SELECT SUM(amount) as total FROM expenses WHERE MONTHNAME(date) = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble("total");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public double getBudgetForMonth(String month) {
        String sql = "SELECT limit_amount FROM budgets WHERE month = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble("limit_amount");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public void setBudget(String month, double limit) {
        String sql = "REPLACE INTO budgets (month, limit_amount) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, month);
            ps.setDouble(2, limit);
            ps.executeUpdate();
            System.out.println("Budget set for " + month + ": Rs" + limit);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
