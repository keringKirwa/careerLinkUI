package com.kenya.internlink.screens.searching_screen

import com.kenya.internlink.R

sealed class SearchScreenIcons(val title: String, val iconId: Int ) {

    object All : SearchScreenIcons("All Items", R.drawable.all_items)
    object Saved : SearchScreenIcons("Saved", R.drawable.saved_items)
    object Applied : SearchScreenIcons("Applied", R.drawable.applied_jobs)
}

