package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTests {

    @Test
    public void creation() {
        User user = User.builder().email("test@test.com").name("tester").level(100L) .build();

        assertThat(user.getName(), is("tester"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactivate();

        assertThat(user.isActive(), is(false));
    }

    @Test
    public void accessToken() {
        User user = User.builder().password("ACCESSTOKEN").build();

        assertThat(user.getAccessToken(), is("ACCESSTOKE"));

    }

}