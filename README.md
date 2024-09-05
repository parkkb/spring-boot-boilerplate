# Spring-Boot-Boilerplate

- Boilerplate : 여러 가지 상황에서 거의 변경하지 않고 재사용할 수 있는 코드
- Spring-Boot 프로젝트 생성시 기본으로 사용되는 코드를 미리 생성/검수
-

## Spec

- spring-boot 3.2.4
- jdk : azul jdk 17
- orm : jpa, QueryDSL

## 완료한 api

- 로그인
- 회원가입

## package

- common : 공통 부분
- enum, exeception, filter, handler
- domain :  도메인 별 구현
- infrastructure : db crud
- interfaces : api controller

## Test

- controller test
  - Mockito를 통해서 url 검증 테스트
- service test
  - SprintBootTest를 통해서 테스트 가능.
- test 시 local 환경에서는 h2 테이블을 이용해서 테스트
- ci 환경에서 controller와 service는 테스트 불가.

## Module
module-api : api 모듈

module-batch : batch 모듈