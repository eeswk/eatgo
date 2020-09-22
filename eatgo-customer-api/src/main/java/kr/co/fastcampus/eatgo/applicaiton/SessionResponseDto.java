package kr.co.fastcampus.eatgo.applicaiton;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDto {
    private String accessToken;
}
