package ch.fhnw.webec.lengthconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConvertController {

    @GetMapping("convert")
    public ConvertResponse convert(ConvertRequest request) {
        var cm = 30.48 * request.feet + 2.54 * request.inches;
        var cmPart = (int) cm;
        var mmPart = (int) (cm * 10 % 10);
        return new ConvertResponse(cmPart, mmPart);
    }

    public record ConvertRequest(int feet, int inches) {}

    public record ConvertResponse(int cmPart, int mmPart) {}
}
