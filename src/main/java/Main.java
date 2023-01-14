import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user = dao.read(16);
        user.setEmail("pavel@gmail.com");
        user.setUserName("Pavel");
        dao.update(user);
    }
}