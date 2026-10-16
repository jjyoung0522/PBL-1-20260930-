package DataBase;
import java.util.ArrayList;
import java.util.Iterator;
import myClass.*;

/**
 * 도서관시스템에서 사용되는 각각의 DB를 다루는 클래스
 *
 * @author (2025320031 김단이 , 2023320040 이기웅, 2023320006 정준영)
 * @version (2026.10.16)
 */
public class LibDB<T>
{
    private ArrayList<T> db;

    /**
     * 새 DB를 생성하는 메소드
     *
     */
    public LibDB()
    {
        this.db = new ArrayList<T>();
    }

    /**
     * DB에 객체를 추가하는 메소드
     *
     * @param  element : 책 객체 또는 이용자 객체
     */
    public void addElement(T element)
    {
        db.add(element);
    }

    /**
     * DB에서 ID로 객체를 찾아 반환하는 메소드
     *
     * @param  ID : 찾고자 하는 객체의 ID
     * @return  T : 찾아낸 객체
     */
    public T findElement(String ID){
        Iterator<T> dbIterator = db.iterator();
        while(dbIterator.hasNext()){
            DB_Element element = (DB_Element) dbIterator.next();
            if (element.getID().equals(ID)){
                return (T) element;
            }
        }
        return null;
    }

    /**
     * DB에 저장되어 있는 모든 객체를 출력하는 메소드
     *
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }
}