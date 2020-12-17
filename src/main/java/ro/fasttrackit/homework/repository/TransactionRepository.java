package ro.fasttrackit.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackit.homework.entities.Transaction;
import ro.fasttrackit.homework.type.Type;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT * FROM Transaction WHERE id=2", nativeQuery = true)
    Transaction getMyTransaction();

    @Query(value = "SELECT * FROM Transaction t WHERE t.type = ?1 OR t.amount >= ?2 OR t.amount <= ?3", nativeQuery = true)
    List<Transaction> getAll(@RequestParam(required = false) Type type,
                             @RequestParam(required = false) Double minAmount,
                             @RequestParam(required = false) Double maxAmount);

    @Query(value = "SELECT * FROM Transaction WHERE id=2", nativeQuery = true)
    Optional<Transaction> getTransactionWithId(int transactionId);

    @Query("SELECT t from Transaction t where t.type=:types")
    Optional<Transaction> getAll(@Param("types") Type type);

    @Query(value = "DELETE FROM Transaction t WHERE t.id=?1", nativeQuery = true)
    Transaction deleteTransaction(int transactionId);

    @Query(value = "UPDATE Transaction SET Product=?1, Amount=?2 WHERE id=?3", nativeQuery = true)
    Transaction updateTransaction(String product, Double amount, int transactionId);

    @Query(value = "UPDATE Transaction SET product=?1, type=?2, amount=?3 WHERE id=?4", nativeQuery = true)
    Transaction replaceTransaction(String product, Type type, Double amount, int transactionId);
}
