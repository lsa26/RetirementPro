pipeline {
    agent {
        kubernetes {
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3.9.5-eclipse-temurin-17
    command:
    - cat
    tty: true
    volumeMounts:
    - name: maven-cache
      mountPath: /root/.m2
  volumes:
  - name: maven-cache
    emptyDir: {}
'''
        }
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
                container('maven') {
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage('Package') {
            steps {
                container('maven') {
                    sh 'mvn package -DskipTests'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
    
    post {
        success {
            echo "${APP_NAME} build completed successfully!"
            echo "Artifact: target/retirement-api-1.0.0-SNAPSHOT.jar"
            echo "Build URL: ${BUILD_URL}"
        }
        failure {
            echo "${APP_NAME} build failed!"
        }
    }
}
