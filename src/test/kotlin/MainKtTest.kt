import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    //     val CARD_MONTH_LIMIT = 600000
//     val VK_MONTH_LIMIT = 40000
//     val VK_MAX_TRANSFER = 15000
//     val MC_COMMISSION_START = 75000
//     val VAR_COMM_VISA = 0.0075
//     val MIN_COMM_VISA = 35
//     val VAR_COMM_MC = 0.006
//     val STAT_COMM_MC = 20
//     val OVER_LIMIT = -1
    private val CARD_VISA1 = "Visa"
    private val CARD_MC1 = "MasterCard"
    private val CARD_VK1 = "VK Pay"
//     val CARD_ERROR = -2

    @Test
    fun userCardType_MCShouldCommission() {
        val transAmmount = 5000
        val card = CARD_MC1
        val monthTrasfered = 73000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(38, res)
    }

    @Test
    fun userCardType_MCShouldNotCommission() {
        val transAmmount = 5000
        val card = CARD_MC1
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_VisaShouldMinCommission() {
        val transAmmount = 500
        val card = CARD_VISA1
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(35, res)
    }

    @Test
    fun userCardType_VisaShouldNotMinCommission() {
        val transAmmount = 50000
        val card = CARD_VISA1
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(375, res)
    }

    @Test
    fun userCardType_VKShouldCommission() {
        val transAmmount = 5000
        val card = CARD_VK1
        val monthTrasfered = 7000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_MCOverlimit() {
        val transAmmount = 500000
        val card = CARD_MC1
        val monthTrasfered = 173000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(-1, res)
    }

    @Test
    fun userCardType_VKOverlimit() {
        val transAmmount = 5000
        val card = CARD_VK1
        val monthTrasfered = 37000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(-1, res)
    }

    @Test
    fun userCardType_VKOneTimeOverlimit() {
        val transAmmount = 25000
        val card = CARD_VK1
        val monthTrasfered = 1000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(1, res)
    }

    @Test
    fun userCardType_TypeError() {
        val transAmmount = 25000
        val card = "Viisa"
        val monthTrasfered = 1000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(2, res)
    }
}