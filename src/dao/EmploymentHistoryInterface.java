package dao;
import entitiy.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryInterface {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
}
