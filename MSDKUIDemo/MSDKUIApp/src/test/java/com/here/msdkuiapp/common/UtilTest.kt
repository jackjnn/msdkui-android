/*
 * Copyright (C) 2017-2019 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.here.msdkuiapp.common

import com.here.msdkui.common.measurements.UnitSystem
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.Locale

/**
 * Tests for [Util]
 */
class UtilTest {

    @Test
    fun testGetLocaleUnit() {
        Locale.setDefault(Locale("en", "US"))
        assertEquals(Util.getLocaleUnit(), UnitSystem.IMPERIAL_US)
        Locale.setDefault(Locale("en", "GB"))
        assertEquals(Util.getLocaleUnit(), UnitSystem.IMPERIAL_UK)
        Locale.setDefault(Locale("pl", "PL"))
        assertEquals(Util.getLocaleUnit(), UnitSystem.METRIC)
    }
}