package com.kenya.internlink

class AppData {
    companion object{
        val testimonials = arrayOf(
            Testimonial("Jane Kamau", "I couldn't have found my dream internship without this app! It made the process so much easier, and I secured an amazing opportunity at Company XYZ. Thank you!"),
            Testimonial("John Njoroge", "This app is a game-changer! I was able to browse through various industries and apply for internships with just a few clicks. I'm grateful for the opportunity I got through this platform."),
            Testimonial("Sarah Chebet", "I highly recommend this app to all students looking for internships. It not only helped me find a great placement but also provided resources and tips that boosted my confidence during the application process."),
            Testimonial("Peter Odhiambo", "Thanks to this app, I landed an industrial attachment at a renowned organization in my field of interest. The user-friendly interface and personalized recommendations made all the difference. I'm excited about the experience I gained!"),
            Testimonial("Grace Mwende", "I'm extremely grateful for this app. It connected me to internship opportunities that matched my career goals and allowed me to build valuable connections in the industry. It's definitely a must-have for every student.")
        )
    }

}



data class Testimonial(val name: String, val content: String)
