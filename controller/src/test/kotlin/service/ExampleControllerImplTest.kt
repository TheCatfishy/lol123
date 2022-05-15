package com.gss.restExample.service

import com.gss.interfaces.service.ExampleService
import com.gss.restExample.controller.ExampleControllerImpl
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.Mock

import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired


@ExtendWith(MockitoExtension::class)
class ExampleControllerImplTest {

    //Mockito mocks the total interface...
    @Mock
    var service: ExampleService? = null

    //And injects it in this autowired impl of the controller
    @InjectMocks
    var controller: ExampleControllerImpl? = null

    @Test
    fun testPingPong() {
        Assertions.assertNotNull(controller)
        Assertions.assertNotNull(controller?.service)
        //tell mockite what to return on which calls
        Mockito.`when`(service?.ping()).thenReturn("pong1")
        var str = controller?.ping()
        Assertions.assertEquals("pong1", str)

        Mockito.`when`(service?.ping()).thenReturn("pong2")
        str = controller?.ping()
        Assertions.assertEquals("pong2", str)

    }
}