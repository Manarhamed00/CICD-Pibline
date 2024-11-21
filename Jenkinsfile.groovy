pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS = credentials('dockerhub-credentials')
        IMAGE_NAME = 'django-app'
    }
    stages {
        stage('Clone Repository') {
            steps {
                // قم بسحب الكود من GitHub
                git branch: 'main', url: 'https://github.com/Manarhamed00/CICD-Pipeline'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                           // بناء الـ Docker Image من داخل مجلد المشروع
                    dir('myproject') {
                        docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS) {
                            sh 'docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} .'
                        }
                    }
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                      
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS) {
                       
                        sh 'docker push ${IMAGE_NAME}:${BUILD_NUMBER}'
                    }
                }
            }
        }
      
        stage('Deploy to Kubernetes Cluster') {
            steps {
                script {
                    
                        sh "kubectl apply -f deployment.yaml"
                    
                }
            }
        }
    }
}
