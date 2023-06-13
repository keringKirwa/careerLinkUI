package com.kenya.internlink.screens.searching_screen
sealed class SearchData(

    val companyName: String,
    val numberOfJobVacancies: String,
    val salary: String,
    val onlineOrRemote: String

) {

    object LandingScreen : SearchData(

        "Apple",
        "45 job vacancies",
        "70K-120k/ month",
        "Online/ Remote"
    )



}

/**
 * Image(
painter = painterResource(id = R.drawable.careers_inside),
contentDescription = null,
modifier = Modifier
.size(50.dp)
.clip(RoundedCornerShape(3.dp)),

)
 */