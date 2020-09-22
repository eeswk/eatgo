package kr.co.fastcampus.eatgo.applicaiton;

public class EmailExistedException extends RuntimeException {
    public EmailExistedException(String email) {
        super("Email is already registed : " + email);
    }
}
