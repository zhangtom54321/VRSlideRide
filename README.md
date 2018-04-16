 # VRSlideRide
 
 ## Authors
  - Tom Zhang
  - Gautham Raghupathi
  - Nitin Subramanian
 
 ## Overview
 VR Slide Ride is a revolutionary app that is built for Android and the Google Cardboard VR platform. A user uploads a PPT to "http://vrslideride.tech/" or "https://zhangtom54321.github.io/vrslideridewebsite/" and is given a code. The user then opens this app and types in the code to view the PPT in 360 degree virtual reality!
 
 ## Inspiration
Nowadays, people all over the world use slideshows as a way to impart knowledge or transfer information to a group of people. However, we found that there were many distractions in the environment which teachers would teach in and that with an immersive environment, more information could be acquired in shorter periods of time.

 ## What it does
VRSlideRide https://zhangtom54321.github.io/vrslideridewebsite/ solves this problem statement in a creative, next-gen fashion. We use Google Cardboard products, which are cheap and effective. The option of downloading this app on any android phone makes it accessible to millions. Lastly, it can be used in any environment: company, marketing, and schooling. When only information is placed in front of one without distractions, they are likely to absorb the information in a timely manner.

 ## The process: 1) Upload powerpoint presentation to this website: https://zhangtom54321.github.io/vrslideridewebsite/ 2) Receive key from the website and enter it on Android Device 3) View in Cardboard Viewer

 ## How we built it
After we realized we wanted to solve this problem, we that an android app would be the best choice because they are easily accessible. We used Android Studio to code the Android app and coded the website using HTML, CSS, and Javascript. We built the website first. We coded it so the user would be able to upload a PPT to the website before receiving a code. The PPT is stored in Firebase with the matching code. Viewers then download our app and enter the code, and our app takes the PPT from Firebase, converts the slides to images, stitches them together, and allows the user to view it in 360 degrees!

 ## Challenges we ran into
We faced three main challenges in this hackathon.

1) Implementing VR Implementing VR on its own is tough, especially since we didn't use Unity or any game development platform as other VR apps. Afterall, our goal was accessibility and the VR portion of VRSlideRide accomplishes this by being run on Android solely. We had to use a couple Google API's but the problem was nonetheless very hard.

2) Acquiring images in .pptx formats from an HTML environment to Android Transferring data via firebase itself was a daunting task, but after that, various picture manipulations had to be made to change the picture to a nice VR curved image.

3) The documentation for API's was hard to follow. This caused the implementation of those API's to cause a great deal of adversity when it came to writing code.

 ## Accomplishments that we're proud of
We are proud that we were able to create this app from scratch without any guidance.

 ## What we learned
We learned that working together as a team is crucial to be able to complete our project in the time allotted. We learned how to divide up the work equally and have people who were better at one aspect work on that aspect for the best results.

 ## What's next for VRSlideRide
We also hope to release it to the android play store someday
  
This app, along with its website, was built on 11/4/17 - 11/5/17 in 24 hours at Firebird Hacks in Fremont, CA. It won 2nd place.
It was improved upon at EVHacks in February 2018. It won Honorable Mention.

 ## More Info
The website's Github Repository can be found at "https://github.com/zhangtom54321/vrslideridewebsite".

View the devpost at "https://devpost.com/software/vrslideride-04qprz"
