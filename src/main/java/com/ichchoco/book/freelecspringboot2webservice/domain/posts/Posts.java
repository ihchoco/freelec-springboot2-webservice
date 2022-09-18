package com.ichchoco.book.freelecspringboot2webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //기본 생성자 자동 추가 public Posts(){}
@Getter
@Entity //테이블과 링크될 클래스(ex. SalesManager.java -> sales_manager table)
public class Posts {

    @Id //해당 테이블의 PK 필드를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙(스프링부트에서는 GenerationType.IDENTITY를 추가해야만 auto_increment 수행)
    private Long ID;

    @Column(length = 500, nullable = false) //선언 하지 않아도 모든 클래스 필드는 컬럼이 된다. 하지만 기본값 이외에 변경할 때 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)  //컬럼 타입을 VARCHAR(255) 기본에서 TEXT(255) 타입으로 변경
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //여기에 보면 Setter 메소드를 만들지 않았다. 앞으로 Entity 클래스에는 절대 Setter 메소드를 만들지 앟겠다.
    //혹시 변경이 필요하면 그 목적과 의도를 나타낼 수 있는 메소드를 추가하겠다

    /*  [잘못된 사용]
       public void setStatus(boolean status){
            this.status = status;
       }
       [올바른 사용]
       public void cancelOrder(){
            this.status = false;
       }

     */

    //신규로 추가(112p - PostsUpdateRequestDto와 함께 추가)
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
