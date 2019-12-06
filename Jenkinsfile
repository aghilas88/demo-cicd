pipeline {
    environment {
        imageName = "demo-jenkins-ci"
        imageVersion = "0.0.1-SNAPSHOT"
        registryUser = "aghilas88"
        registryCredential = 'docker-hub-credential'
        dockerImage = ''
      }
    agent any
    tools {
        maven "maven-3"
        jdk "jdk8"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build image') {
            steps{
                script {
                    dockerImage = docker.build registryUser + "/" + imageName + ":" + imageVersion
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                }
            }
            }
        }
    }
}