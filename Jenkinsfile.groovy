pipeline {
    agent any
    environment {
        DOCKER_USERNAME = 'manarhamed01'
        DOCKER_PASSWORD = 'manar@docker'
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
                    dir('my-project') {
                        sh 'docker build -t ${DOCKER_USERNAME}/${IMAGE_NAME}:${BUILD_NUMBER} .'
                    }
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // تسجيل الدخول إلى Docker Hub
                    sh '''
                    docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                    docker push ${DOCKER_USERNAME}/${IMAGE_NAME}:${BUILD_NUMBER}
                    '''
                }
            }
        }
      
        stage('Deploy to Kubernetes Cluster') {
            steps {
                script {
                    // التأكد من الاتصال بـ Kubernetes باستخدام kubectl
                    sh '''
                    kubectl apply -f blue-deployment.yaml
                    '''
                }
            }
        }
    }
}
