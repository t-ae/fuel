package fuel

import fuel.core.Either
import fuel.core.Request
import fuel.core.Response
import junit.framework.TestCase
import java.net.HttpURLConnection
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Created by Kittinun Vantasin on 5/21/15.
 */

abstract class BaseTestCase : TestCase() {

    val DEFAULT_TIMEOUT = 5000L

    abstract val numberOfTestCase: Int

    val countdown by Delegates.lazy { CountDownLatch(numberOfTestCase) }

    fun countdownWait(timeout: Long = DEFAULT_TIMEOUT) = countdown.await(timeout, TimeUnit.MILLISECONDS)
    fun countdownFulfill() = countdown.countDown()

}