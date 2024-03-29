package com.ichchoco.book.freelecspringboot2webservice.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

        //assertj
        //테스트 검증 라이브러리의 검증 메소드
        //검증하고 싶은 대상을 메소드 인자로 받는다
        //메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능

        //isEqualTo
        //assertj의 동등 비교 메소드이다
        //assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공

    }
}
