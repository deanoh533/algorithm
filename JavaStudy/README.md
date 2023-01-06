# JAVA Study
[1. 두 배열을 합치는 방법 4가지](#1-두-배열을-합치는-방법)  
[2. 키보드로 사용자 입력받는 방법 2가지](#2-키보드로-사용자-입력받는-방법-2가지)  
[3. 오름차순 정렬과 내림차순 정렬](#3-오름차순-정렬과-내림차순-정렬)  

---
 ## 1. 두 배열을 합치는 방법 
 1. System.arraycopy()
 2. Collection(List)
 3. Stream API
 4. Apache Commons Lang

 ### 1) System.arraycopy()
 원본배열을 다른 배열에 복사하면서, 배열을 합치는 방법
 배열을 복사할 때, java.lang.System.arraycopy() 메소드를 활용.

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

### 2) Collection(List)
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


### 3)  Stream API

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

### 4) Apache commons Lang

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
---

## 2. 키보드로 사용자 입력받는 방법 2가지
1. BufferedReader, InputStreamReader, System.in
2. Scanner

### 1) BufferedReader, InputStreamReader, System.in
#### **System.in**
일반적으로 keyboard 입력을 지칭하는  Standard Input Stream 이다.

#### **InputStreamReader**
- InputstreamReader (InputStream in)
- InputstreamReader (InputStream in, String charsetName) 
- InputstreamReader (InputStream in, Charset cs)
- InputstreamReader (InputStream in, CharsetDecoder dec)

byte stream을 character stream 으로 변경해주는 역할을 한다.
InputStreamReader 클래스는 생성자의 파라미터로 InputStream객체를 전달 받는다.(이 InputStream 객체의 종류에 따라서, 키보드 사용자 입력을 읽어들일 수도 있고, 파일의 내용을 읽어드릴 수도 있다.)  
또한, 생성자의 파라미터로 charser 정보를 입력받아서, 읽어들이는 stream의 charset을 지정할 수 있다.

#### **BufferedReader**
- BufferedReader(Reader in)
- BufferedReader(Reader in, int sz)

효율적으로 문자를 읽어들이기 위해 버퍼링을 해준다.
기본 버퍼 사이즈를 그대로 사용해도 되고, 생성자를 활용해 버퍼 사이즈를 지정해 줄수도 있다.
보통, FileReader, InputStreamReader의 read()와 같이 비용이 많이 드는 Reader를 파라미터로 전달받아서 사용한다.

만약, BufferedReader 없이 FilerReader나 InputStreamReader를 사용하면 시스템은 바이트별로 사용자의 입력을 받아서 처리하는 동작을 반복한다.
BufferedReader를 사용하면 시스템은 버퍼가 비어있을 때만, 실제 IO를 일으켜서 데이터를 읽어오고, 나머지 경우에는 메모리에 있는 버퍼의 데이터를 읽어서 처리한다.

-  예제 1
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class UserInput {
    public static void main(String[] args) throws IOException {
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        // 입력 데이터 읽기
        String str = reader.readLine();  // Hi Anna
 
        // 입력 데이터 출력
        System.out.println(str);  // Hi Anna
 
    }
}

```

`BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));`

BufferedReader, InputStreamReader, System.in을 이용하여

키보드 사용자 입력을 받을 수 있는 객체를 생성하였습니다.

 

`String str = reader.readLine();`

BufferedReader의 readLine() 메소드를 이용하여 사용자 입력 한 줄을 받습니다.

### 2) Scanner
```java
import java.util.Scanner;
 
public class ScannerInput {
    public static void main(String[] args) {
 
        // scanner 선언
        Scanner scanner = new Scanner(System.in);
 
        // 사용자 입력
        System.out.println("문자열을 입력하세요 : ");
        String str = scanner.nextLine();
 
        System.out.println("정수를 입력하세요 : ");
        int number = scanner.nextInt();
 
        System.out.println("실수를 입력하세요 : ");
        float floatNumber = scanner.nextFloat();
 
        System.out.println("true/false를 입력하세요 : ");
        boolean bool = scanner.nextBoolean();
 
        // 결과 출력
        System.out.println(str);
        System.out.println(number);
        System.out.println(floatNumber);
        System.out.println(bool);
 
        // close scanner
        scanner.close();
    }
}
```
```
< 입력 >
문자열을 입력하세요 : 
hi
정수를 입력하세요 : 
3
실수를 입력하세요 : 
3.3
true/false를 입력하세요 : 
false
----------
< 출력 >
hi
3
3.3
false
```
` Scanner scanner = new Scanner(System.in);`

Scanner로 Standard Input Stream을 전달하여, 키보드에서 입력을 받을 수 있는 Scanner 객체를 하나 생성.

`scanner.nextLine();`

입력 받은 데이터 한 줄을 읽어서, String으로 리턴한다.

`scanner.nextInt();`
`scanner.nextFloat();`
`scanner.nextBoolean();`

Scanner의 nextXXX() 메소드를 이용하여 사용자로부터 입력받은 토큰(token)을 String, int, boolean 등의 타입으로 변환할 수 있다. 

// token은 공백 문자 ('\t', '\f', '\r', ' ', '\n')

예제에 있는 메소드 이외에도 nextBigDecimal(), nextBigInteger(), nextByte(), nextDouble(), nextLong(), nextShort() 메소드를 사용하여 입력받은 데이터를 원하는 타입으로 변환할 수 있다.
`scanner.close();`

다 사용한 scanner를 close 한다.

`scanner.hasNextLine();`
Scanner 가 더 읽어들일 Line이 있는지 체크 true, false 로 반환.
실제로 값을 읽지는 않는다.

`scanner.hasNext()`
다음으로 읽을 토큰이 있는지 체크

`scanner.next()`
토큰별로 입력값을 읽어 String 반환


## 3. 오름차순 정렬과 내림차순 정렬
### 1) 오름차순 정렬
- 코드
```java
int a[] = {5,3,2,4,1};
Arrays.sort(a);
System.out.println(Arrays.toString(a));
```
- 결과
```
[1,2,3,4,5]
```

### 2) 내림차순 정렬
#### 2-1) Arrays.sort(A, Collections.reverseOrder()) 사용
- Collections.reverseOrder()는 객체에만 사용할 수 있다. 그러므로, **Integer**를 사용해야한다.
- 코드
```java
int a[] = {5,3,2,4,1};
Arrays.sort(a, Collections.reverseOrder());
System.out.println(Arrays.toString(a));
```
- 결과
```
[5, 4, 3, 2, 1]
```

#### 2-2)  Stream 활용
- 코드

```java
int a[] = {5,3,2,4,1};
Interger[] temp = Arrays.stream(a).boxed().toArray(Integer[]::new);
Arrays.sort(tmp, Collections.reverseOrder());
System.out.println(Arrays.toString(temp));
```
- 결과
```
[5, 4, 3, 2, 1]
```

#### 2-3) -1을 곱해서 저장하는 방법

- 코드
```java
int a[] = {5,3,2,4,1};
int a[] = {-5,-3,-2,-4,-1}; 로 변환!!
Arrays.sort(a);
System.out.println(Arrays.toString(a));
```
- 결과
```
[-5, -4, -3, -2, -1] // 그리고 -1을 곱해서 다시 출력한다.
```