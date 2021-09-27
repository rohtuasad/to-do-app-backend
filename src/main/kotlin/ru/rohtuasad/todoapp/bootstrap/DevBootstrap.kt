package ru.rohtuasad.todoapp.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import ru.rohtuasad.todoapp.model.User
import ru.rohtuasad.todoapp.repository.UserRepository

@Component
class DevBootstrap
@Autowired
constructor(private val userRepository: UserRepository) :
    ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(p0: ContextRefreshedEvent) {
        val user = User("Name", "username", "password", "user@user.com")
        userRepository.save(user)
    }
}
