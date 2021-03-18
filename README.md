# SpringStudy
## Spring의 핵심개념을 정리하기위한 Repo


# POJO (Plain Old Java Object)
## 특정 기술에 의존적이지 않은 순수한 자바 객체
```
특정 기술의 클래스를 상속받거나, 인터페이스를 구현함으로 해서,
확장성이 떨어지고, 그 기술을 알지못하면 이해할 수 없는 상황이 발생하였다
그러한 개발문제점의 대항하는 의미로 POJO가 생겼다.
```

### POJO 규약
1. 특정규약에 종속되지않는다.
2. 특정환경에 종속되지않는다.
3. 객체지향 원리에 충실한다

# Spring PSA(Portable Service Object)
```
특정 기술 사이에 또 하나의 추상화 Layer를 추가함으로 해서,
특정 기술에 의존적이 아니고 개발자들은 해당 Layer를 사용하고 내부 기술은 몰라도된다. 
```


# SOLID(OOP 5원칙)

## SRP(Single Responsibility Principle)
### 단일 책임원칙
```
한 클래스는 한가지의 책임을 가진다는 원칙이다.
이 책임이라는 것이 애매한데, 클 수도있고, 작을수도 있다.
여기서 중요한 기준은 변경인데, 
한 클래스가 변경되는 사유는 단 한가지여야만 한다.
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
```
### @Component Scan
[@Component Scan 설정](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/main/java/com/study/spring/config/AutoAnnotationBeanConfig.java)
```
XML → Java를 이용한 Bean설정으로 넘어가면서 편해지긴 했지만,
개발자가 수동으로 설정을 해주어야하는 것이므로, 
Bean과 의존관계가 누락되는 경우도 발생하였다.
Component Scan방법을 이용하여, 그러한 문제점을 해결하고자 하였다.
@Component Scan이 붙은 설정클래스를 생성하면,@Component와 
@Component를 상속하는 @Repository, @Service, @Controller, @Configuration이 
붙은  클래스는 자동으로 Bean에 등록된다.

옵션으로는 대표적으로 basePackages와 excludeFilters, includeFilters가 있는데,
basePackages는 해당 패키지 + 하위패키지를 Component Scan을 하라고 명시하는 것이고,
excludeFilter는 Component Scan을 통한 Bean등록에서 제외할 것들을 정의하는것이다.
includeFilter는 커스텀하게 정의한 class를 Bean으로 등록하고자 할때 사용된다.

default는 @Component Scan이 붙은 패키지부터 시작이된다.
관례는 설정클래스를 패키지의 최상단에 정의하고, default 설정을 사용하는 것이다.

Bean 이름은 Class 이름의 맨 앞글자만 소문자로 바꾸어 지정된다.
Bean 이름을 직접 지정하고 싶다면 @Component("이름")으로 지정하면 된다.

하지만 @ComponentScan도 Bean을 등록만 해줄 뿐, 의존관계는 설정해주지 못했다.
이 것을 해결한게 @Autowired다.
```
### @Autowired
[@Autowired를 통한 singleton Bean dependency 확인](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/test/java/com/study/spring/bean/AutoAnnotationBeanTest.java)
```
의존관계를 자동으로 주입해주는 @Autowired는 주로 @ComponentScan과 함께 사용된다.
설정클래스에 의존관계에 대한 명시를 할 필요가없기 떄문에,
Bean클래스에서 의존관계를 직접 명시해야 한다.
@Autowired는 필드,생성자,Setter에 명시 할 수 있다. 기본 조회 전략은 같은 Type을 찾게된다.
@Component Scan으로 IOC컨테이너에 등록된 Bean들을 조회하여, 
@Autowired로 엮인 Bean들의 의존관계를 자동으로 설정한다.
```
### Bean 중복 정의 시에 충돌
```
Bean의 이름에 중복된 이름이 있을 경우 충돌이 발생하는데,
보통 Bean의 자동정의와 수동정의 설정이 겹치면서 발생한다.
물론 자동정의 + 자동정의의 설정이 겹치는 경우도 있다. 
이 떄는 에러가 발생하며 정상 실행이 되지않는다.
기존의 전략은, 수동이 더 우선권을 가지므로, Spring에서 자동정의 빈에
수동정의 빈을 Overriding 해주었었다.
하지만 최근 Spring Boot에서는 자동 정의와 수동정의 빈의 충돌시에도
에러를 던지도록 변경되었다.
만약 수동정의 빈의 Overriding을 허용하려면,
application.properties에 spring.main.allow-bean-definition-overriding = true로 변경해주면 된다.
```
### Field Injection(필드 주입)
```
Spring이 관리하는 Bean의 필드에 @Autowired를 붙여서 의존관계를 주입받는 것이다.
단순히 필드위에 붙이면 되기때문에, 매우 간결한 코드가 된다.
하지만, SpringContainer에 의존적이게 된다. 
예를들어, Spring을 사용하지않고, 직접 객체를 제어하며 Test Code를 작성하고자 할 때,
Spring이 @Autowired를 통해서 Bean을 넣어주지 않기 때문에 NullPointerException이
발생하고, 결국 Setter를 통해서 넣어주게되면, 불변성을 보장할 수도 없으며,
필드 주입의 장점인 간결한 코드 또한 의미가 없어지게 된다.
주로 테스트코드나 Spring 설정 클래스인 @Configuration 같은 곳에서만 사용된다.
```
 
### Constructor Injection(생성자 주입)
```
가장 많이 사용되는 방법으로, 생성자를 통해 의존관계를 주입받는 것이다.
생성자위에 @Autowired 에노테이션을 붙여주면 된다.
생성자가 하나라면 생략이 가능하다. 객체 생성시점에 단 한번만 호출되며, 
불변, 필수적인 요소를 주입 받을 때 사용하면 좋다.
```

### Setter Injection (수정자 주입)
```
setter 메소드위에 @Autowired 에노테이션을 붙여주면된다.
IOC 컨테이너가 @Autowired가 붙은 요소들을 찾아서 injection을 해주기 떄문에 가능하다.
객체 생성이후에, @Autowired가 붙은 수정자가 호출된다. 순서는 보장되지 않는다.
setter를 통해서 의존성을 변경하고자 할 때 사용된다.
```
### Method Injection(메소드 주입)
```
사실 Setter와 별 차이가 없다. @Autowired 에노테이션이 붙은
메소드를 실행하기 때문에 메소드 주입 또한 가능하다.
setter와 다른점은 여러개를 동시에 주입받을 수 있다는 것이다.
객체 생성 이후에 메소드가 실행된다.
```

## @Autowired 주입 옵션
[Autowired 옵션에 따른 DI 테스트](https://github.com/ktj1997/SpringStudy/blob/master/spring/src/test/java/com/study/spring/bean/AutowiredTest.java)
### @Autowired(required=false)
IOC컨테이너가 관리하지 않는 Bean 주입을 요청하면, 메소드 자체를 호출하지 않는다.

### 인자에 @Nullable
IOC컨테이너가 관리하지 않는 Bean 주입을 요청하면 Null을 주입해준다.

### 인자에 Optional
IOC컨테이너가 관리하지 않는 Bean 주입시에 Optional.empty()를 주입해준다.

## 동일한 Type의 Bean이 2개 이상일 때
우선적으로 Type으로 검색하고 그 이후에 이름으로 검색한다.
만약 같은 Type이 2가지 이상 있을 때 에러가 발생한다. (무엇을 주입 받을지 모르기 떄문)
이럴 때 @Qualifier나 @Primary를 사용 할 수 있다.

### @Qualifier
DisCountPolicy의 타입을 갖는 Bean이 두가지 있다고 가정할 때,

```java
@Component
@Qualifier("FixedPolicy")
public class FixDiscountPolicy implements DiscountPolicy 
```

```java
@Autowired
    public OrderServiceImpl(@Qualifier("FixedPolicy") DiscountPolicy discountPolicy, OrderRepository orderRepository){ 
        this.discountPolicy = discountPolicy;
        this.orderRepository = orderRepository;
    }
```

주입 받는 측에서 Parameter에 @Qualifier를 붙인 인자와 함께 주입 가능하다.
### @Primary

동일 Bean이 2가지 있더라도, @Primary가 붙은 Bean을 주입한다.

```java
@Component
@Primaryublic class FixDiscountPolicy implements DiscountPolicy
```

# Spring Bean LifeCycle

### 스프링 컨테이너 생성 → 스프링 빈 생성 → 의존관계 주입

### → 초기화 콜백 → 소멸 전 콜백 → 소멸

### 1. 인터페이스 상속을 통한 LifeCycleCallback 사용

```jsx
초기화 용도의 Callback을 사용할 경우
InitializingBean을 implements한다.

소멸 용도의 Callback을 사용할 경우
DisposalBean을 implements한다.

이 방법의 단점은 SpringContainer에 의존적이 된 다는 것이고,
코드의 수정이 불가능한 외부라이브러리에는 사용 할 수 없다.
```

### 2. Bean Configuration을 사용한 LifeCycleCallback 사용

```jsx
Configuration 클래스에서 Bean을 설정 할 때, 에노테이션에 추가적인 옵션을 부여 할 수 있다.

@Bean(initMethod=[initMethod정의]
@Bean(destroyMethod=[destroyMethod정의])

Configuration클래스에서의 설정이기 떄문에 Spring에 의존적이지 않으며,
코드에 변경이 불가능한 외부라이브러리에도 적용이 가능하다.
```

### 3. Annotaion을 이용한 LiceCycleCallback 사용

```jsx
에노테이션을 이용하여, LifeCycleCallback사용이 가능하다.
Bean에 메소드를 정의하고 위에 @PostConstruct나 @PreDestory를 정의하면 된다.

장점은 구현이 쉽다는 것과, 컴포넌트 스캔에 알맞다는 것이지만, 
1번과마찬가지로 외부라이브러리에 적용이 불가능하다.
```

## Bean Scope

### Singleton

```jsx
@Scope("singleton")
Bean의 Default가 Singleton이다.
SpringContainer와 Scope가 같은 Bean.
SpringContainer가 Bean의 생성부터 소멸까지 모두 관여한다.

의존성 주입은 Singleton객체 생성이후 PostConstruct시점에 한번 일어난다.
```

### Prototype

```jsx
@Scope("prototype")

Singleton Bean에 비해서 생명이 짧은 Bean
SpringCotainer가 Bean의 생성과 의존성주입까지는 관여하지만
객체의 소멸에는 관여하지 않는다.

객체의 소멸시점에 따른 추가작업의 책임은 클라이언트로 넘어간다.
매번 사용할 때 새로운 의존관계 주입이완료된 객체가 필요할 때 사용한다.
```

### Singleton과 Prototype을 혼용할 때 문제점

```jsx
Singleton Bean안에 PrototyeBean을 주입받아 사용할 때,
의도와 다르게 각 Client마다 PrototypeBean을 할당해주지 않는다.

SingletonBean의 의존성주입은 SingletonBean 생성 시점에서 이미 발생했기 때문이다.
이러한 경우 DL(DependncyLookUp)이 필요하다.

필요한 Bean을 SpringContainer에서 찾아서 필요할 때 직접 주입하는 것이다.
ApplicationContext를 주입받아 사용하는 방법도 있지만 너무 Spring에 의존적이다.

방법은 크게 2가지 있다.

1)ObjectProvider - Spring
  DL기능과 더불어 추가적인 편의기능을 제공해준다.
  @Autowired
  ObjectProvider<T> objectProvider;
  provider.getObjet()를 이용해서 사용 가능하다.

2)Provider - JSR303 Provider
  java진영의 표준, 하지만 외부라이브러리이다.
  Spring에 의존적이지않다.

  @Autowired
  Provider<T> provider;
  provider.get()을 이용해서 사용가능하다.
```

### web
```
 1.request: Http 요청이 나갔다가 들어올때까지의 생명주기를 가짐
 2.session: Http Session만큼의 생명주기를 가짐
 3.application: ServerletContext만큼의 생명주기를 가짐
 4.webSocket: 웹소켓 만큼의 생명주기를 가짐
 
 공통점은 이 Bean들은 Web요청이 들어올 때 생성이 
 Controller나 Service에 생성자 주입이 불가능 하다는 것이다.
 
 이러한 문제는 Provider나, 프록시를 통해 해결 할 수 있다.
```
### webScope 의존성주입 Proxy로 해결
```
@Scope(value ="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope 에노테이션에는 proxyMode를 지정해 줄 수 있다.
클래스, 인터페이스를 지정 가능한데, 클래스의 경우 해당 클래스를 상속받은 프록시클래스가 생성된다.(CGLIB 기반)
해당 프록시객체로 우서적으로 의존성주입이 되고, 실제 사용될 때 실제 해당 클래스를 로딩한다.

Proxy기반 방법과, Provider방법 모두 공통점은 실제 사용 할 때까지 해당 클래스의 로딩을 지연한다는 것이다.
```
