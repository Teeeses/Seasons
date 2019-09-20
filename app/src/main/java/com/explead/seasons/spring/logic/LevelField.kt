package com.explead.seasons.spring.logic

class LevelField(val level: Int,
                 val field: Array<Array<Char>>,
                 val members: ArrayList<Member>) {

    data class Builder(var level: Int = 0,
                       var field: Array<Array<Char>> = arrayOf(arrayOf()),
                       var members: ArrayList<Member> = ArrayList()) {


        fun count(level: Int) = apply {
            this.level = level
        }

        fun field(field: Array<Array<Char>>) = apply {
                this.field = field
        }

        fun addMember(member: Member) = apply {
                this.members.add(member)
        }

        fun build() = LevelField(level, field, members)
    }
}