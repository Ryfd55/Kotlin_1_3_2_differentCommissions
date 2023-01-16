import kotlin.math.max

const val CARD_MONTH_LIMIT = 600000
const val VK_MONTH_LIMIT = 40000
const val VK_MAX_TRANSFER = 15000
const val MC_COMMISSION_START = 75000
const val VAR_COMM_VISA = 0.0075
const val MIN_COMM_VISA = 35
const val VAR_COMM_MC = 0.006
const val STAT_COMM_MC = 20
const val OVER_LIMIT = -1
const val CARD_VISA = "Visa"
const val CARD_MC = "MasterCard"
const val CARD_VK = "VK Pay"
const val CARD_ERROR = -2

fun main() {
    val res = userCardType(100000, CARD_MC, 20000)
    when (res) {
        CARD_ERROR -> println("Ошибка выбора карты")
        OVER_LIMIT -> {
            println("Перевод не проведен")
            println("Превышен лимит")
        }
        else -> {
            println("Перевод успешно проведен.")
            println("Комиссия за перевод составляет $res руб.")
        }
    }
}

fun userCardType(transAmmount: Int, card: String = CARD_VK, monthTrasfered: Int = 0): Int {
    return when (card) {
        CARD_VK -> if ((monthTrasfered + transAmmount > VK_MONTH_LIMIT) || transAmmount > VK_MAX_TRANSFER)
            OVER_LIMIT else 0
        else -> {
            if (monthTrasfered + transAmmount > CARD_MONTH_LIMIT) {
                OVER_LIMIT
            } else {
                when (card) {
                    CARD_MC -> {
                        getMCCommission(transAmmount, monthTrasfered)
                    }
                    CARD_VISA -> {
                        getVisaMirCommission(transAmmount)
                    }
                    else -> {
                        CARD_ERROR
                    }
                }
            }
        }
    }
}

fun getMCCommission(transAmmount: Int, monthTrasfered: Int) =
    if (transAmmount + monthTrasfered > MC_COMMISSION_START)
        ((transAmmount + monthTrasfered - MC_COMMISSION_START) * VAR_COMM_MC + STAT_COMM_MC).toInt() else 0

fun getVisaMirCommission(transferAmmount: Int) = max((transferAmmount * VAR_COMM_VISA).toInt(), MIN_COMM_VISA)

