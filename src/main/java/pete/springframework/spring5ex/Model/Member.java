package pete.springframework.spring5ex.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Member {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastName;
        private int age;

        @ManyToMany
        @JoinTable(name = "crue_member", joinColumns = @JoinColumn(name = "member_id"),
                inverseJoinColumns = @JoinColumn(name = "crue_id"))
        private Set<Crue> crues = new HashSet<>();


        public Member() {
        }

        public Member(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Member(String firstName, String lastName, int age, Set<Crue> crues) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.crues = crues;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    public Set<Crue> getCrues() {
        return crues;
    }

    public void setCrues(Set<Crue> crues) {
        this.crues = crues;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Member member = (Member) o;

            return id != null ? id.equals(member.id) : member.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", crues=" + crues +
                    '}';
        }
    }


