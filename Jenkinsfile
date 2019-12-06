pipeline {
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
                    def dockerImage = docker.build "agh/demo-jenkins-ci:0.0.1-SNAPSHOT"
                }
            }
        }
    }
}