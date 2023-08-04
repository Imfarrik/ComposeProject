package com.example.noinsoft.components

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class SimpleTextWatcher : TextWatcher {
    private var mEditText: EditText? = null
    private var mFormat: String? = null
    private var mSimpleTextWatcher: SimpleTextWatcher? = null
    private var mTextReadyListener: TextReadyListener? = null
    private var mTextNotReadyListener: TextNotReadyListener? = null
    private var mNewText: String = ""
    private var mInputText: String = ""
    private var mCursor: Int = 0

    init {
        mSimpleTextWatcher = this
    }

    class Builder {
        private val simpleTextWatcher: SimpleTextWatcher =
            SimpleTextWatcher()

        fun setParameters(editText: EditText, format: String): Builder {
            simpleTextWatcher.mEditText = editText
            simpleTextWatcher.mFormat = format
            return this
        }

        fun setTextReadyListener(textReadyListener: TextReadyListener): Builder {
            simpleTextWatcher.mTextReadyListener = textReadyListener
            return this
        }

        fun setTextNotReadyListener(textNotReadyListener: TextNotReadyListener): Builder {
            simpleTextWatcher.mTextNotReadyListener = textNotReadyListener
            return this
        }

        fun build(): SimpleTextWatcher = simpleTextWatcher
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mInputText = s.toString()
        mCursor = mEditText!!.selectionStart

        if (mInputText.isEmpty()) {
            setText(mInputText, mCursor)
        }
        /*
            Remove +998 when paste
         */
        if (mInputText.indexOf("+998") != -1) {
            mInputText = mInputText.replace("+998", "")
            if (mCursor > 3) mCursor -= 4 else mCursor = 0
        }

        /*
            Get count of digits of mInputText from 0 to mCursor
         */
        val countDigit = mInputText.substring(0, mCursor).count { c -> c in '0'..'9' }
        mCursor = countDigit

        mInputText = mInputText.replace("\\D".toRegex(), "")

        /*
            Create mNewText from mInputText by Format
         */
        mNewText = ""
        var i = 0
        while (i < mInputText.length) {
            if (mNewText.length == mFormat!!.length) break
            val nextChar = mFormat!![mNewText.length]
            if (nextChar == '#') {
                mNewText += mInputText[i]
                i++
            } else {
                mNewText += ' '
                if (i <= countDigit) {
                    mCursor++
                }
            }
        }

        /*
            00 000 |00 00 -> 00 000| 00 00
         */
//        if (mCursor > 0 && mFormat!![mCursor - 1] == ' ') {
//            mCursor--
//        }
        setText(mNewText, mCursor)
    }

    interface TextReadyListener {
        fun onTextReady(text: String)
    }

    interface TextNotReadyListener {
        fun onTextNotReady()
    }

    fun setText(newText: String, cursor: Int) {
        mEditText!!.removeTextChangedListener(mSimpleTextWatcher)
        mEditText!!.setText(newText)
        val textLength = newText.length
        when {
            textLength <= cursor -> {
                mEditText!!.setSelection(textLength)
            }
            else -> {
                mEditText!!.setSelection(cursor)
            }
        }
        if (newText.length == mFormat!!.length) {
            val text = newText.replace("\\D".toRegex(), "")
            mTextReadyListener?.onTextReady(text)
        } else {
            mTextNotReadyListener?.onTextNotReady()
        }
        mEditText!!.addTextChangedListener(mSimpleTextWatcher)
    }

    fun isTextReady(text: String, format: String): Boolean {
        return text.length == format.length
    }
}