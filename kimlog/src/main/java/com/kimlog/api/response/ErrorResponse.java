package com.kimlog.api.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * {
 *     "code": "400",
 *     "message": "잘못된 요청입니다.",
 *     "validation":{
 *         "title": 값을 입력해주세요
 *     }
 * }
 */
@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;

    private final Map<String, String> validation = new HashMap<>(); //final로 해도 초기값이 존재하기때문에 빼고 생성자 만듦
    // final이라도 객체 내부의 값은 변경 가능

    public void addValidation(String fieldName, String errorMessage) {
        this.validation.put(fieldName, errorMessage);
    }

}
