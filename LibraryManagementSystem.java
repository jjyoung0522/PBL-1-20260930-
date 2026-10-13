import myClass.*;
import DataBase.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibraryManagementSystem()
    {
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
        this.loanDB = new HashMap<User,Book>();        
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void borrowBook(String userID, String bookID)
    {
        loanDB.put(userDB.findElement(userID) , bookDB.findElement(bookID));
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
        System.out.println();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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