
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

        libMS.setUserDB("c:\\Temp\\UserData2025.txt");
        libMS.setBookDB("c:\\Temp\\BookData2025.txt");

    }
}