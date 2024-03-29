package kr.co.ch07.dto;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Slf4j
@ToString
@Builder
// 집계
public class ProductAggDTO {
    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;

}














