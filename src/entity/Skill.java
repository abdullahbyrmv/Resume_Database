package SQL_Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill", schema = "resume", catalog = "")
public class Skill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "skill_name")
    private String skillName;

    public Skill() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Skill(int id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill that = (Skill) o;

        if (id != that.id) return false;
        if (skillName != null ? !skillName.equals(that.skillName) : that.skillName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (skillName != null ? skillName.hashCode() : 0);
        return result;
    }
}
