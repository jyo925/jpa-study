package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//엔티티를 찾아주는 것, DAO같은..
@Repository
public class MemberRepository {

    @PersistenceContext //스프링 부트가 의존성 주입해줌
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); //커메늗와 커리 분리 - member를 리턴하지 말고 아이디 정도만...
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
