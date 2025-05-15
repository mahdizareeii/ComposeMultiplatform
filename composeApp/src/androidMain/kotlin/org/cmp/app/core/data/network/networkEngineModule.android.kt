package org.cmp.app.core.data.network

import android.annotation.SuppressLint
import android.os.Build
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

actual fun networkEngineModule(): Module = module {
    single {
        OkHttp.create {
            config {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N_MR1) {
                    sslSocketFactory(
                        getSslFactory(),
                        getTrustManager()
                    )
                }
            }
        }
    }
}

private fun getSslFactory(): SSLSocketFactory {
    val trustAllCerts = arrayOf<TrustManager>(getTrustManager())
    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, SecureRandom())
    return sslContext.socketFactory
}

private fun getTrustManager() =
    @SuppressLint("CustomX509TrustManager") object : X509TrustManager {
        @SuppressLint("TrustAllX509TrustManager")
        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @SuppressLint("TrustAllX509TrustManager")
        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    }