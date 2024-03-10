package hello.core.member;

public interface MemberService {
    //2가지 기능
    //회원가입, 회원조회


    void join(Member member); //회원가입

    Member findMember(Long memberId); //회원조

    // 자 이제 인터페이스를 만들었으니 구현체를 만들러 가보자
}


