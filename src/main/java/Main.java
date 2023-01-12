import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user1 = new User("Paweł", "paweł@gmail.com", "4710324333");
        User user2 = new User("Ala", "ala@gmail.com", "56812391");
        User user3 = new User("Radek", "rader@gmail.com", "3712481412");
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        dao.read(1);
        dao.findAll();
        dao.delete(3);




    }
}