/*
 * Copyright (C) 2023 Romain Guy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.romainguy.kotlin.explorer.code

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory

class SyntaxStyle private constructor() {
    companion object {
        val Dex: String get() = "text/dex-bytecode"
        val ByteCode: String get() = "text/java-bytecode"
        val Kotlin: String get() = "text/kotlin"
        val Oat: String get() = "text/oat-assembly"

        init {
            val factory = TokenMakerFactory.getDefaultInstance() as AbstractTokenMakerFactory
            factory.putMapping(ByteCode, DexTokenMaker::class.java.canonicalName)
            factory.putMapping(Dex, DexTokenMaker::class.java.canonicalName)
            factory.putMapping(Kotlin, KotlinTokenMaker::class.java.canonicalName)
            factory.putMapping(Oat, OatTokenMaker::class.java.canonicalName)
        }
    }
}
