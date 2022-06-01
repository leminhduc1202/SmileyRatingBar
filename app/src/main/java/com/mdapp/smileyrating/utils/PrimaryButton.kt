package com.mdapp.smileyrating.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.LayoutPrimaryButtonBinding


class PrimaryButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: LayoutPrimaryButtonBinding

    companion object {
        const val DEFAULT_STYLE = "default"
        const val SECONDARY_STYLE = "second"
        const val TERTIARY_STYLE = "third"
        const val QUATERNARY_STYLE = "fourth"
        const val TEXT_SHOW_BUTTON_PLUS = "plus"
    }

    init {
        init(attrs)
    }

    var listener: OnPrimaryButtonListener? = null

    var buttonText: String? = null
        set(value) {
            binding.nameBtn.text = value
            field = value
        }
    private var isLoading: Boolean? = null
        set(value) {
            binding.nameBtn.handleGoneVisibility(value != true)
            field = value
        }

    private var buttonStyle: String? = null
        set(value) {
            updateStyle(value)
            field = value
        }
    private var textSize: Float = 0f
        set(value) {
            binding.nameBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
            field = value
        }
    private var marginTop: Int = 0
        set(value) {
            binding.nameBtn.setMargins(top = value)
            field = value
        }
    private var marginBottom: Int = 0
        set(value) {
            binding.nameBtn.setMargins(bottom = value)
            field = value
        }
    private var leftDrawable: Drawable? = null
        set(value) {
            value?.let {
                binding.nameBtn.setCompoundDrawablesWithIntrinsicBounds(
                    leftDrawable,
                    null,
                    null,
                    null
                )
            }
            field = value
        }

    private var marginHorizontal: Int = 0
        set(value) {
            binding.nameBtn.setMargins(start = value, end = value)
            field = value
        }

    fun handleLoading(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    fun updateButtonText(text: String) {
        binding.nameBtn.text = text
    }

    fun selfClick() {
        binding.layoutContainer.performClick()
    }

    fun handleEnable(isEnabled: Boolean) {
        binding.layoutContainer.isEnabled = isEnabled
        if (isEnabled) {
            updateTextButtonStyle(buttonStyle)
        } else {
            when (buttonStyle) {
                TERTIARY_STYLE -> binding.nameBtn.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.mercuryapprox
                    )
                )
                QUATERNARY_STYLE -> binding.nameBtn.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.gray_two_b_main_color
                    )
                )
                else -> binding.nameBtn.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.white1
                    )
                )
            }
        }
        if (!isEnabled) {
            hideLoading()
        }
    }

    fun isLoading(): Boolean {
        return isLoading ?: false
    }

    private fun updateStyle(style: String?) {
        updateTextButtonStyle(style)
        when (style) {
            DEFAULT_STYLE -> {
                binding.layoutContainer.setBackgroundResource(R.drawable.primary_button_background_selector)
            }
            SECONDARY_STYLE -> {
                binding.layoutContainer.setBackgroundResource(R.drawable.primary_button_background_circle_selector)
                binding.layoutContainer.layoutParams = LayoutParams(
                    context.resources.getDimensionPixelOffset(R.dimen.dp_40),
                    context.resources.getDimensionPixelOffset(R.dimen.dp_40)
                )
                binding.nameBtn.gone()
                binding.imgbtn.visible()
                if (buttonText == TEXT_SHOW_BUTTON_PLUS) {
                    binding.imgbtn.setImageResource(R.drawable.ic_plus)
                } else {
                    binding.imgbtn.setImageResource(R.drawable.ic_minus)
                }
            }
            TERTIARY_STYLE -> {
                binding.layoutContainer.setBackgroundResource(R.drawable.secondary_button_background_selector)
            }
            QUATERNARY_STYLE -> {
                binding.layoutContainer.setBackgroundResource(R.drawable.primary_button_background_selector)
            }
            else -> {
                binding.layoutContainer.setBackgroundResource(R.drawable.primary_button_background_selector)
            }
        }
    }

    private fun updateTextButtonStyle(style: String?) {
        when (style) {
            DEFAULT_STYLE -> {
                binding.nameBtn.setTextColor(ContextCompat.getColor(context, android.R.color.white))
            }
            SECONDARY_STYLE -> {
                binding.nameBtn.setTextColor(ContextCompat.getColor(context, android.R.color.white))
            }
            TERTIARY_STYLE -> {
                binding.nameBtn.setTextColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.tab_text_selector
                    )
                )
            }
            QUATERNARY_STYLE -> {
                binding.nameBtn.setTextColor(ContextCompat.getColor(context, android.R.color.white))
            }
            else -> {
                binding.nameBtn.setTextColor(ContextCompat.getColor(context, android.R.color.white))
            }
        }
    }

    private fun init(attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.layout_primary_button, this, true)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PrimaryButton)
        try {
            buttonText = typedArray.getString(R.styleable.PrimaryButton_pb_text)
            buttonStyle = typedArray.getString(R.styleable.PrimaryButton_pb_style) ?: DEFAULT_STYLE
            leftDrawable = typedArray.getDrawable(R.styleable.PrimaryButton_pb_leftDrawable)
            textSize = typedArray.getDimension(R.styleable.PrimaryButton_pb_textSize, 0f)
            marginTop =
                typedArray.getDimensionPixelOffset(R.styleable.PrimaryButton_pb_marginTop, 0)
            marginBottom =
                typedArray.getDimensionPixelOffset(R.styleable.PrimaryButton_pb_marginBottom, 0)
            marginHorizontal =
                typedArray.getDimensionPixelOffset(R.styleable.PrimaryButton_pb_marginHorizontal, 0)
        } finally {
            typedArray.recycle()
        }
        handleEvent()
    }

    private fun handleEvent() {
        binding.layoutContainer.safeClick(OnClickListener {
            if (!isLoading()) {
                hideSoftKeyBoard()
                listener?.onClick(it)
            }
        })
    }

    private fun hideLoading() {
        isLoading = false
    }

    interface OnPrimaryButtonListener {
        fun onClick(view: View?)
    }
}