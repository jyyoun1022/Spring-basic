package hello.hellospring.Repository;

import hello.hellospring.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //회원이 저장소에 저장
    Optional<Member> findById(Long id); //아이디로 회원을 찾아
    Optional<Member> findByName(String name);   //이름으로 회원을 찾아
    List<Member> findAll(); //리스트로 회원모두 반환
}
