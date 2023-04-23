package com.example.theaterservice.dto.v1;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotNull
    private Long cityId;

    @NotEmpty
    private String company;

}
