package SQL_Database.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employment_history", schema = "resume", catalog = "")
public class EmploymentHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "company")
    private String company;
    @Basic
    @Column(name = "begin_date")
    private Date beginDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "job_Description")
    private String jobDescription;
    @Basic
    @Column(name = "user_id")
    private Integer userId;

    public EmploymentHistory() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public EmploymentHistory(int id, String company, Date beginDate, Date endDate, String jobDescription, Integer userId) {
        this.id = id;
        this.company = company;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmploymentHistory that = (EmploymentHistory) o;

        if (id != that.id) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (jobDescription != null ? !jobDescription.equals(that.jobDescription) : that.jobDescription != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
