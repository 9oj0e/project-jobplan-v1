INSERT INTO board_tb
(user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
VALUES (1, '제목', '내용', '채용분야', '포지션', '연봉', '2024-02-26', '2024-03-08', now());

INSERT INTO resume_tb
(user_id, title, content, school_name, major, education_level, career, created_at)
VALUES (1, '이력서제목', '이력서내용', '학교명', '전공', '학력', '경력', now());

INSERT INTO user_tb
(username, password, name, birthdate, gender, phone_number, address, email,
 is_employer, employer_id_number, business_name, created_at)
VALUES ('user', '1234', '조정현', '1996-04-01', 'M', 010-0000-0000, '주소', '이메일',
    false, 1234, '회사명', now());