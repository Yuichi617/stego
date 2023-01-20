package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.app.internal_v1.form.UserDeleteParam
import com.movies.stegobe.app.internal_v1.form.UserParam
import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.service.UserService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
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
    @ApiOperation(value = "ユーザを取得する", notes = "")
    fun get(): List<User> = userService.findAll()

    /**
     * IDでユーザGET
     * @param id ID
     * @return ユーザ
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "IDでユーザを取得する", notes = "")
    fun getById(@ApiParam(value = "ユーザID", example = "123") @PathVariable @NotNull id: Int): User? = userService.getById(id)

    /**
     * ユーザPOST
     * @param postParam ユーザPOSTパラメータ
     * @return ユーザ
     */
    @PostMapping
    @ApiOperation(value = "ユーザを登録する", notes = "")
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
    @ApiOperation(value = "ユーザを更新する", notes = "")
    fun put(
        @ApiParam(value = "ユーザID", example = "123") @PathVariable id: Int,
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
    @ApiOperation(value = "ユーザを削除する", notes = "")
    fun delete(
        @ApiParam(value = "ユーザID", example = "123") @PathVariable id: Int,
        @RequestBody @Validated deleteParam: UserDeleteParam
    ) =
        userService.delete(id, deleteParam.user_id)
}