package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.app.internal_v1.form.MovieParam
import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.service.UserService
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("internal_api/v1/users")
class UserController(
    private val userService: UserService
) {

    /**
     * ユーザGET
     * @return ユーザ
     */
    @GetMapping
    fun get(): List<User> = userService.find()

    /**
     * IDでユーザGET
     * @param id ID
     * @return ユーザ
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): User = userService.findById(id)

//    /**
//     * ユーザPOST
//     * @param postParam ユーザPOSTパラメータ
//     * @return ユーザ
//     */
//    @PostMapping
//    fun post(@RequestBody @Validated(MovieParam.Post::class) postParam: MovieParam): MovieWithRelation =
//        userService.save(
//            Movie(
//            userId = postParam.user_id,
//            name = postParam.name,
//            comment = postParam.comment,
//            eval = postParam.eval,
//            genreId = postParam.genre_id
//        )
//        )
//
//    /**
//     * ユーザPUT
//     * @param id ID
//     * @param putParam ユーザPUTパラメータ
//     * @return ユーザ
//     */
//    @PutMapping("/{id}")
//    fun put(
//        @PathVariable id: Int,
//        @RequestBody @Validated(MovieParam.Put::class) putParam: MovieParam
//    ): MovieWithRelation =
//        userService.save(
//            Movie(
//            id = id,
//            userId = putParam.user_id,
//            name = putParam.name,
//            comment = putParam.comment,
//            eval = putParam.eval,
//            genreId = putParam.genre_id
//        )
//        )
//
//    /**
//     * ユーザDELETE
//     * @param id ID
//     */
//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: Int) =
//        userService.delete(id)
}