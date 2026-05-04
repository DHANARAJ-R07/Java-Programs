import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// Database Connection Class
class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/TelephoneBillingSystem";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "password"; // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

// Customer Management Class
class CustomerManager {
    public void addCustomer(String name, String email, String phoneNumber, String accountType) {
        String sql = "INSERT INTO Customer (name, email, phoneNumber, accountType) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setString(4, accountType);
            stmt.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Call Data Tracking Class
class CallManager {
    public void addCall(int customerId, Timestamp startTime, Timestamp endTime, double cost) {
        String sql = "INSERT INTO Call (customerId, startTime, endTime, cost) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.setTimestamp(2, startTime);
            stmt.setTimestamp(3, endTime);
            stmt.setDouble(4, cost);
            stmt.executeUpdate();
            System.out.println("Call data added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Billing Generation and Management Class
class BillingManager {
    public void generateBill(int customerId) {
        double totalCost = 0;
        
        String sql = "SELECT SUM(cost) AS total FROM Call WHERE customerId = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                totalCost = rs.getDouble("total");
            }
            
            String insertBill = "INSERT INTO Billing (customerId, totalAmount) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertBill)) {
                insertStmt.setInt(1, customerId);
                insertStmt.setDouble(2, totalCost);
                insertStmt.executeUpdate();
                System.out.println("Bill generated for Customer ID: " + customerId + ", Total Amount: " + totalCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Payment Processing Class
class PaymentManager {
    public void processPayment(int billId, double amount) {
        String sql = "INSERT INTO Payment (billId, paymentDate, amount) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, billId);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
            
            // Update Billing table to mark bill as paid
            String updateBill = "UPDATE Billing SET isPaid = TRUE WHERE billId = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateBill)) {
                updateStmt.setInt(1, billId);
                updateStmt.executeUpdate();
            }
            
            System.out.println("Payment processed for Bill ID: " + billId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Fraud Detection Manager Class
class FraudDetectionManager {
    private static final double MAX_CALL_COST_THRESHOLD = 50.00;
    private static final int MAX_CALLS_PER_DAY = 30;
    private static final int MAX_CALL_DURATION_MINUTES = 120;

    // Method to detect high-cost calls
    public List<Integer> detectHighCostCalls() {
        List<Integer> suspiciousCallIds = new ArrayList<>();
        String sql = "SELECT callId, customerId, cost FROM Call WHERE cost > ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, MAX_CALL_COST_THRESHOLD);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int callId = rs.getInt("callId");
                int customerId = rs.getInt("customerId");
                suspiciousCallIds.add(callId);
                System.out.println("High-cost call detected: Call ID " + callId + ", Customer ID " + customerId + ", Cost: " + rs.getDouble("cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return suspiciousCallIds;
    }

    // Method to detect excessive number of calls in a single day
    public List<Integer> detectExcessiveDailyCalls(int customerId) {
        List<Integer> suspiciousDays = new ArrayList<>();
        String sql = "SELECT DATE(startTime) AS callDate, COUNT(*) AS callCount " +
                     "FROM Call WHERE customerId = ? GROUP BY callDate HAVING callCount > ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, MAX_CALLS_PER_DAY);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Date callDate = rs.getDate("callDate");
                suspiciousDays.add(callDate.hashCode());
                System.out.println("Excessive calls detected on " + callDate + " for Customer ID " + customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return suspiciousDays;
    }

    // Method to detect unusually long call durations
    public List<Integer> detectLongCalls() {
        List<Integer> suspiciousCallIds = new ArrayList<>();
        String sql = "SELECT callId, customerId, TIMESTAMPDIFF(MINUTE, startTime, endTime) AS duration " +
                     "FROM Call WHERE TIMESTAMPDIFF(MINUTE, startTime, endTime) > ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, MAX_CALL_DURATION_MINUTES);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int callId = rs.getInt("callId");
                int customerId = rs.getInt("customerId");
                int duration = rs.getInt("duration");
                suspiciousCallIds.add(callId);
                System.out.println("Unusually long call detected: Call ID " + callId + ", Customer ID " + customerId + ", Duration: " + duration + " minutes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return suspiciousCallIds;
    }
}

// Main Class to Test the System
public class TelephoneBillingSystem {
    public static void main(String[] args) {
        // Initialize managers
        CustomerManager customerManager = new CustomerManager();
        CallManager callManager = new CallManager();
        BillingManager billingManager = new BillingManager();
        PaymentManager paymentManager = new PaymentManager();
        FraudDetectionManager fraudDetectionManager = new FraudDetectionManager();
        
        // Add a new customer
        customerManager.addCustomer("John Doe", "john@example.com", "1234567890", "postpaid");
        
        // Add call data for the customer
        callManager.addCall(1, Timestamp.valueOf("2024-11-01 08:30:00"), Timestamp.valueOf("2024-11-01 08:45:00");
                // Add multiple call records for testing
                callManager.addCall(1, Timestamp.valueOf("2024-11-01 08:30:00"), Timestamp.valueOf("2024-11-01 08:45:00"), 20.0);
                callManager.addCall(1, Timestamp.valueOf("2024-11-01 09:00:00"), Timestamp.valueOf("2024-11-01 09:30:00"), 45.0);
                callManager.addCall(1, Timestamp.valueOf("2024-11-01 14:15:00"), Timestamp.valueOf("2024-11-01 15:45:00"), 60.0); // Long duration for testing
                
                // Generate a bill for the customer
                billingManager.generateBill(1);
                
                // Process a payment for the generated bill (assuming the billId is 1)
                paymentManager.processPayment(1, 125.0); // Replace the amount with the total calculated amount if needed
                
                // Detect potential fraud
                System.out.println("Fraud Detection Results:");
                
                // Detect high-cost calls
                List<Integer> highCostCalls = fraudDetectionManager.detectHighCostCalls();
                System.out.println("High-Cost Calls: " + highCostCalls);
                
                // Detect excessive daily calls
                List<Integer> excessiveDailyCalls = fraudDetectionManager.detectExcessiveDailyCalls(1);
                System.out.println("Excessive Daily Calls: " + excessiveDailyCalls);
                
                // Detect unusually long calls
                List<Integer> longCalls = fraudDetectionManager.detectLongCalls();
                System.out.println("Long Calls: " + longCalls);
            }
        }
    
    
