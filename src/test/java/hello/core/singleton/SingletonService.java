package hello.core.singleton;

public class SingletonService {

    //자기 자신을 내부에 가지고 있는데 static으로 가지고 잇다. instance는 관례상 표기한다.
    //static으로 선언하면 classlevel로 올라가기 때문에 객체가 딱 하나만 존재하게 된다.
    //static영역에 올라간다라고 이해하고 있으면 된다.
    //자바가 실행이되면 객체를 생성해서 instance에 넣어둔다.
    private static final SingletonService instance = new SingletonService();

    //조회
    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자를 사용한다. -> 무분별한 객체생성을 막기 위함이다.
    private SingletonService() {
        System.out.println("싱글톤 객체 로직 호출");
    }



}
