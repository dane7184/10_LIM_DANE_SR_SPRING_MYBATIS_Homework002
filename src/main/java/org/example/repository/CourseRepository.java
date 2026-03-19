package org.example.repository;

import org.apache.ibatis.annotations.*;
import org.example.model.entity.Course;
import org.example.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    /*  Get All Courses  */
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructors", column = "instructor_id",
            one = @One(select = "org.example.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
        SELECT * FROM tb_courses LIMIT #{size} OFFSET #{offSet};
    """)
    List<Course> getAllCourses(int offSet, int size);

    /*  Get Course By ID  */
    @ResultMap("courseMapper")
    @Select("""
        SELECT * FROM tb_courses WHERE course_id = #{courseId}
    """)
    Course getCourseById(Long courseId);

    /*   Get More Course By ID    */
    @ResultMap("courseMapper")
    @Select("""
    SELECT c.*
        FROM tb_courses c
        INNER JOIN tb_student_course sc ON c.course_id = sc.course_id
        WHERE sc.student_id = #{studentId}
    """)
    Course getCourseByIds(Long courseId);

    /*   Add Course   */
    @ResultMap("courseMapper")
    @Select("""
        INSERT INTO tb_courses VALUES (default, #{req.courseName}, #{req.description}, #{req.instructorId})
        RETURNING *
    """)
    Course addCourse(@Param("req") CourseRequest request);

    /*  Update Course By ID  */
    @ResultMap("courseMapper")
    @Select("""
        UPDATE tb_courses 
        SET course_name = #{req.courseName},
            description = #{req.description},
            instructor_id = #{req.instructorId}
        WHERE course_id = #{courseId} RETURNING *
    """)
    Course updateCourseeById(Long courseId,@Param("req") CourseRequest request);

    /*  Delete Course By ID   */
    @ResultMap("courseMapper")
    @Select("""
        DELETE FROM tb_courses WHERE course_id = #{courseId}
    """)
    Course deleteCourseById(Long courseId);
}
