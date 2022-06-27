package userDaoImpl;
import AbstractDao.abstractDao;
import dao.EmploymentHistoryInterface;
import entitiy.EmploymentHistory;
import entitiy.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends abstractDao implements EmploymentHistoryInterface {
    private EmploymentHistory getEmploymentHistory(ResultSet res) throws SQLException {
        String header = res.getString("header");
        Date beginDate = res.getDate("begin_date");
        Date endDate = res.getDate("end_date");
        int userId = res.getInt("user_id");
        String jobDescription = res.getString("job_description");

        EmploymentHistory emp_history = new EmploymentHistory(null,header,beginDate,endDate,jobDescription,new User(userId));
        return emp_history;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> list = new ArrayList<>();
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("select * from employment_history where user_id = ?");
            st.setInt(1,userId);
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()) {
                EmploymentHistory emp_history = getEmploymentHistory(result);
                list.add(emp_history);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
