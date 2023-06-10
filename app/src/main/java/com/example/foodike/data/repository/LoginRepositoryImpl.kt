package com.example.foodike.data.repository
/**
 *
 *	MIT License
 *
 *	Copyright (c) 2023 Gautam Hazarika
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 *
 **/
import android.content.Context
import com.example.foodike.domain.repository.LoginRepository


class LoginRepositoryImpl(context: Context) : LoginRepository {

    private val prefs = context.getSharedPreferences(LOGIN_STATE, Context.MODE_PRIVATE)
    private val isUserLoggedIn = prefs.getBoolean(IS_USER_LOGGED_IN, false)


    companion object {
        const val LOGIN_STATE = "user_login_state"
        const val IS_USER_LOGGED_IN = "is_user_logged_in"
    }

    override fun readLoginState(): Boolean {
        return prefs.getBoolean(IS_USER_LOGGED_IN, false)
    }

    override fun toggleLoginState() {
        prefs.edit().putBoolean(IS_USER_LOGGED_IN, !isUserLoggedIn).apply()
    }


}