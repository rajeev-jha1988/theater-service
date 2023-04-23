package com.example.theaterservice.dto.v1;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDetailDto {

    private Long id;
    private String name;

    List<AuditoriumDetailDto> auditoriumDetails;

}
