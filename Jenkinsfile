final GRADLE_VERSION = '4.8-jdk-alpine'

pipeline {
    agent none
    stages {
        stage('Build') {
            agent { docker "gradle:$GRADLE_VERSION" }
            steps {
                sh 'gradle build'
            }
        }
        stage('Unit Tests') {
            agent { docker "gradle:$GRADLE_VERSION" }
            steps {
                sh 'gradle test'
            }
        }
    }
}

