package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Spring Bean으로 등록
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /*
    ComponentScan을 사용하게 되면 자동적으로 AutoWired를 사용하게 된다.
     */
    @Autowired //생성자에 AutoWired를 붙여주면 타입에 맞는 애를 찾아와서 의존관계 주입을 자동으로 연결해서 주입한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save( member );
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById( memberId );
    }

    //테스트 용도
    public MemberRepository memberRepository() {
        return memberRepository;
    }
}
