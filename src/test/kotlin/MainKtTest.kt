import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun userCardType_MCShouldCommission() {
        val transAmmount = 5000
        val card = "MasterCard"
        val monthTrasfered = 73000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(38, res)
    }

    @Test
    fun userCardType_MCShouldNotCommission() {
        val transAmmount = 5000
        val card = "MasterCard"
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_VisaShouldMinCommission() {
        val transAmmount = 500
        val card = "Visa"
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(35, res)
    }

    @Test
    fun userCardType_VisaShouldNotMinCommission() {
        val transAmmount = 50000
        val card = "Visa"
        val monthTrasfered = 3000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(375, res)
    }

    @Test
    fun userCardType_VKShouldCommission() {
        val transAmmount = 5000
        val card = "VK Pay"
        val monthTrasfered = 7000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(0, res)
    }

    @Test
    fun userCardType_MCOverlimit() {
        val transAmmount = 500000
        val card = "MasterCard"
        val monthTrasfered = 173000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(-1, res)
    }

    @Test
    fun userCardType_VKOverlimit() {
        val transAmmount = 5000
        val card = "VK Pay"
        val monthTrasfered = 37000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(-1, res)
    }

    @Test
    fun userCardType_VKOneTimeOverlimit() {
        val transAmmount = 25000
        val card = "VK Pay"
        val monthTrasfered = 1000

        val res = userCardType(transAmmount, card, monthTrasfered)

        assertEquals(-1, res)
    }
}