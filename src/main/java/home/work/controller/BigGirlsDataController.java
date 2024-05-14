package home.work.controller;

import home.work.workingWithData.Calculator;
import home.work.workingWithData.Participant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class BigGirlsDataController {
    public static final List<Participant> PARTICIPANTS = new ArrayList<>();
//        add(new Participant("Vanya", 100.5));
//        add(new Participant("Vera", 70.9));
//    }};

    private Calculator calculator = new Calculator();

    @PostMapping(path = "v1/add")
    public void addParticipant(@RequestHeader(name = "name") String name,
                               @RequestHeader(name = "weight") Double weight) {
        PARTICIPANTS.add(new Participant(name, weight));
        log.info("Добавлена участница" + " Имя Фамилия: " + name + " Вес: " + weight);
    }


    @PostMapping(path = "/v1/post-data")
    public String post(@RequestHeader(name = "name") String name,
                       @RequestHeader(name = "lostKilos") Double lostKilos) {
        log.info("Получены параметры name: {}, lostKilos: {}", name, lostKilos);

        try {
            Optional<Participant> first = PARTICIPANTS.stream()
                    .filter(participant -> participant.getName().equals(name))
                    .findFirst();
            Participant participant = first.get();
            return calculator.calculateThePercentage(participant, lostKilos);
        }catch (NoSuchElementException noSuchElementException){
            return "Такой участницы нет.";
        }
    }
}
