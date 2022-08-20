package SQL_Database.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user", schema = "resume", catalog = "")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "profile_description")
    private String profileDescription;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "birthdate")
    private Date birthdate;
    @Basic
    @Column(name = "birthplace_id")
    private Integer birthplaceId;
    @Basic
    @Column(name = "nationality_id")
    private Integer nationalityId;
    @Basic
    @Column(name = "old_company_name")
    private String oldCompanyName;
    @Basic
    @Column(name = "begin_date")
    private Date beginDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "job_description")
    private String jobDescription;
    @Basic
    @Column(name = "employment_id")
    private Integer employmentId;
    @Basic
    @Column(name = "password")
    private String password;

    public User() {

    }

    public User(int id, String name, String surname, String phone, String email, String profileDescription, String address, Date birthdate, Nationality nationality, Country birthplace, String header, Date begin_date, Date end_date, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.birthplaceId = birthplaceId;
        this.nationalityId = nationalityId;
        this.oldCompanyName = oldCompanyName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getBirthplaceId() {
        return birthplaceId;
    }

    public void setBirthplaceId(Integer birthplaceId) {
        this.birthplaceId = birthplaceId;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getOldCompanyName() {
        return oldCompanyName;
    }

    public void setOldCompanyName(String oldCompanyName) {
        this.oldCompanyName = oldCompanyName;
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

    public Integer getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(Integer employmentId) {
        this.employmentId = employmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String surname, String email, String phone, String profileDescription, String address, Date birthdate, Integer birthplaceId, Integer nationalityId, String oldCompanyName, Date beginDate, Date endDate, String jobDescription) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.birthplaceId = birthplaceId;
        this.nationalityId = nationalityId;
        this.oldCompanyName = oldCompanyName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (profileDescription != null ? !profileDescription.equals(that.profileDescription) : that.profileDescription != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (birthplaceId != null ? !birthplaceId.equals(that.birthplaceId) : that.birthplaceId != null) return false;
        if (nationalityId != null ? !nationalityId.equals(that.nationalityId) : that.nationalityId != null)
            return false;
        if (oldCompanyName != null ? !oldCompanyName.equals(that.oldCompanyName) : that.oldCompanyName != null)
            return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (jobDescription != null ? !jobDescription.equals(that.jobDescription) : that.jobDescription != null)
            return false;
        if (employmentId != null ? !employmentId.equals(that.employmentId) : that.employmentId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (profileDescription != null ? profileDescription.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (birthplaceId != null ? birthplaceId.hashCode() : 0);
        result = 31 * result + (nationalityId != null ? nationalityId.hashCode() : 0);
        result = 31 * result + (oldCompanyName != null ? oldCompanyName.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + (employmentId != null ? employmentId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
