
# 💼 BudgetFox – Smart Expense Manager (Java + MySQL)

## 📋 Prerequisites
- JDK installed (Java 8 or above)
- MySQL installed and running
- MySQL Connector JAR (used version: `mysql-connector-j-8.3.0.jar`)
- Database `budgetfox_db` created with required tables

---

## 🗃️ Database Setup

Create a database named:
```sql
CREATE DATABASE budgetfox_db;
```

Then, create the required table:
```sql
USE budgetfox_db;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount DOUBLE,
    date DATE,
    notes TEXT
);

CREATE TABLE budgets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    month VARCHAR(20),
    amount DOUBLE
);
```

---

## 🧩 Project Folder Structure
```
BudgetFox/
│
├── lib/
│   └── mysql-connector-j-8.3.0.jar
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseManager.java
│   └── DBConnection.java
```

---

## 🧪 How to Compile and Run

> ✅ This works **only when MySQL Connector is correctly linked** via classpath.

### 🔧 1. Go to your src folder:
```bash
cd C:\Users\Janjitha\Desktop\Budget\BudgetFox\src
```

### 🛠️ 2. Compile Java files with classpath:
```bash
javac -cp "..\lib\mysql-connector-j-8.3.0.jar" *.java
```

### ▶️ 3. Run the program using classpath:
```bash
java -cp ".;..\lib\mysql-connector-j-8.3.0.jar" Main
```

---

## ⚠️ Common Error
If you miss the `-cp` in the run command, it will always say:

```
No suitable driver found for jdbc:mysql://...
```

📌 **Without this, the code will not run. So be sure to include the `-cp` option during both compile and run.**

---

---

## 🎯 Possible Outcomes

Below are the expected outputs when interacting with the BudgetFox Smart Spend Manager:

### 1. Adding an Expense
```
📊 BudgetFox – Smart Spend Manager
1. Add Expense
...
Enter choice: 1
Category: Food
Amount (Rs.): 250
Date (YYYY-MM-DD): 2025-07-30
Notes: Lunch at cafe
✅ Expense added successfully!
```

### 2. Viewing All Expenses
```
📊 BudgetFox – Smart Spend Manager
1. Add Expense
...
Enter choice: 2
--- Expenses List ---
Category: Food | Amount: Rs.250.0 | Date: 2025-07-30 | Notes: Lunch at cafe
----------------------
```

### 3. Viewing Expenses by Category
```
Enter choice: 3
Enter category: Food
--- Expenses in Category: Food ---
Category: Food | Amount: Rs.250.0 | Date: 2025-07-30 | Notes: Lunch at cafe
----------------------
```

### 4. Setting Monthly Budget
```
Enter choice: 4
Enter month (e.g., July): July
Set budget limit (Rs.): 3000
✅ Budget set for July: Rs.3000.0
```

### 5. Checking Spending Status
```
Enter choice: 5
Enter month (e.g., July): July
🧾 Total spent in July: Rs.250.0
🎯 Budget limit: Rs.3000.0
✅ You're within budget.
```

### 6. Exiting the Program
```
Enter choice: 6
👋 Exiting. Stay smart with BudgetFox!
```

### 7. Invalid Option
```
Enter choice: 9
❌ Invalid choice.
```

