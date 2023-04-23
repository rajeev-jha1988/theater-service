package com.example.theaterservice.dto.v1.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumMessageDto {

    private Long auditoriumId;
    private String auditoriumName;
    private Long theatreId;

}
