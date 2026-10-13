import myClass.*;
import DataBase.*;

/**
 * 도서관 시스템이 실행되는 메인 클래스
 *
 * @author (2025320031 김단이 , 2023320040 이기웅, 2023320006 정준영)
 * @version (2026.10.14)
 */
public class App
{
    public static void main(String[] args){
        LibraryManagementSystem libMS = new LibraryManagementSystem();

        LibDB<User> userDB = libMS.setUserDB("c:\\Temp\\UserData2025.txt");
        System.out.println("----- 이용자 목록 출력 -----");
        libMS.printDB(userDB);

        LibDB<Book> bookDB = libMS.setBookDB("c:\\Temp\\BookData2025.txt");
        System.out.println("----- 책 목록 출력 -----");
        libMS.printDB(bookDB);

        libMS.borrowBook("2025320001","B02");
        libMS.borrowBook("2024320002","B03");
        libMS.borrowBook("2023320003","B04");

        libMS.printLoanList();
    }
}