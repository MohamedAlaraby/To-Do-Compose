package com.example.to_docompose.data

import androidx.room.*
import com.example.to_docompose.data.model.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query(value = "SELECT * FROM to_do_table order by id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query(value = "select * FROM to_do_table where id=:taskID")
    fun getSelectedTask(taskID: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("delete FROM to_do_table")
    suspend fun deleteAllTasks()

    @Query(value = "SELECT * FROM to_do_table where title LIKE :searchQuery OR" +
            " description like :searchQuery")
     fun searchDatabase(searchQuery:String):Flow<List<ToDoTask>>


    @Query(value = "SELECT * FROM to_do_table ORDER BY CASE WHEN priority like 'L%' THEN 1 " +
            "  WHEN priority LIKE 'M%' THEN 2  WHEN priority like 'H%' THEN 3 end")
     fun sortByLowPriority():Flow<List<ToDoTask>>
    @Query(value = "select * from to_do_table order by case when priority like 'H%' THEN 1" +
            " WHEN priority like 'M%' THEN 2  WHEN priority like 'L%' then 3 end")
     fun sortByHighPriority():Flow<List<ToDoTask>>

}