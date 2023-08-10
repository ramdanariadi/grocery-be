package id.grocery.tunas.transaction;

import java.util.List;

public class TransactionData {
    private TransactionRepository.ITransactionData transaction;
    private List<TransactionDetailRepository.IDetailTransactions> detailTransaction;

    public TransactionData(TransactionRepository.ITransactionData transaction, List<TransactionDetailRepository.IDetailTransactions> detailTransaction) {
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

    public List<TransactionDetailRepository.IDetailTransactions> getDetailTransaction() {
        return detailTransaction;
    }

    public void setDetailTransaction(List<TransactionDetailRepository.IDetailTransactions> detailTransaction) {
        this.detailTransaction = detailTransaction;
    }
}
