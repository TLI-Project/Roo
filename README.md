# roo
 ## How to Use
 
### On Local machine
1. First, we need to start the application using `./mvnw spring-boot:run` in terminal.
2. Then, use `curl http://localhost:8080/*function_name*` (example `mockSensoAPI`).
3. Go to http://localhost:8080/function_name on browser of choice.

### On Elastic Beanstalk
1. First, we need to execute a .jar file that the server can read using `$ ./mvnw package -DskipTests`
2. Navigate to the Piglet-env in Elastic Beanstalk (using login information) and click 'upload and deploy'
3. Select choose file and navigate to `.../roo/target/*version_name*.jar`.
4. Click deploy. It will take a few minutes and then be done.

### Connection with the database 
1. Should be connected and nothing you need to do.
2. Check links document for the endpoint and username/password combo.

 ***
Senso.ai introduces Senso Education, a new web application that helps car-buyers make more informed decisions about their vehicle purchases, as well as the features they choose to include, allowing them to walk away with more time and more money in their pockets. Senso Education takes information from buyers which includes their credit score, preferred vehicle, income, budget, etc. The framework then provides a display of monthly payments of the vehicle in comparison to other vehicles the buyer is interested in, and provides a list of popular features car dealerships offer in addition to data displaying how many car-buyers typically get those features, all within the short timespan of five minutes.
### the problem
In the auto sector, customers dread facing the salesmen constantly trying to bend them towards spending more money, without educating them on what they are being influenced to purchase. The upselling efforts of the salesmen often result in customers not being able to afford their dream car in the end. The tedious journey of going through one dealership after another only to find out that they are not eligible for a loan on their dream car makes this process extremely inconvenient and unnecessarily complicated.
### the solution
Senso Education makes the car-purchasing system much simpler by providing clients with all the necessary information tailored to their needs and wants before they begin the process of actually purchasing a car. Buyers who have a preferred vehicle will be able to get a detailed analysis of what they can expect to pay, what features are available to them and their costs, advantages and disadvantages of those features. Clients are able to gain an objective view on whether or not they can afford that vehicle. Senso Education will equip buyers with the knowledge and tools that they need, in order to go from dreaming about a car to owning it.
***
## tech stack
### frontend
We are going to be handling the frontend of Senso Education through React using HTML, CSS, SCSS, and JS. This is because we feel that ...
> "I'm a massive React fan. Really big fan personally" - Joanne
### backend
The backend of Senso Education will be built in Java with the Spring Boot framework to allow for easier integration between all of our different componenets. This was discovered out of necessity and talking with other groups. We spent a while trying to integrate the backend to the frontend without a framework like Spring with no success and heard lots of good things about Spring (also very well documented).
> "This is going to be very fun to do using Java. If you look here, (send one line of code), connecting to an API using python is very simple compared to Java (after spending 4hrs trying to connect to the API)." - Antoine

> "I want to switch to Java but I feel like I won't get the full learning experience. I am already so commitedd (1 day into coding a term long project) that I need to see it through at this point" - Callum and Shalev
### database
We are using mySQL because of SQL's relationship features since we will need them in our application. We specifically chose mySQL because after some research we found that this was the most popular one and would therefore be most applicable to any future projects we would be working on.
### hosting
We deployed the Frontend on AWS Amplify. We felt that Amplify was a very approachable platform to host our frontend because of its ease of use (kinda one click and its done and automatically keeps updated with the GitHub repository). We choose AWS Elastic Beanstalk because the abstraction of being able to use multiple CE2's was interesting and something we felt would be useful for future work (not likely that we will use it for this project). Further, it had easy server configuration and was free unlike many of the alternatives we researched (Opalstack, Firebase (functions)). Finally, we are hosting our database on AWS RDS. At this point we had become very familiar with the AWS hosting platforms and RDS allowed us to use our databse of choice (mySQL) and was free and easy to set up.
***

