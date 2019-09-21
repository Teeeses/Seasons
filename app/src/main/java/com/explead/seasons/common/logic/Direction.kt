package com.explead.seasons.common.logic

enum class Direction constructor(val id: Int) {

    U(1) {
        override fun opposite(): Direction {
            return D
        }
    },
    R(2) {
        override fun opposite(): Direction {
            return L
        }
    },
    D(3) {
        override fun opposite(): Direction {
            return U
        }
    },
    L(4) {
        override fun opposite(): Direction {
            return R
        }
    };

    val rotation: Int
        get() = 90 * id - 90

    abstract fun opposite(): Direction
}