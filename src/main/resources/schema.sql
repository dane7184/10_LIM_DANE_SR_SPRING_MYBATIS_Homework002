CREATE TABLE IF NOT exists tb_instructor
(
    instructor_id SERIAL PRIMARY KEY,
    instructor_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_student
(
    student_id   SERIAL PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_courses
(
    course_id   SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description        TEXT NOT NULL,
    instructor_id INT NOT NULL,
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES tb_instructor (instructor_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tb_student_course
(
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES tb_student (student_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES tb_courses (course_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
