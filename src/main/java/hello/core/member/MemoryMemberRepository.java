package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    //MemberService에서 정의해둔 추상적 메소드를 MemoryMemberRepository에서 메서드를 override해서 구현을 해놓는다.

    @Override
    public void save(Member member) {
        store.put( member.getId(), member );

    }

    @Override
    public Member findByid(Long memberId) {
        return store.get(memberId);
    }
}
