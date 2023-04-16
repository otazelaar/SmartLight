package com.example.smartlight.data.db

import androidx.room.*

@Dao
interface LightDao {

    @Upsert
    suspend fun insertBooks(books: List<LightEntity>): LongArray

    /**
     * getBookByID() searches the database by primary key which in this case is the ISBN13 number
     *      which is specific to each book. it returns a single BookEntity which can than be mapped
     *      to the Book data class to be used in the UI.
     */
    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun getBookById(id: String): LightEntity?

    /**
     * searchBooks() searches the entire database of books at any point in time. It is important
     *      to know that books are stored in the database everytime a network call is made. So the
     *      database continues to grow each time the user clicks on a new category. BookDao is not
     *      deleting older books at this point in time. Searching will become incorrect overtime as
     *      new books are added.
     */
    @Query("SELECT * FROM books WHERE title LIKE '%' || :search || '%'")
    suspend fun searchBooks(search: String?): List<LightEntity>

    /**
     * getAllBooks() is used to verify the cache has been filled for testing
     */
    @Query(" SELECT * FROM books")
    suspend fun getAllBooks(): List<LightEntity>

}