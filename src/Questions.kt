fun main() {
    val read= mutableListOf(Book("How to","Brian",96),(Book("Kids Life", "Lisa", 30)),(Book("Tech", "Geek", 765)))
    println(read)
    val account= CurrentAccount("1234567","Irene",456000.00)
    account.deposit(20000.00)
    account.withdraw(10000.00)
    account.details()
    val account2 = SavingsAccount("1234567","Irene",456000.00,5)
    account2.withdrawals(3,15000.00)
    account2.withdrawals(5,17000.00)
}

data class Book(var title:String, var author:String, var pages:Int)

fun book(a: List<Book>): List<Book> {
    return a.sortedByDescending { book -> book.title }
}

open class CurrentAccount(var accountNumber:String,var accountName:String ,var balance:Double){
    fun deposit(amount: Double){
        balance += amount
    }
    open fun withdraw(amount: Double){
        balance -= amount
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}
class SavingsAccount(accountNumber:String,accountName:String ,balance:Double, var withdrawals:Int):CurrentAccount(accountNumber, accountName, balance) {
    fun withdraw(amount: Int){
        balance -= amount
    }
    fun withdrawals(withdrawals: Int, amount: Double) {
        if (withdrawals < 4) {
            balance += amount
            println(balance)
        }
    }
}