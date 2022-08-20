package SQL_Database.entity;
import java.sql.Date;

public class EmploymentHistory {
    private Integer id;
    private String header;
    private Date begin_date;
    private Date end_date;
    private String job_description;
    private User user;

    public EmploymentHistory(Integer id, String header, Date begin_date, Date end_date, String job_description, User user) {
        this.id = id;
        this.header = header;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.job_description = job_description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                ", job_description='" + job_description + '\'' +
                ", user=" + user +
                '}';
    }

    public EmploymentHistory() {

    }
}
