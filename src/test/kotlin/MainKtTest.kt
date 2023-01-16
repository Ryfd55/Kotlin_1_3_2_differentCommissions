import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    val OVER_LIMIT = -1
    val CARD_VISA = "Visa"
    val CARD_MC = "MasterCard"
    val CARD_VK = "VK Pay"
    val CARD_ERROR = -2

    @Test
    fun userCardType_MCShouldCommission() {
        val transAmmount = 5000
        val card = CARD_MC
        val monthTrasfered = 73000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(38, res)
    }

    @Test
    fun userCardType_MCShouldNotCommission() {
        val transAmmount = 5000
        val card = CARD_MC
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_VisaShouldMinCommission() {
        val transAmmount = 500
        val card = CARD_VISA
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(35, res)
    }

    @Test
    fun userCardType_VisaShouldNotMinCommission() {
        val transAmmount = 50000
        val card = CARD_VISA
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(375, res)
    }

    @Test
    fun userCardType_VKShouldCommission() {
        val transAmmount = 5000
        val card = CARD_VK
        val monthTrasfered = 7000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_MCOverlimit() {
        val transAmmount = 500000
        val card = CARD_MC
        val monthTrasfered = 173000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(OVER_LIMIT, res)
    }

    @Test
    fun userCardType_VKOverlimit() {
        val transAmmount = 5000
        val card = CARD_VK
        val monthTrasfered = 37000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(OVER_LIMIT, res)
    }

    @Test
    fun userCardType_VKOneTimeOverlimit() {
        val transAmmount = 25000
        val card = CARD_VK
        val monthTrasfered = 1000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(OVER_LIMIT, res)
    }

    @Test
    fun userCardType_TypeError() {
        val transAmmount = 25000
        val card = "Viisa"
        val monthTrasfered = 1000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(CARD_ERROR, res)
    }
}