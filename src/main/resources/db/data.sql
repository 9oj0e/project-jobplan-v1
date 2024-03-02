--board_tb

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (2, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (3, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (4, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (5, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (6, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (7, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (8, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (9, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (10, '제목', '2024년 신입 노예 채용', '백앤드 프론트', '신입', '최저시급', '2024-02-26', '2024-03-08', now());

-- resume_tb

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (1, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (2, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (3, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (4, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (5, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (6, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (7, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (8, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (9, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (10, '성실하고 유능한 인재입니다.', '이력서내용', '학교명', '전공', '학력', '백앤드 1년', now());





-- user_tb
INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
        false, 1234, '회사명', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '서울', '이메일',
        true, 1234, '삼성', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '대전', '이메일',
        true, 1234, '롯데', now());


INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
        false, 1234, '회사명', now());



INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '대구', '이메일',
        true, 1234, '구글', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '부산', '이메일',
        true, 1234, '네이버', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
        false, 1234, '회사명', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '광주', '이메일',
        true, 1234, '카카오', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
        false, 1234, '회사명', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '마산', '이메일',
        true, 1234, '네이버', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
        false, 1234, '회사명', now());