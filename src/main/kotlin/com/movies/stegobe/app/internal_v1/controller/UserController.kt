package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.app.internal_v1.form.MovieParam
import com.movies.stegobe.app.internal_v1.form.UserDeleteParam
import com.movies.stegobe.app.internal_v1.form.UserParam
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
    fun get(): List<User> = userService.findAll()

    /**
     * IDでユーザGET
     * @param id ID
     * @return ユーザ
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): User = userService.getById(id)

    /**
     * ユーザPOST
     * @param postParam ユーザPOSTパラメータ
     * @return ユーザ
     */
    @PostMapping
    fun post(@RequestBody @Validated postParam: UserParam): User =
        userService.save(
            User(
                name = postParam.name,
                password = postParam.password
            )
        )

    /**
     * ユーザPUT
     * @param id ID
     * @param putParam ユーザPUTパラメータ
     * @return ユーザ
     */
    @PutMapping("/{id}")
    fun put(
        @PathVariable id: Int,
        @RequestBody @Validated putParam: UserParam
    ): User =
        userService.save(
            User(
                id = id,
                name = putParam.name,
                password = putParam.password
            )
        )

    /**
     * ユーザDELETE
     * @param id ID
     */
    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Int,
        @RequestBody @Validated deleteParam: UserDeleteParam
    ) =
        userService.delete(id, deleteParam.user_id)
}