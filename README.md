# Programming Discussion Forum

Fully functional discussion forum backed with Spring MVC, Spring Security and Hibernate. 

### Getting started

Clone the project

```
git clone https://github.com/YogenRaii/pdf.git
```

Import project into any of IDE and deploy in any container (Tomcat would be the easiest) and test endpoint:

```
http://localhost:8080
```

### Docker
You need to have Docker installed to run the latest `master` branch.

Build artifact with Maven as:

```
mvn clean install
```

Now, create Docker image, and hence container with Docker Compose as:

```
docker-compose up --build
```

This creates container for app and mysql, network bridge to connect these to container!

### Spring Boot Run
Need to switch to branch [spring-boot-embedded-container](https://github.com/YogenRaii/pdf/tree/spring-boot-embedded-container) for this feature!

Go to `$PROJECT_DIR/pdf-app` directory and run:

```
mvn clean spring-boot:run
```
With this, Spring Boot starts embedded container at port 8081. So, service can be reached at:
```
http://localhost:8080
```

### Vagrant Installation
Need to switch to branch [spring-5-hibernate-5](https://github.com/YogenRaii/pdf/tree/spring-5-hibernate-5) for this feature!


Go to `$PROJECT_DIR/vagrant` directory and install the plugins as defined in `Vagrantfile`.

Once vagrant plugins are ready, run script to create artifacts:

```
./build_pdf.sh
``` 

Once, artifact is ready, bring up vagrant box with:

```
vagrant up pdf
```

Once vagrant box comes up, you should be able to access the service at:

```
http://pdf.local:8080/pdf
```
### Testing

User can search the questions and go into the details even without login. 

![Search Page](/docs/forum.png?raw=true "Forum Page")

Once registered user logs in, s/he can ask the question and answer the question.

![Wall Page](/docs/home.png?raw=true)

Application supports internationalization with Nepalese and Chinese language.

![I18N Page](/docs/i18n.png?raw=true)

### Logging into the system
As Admin User
```$xslt

username : ironman

password : ironman
```

As General User,

```$xslt

username : rabi

password : rabi
```
