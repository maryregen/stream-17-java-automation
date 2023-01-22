package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import files.model.Employee;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideJSONFileTest {

    @Test
    void parseJSONFile() throws IOException {
        File file = new File ("src/test/resources/employee.json");
        ObjectMapper m = new ObjectMapper();
        Employee employee = m.readValue(file, Employee.class);
        assertThat(employee.name).isEqualTo("Alex Melon");
        assertThat(employee.address.street).isEqualTo("32, Laham St.");
        assertThat(employee.address.city).isEqualTo("Innsbruck");
        assertThat(employee.address.country).isEqualTo("Austria");
        assertThat(employee.role).contains("Dev");
        assertThat(employee.role).contains("DBA");
    }
}
