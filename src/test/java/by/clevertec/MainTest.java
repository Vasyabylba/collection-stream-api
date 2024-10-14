package by.clevertec;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    @Test
    @SneakyThrows
    void task1() {
        String text = tapSystemOutNormalized(Main::task1);

        assertEquals("""
                Animal(id=614, bread=Snake, buttermilk, age=10, origin=Belarusian, gender=Bigender)
                Animal(id=649, bread=European stork, age=10, origin=Danish, gender=Female)
                Animal(id=712, bread=Flamingo, chilean, age=10, origin=Somali, gender=Male)
                Animal(id=713, bread=Red-breasted cockatoo, age=10, origin=Papiamento, gender=Female)
                Animal(id=744, bread=Blue-tongued lizard, age=10, origin=Swati, gender=Male)
                Animal(id=775, bread=Wolf spider, age=10, origin=Romanian, gender=Female)
                Animal(id=857, bread=Jackal, silver-backed, age=10, origin=Kazakh, gender=Female)\n""", text);
    }

    @Test
    @SneakyThrows
    void task2() {
        String text = tapSystemOutNormalized(Main::task2);

        assertEquals("""
                HURON
                BOA, MALAGASY GROUND
                BRAZILIAN TAPIR
                JAEGER, LONG-TAILED
                BLUE AND YELLOW MACAW
                GULL, LAVA
                GOLIATH HERON
                TORTOISE, INDIAN STAR
                SOUTH AMERICAN PUMA
                LONG-FINNED PILOT WHALE
                GULL, LAVA\n""", text);
    }

    @Test
    @SneakyThrows
    void task3() {
        String text = tapSystemOutNormalized(Main::task3);

        assertEquals("""
                Azeri
                Aymara
                Afrikaans
                Arabic
                Armenian
                Amharic
                Assamese
                Albanian\n""", text);
    }

    @Test
    @SneakyThrows
    void task4() {
        String text = tapSystemOutNormalized(Main::task4);

        assertEquals("""
                476\n""", text);
    }

    @Test
    @SneakyThrows
    void task5() {
        String text = tapSystemOutNormalized(Main::task5);

        assertEquals("""
                true\n""", text);
    }

    @Test
    @SneakyThrows
    void task6() {
        String text = tapSystemOutNormalized(Main::task6);

        assertEquals("""
                false\n""", text);
    }

    @Test
    @SneakyThrows
    void task7() {
        String text = tapSystemOutNormalized(Main::task7);

        assertEquals("""
                true\n""", text);
    }

    @Test
    @SneakyThrows
    void task8() {
        String text = tapSystemOutNormalized(Main::task8);

        assertEquals("""
                48\n""", text);
    }

    @Test
    @SneakyThrows
    void task9() {
        String text = tapSystemOutNormalized(Main::task9);

        assertEquals("""
                3\n""", text);
    }

    @Test
    @SneakyThrows
    void task10() {
        String text = tapSystemOutNormalized(Main::task10);

        assertEquals("""
                25329\n""", text);
    }

    @Test
    @SneakyThrows
    void task11() {
        String text = tapSystemOutNormalized(Main::task11);

        assertEquals("""
                25.8\n""", text);
    }


    @Test
    @SneakyThrows
    void task14() {
        String text = tapSystemOutNormalized(Main::task14);

        assertEquals("""
                Mongolia: Total mass = 16920 kilograms, Transportation expenses = $120808.80
                Uzbekistan: Total mass = 15075 kilograms, Transportation expenses = $107635.50
                Kazakhstan: Total mass = 283439 kilograms, Transportation expenses = $2023754.46
                Turkmenistan: Total mass = 31081 kilograms, Transportation expenses = $221918.34
                Kyrgyzstan: Total mass = 74411 kilograms, Transportation expenses = $531294.54
                Other: Total mass = 336779 kilograms, Transportation expenses = $2404602.06
                Russia: Total mass = 2099463 kilograms, Transportation expenses = $14990165.82
                Logistic company revenue: $20400179.52\n""", text);
    }

    @Test
    @SneakyThrows
    void task15() {
        String text = tapSystemOutNormalized(Main::task15);

        assertEquals("""
                The total maintenance cost of all plants = 3522362.23\n""", text);
    }

    @Test
    @SneakyThrows
    void task16() {
        String text = tapSystemOutNormalized(Main::task16);

        assertEquals("""
                Biba(age=17)\n""", text);
    }

    @Test
    @SneakyThrows
    void task17() {
        String text = tapSystemOutNormalized(Main::task17);

        assertEquals("""
                P-1
                C-2
                M-3
                C-4
                M-1
                C-3
                M-2
                P-3
                P-4
                C-1
                P-2\n""", text);
    }

    @Test
    @SneakyThrows
    void task18() {
        String text = tapSystemOutNormalized(Main::task18);

        assertEquals("""
                faculty = Chemistry, average age = 19.416666666666668
                faculty = ComputerScience, average age = 19.153846153846153
                faculty = Physics, average age = 18.846153846153847
                faculty = Mathematics, average age = 18.692307692307693\n""", text);
    }

    @Test
    @SneakyThrows
    void task19() {
        String group = "M-1";
        withTextFromSystemIn(group).execute(() -> {
            String text = tapSystemOutNormalized(Main::task19);

            assertEquals("""
                    Enter group number:
                    Student(id=5, surname=Williams, age=18, faculty=Mathematics, group=M-1)
                    Student(id=14, surname=Carter, age=18, faculty=Mathematics, group=M-1)\n""", text);
        });
    }

    @Test
    @SneakyThrows
    void task19_illegalArgumentException() {
        String group = "";
        withTextFromSystemIn(group)
                .andExceptionThrownOnInputEnd(new IllegalArgumentException("The group number must not be empty!!!"))
                .execute(() -> assertThrows(IllegalArgumentException.class, Main::task19));
    }

    @Test
    @SneakyThrows
    void task20() {
        String text = tapSystemOutNormalized(Main::task20);

        assertEquals("""
                Chemistry\n""", text);
    }

    @Test
    @SneakyThrows
    void task21() {
        String text = tapSystemOutNormalized(Main::task21);

        assertEquals("""
                M-1 - 6 students
                M-3 - 3 students
                M-2 - 4 students
                P-2 - 2 students
                P-1 - 7 students
                C-1 - 4 students
                P-4 - 1 students
                P-3 - 3 students
                C-3 - 9 students
                C-2 - 11 students
                C-4 - 1 students\n""", text);
    }

    @Test
    @SneakyThrows
    void task22() {
        String text = tapSystemOutNormalized(Main::task22);

        assertEquals("""
                ComputerScience: minimum age — 18
                Chemistry: minimum age — 18
                Mathematics: minimum age — 17
                Physics: minimum age — 18\n""", text);
    }
}