package DataBase;
import java.util.ArrayList;
import java.util.Iterator;
import myClass.*;

/**
 * a 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T>
{
    private ArrayList<T> db;

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB()
    {
        this.db = new ArrayList<T>();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void addElement(T element)
    {
        db.add(element);
    }
    
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public T findElement(String ID){
        Iterator<T> dbIterator = db.iterator();
        
        while(dbIterator.hasNext()){
            DB_Element element = (DB_Element) dbIterator.next();
            if (element.getID().equals(ID)){
                return (T) element;
            }
            else{
            }
        }
        return null;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }
}