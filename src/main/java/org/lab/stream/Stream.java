package org.lab.stream;

import java.util.Arrays;
import java.util.List;

public class Stream {
    /*
        스트림(Stream)은 자바 8에서 도입된 기능으로, 컬렉션(배열, 리스트 등)의 요소를
        함수형 프로그래밍 스타일로 처리할 수 있게 해주는 API입니다.
        스트림은 데이터 소스(컬렉션, 배열 등)에서 데이터를 추출하고,
        필터링, 매핑, 정렬 등의 연산을 수행하여 결과를 생성합니다.
     */
    public static void main(String[] args) {
        // 스트림 사용 예시
        // 스트림을 사용하여 컬렉션의 요소를 처리하는 방법을 보여줍니다.
        // 예를 들어,
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println(numbers.stream()
                .filter(n -> n % 2 == 0) // 짝수만 필터링
                .map(n -> n * n) // 각 요소를 제곱
                .toList()); // 결과를 리스트로 변환);
    }
}
