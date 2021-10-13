package tunas.ecomerce.transaction;

import java.util.List;

public class TransactionResponse {
    private TransactionRepository.ITransactionResponse transaction;
    private List<DetailTransactionRepository.IDetailTransactions> detailTransaction;

    public TransactionResponse(TransactionRepository.ITransactionResponse transaction, List<DetailTransactionRepository.IDetailTransactions> detailTransaction) {
        this.transaction = transaction;
        this.detailTransaction = detailTransaction;
    }

    public TransactionResponse() {
    }

    public TransactionRepository.ITransactionResponse getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionRepository.ITransactionResponse transaction) {
        this.transaction = transaction;
    }

    public List<DetailTransactionRepository.IDetailTransactions> getDetailTransaction() {
        return detailTransaction;
    }

    public void setDetailTransaction(List<DetailTransactionRepository.IDetailTransactions> detailTransaction) {
        this.detailTransaction = detailTransaction;
    }
}
