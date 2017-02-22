/*
 * Copyright (C) 2017 Luke Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.klinker.android.drag_dismiss;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Builder to help with creating a DragDismissActivity and DragDismissRecyclerViewActivity
 */
public class DragDismissBundleBuilder {

    public static final String EXTRA_THEME = "arg_base_theme";
    public static final String EXTRA_PRIMARY_COLOR = "arg_primary_color";
    public static final String EXTRA_TOOLBAR_TITLE = "arg_toolbar_title";
    public static final String EXTRA_SHOULD_SHOW_TOOLBAR = "arg_show_toolbar";

    public static final int DEFAULT_TOOLBAR_RESOURCE = R.color.dragdismiss_toolbarBackground;

    public enum Theme {
        LIGHT, DARK, BLACK, DAY_NIGHT
    }

    private Theme theme = Theme.LIGHT;
    private int primaryColor = -1;
    private String toolbarTitle = null;
    private boolean shouldShowToolbar = true;

    private Context context;

    public DragDismissBundleBuilder(Context context) {
        this.context = context;
    }

    /**
     * Create the Bundle to pass to with the Intent.
     *
     * @return bundle describing how the Activity should be initialized
     */
    public Intent build(Intent intentToBuildOn) {
        if (primaryColor == -1) {
            primaryColor = context.getResources().getColor(DEFAULT_TOOLBAR_RESOURCE);
        }

        intentToBuildOn.putExtra(EXTRA_TOOLBAR_TITLE, toolbarTitle);
        intentToBuildOn.putExtra(EXTRA_THEME, theme.name());
        intentToBuildOn.putExtra(EXTRA_PRIMARY_COLOR, primaryColor);
        intentToBuildOn.putExtra(EXTRA_SHOULD_SHOW_TOOLBAR, shouldShowToolbar);

        return intentToBuildOn;
    }

    /**
     * Set the theme of the activity.
     *
     * @param theme LIGHT, DARK, or DAY_NIGHT.
     * @return the builder.
     */
    public DragDismissBundleBuilder setTheme(Theme theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Set the primary color for the Activity.
     *
     * @param primaryColor the color resource for the toolbar and the status bar.
     * @return the builder.
     */
    public DragDismissBundleBuilder setPrimaryColorResource(int primaryColor) {
        this.primaryColor = context.getResources().getColor(primaryColor);
        return this;
    }

    /**
     * Set the primary color for the Activity.
     *
     * @param primaryColor the color resource for the toolbar and the status bar.
     * @return the builder.
     */
    public DragDismissBundleBuilder setPrimaryColorValue(int primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }

    /**
     * Set the title on the Toolbar.
     *
     * @param title the title of the Activity.
     * @return the builder.
     */
    public DragDismissBundleBuilder setToolbarTitle(String title) {
        this.toolbarTitle = title;
        return this;
    }

    /**
     * Set whether or not the Toolbar should be shown.
     *
     * @param showToolbar
     * @return the builder.
     */
    public DragDismissBundleBuilder setShowToolbar(boolean showToolbar) {
        this.shouldShowToolbar = showToolbar;
        return this;
    }
}
