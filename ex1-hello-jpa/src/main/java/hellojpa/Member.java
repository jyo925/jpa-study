package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    //테이블에 맞춰서 외래키 값을 그대로 가지고 있음
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    //member입장이 N이고 team이 1이므로
    @ManyToOne(fetch = FetchType.LAZY) //지연로딩: team을 프록시객체로 조회함 -> member클래스만 조회한다는 것
//    @ManyToOne(fetch = FetchType.EAGER) //즉시로딩: 실제 엔티티를 조회함
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID")) //테이블 명 지정
    @Column(name = "FOOD_NAME") //값이 String 하나이기 때문에 컬럼명 셋팅
    private Set<String> favoriteFoods = new HashSet<>();

/*    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID")) //테이블 명 지정
    private List<Address> addressesHistory = new ArrayList<>();*/

    //Entity로 맵핑
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID") //단방향 맵핑
    private List<AddressEntity> addressesHistory = new ArrayList<>();

    public List<AddressEntity> getAddressesHistory() {
        return addressesHistory;
    }

    public void setAddressesHistory(List<AddressEntity> addressesHistory) {
        this.addressesHistory = addressesHistory;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

/*
    public List<Address> getAddressesHistory() {
        return addressesHistory;
    }

    public void setAddressesHistory(List<Address> addressesHistory) {
        this.addressesHistory = addressesHistory;
    }
*/

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}