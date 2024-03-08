-- user_tb
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('emp1', '1234', '조정현', '1996-04-01', 'M', '01012345678', '주소', 'email@naver.com',
        true, '0128275512', '네이버', now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('emp2', '1234', '류재성', '1991-10-01', 'M', '01012345678', '주소', 'email@kakao.com',
        true, '0128275512', '카카오', now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('emp3', '1234', '김정수', '1996-08-01', 'M', '01012345678', '주소', 'email@line.com',
        true, '0128275512', '라인', now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('emp4', '1234', '김성재', '1998-05-01', 'M', '01012345678', '주소', 'email@coupang.com',
        true, '0128275512', '쿠팡', now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('emp5', '1234', '최윤정', '2000-04-01', 'F', '01012345678', '주소', 'email@baemin.com',
        true, '0128275512', '배달의민족', now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user1', '1234', '홍길동', '2000-01-01', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user2', '1234', '이가탄', '2000-01-01', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user3', '1234', '홍금보', '2000-01-01', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user4', '1234', '김덕배', '2000-01-01', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user5', '1234', '한만춘', '2000-01-01', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user6', '1234', '전두광', '1931-01-18', 'M', '01012345678', '주소', 'username@domain.com',
        false, null, null, now());

--board_tb

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, '솔루션 운영/개발자 (2년 이상)',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '풀스택', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, 'S/W Front-End',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, 'AI 비전 플랫폼 개발',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '기획자', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, '클라우드 DevOps 엔지니어',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '클라우드', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (2, '솔루션 운영/개발자 (2년 이상)',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '풀스택', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (2, 'S/W Front-End',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (2, 'AI 비전 플랫폼 개발',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '기획자', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (2, '클라우드 DevOps 엔지니어',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '클라우드', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (3, '솔루션 운영/개발자 (2년 이상)',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '풀스택', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (3, 'S/W Front-End',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (3, 'AI 비전 플랫폼 개발',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '기획자', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (3, '클라우드 DevOps 엔지니어',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '클라우드', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (4, '솔루션 운영/개발자 (2년 이상)',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '풀스택', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (4, 'S/W Front-End',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (4, 'AI 비전 플랫폼 개발',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '기획자', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (4, '클라우드 DevOps 엔지니어',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '클라우드', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (5, '솔루션 운영/개발자 (2년 이상)',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '풀스택', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (5, 'S/W Front-End',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (5, 'AI 비전 플랫폼 개발',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '기획자', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(employer_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (5, '클라우드 DevOps 엔지니어',
        '저희 회사와 함께 성장할 수 있는 역량 있고 창의적인 분들의 지원을 기대합니다. 포지션 상세.. 주요 업무 : 게시판, 백 오피스 구축, 연동, api 연동. 자격 요건 : 풀스택. 우대 사항 : PHP를 전문적으로 다루시는 분. 혜택 및 복지 : 4대 보험, 주 5일제',
        '클라우드', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

-- resume_tb

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (6, '새싹을 틔울 수 있는 씨앗이 되겠습니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (7, '새싹을 틔울 수 있는 씨앗이 되겠습니다.', '이력서내용', '학교명', '전공', '학력', '프론트 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (8, '새싹을 틔울 수 있는 씨앗이 되겠습니다.', '이력서내용', '학교명', '전공', '학력', '풀스택 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (9, '매일 30분으로 내가 이뤄낸 것.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (10, '학점 2.3에서 편입 후 4.2로.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (11, '목표를 달성하기 위해 실행한 3단계 실행 계획.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (6, '당신은 내가 넘어야 할 작은 산에 불과하다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (7, '당신은 내가 넘어야 할 작은 산에 불과하다.', '이력서내용', '학교명', '전공', '학력', '프론트 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (8, '당신은 내가 넘어야 할 작은 산에 불과하다.', '이력서내용', '학교명', '전공', '학력', '풀스택 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (9, '화살 하나는 쉽게 부러져도 화살 한 묶음은 쉽게 부러지지 않습니다.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (10, '자전거는 계속 나아가지 않으면 쓰러진다.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (11, '한번 물면 쉽게 놓지 않습니다.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (6, '회복의 유일한 길은 다시 시작하는 것이다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (7, '회복의 유일한 길은 다시 시작하는 것이다.', '이력서내용', '학교명', '전공', '학력', '프론트 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (8, '회복의 유일한 길은 다시 시작하는 것이다.', '이력서내용', '학교명', '전공', '학력', '풀스택 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (9, '배우는 것은 산에 오르는 것과 같다.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (10, '혁신은 180도 다른 시선에서 나온다.', '이력서내용', '학교명', '전공', '학력', '신입', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (11, '여전할 것인가, 역전할 것인가.', '이력서내용', '학교명', '전공', '학력', '신입', now());

-- apply_tb

INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at, status)
VALUES (1, 6, 1, 1, now(), 1);
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at, status)
VALUES (2, 7, 2, 1, now(), 0);
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (3, 8, 3, 1, now());
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (4, 9, 4, 1, now());
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (5, 10, 1, 1, now());
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (6, 11, 2, 1, now());

INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at, status)
VALUES (1, 6, 5, 2, now(), 1);
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at, status)
VALUES (2, 7, 6, 2, now(), 0);
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (3, 8, 7, 2, now());
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (4, 9, 8, 2, now());
INSERT INTO apply_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (5, 10, 5, 2, now());

-- subscribe_tb

INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (1, null, null, 1, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (2, null, null, 1, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (1, null, null, 2, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (2, null, null, 2, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (1, null, null, 3, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (2, null, null, 3, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (1, null, null, 4, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (1, null, null, 5, now());

INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 6, 1, null, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 6, 2, null, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 6, 3, null, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 7, 1, null, now());
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 7, 4, null, now());;
INSERT INTO subscribe_tb
(resume_id, resume_user_id, board_id, board_user_id, created_at)
VALUES (null, 8, 7, null, now());