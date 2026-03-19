INSERT INTO tb_instructor (instructor_name, email)
VALUES ('Dane', 'dane.example@gmail.com'),
       ('Thearin', 'thearin.example@gmail.com'),
       ('Sean Sean', 'seansean.example@gmail.com'),
       ('Lyza', 'Lyza.example@gmail.com'),
       ('Pich', 'pich.example@gmail.com');

INSERT INTO tb_student (student_name, email, phone_number)
VALUES ('Dane', 'dane@gmail.com', '0987654321'),
       ('Koko', 'koko@gmail.com', '0123456789'),
       ('kaka', 'kaka@gmail.com', '0345678912'),
       ('Nita', 'Nita@gmail.com', '0765432198'),
       ('Jane', 'jane@gmail.com', '0132475869');

INSERT INTO tb_courses (course_name, description, instructor_id)
VALUES ('JAVA', 'Java is a popular programming language.', 1),
       ('Spring', 'Spring is an open-source, Java-based app framework that covers many smaller projects under its umbrella.', 2),
       ('React Js', 'React  is an open-source JavaScript library for building user interfaces (UIs) using a component-based approach. ', 3),
       ('Database', 'database is an organized, electronically stored collection of structured information or data, typically managed by a Database Management System (DBMS). ', 4),
       ('Korea', 'Korean is the official language of both South and North Korea.', 5);


INSERT INTO tb_student_course
VALUES (1, 1),
       (1,2),
       (2, 4),
       (2, 5),
       (3, 1),
       (3, 4),
       (4, 1),
       (4, 2),
       (5, 3),
       (5, 5);