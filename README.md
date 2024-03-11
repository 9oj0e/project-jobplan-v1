# 구인구직 사이트
## 프로젝트 목표

# 시연 (영상)
## PPT

# 시연 (핵심 로직)
## 공고 작성 (구인자)
### 1. 회원가입 및 로그인
### 2. 채용공고 작성
### 3. 작성 공고 확인
## 이력서 작성 (구직자)
### 1. 회원가입 및 로그인
### 2. 이력서 작성
### 3. 이력서 확인
## 지원
### 1. 채용공고 확인 (구직자)
### 2. 이력서 지원 (구직자)
### 3. 지원 현황 확인 (구인자)
### 4. 지원서 합격 판별 (구인자)
### 5. 지원 합격 여부 확인 (구직자)

# 시연 (부가 로직)
## 개인 정보 수정
## 채용공고 수정 (구인자)
## 이력서 수정 (구직자)
## 스킬 추가(및 수정)
## 로그아웃
## 사진 업로드
## 스킬 매칭
## 평점
![평가하기_user1](https://github.com/9oj0e/project-job-plan/assets/129649095/722254f7-55c1-40ec-bf6f-9605d52631a6)

![image](https://github.com/9oj0e/project-job-plan/assets/129649095/f9bcdb31-507f-4d4c-b0c1-63d2bde9ab22)

![image](https://github.com/9oj0e/project-job-plan/assets/129649095/1c878e5c-0893-4a65-82b8-a050d331800e)

![image](https://github.com/9oj0e/project-job-plan/assets/129649095/daccc476-1a02-497b-8d53-52ee48dac76c)

![image](https://github.com/9oj0e/project-job-plan/assets/129649095/d217f161-db33-441e-8d91-b03ecd932dd4)

![image](https://github.com/9oj0e/project-job-plan/assets/129649095/853072a1-43e1-466e-b932-4b926b2a4100)
## 구독

# 개발 환경
## IDE
## 언어
## Framework
## DB
## Template
## VSC
## 프로젝트 아키텍쳐 : MVC 설계

## 테이블 설계

## 진행
### 1단계 (완료)
요구사항 수집 및 분석
웹 화면 설계
table 설계
### 2단계 (완료)
조정현
- 세팅 완료
  - CRUD 인터페이스 생성
    - board
    - user
  - 회원가입
  - 로그인&로그아웃
  - 마이 페이지(개인)
    - 이력서
      - 리스트 보기
      - 수정
      - 삭제
    - 지원 현황
      - view 디자인
      - SQL
  - 마이 페이지(기업)
    - 지원자 현황
      - view 디자인
      - 지원자 현황
        - 전체 보기
        - 공고별 보기
  - 채용 공고
    - 지원하기
김정수
- 이력서
  - 등록
  - 상세보기
  - 수정
  - 삭제
- 채용 공고
  - 등록
  - 상세보기
  - 수정
  - 삭제
- 메인 페이지
  - 공고 목록 보기
- 마이 페이지 (개인)
  - 지원 현황
    - 기능 구현
- 마이 페이지 (기업)
  - 지원자 현황
    - SQL
류재성
- 메인 페이지
  - 개인 메인
  - 기업 메인
  - 페이지네이션
김성재&최윤정
- 마이 페이지 (개인)
  - 보기
  - 수정
- 마이 페이지 (기업)
  - 보기
  - 수정
  - 공고 리스트 보기
- 사진
  - 등록
  - 조회
    - 메인 페이지
    - 마이 페이지
    - 공고 페이지
    - 이력서 페이지
  - 삭제
### 3단계 (완료)
조정현&김정수
- 디버깅 & view 취합
- 구독(스크랩)
류재성
- 스킬
  - 체크박스 데이터 받기
  - 조회
  - 수정
  - 삭제
- 매칭
김성재&최윤정
- 평점
  - 개인
    - 등록(기업 평가)
    - 조회
  - 기업
    - 등록(개인 평가)
    - 조회
### 4단계 (미완)
커뮤니티
고객센터
push
redis
## 협업 전략
### GitHub
- Branch : 이름 이니셜 날짜 시간
- commit : 작업 내용에 대한 요약 담기
- comment : 문제를 겪은 부분 정리
- issue : 버그나 해결사항 올리기
### 코드 컨벤션
- 패키지 : lowerCase, domain별 패키지 만들기
- 파일 : camelCase
- 클래스/메서드/필드값 : pascalCase
- DTO : Request/Response 내부 클래스에 목적지정보를 담기
  - e.g. Request : UploadDTO, UpdateDTO, Response : ToEmployerDTO, ToUserDTO
### 회의
- 매일 회의록 작성
  - 진행 상황 보고
  - 문제점 발견 및 피드백
  - 건의사항
- 해결 과제
  - 할 일 목록 작성