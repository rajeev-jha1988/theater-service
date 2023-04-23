package com.example.theaterservice.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumDetailDto {

    private Long id;
    private String name;

}
