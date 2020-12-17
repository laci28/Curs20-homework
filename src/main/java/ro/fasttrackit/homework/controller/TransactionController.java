package ro.fasttrackit.homework.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework.entities.Transaction;
import ro.fasttrackit.homework.repository.TransactionRepository;
import ro.fasttrackit.homework.type.Type;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Transaction> getAll(@RequestParam(required = false) Type type,
                             @RequestParam(required = false) Double minAmount,
                             @RequestParam(required = false) Double maxAmount) {
        return repo.getAll(type, minAmount, maxAmount);
    }

    @GetMapping("{transactionId}")
    Optional<Transaction> getTransaction(@PathVariable int transactionId) {
        return repo.findById(transactionId);
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return repo.save(transaction);
    }

    @PutMapping("{transactionId}")
    Transaction replaceTransaction(String product, Type type, Double amount,
                                   @PathVariable int transactionId) {
        return repo.replaceTransaction(product, type, amount, transactionId);
    }

    @PatchMapping("{transactionId}")
    Transaction updateTransaction(String product,
                                  Double amount,
                                  @PathVariable int transactionId) {
        return repo.updateTransaction(product, amount, transactionId);
    }

    @DeleteMapping("{transactionId}")
    Transaction deleteTransaction(@PathVariable int transactionId) {
        return repo.deleteTransaction(transactionId);
    }
}
