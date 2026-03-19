package org.example.repository;

import org.apache.ibatis.annotations.*;
import org.example.model.entity.Student;
import org.example.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {

    /*  Get All Student  */
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
            many = @Many(select = "org.example.repository.CourseRepository.getCourseByIds"))
    })
    @Select("""
        SELECT * FROM tb_student;
    """)
    List<Student> getAllStudent(int offSet, int size);

    /*  Get Student By ID  */
    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM tb_student WHERE student_id = #{studentId}
    """)
    List<Student> getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM tb_student WHERE student_id = #{studentId}
    """)
    Student getStudentByIds(Long studentId);

    /*  Add Student  */
    @ResultMap("studentMapper")
    @Select("""
        INSERT INTO tb_student VALUES (default, #{rep.name}, #{rep.email}, #{rep.phoneNumber}) RETURNING *
    """)
    Student saveStudent(@Param("rep") StudentRequest request);

    /*   Insert student course By ID   */
    @Insert("""
        INSERT INTO tb_student_course (student_id, course_id)
        VALUES (#{studentId}, #{courseId})
    """)
    void insertStudentCourse(@Param("studentId") Long studentId,
                             @Param("courseId") Long courseId);

    /*  Update Student By ID  */
    @ResultMap("studentMapper")
    @Select("""
        UPDATE tb_student SET
            student_name = #{rep.name}, 
            email = #{rep.email}, 
            phone_number = #{rep.phoneNumber}
        WHERE student_id = #{studentId} RETURNING *
    """)
    Student updateStudentById(@Param("studentId")Long studentId,@Param("rep") StudentRequest request);

    /*  Delete Student By ID  */
    @ResultMap("studentMapper")
    @Select("""
        DELETE FROM tb_student WHERE student_id = #{studentId}
    """)
    Student deleteStudentById(Long studentId);

    @Delete("""
        DELETE FROM tb_student_course
        WHERE student_id = #{studentId}
    """)
    void deleteStudentCourses(@Param("studentId") Long studentId);
}
