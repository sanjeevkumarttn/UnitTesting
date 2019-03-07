package demo.service

import demo.domain.Order
import spock.lang.Specification

class EmailServiceTest extends Specification {
    def "Send Email"() {
        setup:
        EmailService emailService = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        emailService.sendEmail(order);

        then:
        thrown(RuntimeException)
    }

    def "Send Email using a string"() {
        setup:
        EmailService emailService = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        Boolean result = emailService.sendEmail(order, "abc");

        then:
        result
    }

    def "send email with a string for cancel order"() {
        setup:
        EmailService emailService = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        boolean result = emailService.sendEmail(order, string)

        then:
        result == inputstatus

        where:
        string   | inputstatus
        "cancel" | true
        " "      | true
    }


}
