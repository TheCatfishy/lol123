package com.gss.restExample.controller


import com.gss.interfaces.service.ExampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping()
class ExampleControllerImpl constructor() {


    @Autowired
    var service: ExampleService? = null


    @GetMapping("/ping")
    fun ping() : String?{
        return service?.ping()
    }

    @GetMapping(value = ["/today/{language}/{city}"], produces = ["application/xml"])
    fun weatherToday(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather = service?.getWeatherToday(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }


    @GetMapping(value = ["/tomorrow/{language}/{city}"], produces = ["application/xml"])
    fun weatherTomorrow(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeatherTomorrow(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }

    @GetMapping(value = ["/2DaysAhead/{language}/{city}"], produces = ["application/xml"])
    fun weather2DaysAhead(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeather2DaysAhead(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }

    @GetMapping(value = ["/3DaysAhead/{language}/{city}"], produces = ["application/xml"])
    fun weather3DaysAhead(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeather3DaysAhead(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }

    @GetMapping(value = ["/4DaysAhead/{language}/{city}"], produces = ["application/xml"])
    fun weather4DaysAhead(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeather4DaysAhead(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }

    @GetMapping(value = ["/5DaysAhead/{language}/{city}"], produces = ["application/xml"])
    fun weather5DaysAhead(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeather5DaysAhead(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }

    @GetMapping(value = ["/6DaysAhead/{language}/{city}"], produces = ["application/xml"])
    fun weather6DaysAhead(@PathVariable language: String, @PathVariable city: String) : String?{
        val weather =  service?.getWeather6DaysAhead(language, city)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<vxml version = \"2.1\" >\n" +
                "<form>\n" +
                "<block>\n" +
                weather+
                "</block>\n" +
                "\n" +
                "    <goto next=\"http://webhosting.voxeo.net/208167/www/ict4d/intro/introTest.xml\"/>\n" +
                "\n" +
                "</form>\n" +
                "</vxml>"
    }
}