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

package com.here.msdkuiapp.guidance

import android.support.v7.widget.RecyclerView
import android.view.View

import com.here.msdkuiapp.R
import com.here.testutils.BaseTest
import junit.framework.Assert.assertEquals

import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertNotNull
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Tests for [GuidanceDashBoardView].
 */
class GuidanceDashBoardViewTest : BaseTest() {

    private lateinit var mGuidanceDashBoardView: GuidanceDashBoardView

    @Mock
    private lateinit var mockPresenter: GuidanceDashBoardPresenter

    @Before
    override fun setUp() {
        super.setUp()
        MockitoAnnotations.initMocks(this)
        mGuidanceDashBoardView = GuidanceDashBoardView(applicationContext)
        mGuidanceDashBoardView.presenter = mockPresenter
    }

    @Test
    fun testUi() {
        mGuidanceDashBoardView.findViewById<View>(R.id.stop_navigation).performClick()
        verify(mockPresenter).onStopNavigationButtonClicked()

        mGuidanceDashBoardView.findViewById<View>(R.id.collapsed_view).performClick()
        verify(mockPresenter).onCollapsedViewClicked()

        val itemsList = mGuidanceDashBoardView.findViewById<RecyclerView>(R.id.items_list)
        assertNotNull(itemsList)
        assertNotNull(itemsList.layoutManager)
        assertEquals(itemsList.hasFixedSize(), true)
        assertNotNull(itemsList.adapter)
    }
}
