package SQL_Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "nationality", schema = "resume", catalog = "")
public class Nationality {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nationality_name")
    private String nationalityName;

    public Nationality() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    public Nationality(int id, String nationalityName) {
        this.id = id;
        this.nationalityName = nationalityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nationality that = (Nationality) o;

        if (id != that.id) return false;
        if (nationalityName != null ? !nationalityName.equals(that.nationalityName) : that.nationalityName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nationalityName != null ? nationalityName.hashCode() : 0);
        return result;
    }
}
