package desafio.itau.springboot.services;

import desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionServices {
    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void cleartransactions() {
        transactions.clear();
    }
    public DoubleSummaryStatistics getStatistcs() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                //.filter(t ->  t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction ::getValor)
                .summaryStatistics();
    }
}
