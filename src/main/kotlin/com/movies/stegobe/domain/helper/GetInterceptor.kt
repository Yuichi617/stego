package com.movies.stegobe.domain.helper

import com.movies.stegobe.domain.exception.NotFoundException
import org.apache.commons.logging.LogFactory
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class GetInterceptor {

    companion object {
        private val log = LogFactory.getLog(GetInterceptor::class.java)
    }

    /**
     * get*ById*メソッド正常終了後の処理
     * @param jp get*ById*メソッドのJoinPoint
     * @param entity get*ById*メソッドの戻り値
     * @param id get*ById*メソッドに渡したID
     */
    @AfterReturning(
        value = "execution(* com.movies.stegobe..*.*ServiceImpl.get*ById*(..)) && args(id,..)",
        argNames = "jp, entity, id",
        returning = "entity"
    )
    fun afterReturning(jp: JoinPoint, entity: Any?, id: Any) {
        if (entity == null) {
            log.info(String.format("%s.%s(%s) entity is null.",
                jp.target.javaClass.name,
                jp.signature.name,
                id))
            throw NotFoundException()
        }
    }
}