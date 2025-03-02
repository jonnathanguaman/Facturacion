package com.springcloud.store.spring_cloud_product.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String code;
    private List<Map<String,String>> messsage;
}
