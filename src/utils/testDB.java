package utils;
import utils.JdbcUtils;
import java.sql.Connection;

public class testDB {
    public static void main(String[] args) {
        try {
            System.out.println("🟡 正在尝试连接数据库...");
            Connection conn = JdbcUtils.getConnection();
            if (conn != null) {
                System.out.println("✅ 数据库连接成功！");
                conn.close();
            } else {
                System.out.println("❌ 数据库连接失败！");
            }
        } catch (Exception e) {
            System.out.println("❌ 发生异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
