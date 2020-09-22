package kr.co.fastcampus.eatgo.applicaiton;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException() {
        super("password is wrong");
    }
}
