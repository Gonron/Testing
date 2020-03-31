package dk.cphbusiness.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataAccessObject {

    public static void CreatUser() {
        try {
            Connection conn = DBConnector.connection();
            String SQL = "INSERT INTO customer (cpr, name) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, "1204971234");
            ps.setString(2, "Michael");
            ResultSet rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        CreatUser();
    }
}