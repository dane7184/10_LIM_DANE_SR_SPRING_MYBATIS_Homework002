package org.example.repository;

import org.apache.ibatis.annotations.*;
import org.example.model.entity.Instructor;
import org.example.model.request.InstructorsRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    /* Get All Instructor */
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "name", column = "instructor_name")
    }
    )
    @Select("""
            SELECT * FROM tb_instructor LIMIT #{size} OFFSET #{offSet};
    """)
    List<Instructor> getAllInstructor(@Param("offSet")int offSet, @Param("size") int size);

    /*  Get Instructor By ID  */
    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM tb_instructor WHERE instructor_id = #{instructorId}
    """)
    Instructor getInstructorById(Long instructorId);

    /*  Add Instructor  */
    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO tb_instructor VALUES (default, #{req.name}, #{req.email}) RETURNING *
    """)
    Instructor addInstructor(@Param("req") InstructorsRequest request);

    /*  Update  */
    @ResultMap("instructorMapper")
    @Select("""
        UPDATE tb_instructor
        SET instructor_name = #{req.name},
            email = #{req.email} 
        WHERE instructor_id = #{instructorId} RETURNING *
    """)
    Instructor updateInstrouctorById(Long instructorId, @Param("req") InstructorsRequest request);

    /*  Delete By Id  */
    @ResultMap("instructorMapper")
    @Select("""
        DELETE FROM tb_instructor WHERE instructor_id = #{instructorId}
    """)
    Instructor deleteInstructorById(Long instructorId);
}
