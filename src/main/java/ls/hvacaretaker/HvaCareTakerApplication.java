package ls.hvacaretaker;

import ls.hvacaretaker.commonlogic.HermeticTestCheck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HvaCareTakerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HvaCareTakerApplication.class, args);
        try {
            context.getBean(HermeticTestCheck.class).hermeticTestReminder();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
