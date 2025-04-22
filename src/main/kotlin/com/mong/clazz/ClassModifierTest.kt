package com.mong.clazz

internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

/* does not compile
fun TalkativeButton.giveSpeech() {
    yell()

    whisper()
}
*/
