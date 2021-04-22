# 13주차 : 자바의 Input과 Ontput에 대해 학습하세요.

#### 목표

- 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
- InputStream과 OutputStream
- Byte와 Character 스트림
- 표준 스트림 (System.in, System.out, System.err)
- 파일 읽고 쓰기

------------
### 1. 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O

![](https://user-images.githubusercontent.com/52314663/107365487-36f3b980-6b20-11eb-8a92-10b6b90cdc68.png)  
출처 : http://www.tcpschool.com/java/java_io_stream#:~:text=자바에서는 파일이나 콘솔,된 흐름을 의미합니다  

입출력 : 컴퓨터 내부 또는 외부 장치와 프로그램간의 데이터를 주고 받는 것.  
  
스트림 : 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름.   
- 자바에서는 파일이나 콘솔에서의 입출력을 스트림을 통해 다룬다.  
- 한 방향으로만 통신이 가능하므로 입출력을 동시에 처리할 수 없다.  
- FIFO

버퍼 : byte, char, int 등 기본 데이터 타입을 저장할 수 있는 저장소, 배열처럼 제한된 크기에 순서대로 데이터 저장  
- 버퍼는 데이터를 저장하기 위한 것이지만, 실제로 버퍼가 사용되는 것은 채널을 통해서 데이터를 주고 받을 때 쓰인다
- 채널을 통해 소켓, 파일 등에 데이터를 전송할 때나 읽어올 때 버퍼를 사용하게 됨으로써 가비지량 최소화 가능
- 가비지 콜렉션 회수를 줄임으로써 서버의 전체 처리량을 증가시켜준다
  
  
채널 : 데이터가 통과하는 쌍방향 통로  
- 채널에서 데이터를 주고 받을 때 사용되는 것이 버퍼
- 채널에는 소켓과 연결된 SocketChannel, 파일과 연결된 FileChannel, 파이프와 연결된 Pipe.SinkChannel 과 Pipe.SourceChannel 등이 존재하며, 서버소켓과 연결된 ServerSocketChannel 도 존재



------------
### 2. InputStream과 OutputStream

스트림은 단방향 통신만 지원하므로 사용 목적에 따라 입/출력 스트림으로 구분한다.  
java.io 패키지를 이용해 Input/OutputStream을 지원한다.  
  
- InputStream : 입력 스트림들 중 최상위 클래스(추상 클래스). 
  - read() : 입력 스트림으로부터 1byte를 읽고 읽은 바이트 리턴
  - read(byte[] b) : 입력 스트림으로부터 읽은 바이트들을 byte[] b에 저장하고 실제로 읽은 바이트 수를 리턴하는 메소드
  - close() : 사용한 시스템 리소스를 반납 후 입력 스트림을 닫는 메소드
  
- OutputStream : 출력 스트림들 중 최상위 클래스(추상 클래스).
  - write(byte[] b) : 출력 스트림으로부터 주어진 byte[] b의 모든 바이트를 보내는 메소드
  - flush() : 버퍼에 남아있는 모든 바이트를 출력
  - close() : 사용한 시스템 리소스를 반납 후 출력 스트림을 닫는 메소드
  

------------
### 3. Byte와 Character 스트림

<Byte Stream>
  - 자바의 스트림은 기본적으로 바이트 단위로 스트림 전송
  - 입출력 대상에 따라 제공하는 클래스가 다르다
  - 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 주고 받을 수 있다
  - 파일 입출력 : FileInput/OutputStream
  - 메모리 입출력 : ByteArrayInput/OutputStream
  - 프로세스 입출력 : PipedInput/OutputStream
  - 오디오 장치 입출력 : AudioInput/OutputStream 
  
<Character Stream>
  - 1바이트씩 전송되는 바이트 기반 스트림으로는 원활한 처리가 힘든 경우 존재
  - 이를 해결하기 위해 자바에서 문자 기반 스트림 지원
  - 오직 문자 데이터를 주고받기 위해 존재하는 스트림
  - Reader, Writer 클래스 상속받아 사용
  - 파일 입출력 : FileReader/Writer 
  - 메모리 입출력 : CharArrayReader/Writer 
  - 프로세스 입출력 : PipedReader/Writer
  - 문자열 입출력 : StringReader/Writer
  

------------
### 4. 표준 스트림 (System.in, System.out, System.err)

표준 입출력 스트림의 종류는 java.lang 패키지의 System 클래스 내부에 static으로 선언되어 있다.  
```java
public final class System {
    public static final InputStream in;
    public static final PrintStream out;
    public static final PrintStream err;
}
```
    
클래스 변수  
- System.in : 콘솔로부터 데이터 입력 받음
- System.out : 콘솔로 데이터 출력
- System.err : 콘솔로 데이터 출력
  - out과 달리 err는 버퍼링을 지원하지 않는다.
  - 버퍼링 도중 프로그램이 멈추면 버퍼링된 내용은 출력되지 않기 때문에 보다 더 정확하고 빠른 출력을 요하기 때문.


------------
### 5. 파일 읽고 쓰기
