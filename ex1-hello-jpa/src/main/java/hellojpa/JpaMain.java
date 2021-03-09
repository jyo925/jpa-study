package hellojpa;

import org.hibernate.Hibernate;

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

/*
//            Member findMember = em.find(Member.class, 33L);
            Member findMember = em.getReference(Member.class, 33L); //프록시 객체 조회
            System.out.println(findMember.getClass());
            System.out.println(findMember.getId());
            System.out.println(findMember.getName()); //name등 실제 값을 호출할 때 그 때 프록시 객체가 영속성 컨텍스트에 초기화 요청함 -> 쿼리 나감*/


/*            Member m1 = em.find(Member.class, 33L);
            System.out.println(m1.getClass());

            Member reference = em.getReference(Member.class, 33L); //영속성에 엔티티가 이미 있으면 프록시객체가 아닌 실제 엔티티 반환
            System.out.println(reference.getClass());
            
            //JPA에서는 한 트랜잭션 안에서는 동일 객체를 보장한다는 특징
            //프록시로 반환해봐야 이점이 없으므로 reference도 실제 엔티티를 얻게됨
            System.out.println("a == a : " + (m1 == reference));*/

/*            Member reference1 = em.getReference(Member.class, 33L);
            Member reference2 = em.getReference(Member.class, 33L);
            System.out.println("a == a : " + (reference2 == reference1)); //true*/


/*            //순서를 뒤집어서
            Member refMember = em.getReference(Member.class, 33L);
            System.out.println("refMember = " + refMember.getClass()); //Proxy

            Member findMember = em.find(Member.class, 33L); //Proxy를 가져옴 (JPA가 동일 객체를 보장하려고하기 때문임...) 실제 조회 쿼리가 나감 but 프록시가 담김
            System.out.println("findMember = " + findMember.getClass());
            System.out.println("findMember = " + findMember.getName());

            System.out.println("a == a : " + (findMember == refMember)); //true

//            em.detach(refMember);    // or em.close() -> 관리 X
////            System.out.println(refMember.getName()); //비영속 상태에서 초기화는 불가능(에러)
                // -> 근데 위에 findMember를 주석 해제하면 에러가 안남(똑같이 프록시가 담기는데...??)*/

/*            Member refMember = em.getReference(Member.class, 33L);
            System.out.println("refMember = " + refMember.getClass());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); //초기화 여부

            Hibernate.initialize(refMember);*/

/*            Member member = em.find(Member.class, 33L);
            Team team = new Team();
            team.setName("teamC");
            em.persist(team);
            member.setTeam(team);

            em.flush();
            em.clear();
*/

/*             Member member1 = em.find(Member.class, 33L);
           System.out.println("member = " + member1.getTeam().getClass());//지연로딩을 걸었기 때문에 Proxy team 반환됨

            System.out.println("실제 사용 시점에 초기화(객체 조회 쿼리 나감)");
            member1.getTeam().getName(); //초기화

            //즉시로딩 Eager
            System.out.println("member1.getTeam().getClass() = " + member1.getTeam().getClass());*/

/*
            //JPQL에서 N+1 문제 발생
            List<Member> results = em.createQuery("select m from Member m", Member.class).getResultList();
            //쿼리가 두번 나가게 됨, 즉시로딩 걸어둔 객체는 값이 무조건 들어가야 하기 때문
            //SQL: select * from member(1)
            //SQL: select * from team where team_id = xxx ---> 이때 team 조회 쿼리는 member 수 만큼 나감(N)

            //지연로딩이여도 한번에 불러오려면 fetch join 사용
            List<Member> results2 = em.createQuery("select m from Member m join fetch m.team join fetch m.locker", Member.class).getResultList();
*/

/*            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
            //persist를 여러번 하지 않고 한번에 저장하는 방법 -> cascade사용
            //parent와 연관된 child도 같이 저장
            em.persist(parent);*/

            /*//orphanRemoval = true -> delete from child where id = ?
            Parent parent = em.find(Parent.class, 65L);
            parent.getChildList().remove(0);
*/

            em.remove(em.find(Parent.class, 65L));
            //child 생명주기를 parent가 관리한다고 볼 수 있음 -> child는 DAO, Repository 등이 없어도 되는 것....


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
