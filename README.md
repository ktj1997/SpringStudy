# SpringStudy
## Spring의 핵심개념을 정리하기위한 Repo

# SOLID(OOP 5원칙)

## SRP(Single Responsibility Principle)
### 단일 책임원칙
```
한 클래스는 한가지의 책임을 가진다는 원칙이다.
이 책임이라는 것이 애매한데, 클 수도있고, 작을수도 있다.
여기서 중요한 기준은 **변경**인데, 
한 클래스가 **변경되는 사유는 단 한가지여야만 한다.**
클래스의 코드가 변경되는 사유가 여러가지일 경우, SRP가 위반 된 것이다.

ex) 한 클래스에 여러가지 기능이 있을 경우, 범위도 애매해지고, 여러 책임을 겸하고있을 때에
    변경을 하는 경우 생각
```
## OCP(Open/Closed Principle)
### 개방/폐쇄 원칙
```
확장에는 열려있으나, 변경에는 닫혀있어야 한다는 원칙이다.
기능을 변경함에 있어서, 기능 추가 및 변경에 소스코드 변경이 일어나서는 안된다.
주로 인터페이스를 이용한 추상화와 다형성을 통해서 구현이 되는데, 
역할에 대한 여러가지 구현을 부품 갈아끼는 듯한 형태로 구현이 된다.

ex) 차라는 인터페이스를 만들고 그 하위 클래스를 구현한다고 했을 때,
    차라는 인터페이스를 상속하고 구현한 클래스들은 여러가지 차 클래스로 확장 된것.
    하지만 차라는 공통인터페이스에는 변경이 가해지지 않았다.
```
## LSP(Liskov Substitution Principle)
### 리스코프 치환 원칙
```
상위객체가 하위객체 인스턴스로 아무런 문제없이 인스턴스를 교체 할 수 있어야 한다는 것이다.
다형성을 통해서, 상위객체를 하위객체로 변경을 했을 때, 정상적인 작동이 가능해야한다.

ex) 정사각형은 직사각형의 일종이지만 직사각형은 정사각형이 아니다.
    단순히 이 원리를 보고 직사각형을 상속하는 정사각형을 만들 수 있겠지만,
    직사각형 인스턴스를 정사각형 인스턴스로 변경하면 문제가 발생할 수 있다.
    (예를들어 가로x세로가 아닌 정사각형 객체의 구현을 가로*가로 이런식으로 했을 때)
    리스코프원칙에 따라 분리시키는 것이 좋다.
```
## ISP(Interface Segregation Principle)
### 인터페이스 분리 원칙

```범용 인터페이스 한개보다 여러개의 인터페이스로 분리하는 것이 더 좋다는 것이다.
인터페이스의 범위를 크게 잡아서, 쓰임새 이상으로 추상화가 되면,
추가적인 구현을 요구하는 경우가 생길 수 있기 때문이다.

ex) Unit이라는 공통 인터페이스에 walk( )라는 메소드를 정의 하였을 떄,
    공중 유닛은 정의가 불가능하다. Unit 인터페이스를 상속하는
    Walkable과 Flyable등으로 나누는 것이 더 적합하다.
```
## DIP(Dependency Inversion Principle)
### 의존관계 역전 원칙
```
추상화에 의존해야지 구현체에 의존하면 안된다는 원칙이다.
어떠한 객체를 의존할 일이 있을 때, 구현체가아닌 추상화된 객체를 사용해야 
하위 객체의 구현으로부터 자유로울 수 있다.
구현에 의존하는 것이아닌, 추상화에 의존하는 것. DI는 DIP의 수단

ex) 공통된 추상화 객체를 사용함으로 해서 구현체를 몰라도 자신의 역할을 수행 가능하며,
    구현체의 변경에 민감하지 않다.
   ``` 
   # IOC(Inversion Of Control)
```
기존의 직접 객체를 생성하고 할당하는 것이 아닌, 제어권을 넘기는 것이다.
구현과 설정을 분리하는 것인데, 구현객체는 자신의 구현에만 신경을 쓰면되고,
설정객체는 설정에 따라 생성과 할당을 담당하는 것이다.
구현이 아닌 추상화에 의존하게 됨으로, DIP에도 만족하며, 코드의 변경을 줄일 수 있다.
```
### IOC 컨테이너
```
DI 컨테이너라고도 불리며, 스프링에서 설정정보(XML, Java 등등)에 따라서
Bean을 생성하고 주입해주는 의존관계 주입(Dependency Injection)의 역할을 한다.
ApplicationContext를 SpringContainer라고 하는데, 할당된 Bean을 받아올 수 있고, 추가적인 기능을 수행할 수 있다.

ApplicationContext는 Interface 이고, BeanFactory 포함한 여러 Interface를 상속받는다.
구현체로는 에노테이션으로 설정한 컨테이너(AnnotationConfigApplicationContext)와 
XML으로 설정한 컨테이너(GenericXmlApplicationContext) 등이 있다.
ApplicationContext가 상속받는 인터페이스는 아래와 같다.
1. BeanFactory
      최상위 인터페이스이며, Spring Bean을 관리하고 조회하는 역할을 담당한다.

 2.  MessageSource
      국제화 기능 제공

 3.  EnvironmentCapable
      로컬, 개발, 운영환경등에 따른 환경변수처리를 지원

 4.   ApplicationEventPublisher
      이벤트를 Publish 및 Subscribe 지원

 5.   ResourceLoader
       File, ClassPath 등에서 편리한 Resource 기능 제공
```
### XML기반 Bean설정

[Xml설정](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/main/resources/XmlBeanConfig.xml)
resource 디렉토리 밑에 XML 파일이 필요

```xml
<bean id="Bean의 Id 설정", class="FQCN">
	<constructor-arg name="참조할 Bean의 이름 설정" ref="참조할 Bean의 Id">
</bean>
```
### Annotation 기반 Bean설정
[Annotation 설정](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/main/java/com/study/spring/config/AnnotationBeanConfig.java)

```
Java 클래스파일로 설정
@Configuration → IOC컨테이너에세 설정관련 클래스파일임을 알림
@Bean  → 메소드에 붙으며, 해당 메소드의 이름이 default로 Bean의 이름이되며, 반환 객체가 Bean
```

### IOC컨테이너 사용의 장점
```
1. 의존성 관리 용이
2. 라이프사이클 인터페이스 사용가능
3. 싱글톤 스코프를 가짐 —> 런타임 최적화 유리
```
### Singleton
요청마다 새롭게 객체를 생성하는 것이아닌, 이미 만들어놓은 객체의 참조만을 넘겨주는 것.
JVM에 한 클래스에 오직 하나의 인스턴스만 존재하게 만든다.
(Singleton이 아닐 때, 웹서비스 하나의 요청당 하나의 객체를 생성한다면?)

#### Singleton Pattern 사용시 주의점
1. Read-Only로 만들 것
2. Stateless하게 만들 것

#### Singleton Pattern의 단점
```
1. private 생성자로 만들기 때문에 자식 클래스 만들기가 어렵다
2. 테스트하기 어렵다
3. 유연성이 떨어진다
4. 내부 속성의 변경 및 초기화가 어렵다
```
### Singleton Container
```
객체인스턴스를 모두 싱글톤으로 관리
싱글톤 패턴을 구현하기위한 추가적인 코드를 구현하지 않을 수 있고,
기존 싱글톤패턴구현의 단점들로부터 자유로워질 수 있다.
```
### @Configuration
```
@Configuration이 붙은 설정클래스는 SpringContainer가 관리하는 Bean이 된다.
@Configuration이 붙은 클래스의 경우 추가적으로 
바이트코드조작 라이브러리인 cglib이 해당 설정클래스를 상속받아,
싱글톤에 필요한 코드를 추가적으로 구현하고, 해당 클래스를 Bean으로 등록한 후
ApplicationContext가 해당 클래스를 사용한다.

@Bean에노테이션이 붙어있다면, 해당 메소드가 리턴하는 객체를 Bean으로 등록하기는 하지만,
@Configuration이 없다면, 스프링컨테이너에 의해서 관리되는지 알지 못하게되고,
이미 한번 만들어진 해당 Type의 Bean은 Spring Container에 의해서 관리되지만,
의존관계에 따른 참조까지 Singleton을 보장하지못한다.
```

[@Configuration에 따른 싱글톤 테스트](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/test/java/com/study/spring/bean/SingletonBeanTest.java)
```
OrderServiceImpl orderService = aac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = aac.getBean(MemberRepository.class);
        MemberServiceImpl memberService = aac.getBean(MemberServiceImpl.class);
        Class annotationBeanConfig = AnnotationBeanConfig.class;
        Annotation annotation = annotationBeanConfig.getAnnotation(Configuration.class);

        if(annotation != null)
            assertAll(
                    () -> assertTrue(memberRepository == memberService.getMemberRepository()),
                    () -> assertTrue(memberRepository == orderService.getMemberRepository()),
                    () -> assertTrue(memberService.getMemberRepository() == orderService.getMemberRepository())
            );
        else
            assertAll(
                    () -> assertFalse(memberRepository == memberService.getMemberRepository()),
                    () -> assertFalse(memberRepository == orderService.getMemberRepository()),
                    () -> assertFalse(memberService.getMemberRepository() == orderService.getMemberRepository())
            );
