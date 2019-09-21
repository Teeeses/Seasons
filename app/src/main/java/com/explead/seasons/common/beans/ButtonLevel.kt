package com.explead.seasons.common.beans

/**
 * Created by develop on 30.01.2017.
 */

class ButtonLevel(val number: Int) {
    lateinit var status: LevelButtonConfig
    var isEasyCompleted: Boolean = false
    var isHardCompleted: Boolean = false

    fun installStatus(current: Int, easyCompleted: Boolean, hardCompleted: Boolean) {
        this.isEasyCompleted = easyCompleted
        this.isHardCompleted = hardCompleted
        if (number == current) {
            status = LevelButtonConfig.STATUS_CURRENT
        }
        if (number > current) {
            status = LevelButtonConfig.STATUS_CLOSE
        }
        if (number < current) {
            status = LevelButtonConfig.STATUS_OPEN
        }
    }
}