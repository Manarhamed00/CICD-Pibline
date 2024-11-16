# My Project

This project is designed to demonstrate setting up a Jenkins pipeline for a Django application, including automated testing.

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

Before you begin, make sure you have the following software installed on your machine:
- Python (version 3.6 or higher)
- pip (Python package installer)
- Django (version 3.x)
- Docker
- Jenkins

### Installation

1. Clone the repository to your local machine:
   
   https://github.com/Manarhamed00/jenkens--labs/tree/develop1


2. Navigate to the project directory:
   
   cd jenkens--labs

3. Install project dependencies:

   pip install -r myproject/requirements.txt


### Running Tests

To run the automated tests for this system, execute the following command:

python myproject/manage.py test



### Usage

To start the Django development server, run the following command:

python myproject/manage.py runserver



You can now access the application at [http://localhost:8000](http://localhost:8000) in your web browser.

### Tools Used

- **Jenkins:** Jenkins is used for continuous integration and deployment automation.
- **Django:** Django is a high-level Python web framework for rapid development.
- **Docker:** Docker is used for containerization of the Django application.
- **Git:** Git is a distributed version control system used for collaboration and version management.
- **Python:** Python is the programming language used for development.

### Webhooks

To trigger Jenkins pipeline builds automatically on code changes, set up a webhook in your GitHub repository with the following URL:

http://your-jenkins-server/github-webhook/


### Docker Setup

#### Docker Commands

To build and run your Docker image, follow these steps:

1. Build the Docker Image:
  
   docker build -t my-django-app .


2. Run a Container using the Built Image:

  docker run -d -p 8000:8000 my-django-app

  Replace 8000:8000 with the appropriate port mapping if your Django application uses a different port.

3. View Running Containers:
   docker ps


4. Push the Docker Image to a Registry (e.g., Docker Hub):

docker push username/my-django-app


Replace username with your Docker Hub username and my-django-app with the name you want to give to your Docker image.

### Future Improvement

In the next iteration, we plan to use a Docker image as an artifact to streamline deployment and ensure consistency across environments.


### Testing and Validation

Once the Docker image is built and the container is running, you can test your application by accessing it in a web browser or using tools like cURL or Postman to send requests to the exposed endpoints.

### Contributing

We welcome contributions from the community! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository on GitHub.
2. Create a new branch off of develop for your feature or fix.
3. Make your changes and commit them with clear, descriptive commit messages.
4. Push your changes to your fork.
5. Submit a pull request against the develop branch of the original repository.

### Testing and Validation

Push a change to the develop branch and verify Jenkins triggers a build.

Check the Jenkins dashboard for build status and output ...

![last](https://github.com/Manarhamed00/jenkens--labs/assets/123329277/c4ff9332-8a50-405e-854b-786af234aa33)

![Capturerrrrrr](https://github.com/Manarhamed00/jenkens--labs/assets/123329277/282ab353-f242-4e2d-924b-2ff9734fd91a)

   


   

   



   

   

