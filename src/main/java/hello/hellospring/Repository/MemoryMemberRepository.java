package hello.hellospring.Repository;

import hello.hellospring.Domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static Long sequence = 0L;  //0,1,2 키값을 생성해주준다.


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
         return Optional.ofNullable(store.get(id)); //이 결과가 null이면? null이 반환될 가능성이 있으면 Optional.ofNullable로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
//        findAny()는 Stream에서 가장 먼저 탐색되는 요소를 리턴하고,
//        findFirst()는 조건에 일치하는 요소들 중에 Stream에서 순서가 가장 앞에 있는 요소를 리턴합니다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
