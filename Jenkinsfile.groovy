pipeline {
    agent any
    environment {
        IMAGE_NAME = 'manarhamed01/django-app' 
    }
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Manarhamed00/CICD-Pipeline'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    dir('myproject') {
                        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                            sh 'docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} .'
                        }
                    }
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                        sh 'docker push ${IMAGE_NAME}:${BUILD_NUMBER}'
                    }
                }
            }
        }
        stage('Deploy to Kubernetes Cluster') {
            steps {
                script {
                    sh 'kubectl apply -f blue-deployment.yaml'
                }
            }
        }
    }
}
