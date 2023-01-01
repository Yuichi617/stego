package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.service.UserService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}