package myClass;

/**
 * 책 객체를 만들고 생성된 책 객체의 여러가지 기능을 다루는 클래스
 *
 * @author (2025320031 김단이 , 2023320040 이기웅, 2023320006 정준영)
 * @version (2026.10.14)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * 책 객체를 만드는 메소드
     *
     * @param  author : 책의 저자
     *         bookID : 책 번호
     *         publisher : 출판사
     *         title : 책 제목
     *         year : 출판연도
     */
    public Book(String author, String bookID, String publisher, String title, int year){
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year =year;
    }

    /**
     * DB_Element의 getID를 오버라이딩한 메소드로 책 번호 반환.
     *
     * @return    책 번호
     */
    public String getID(){
        return bookID;
    }

    /**
     * 책 정보를 형식에 맞게 반환하는 메소드
     *
     * @return    책ID, 제목, 저자, 출판사, 출판연도를 형식에 맞추어 반환
     */
    public String toString(){
        return "(" + bookID + ") " + title + ", " + author + ", " + publisher + ", " + year;
    }
}