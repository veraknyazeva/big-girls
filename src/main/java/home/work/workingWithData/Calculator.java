package home.work.workingWithData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {

    public String calculateThePercentage(Participant participant, double lostKilos){
        double currentWeight = participant.getWeight() - lostKilos;
        double weightPercentage = currentWeight * 100 / participant.getWeight();
        double finalPercentage = 100 - weightPercentage;
        participant.setWeight(currentWeight);
        return "Текущий вес " + currentWeight + " процент скинутых килограмм " + finalPercentage;
    }
}
