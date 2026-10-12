import myClass.*;
import DataBase.*;

/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class App
{
    public static void main(String[] args){
        LibraryManagementSystem libMS = new LibraryManagementSystem();

        LibDB<User> userDB = libMS.setUserDB("c:\\Temp\\UserData2025.txt");
        libMS.printDB(userDB);
        
        
        LibDB<Book> bookDB = libMS.setBookDB("c:\\Temp\\BookData2025.txt");
        libMS.printDB(bookDB);
        
        libMS.borrowBook("2025320001","B02");
        libMS.borrowBook("2024320002","B03");
        libMS.borrowBook("2023320003","B04");
        
        libMS.printLoanList();
    }
}