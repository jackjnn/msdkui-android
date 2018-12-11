/*
 * Copyright (C) 2017-2018 HERE Europe B.V.
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

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.here.msdkui.guidance.GuidanceEstimatedArrivalViewData
import com.here.msdkui.guidance.GuidanceEstimatedArrivalViewPresenter
import com.here.msdkui.guidance.GuidanceEstimatedArrivalView
import com.here.msdkui.guidance.GuidanceEstimatedArrivalViewListener
import com.here.msdkuiapp.R
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions

/**
 * Fragment class for GuidanceEstimatedArrivalView.
 */
@ContainerOptions(CacheImplementation.NO_CACHE)
class GuidanceEstimatedArrivalViewFragment : Fragment(), GuidanceEstimatedArrivalViewListener {

    internal var viewPresenter : GuidanceEstimatedArrivalViewPresenter? = null;

    init {
        retainInstance = true
    }

    companion object {
        fun newInstance() = GuidanceEstimatedArrivalViewFragment()
    }

    /**
     * Creates view.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val panelFragment = GuidanceEstimatedArrivalView(activity)
        panelFragment.id = R.id.guidanceEstimatedArrivalViewId
        return panelFragment
    }

    /**
     * Creates Presenter for this [GuidanceEstimatedArrivalViewFragment].
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (viewPresenter == null) {
            viewPresenter = GuidanceEstimatedArrivalViewPresenter(SingletonHelper.navigationManager).apply {
                addListener(this@GuidanceEstimatedArrivalViewFragment)
                resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewPresenter?.pause()
    }

    override fun onResume() {
        super.onResume()
        viewPresenter?.resume()
    }

    override fun onDataChanged(viewData: GuidanceEstimatedArrivalViewData?) {
        (view as? GuidanceEstimatedArrivalView)?.estimatedArrivalData = viewData
    }
}