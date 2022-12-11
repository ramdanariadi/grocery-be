package id.grocery.tunas.transaction;

import java.util.List;

public class TransactionData {
    private TransactionRepository.ITransactionData transaction;
    private List<DetailTransactionRepository.IDetailTransactions> detailTransaction;

    public TransactionData(TransactionRepository.ITransactionData transaction, List<DetailTransactionRepository.IDetailTransactions> detailTransaction) {
        this.transaction = transaction;
        this.detailTransaction = detailTransaction;
    }

    public TransactionData() {
    }

    public TransactionRepository.ITransactionData getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionRepository.ITransactionData transaction) {
        this.transaction = transaction;
    }

    public List<DetailTransactionRepository.IDetailTransactions> getDetailTransaction() {
        return detailTransaction;
    }

    public void setDetailTransaction(List<DetailTransactionRepository.IDetailTransactions> detailTransaction) {
        this.detailTransaction = detailTransaction;
    }
}
