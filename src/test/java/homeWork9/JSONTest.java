package homeWork9;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONTest {
    @Test
    void test() throws Exception {
        ClassLoader classLoader = JSONTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("human.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Human human = objectMapper.readValue(inputStream, Human.class);

        assertThat(human
                .getName())
                .isEqualTo("Sergei");

        assertThat(human
                .getIsLearningAutomation())
                .isEqualTo(true);

        assertThat(human
                .getAnimals()
                .getType())
                .isEqualTo("cat");

        assertThat(human
                .getHobbies())
                .contains("swimming", "football", "games");
    }
}
