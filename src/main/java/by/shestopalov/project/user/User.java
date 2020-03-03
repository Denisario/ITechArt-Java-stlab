package by.shestopalov.project.user;

import org.apache.log4j.Logger;

public class User extends AbstractUser {
    private static final Logger log = Logger.getLogger(AbstractUser.class);
    public User(String firstName, String lastName, String phone) {
        super(firstName, lastName, phone);
    }


    @Override
    public String toString() {
        log.info("User saw the info");
        return super.toString();
    }
}
