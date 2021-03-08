package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    //git 반영 test
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//<persistence-unit name="hello">

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
/*            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); //pk값이 셋팅되고나서 영속상태가 됨

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //jpa가 알아서 외래키 값을 뽑아서 insert할때 사용함
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId()); //1차 캐시에서 가져올거임

            Team findTeam = findMember.getTeam();*/

/*
            Member findMember = em.find(Member.class, 2L);
            Team newTeam = new Team("lolollolololTeam");
            em.persist(newTeam);
            findMember.setTeam(newTeam);
*/

/*            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); //pk값이 셋팅되고나서 영속상태가 됨

            Locker locker =  new Locker();
            locker.setName("락커넘버완");
            em.persist(locker);

            Member member = new Member();
            member.setName("member1");
            member.setLocker(locker);
            //meber table은 id, username, team_id 컬럼만 있는데
            //아래 team객체를 set, change 등의 메소드로 member객체에 넣어주면 
            //jpa가 알아서 team_id(외래키 값)을 뽑아서 insert할때 사용함
            member.changeTeam(team); //연관관계 편의 메소드1, 둘 중 하나만 사용해야 함
//            team.addMember(member); //연관관계 편의 메소드2
            em.persist(member); //persist 작업 후 id값을 member 객체에 넣어줌
            
            //team쪽에도 넣어주는게, 즉 양쪽 모두 넣어주는게 객체지향적으로 맞음
//            team.getMembers().add(member); -> 연관관계 편의 메소드로 대체 (memer.setTeam(changeTeam)안에 넣어줌)

            em.flush(); //영속성 컨텍스트의 변경 내용을 DB에 반영(비우는게 아님)
            em.clear(); //영속성 컨텍스트 초기화 -> 모든 엔티티를 준영속성으로 만든다.

            Member findMember = em.find(Member.class, member.getId());
            //멤버에서 팀을 조회 -> 팀에서 멤버를 조회가 가능
            List<Member> members = findMember.getTeam().getMembers();

            System.out.println("=========================================================");
            for (Member m : members) {
                System.out.println("m = " + m.getName());
            }*/


/*            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findeMovie = " + findMovie.getName());*/


            Member member = new Member();
            member.setCreatedBy("kim");
            member.setName("user1");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);
            em.flush();
            em.clear();

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
