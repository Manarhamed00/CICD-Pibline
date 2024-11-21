pipeline {
    agent any
    environment {
        IMAGE_NAME = 'manarhamed01/django-app' 
        DOCKER_REGISTRY = 'https://registry.hub.docker.com'
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
                        docker.withRegistry(DOCKER_REGISTRY, 'dockerhub-credentials') {
                            sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} ."
                        }
                    }
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                        sh "docker push ${IMAGE_NAME}:${BUILD_NUMBER}"
                    }
                }
            }
        }
        stage('Deploy to Kubernetes Cluster') {
            steps {
                script {
                        sh 'kubectl cluster-info'
                        sh 'kubectl apply -f blue-deployment.yaml'
                   
                }
            }
        }
    }
}
