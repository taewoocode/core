package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // Impl이라고 클래스를 만들어준 이유는 구현체가 하나만 있을 경우에는 Impl이라고 관례상 많이 적어준다.

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save( member );

        //save를 호출하게 되면 Override된게 호출이 된다.
        //interface에서 추상적으로 구현해 놓은 메서드를 override된 구현체에서 메소드를 정의해 둔다.

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByid( memberId );

    }
}
