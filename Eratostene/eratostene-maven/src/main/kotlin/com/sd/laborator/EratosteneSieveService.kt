package com.sd.laborator

import jakarta.inject.Singleton
import java.util.*
import kotlin.collections.ArrayList

@Singleton
class EratosteneSieveService {
// implementare preluata de la https://www.geeksforgeeks.org/sieve-eratosthenes-0n-time-complexity/
     val MAX_SIZE = 1000001
/*
isPrime[] : isPrime[i] este adevarat daca numarul i esteprimprime[] : stocheaza toate numerele prime mai mici ca N
SPF[] (Smallest Prime Factor) - stocheaza cel mai mic factorprimal numarului
[de exemplu : cel mai mic factor prim al numerelor '8' si'16'este '2', si deci SPF[8] = 2 , SPF[16] = 2 ]
*/
    private val isPrime = Vector<Boolean>(MAX_SIZE)

    private val SPF = Vector<Int>(MAX_SIZE)
    fun findPrimesLessThan(lista: List<Int>): List<Int> {
        val prime: MutableList<Int> = lista as MutableList<Int>
        for (i in 2 until lista.size+2) {
            if (isPrime[i]) {
                // un numar prim este propriul sau cel mai mic factor prim
                SPF[i] = i
            }
/*
Se sterg toti multiplii lui i * prime[j], care nusuntprimi
setand isPrime[i * prime[j]] = false
si punand cel mai mic factor prim al lui i * prime[j]casi prime[j]
[de exemplu: fie i = 5, j = 0, prime[j] = 2 [i * prime[j]= 10],
si deci cel mai mic factor prim al lui '10' este '2'careeste prime[j] ]
Aceasta bucla se executa doar o singura data pentrunumerele care nu sunt prime
*/
            var j = 0
            while (j < prime.size && i * prime[j] < lista.size+2 && prime[j]<=SPF[i]) {
                isPrime[i * prime[j]] = false

                // se pune cel mai mic factor prim al lui i *prime[j]SPF[i * prime[j]] = prime[j]
                j++
            }
        }
        return prime
    }
    init {
// initializare vectori isPrime si SPF
        for (i in 0 until MAX_SIZE) {
            isPrime.add(true)
            SPF.add(2)
        }
// 0 and 1 are not prime
        isPrime[0] = false
        isPrime[1] = false
    }
}