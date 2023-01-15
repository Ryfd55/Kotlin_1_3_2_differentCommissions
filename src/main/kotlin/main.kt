import kotlin.math.max

const val cardMonthLimit = 600000
const val vkMonthLimit = 40000
const val vkMaxTransfer = 15000
const val mcCommissionStart = 75000
const val varCommVisa = 0.0075
const val minCommVisa = 35
const val varCommMC = 0.006
const val statCommMC = 20

fun main() {
    val res = userCardType(100000, "MasterCard", 20000)
    if (res != -1) {
        println("Перевод успешно проведен.")
        println("Комиссия за перевод составляет $res руб.")
    } else {
        println("Перевод не проведен")
        println("Превышен лимит")
    }
}

fun userCardType(transAmmount: Int, card: String = "VK Pay", monthTrasfered: Int = 0): Int {
    return when (card) {
        "VK Pay" -> if ((monthTrasfered + transAmmount > vkMonthLimit) || transAmmount > vkMaxTransfer)
            -1 else 0
        else -> {
            if (monthTrasfered + transAmmount > cardMonthLimit) {
                -1
            } else {
                when (card) {
                    "MasterCard" -> {
                        getMCCommission(transAmmount, monthTrasfered)
                    }
                    else -> {
                        getVisaMirCommission(transAmmount)
                    }
                }
            }
        }
    }
}

fun getMCCommission(transAmmount: Int, monthTrasfered: Int) = if (transAmmount + monthTrasfered > mcCommissionStart)
    ((transAmmount + monthTrasfered - mcCommissionStart) * varCommMC + statCommMC).toInt() else 0

fun getVisaMirCommission(transferAmmount: Int) = max((transferAmmount * varCommVisa).toInt(), minCommVisa)

