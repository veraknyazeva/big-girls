package home.work.controller;

import home.work.workingWithData.Participant;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;


class BigGirlsDataControllerTest {
    static BigGirlsDataController bigGirlsDataController;
    Participant participant;

    @BeforeAll
    public static void setUp() {
        bigGirlsDataController = new BigGirlsDataController();

    }

    @BeforeEach
    void createParticipant() {
        participant = new Participant("Inna Ivanova", 100.0);
    }

    @AfterEach
    void clearParticipants() {
        BigGirlsDataController.PARTICIPANTS.clear();
    }

    @Test
    void addParticipant() {
        Assertions.assertEquals(true, BigGirlsDataController.PARTICIPANTS.isEmpty());

        bigGirlsDataController.addParticipant("Inna Ivanova", 100.0);

        Assertions.assertEquals(1, BigGirlsDataController.PARTICIPANTS.size());
        Assertions.assertEquals(participant, BigGirlsDataController.PARTICIPANTS.get(0));

    }

    @Test
    void checkContains_with_hamcrest() {
        Participant participant1 = new Participant("Vladimir Svetlov", 100.0);
        Participant participant2 = new Participant("Ivan Ivanov", 110.0);
        Participant participant3 = new Participant("Alena Krasnova", 135.0);

        assertThat(BigGirlsDataController.PARTICIPANTS.isEmpty(), equalTo(true));

        bigGirlsDataController.addParticipant("Vladimir Svetlov", 100.0);
        bigGirlsDataController.addParticipant("Ivan Ivanov", 110.0);
        bigGirlsDataController.addParticipant("Alena Krasnova", 135.0);

        assertThat(BigGirlsDataController.PARTICIPANTS.size(), Is.is(greaterThanOrEqualTo(3)));
        assertThat(BigGirlsDataController.PARTICIPANTS, hasItem(participant3));

    }
}