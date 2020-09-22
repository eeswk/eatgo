package kr.co.fastcampus.eatgo.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue
    @Setter
    private Long id;

    @NotEmpty
    private String name;
    @NotNull
    private Integer score;
    @NotEmpty
    private String description;

    @Setter
    private Long restaurantId;
}
