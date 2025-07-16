package com.org.controller;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl {// implements TransactionService {

	/*
	 * private final TransactionRepository transactionRepository;
	 * 
	 * public TransactionServiceImpl(TransactionRepository transactionRepository) {
	 * this.transactionRepository = transactionRepository; }
	 * 
	 * @Override public List<TransactionDTO> getTransactions(LocalDate fromDate,
	 * LocalDate toDate, String userId) { List<Transaction> entities = (userId !=
	 * null) ? transactionRepository.findByDateRangeAndUser(fromDate, toDate,
	 * userId) : transactionRepository.findByDateRange(fromDate, toDate);
	 * 
	 * return
	 * entities.stream().map(TransactionMapper::toDto).collect(Collectors.toList());
	 * }
	 */
}

interface TransactionService {

}