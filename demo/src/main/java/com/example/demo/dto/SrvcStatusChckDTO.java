package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SrvcStatusChckDTO {

    private String date;
    private String name;
    private String url;
    private String status;

}
