# MyAssigment
This application aims to fulfill my assignment with a company.

I just just made some basic structures, such as recyclerview with view model (mvvm), login and register, login with Google Oauth and some UI features.


# SET-UP
You can hit download or clone project.
if you are confused to how to set up.

This App has basic structure :
- Login and Register with email
- Showing database object in files class
- Some UI feature

### First Set-up The login and register

You can set-up the login and Register by two ways :
- Firebase
- Or mysql database

I have assume you choose like i choose, the mysql database.

first define in the file graddle (Module:APP) the following implementation :

```
//retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.3.0'
    
 //SQL and VOLLEY
    implementation 'com.android.volley:volley:1.1.1'
```
The function of volley and retrofit is to get the HTTP request on the server.

what you need is :
- local host or (domain with website)
- .PHP file extension
- Don't forget to add "INTERNET permission" in manifest

for login with google you have to implements :
```
 implementation 'com.google.android.gms:play-services-auth:17.0.0'
```
And adding the Google repository at Manage-SDK and android-sdk-folder/extras/google/google_play_services.

For storing google login in database you can use Goole OAuth2
service, at [this-Link](https://developers.google.com/identity/sign-in/android/backend-auth?authuser=1)

# Showing Database In the files class

in files.class i have declare some methode to display Object List
From the database into RecyclerView.

I used MVVM Pattern in this methode. how to set up?

- You will need jSon file from your database, i use MySql(optional)
- Displaying data in jSon as an array List
- set up the graddle :
```
// Use retrofit same as in login methode
// implementation 'com.squareup.okhttp3:logging-interceptor:3.3.0'
```
For okhttp is optional when you need to add `clients` in your HTTP request.

For json contract i have use this one, if you want to set-up same with my
project just follow this jSon contract at this [link] (https://www.abkhrr.com/assesment/employee2.php)

if you want to add image through database just add this implementation :

```
implementation 'com.github.bumptech.glide:glide:4.10.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
implementation 'com.squareup.picasso:picasso:2.71828'
```

# Simple unit-test
- i have declare some simple unit test for mvvm pattern (RECYCLERVIEW) to get the response.

# UI overview and describe

#### First View:
![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/first-page-1.jpg)

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/first-page-2.jpg)

#### Login And Registration

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/login-app.jpg)

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/register-app.jpg)

#### Main View (with bottom Nav) => Services Tabs

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/services-tabs.jpg)

#### Main View => Approvals Tabs with three buttons

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/threebuttos-1.jpg)

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/threebuttos-2.jpg)

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/threebuttos-3.jpg)


#### Example of simple Json encode in FILES EMPLOYEE on click cardview in services tabs

![Image of Login And Register](http://www.abkhrr.com/assesment/ImagesGit/card-view.jpg)

