package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 회원을 저장

    Member findByid(Long MemberId);
    /*
    mber findById(Long memberId);는 이름이 findById이고
    Long 타입의 memberId 파라미터를 받아들이며, Member 객체를 반환하는 메서드를 정의한다.
     */
}

