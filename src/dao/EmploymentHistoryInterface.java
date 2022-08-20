package SQL_Database.dao;
import SQL_Database.entity.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryInterface {
    public List<EmploymentHistory> getAllEmploymentHistory(int id);
}
