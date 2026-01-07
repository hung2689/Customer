package dal;

import java.util.List;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO extends DBContext {

    private final String GET_CUSTOMER_BYID = "select * from [dbo].[CUSTOMER]\n"
            + "WHERE Ma_KH=?";
    private final String GET_CUSTOMER_SQL = "SELECT * FROM CUSTOMER";
    private final String REMOVE_CUSTOMER_SQL = "DELETE FROM [dbo].[CUSTOMER]\n" + "      WHERE Ma_KH=?";
    private final String ADD_CUSTOMER_SQL = "INSERT INTO [dbo].[CUSTOMER]\n"
            + "           ([Ma_KH]\n"
            + "           ,[Ten_KH]\n"
            + "           ,[Dia_chi]\n"
            + "           ,[Dien_thoai])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?)";
    private final String UPDATE_CUSTOMER_SQL = "UPDATE [dbo].[CUSTOMER]\n"
            + "   SET [Ten_KH] = ?\n"
            + "      ,[Dia_chi] = ?\n"
            + "      ,[Dien_thoai] = ?\n"
            + " WHERE Ma_KH=?";

    public Customer getCustomerByID(String code) {
        try (PreparedStatement stm = c.prepareStatement(GET_CUSTOMER_BYID)) {

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            return new Customer(
                    rs.getString("Ma_KH"),
                    rs.getString("Ten_KH"),
                    rs.getString("Dia_chi"),
                    rs.getString("Dien_thoai")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }

    public List<Customer> getListCustomer() {
        List<Customer> kq = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_CUSTOMER_SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer(rs.getString("Ma_KH"),
                        rs.getString("Ten_KH"),
                        rs.getString("Dia_chi"),
                        rs.getString("Dien_thoai"));
                kq.add(cus);
            }
        } catch (Exception E) {
            return null;
        }
        return kq;
    }

    public boolean addCustomer(Customer ct) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_CUSTOMER_SQL);
            stm.setString(1, ct.getCode());
            stm.setString(2, ct.getName());
            stm.setString(3, ct.getAddress());
            stm.setString(4, ct.getPhone());
            int n = stm.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeCustomerByID(String id) {
        try {
            PreparedStatement stm = c.prepareStatement(REMOVE_CUSTOMER_SQL);
            stm.setString(1, id);
            int n = stm.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

   public boolean updateCustomerByID(Customer ct) {
    if (ct == null) return false;

    try (PreparedStatement stm = c.prepareStatement(UPDATE_CUSTOMER_SQL)) {

        stm.setString(1, ct.getName());
        stm.setString(2, ct.getAddress());
        stm.setString(3, ct.getPhone());
        stm.setString(4, ct.getCode());

        return stm.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace(); // log lỗi
        return false;
    }
}

    public static void main(String[] args) {
        CustomerDAO cd = new CustomerDAO();
        cd.updateCustomerByID(new Customer("KH101", "Hung yeu thao", "AA", "080908023"));
        for (Customer c : cd.getListCustomer()) {
            System.out.println(c.toString());
        }
    }
}
