package ro.fasttrackit.homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.homework.entities.Transaction;
import ro.fasttrackit.homework.repository.TransactionRepository;
import ro.fasttrackit.homework.type.Type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> getAll(Type type, Double minAmount, Double maxAmount) throws SQLException {
        return repo.findAll();
    }
}
