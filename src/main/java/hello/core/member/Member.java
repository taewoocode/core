package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) { // 생성자는 cmd + N 으로 구현
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // 데이터를 가지고(조회)? 오고 수정하는 getter setter를 만들어 준다.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
