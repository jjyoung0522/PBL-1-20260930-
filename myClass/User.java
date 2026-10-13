package myClass;

/**
 * 이용자 객체를 생성하고 생성된 이용자 객체의 여러가지 기능을 다루는 클래스
 *
 * @author (2025320031 김단이 , 2023320040 이기웅, 2023320006 정준영)
 * @version (2026.10.14)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * 이용자 객체를 만드는 메소드
     *
     * @param  stID 
     *          
     */
    public User(int stID, String name){
        this.stID = stID;
        this.name = name;
    }

    /**
     * DB_Element의 getID를 오버라이딩한 메소드로 학번을 반환.
     *
     * @return    학번
     */
    public String getID(){
        return String.valueOf(stID);
    }

    /**
     * 이용자 정보를 형식에 맞게 반환하는 메소드
     *
     * @return    학번과 이름을 형식에 맞추어 반환
     */
    public String toString(){
        return "[" + stID + "] " + name;
    }
}