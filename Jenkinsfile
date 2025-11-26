pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9.5'
        jdk 'JDK 17'
    }
    
    environment {
        APP_NAME = 'RetirementPro'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo "Building ${APP_NAME}..."
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        success {
            echo "${APP_NAME} build completed successfully!"
        }
        failure {
            echo "${APP_NAME} build failed!"
        }
    }
}
