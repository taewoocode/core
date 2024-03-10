package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // Impl이라고 클래스를 만들어준 이유는 구현체가 하나만 있을 경우에는 Impl이라고 관례상 많이 적어준다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save( member );

        //save를 호출하게 되면 Override된게 호출이 된다.

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByid( memberId );

    }
}
