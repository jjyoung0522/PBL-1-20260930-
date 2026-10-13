import myClass.*;
import DataBase.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 대출에 필요한 기능들과 각각의 DB를 다루는 클래스
 *
 * @author (2025320031 김단이 , 2023320040 이기웅, 2023320006 정준영)
 * @version (2026.10.14)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;

    /**
     * 도서관 시스템에서 이용되는 DB들(책DB, 이용자DB, 대출DB)을 생성하는 메소드
     *
     */
    public LibraryManagementSystem()
    {
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
        this.loanDB = new HashMap<User,Book>();        
    }

    /**
     * ID를 이용하여 이용자 객체와 책 객체를 찾아 각각 대출DB Key와 Value에 저장하는 메소드
     *
     * @param  userID : 책을 대출하는 이용자의 학번
     *         bookID : 대출할 책 번호
     */
    public void borrowBook(String userID, String bookID)
    {
        loanDB.put(userDB.findElement(userID) , bookDB.findElement(bookID));
    }

    /**
     * DB에 있는 모든 요소를 형식에 맞게 출력하는 메소드
     *
     * @param  db : 출력할 DB
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
        System.out.println();
    }

    /**
     * 대출 현황을 출력하는 메소드
     *
     */
    public void printLoanList()
    {
        System.out.println("----- 대출 현황 -----");
        for(User loanUser : loanDB.keySet()){
            System.out.println(loanUser + " ===> " + loanDB.get(loanUser));
        }
        System.out.println("--------------------");
    }

    /**
     * 책 데이터가 들어있는 txt파일을 읽어 와 책DB에 읽어낸 책 모두를 저장하는 메소드
     *
     * @param     bookFile : 책 데이터 파일의 컴퓨터 내 저장위치
     * @return    LibDB<Book> : 데이터 파일 속 책이 모두 저장된 책 DB
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            File file = new File(bookFile);
            FileReader readBookFile = new FileReader(file);
            Scanner scan = new Scanner(readBookFile);
            while(scan.hasNextLine()){
                StringTokenizer bookInfo = new StringTokenizer(scan.nextLine() , "/");

                String bookID = bookInfo.nextToken();
                String title = bookInfo.nextToken();
                String author = bookInfo.nextToken();
                String publisher = bookInfo.nextToken();

                int year = Integer.valueOf(bookInfo.nextToken());
                Book book = new Book(author, bookID, publisher, title, year);
                bookDB.addElement(book);
            }
            readBookFile.close();
            scan.close();

            return bookDB;

        }
        catch(IOException e){
            System.out.println("책 데이터 파일을 읽을 수 없습니다.");
        }
        return null;
    }

    /**
     * 이용자 데이터가 들어있는 txt파일을 읽고 이용자DB에 읽어낸 이용자 모두를 저장하는 메소드
     *
     * @param     userFile : 이용자 데이터 파일의 컴퓨터 내 저장위치
     * @return    LibDB<User> : 데이터 파일 속 이용자가 모두 저장된 이용자DB
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
            File file = new File(userFile);
            FileReader readUserFile = new FileReader(file);
            Scanner scan = new Scanner(readUserFile);
            while(scan.hasNextLine()){
                StringTokenizer userInfo = new StringTokenizer(scan.nextLine() , "/");

                int stID = Integer.valueOf(userInfo.nextToken());
                String name = userInfo.nextToken();

                User user = new User(stID, name);
                userDB.addElement(user);
            }
            readUserFile.close();
            scan.close();

            return userDB;

        }
        catch(IOException e){
            System.out.println("이용자 데이터 파일을 읽을 수 없습니다.");
        }
        return null;
    }
}