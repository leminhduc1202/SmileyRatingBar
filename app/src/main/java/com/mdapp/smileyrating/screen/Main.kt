package com.mdapp.smileyrating.screen

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val conVat: DongVat = Meo("meo meo")
            val conVat1: DongVat = conVat.apply {
                keu = "mao mao"
                Cho("gau gau")
            }
            val conVat2: DongVat = conVat.run {
                Cho("gau gau")
            }
            println("${conVat.keu} : ${conVat1.keu} : ${conVat2.keu}")
        }
    }

    abstract class DongVat {
        abstract var keu: String
    }

    class Meo(
        override var keu: String
    ) : DongVat()

    class Cho(
        override var keu: String
    ) : DongVat()
}