package ro.fasttrackit.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.homework.entities.Transaction;
import ro.fasttrackit.homework.repository.TransactionRepository;
import ro.fasttrackit.homework.type.Type;

@SpringBootApplication
public class Curs20HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs20HomeworkApplication.class, args);
    }


    @Bean
    CommandLineRunner atStartup(TransactionRepository transactionRepository) {
        return args -> {
            transactionRepository.save(new Transaction("benzina", Type.BUY, 4.8));
            transactionRepository.save(new Transaction("paine",Type.BUY ,5));
            transactionRepository.save(new Transaction("motorina",Type.BUY ,4.6));
            transactionRepository.save(new Transaction("carne",Type.BUY ,11.5));
            transactionRepository.save(new Transaction("oua",Type.SELL ,5.6));

        };
    }
}
