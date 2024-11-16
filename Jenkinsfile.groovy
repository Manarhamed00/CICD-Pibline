pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout from Git
                    checkout([$class: 'GitSCM', branches: [[name: 'develop1']], userRemoteConfigs: [[url: 'https://github.com/Manarhamed00/jenkens--labs']]])
                }
            }
        }
        stage('Install Dependencies') {
            steps {
                // Use conditional execution based on the operating system
                script {
                    if (isUnix()) {
                        sh 'pip install -r myproject/requirements.txt'
                    } else {
                        bat 'pip install -r myproject/requirements.txt'
                    }
                }
            }
        }
        stage('Run Tests') {
            steps {
                // Use conditional execution based on the operating system
                script {
                    if (isUnix()) {
                        sh 'python myproject/manage.py test'
                    } else {
                        bat 'python myproject/manage.py test'
                    }
                }
            }
        }
    }
}


