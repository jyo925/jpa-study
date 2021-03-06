package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") //Member객체에 있는 team이라는 변수에 걸려있다고 명시(=주인이 team이라는 것을 알려주는 것)
    private List<Member> members = new ArrayList<>();

    public Team() {

    }

    public Team(String name){
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
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

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
}
