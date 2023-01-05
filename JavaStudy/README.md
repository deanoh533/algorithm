# JAVA

## 두 배열을 합치는 방법 
 1. System.arraycopy()
 2. Collection(List)
 3. Stream API
 4. Apache Commons Lang

 ### 1. System.arraycopy()
 원본배열을 다른 배열에 복사하면서, 배열을 합치는 방법
 배열을 복사할 때, java.lang.System.arraycopy() 메소드를 활용.

 ` public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) `
 > public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

- src : 복사할 원본 배열
- srcPos : 복사할 원본 배열의 시작 index
- dest : destination array. 원본 배열이 dest 배열로 복사된다.
- destPos : dest 배열의 destPos index에 원본 배열이 복사된다.
- length : 원본 배열에서 복사될 element 갯수

```java
import java.util.Arrays;
 
public class ArrayCopy {
    public static void main(String[] args) {
        
        // 1. 합칠 배열 2개 준비
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5 };
 
        // 2. 2개 배열의 총 길이
        int destLength = arr1.length + arr2.length;
 
        // 3. 결과 배열 준비(총 길이는 arr1의 길이 + arr2의 길이)
        int[] dest = new int[destLength];
 
        // 4. 배열 합치기
        // 4.1 arr1을 dest로 복사 (index 0 ~ index 2)
        System.arraycopy(arr1, 0, dest, 0, arr1.length);
        // 4.2 arr2를 dest로 복사 (index 3 ~ index 5)
        System.arraycopy(arr2, 0, dest, arr1.length, arr2.length);
 
        // 5. 결과 출력
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 4, 5]
    }
}


```

System.arraycopy(arr1, 0, dest, 0 arr1.length);  

System.arraycopy(arr2, 0, dest, arr1.length, arr2.length);  

### 2. Collection(List)
> 배열을 List 로 변환하여 합친 후, 다시 배열로 변환하는 방법

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ArrayCopy {
    public static void main(String[] args) {
 
        // 1. 합칠 배열 2개 준비
        Integer[] arr1 = { 1, 2, 3 };
        Integer[] arr2 = { 4, 5 };
 
        // 2. 배열을 List로 변환
        List<Integer> list1 = new ArrayList(Arrays.asList(arr1));
        List<Integer> list2 = new ArrayList(Arrays.asList(arr2));
 
        // 3. 두 List 합치기
        list1.addAll(list2);
 
        // 4. list1을 배열로 변환
        Integer[] dest = list1.toArray(new Integer[0]);
 
        // 5. 결과 출력
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 4, 5]
    }
}

```


### 3.  Stream API

- 코드 1
```java
import java.util.Arrays;
import java.util.stream.Stream;
 
public class ArrayCopy {
    public static void main(String[] args) {
 
        // 1. 합칠 배열 2개 준비
        Integer[] arr1 = { 1, 2, 3 };
        Integer[] arr2 = { 4, 5 };
 
        // 2. 배열 합치기
        Integer[] dest = Stream.of(arr1, arr2).flatMap(Stream::of).toArray(Integer[]::new);
 
        // 5. 결과 출력
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 4, 5]
    }
}
```
- 코드2

```java
import java.util.Arrays;
import java.util.stream.Stream;
 
public class ArrayCopy {
    public static void main(String[] args) {
 
        // 1. 합칠 배열 2개 준비
        Integer[] arr1 = { 1, 2, 3 };
        Integer[] arr2 = { 4, 5 };
 
        // 2. 배열 합치기
        Integer[] dest = Stream
                            .concat(Arrays.stream(arr1), Arrays.stream(arr2))
                            .toArray(Integer[]::new);
 
        // 5. 결과 출력
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 4, 5]
    }
}
```

### 4. Apache commons Lang

> org.apache.commons.lang3.ArrayUtils의 addAll() 메소드를 이용하면, 여러개의 배열을 쉽게 합칠 수 있습니다.

Apach Commons Lang 라이브러리를 사용하기 위해서 의존성을 추가한다.

```java
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
 
public class ArrayCopy {
    public static void main(String[] args) {
 
        // 1. 합칠 배열 2개 준비
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5 };
 
        // 2. 배열 합치기
        int[] dest = ArrayUtils.addAll(arr1, arr2);
 
        // // 5. 결과 출력
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 4, 5]
    }
}
```

- int[] dest = ArrayUtils.addAll(arr1, arr2);


