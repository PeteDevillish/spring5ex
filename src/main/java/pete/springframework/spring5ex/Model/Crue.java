package pete.springframework.spring5ex.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Crue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private boolean isPublic;

    @ManyToMany
            (mappedBy = "crues")
    private Set<Member> members = new HashSet<>();


    public Crue() {
    }

    public Crue(String name, String type, boolean isPublic) {
        this.name = name;
        this.type = type;
        this.isPublic = isPublic;
    }

    public Crue(String name, String type, boolean isPublic, Set<Member> members) {
        this.name = name;
        this.type = type;
        this.isPublic = isPublic;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crue crue = (Crue) o;

        return id != null ? id.equals(crue.id) : crue.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Crue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isPublic=" + isPublic +
                ", members=" + members +
                '}';
    }
}
