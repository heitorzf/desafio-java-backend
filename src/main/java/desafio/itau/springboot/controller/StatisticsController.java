package desafio.itau.springboot.controller;

import java.util.DoubleSummaryStatistics;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.StatisticsResponse;
import desafio.itau.springboot.services.TransactionServices;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {
    private final TransactionServices transactionServices;

    public StatisticsController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }
    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        DoubleSummaryStatistics stats = transactionServices.getStatistcs();
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
    

    
}
