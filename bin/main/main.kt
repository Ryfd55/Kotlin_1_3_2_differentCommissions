fun main() {
    val res = userCardType("Visa", 100000)
    print("Комиссия составляет $res копеек")
}


fun userCardType(card: String = "VK Pay", transferAmmount: Int = 0): Double {
    return when (card) {
        "MasterCard" -> getMCCommission(transferAmmount)
        "Visa", "Mir" -> getVisaMirCommission(transferAmmount)
        else -> {
            getVKCommission(transferAmmount)
        }
    }
}

fun getMCCommission(transferAmmount: Int): Double {
    var commission = 0.0
    if (transferAmmount > 75000) {
        commission = (transferAmmount * 0.006 + 20)
    }
    return commission
}

fun getVisaMirCommission(transferAmmount: Int): Double {
    var commission = 0.0
    if (transferAmmount*0.0075 < 35) {
        commission = 35.00}
    else{
        commission = (transferAmmount * 0.0075)
    }
    return commission
}

fun getVKCommission(transferAmmount: Int): Double {
    var commission = 0.0
    return commission
}