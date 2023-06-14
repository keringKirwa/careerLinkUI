package com.kenya.internlink

class AppData {
    companion object{
        val testimonials = arrayOf(
            Testimonial("Jane Kamau","Software Engineer","Eclectics.", "\"I couldn't have found my dream internship without this app! It made the process so much easier, and I secured an amazing opportunity at Company Eclectics. Thank you!"),
            Testimonial("John Njoroge","Docktor" ,"Mama Lucy Nations Hstp.","\"This app is a game-changer! I was able to browse through various industries and apply for internships with just a few clicks. I'm grateful for the opportunity I got through this platform."),
            Testimonial("Sarah Chebet","Electrical Engineer","SoftTech Ltd.", "\"I highly recommend this app to all students looking for internships. It not only helped me find a great placement but also provided resources and tips that boosted my confidence during the application process."),
            Testimonial("Peter Odhiambo","QA Engineer" ,"Apple."," \"Thanks to this app, I landed an industrial attachment at a renowned organization in my field of interest. The user-friendly interface and personalized recommendations made all the difference. I'm excited about the experience I gained!"),
        )
        val successStories = listOf(
            "Kelvin Kirwa, a Software Engineer Lands a Full Time Job After Internship. Learn more about him in our daily blogs.",
            "Jane Kipchoge, a Business Administration student secures an internship at a leading company in Nairobi.",
            "Patrick Mutai, an Engineering student, completes an industrial attachment program and receives a job offer from the host company.",
            // Add more stories as needed
        )


    }

}

data class Testimonial(val name: String,val role : String,val companyName: String, val content: String)
