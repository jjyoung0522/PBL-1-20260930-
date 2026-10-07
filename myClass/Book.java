package myClass;


/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;
    
    public Book(String author, String bookID, String publisher, String title, int year){
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year =year;
    }
    
    public String getID(){
        return bookID;
    }
    
    // public String toString(){
        
    // }
}