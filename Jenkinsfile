/**
 * Texercise pipeiline script
 *
 * author: Jason Bolito
 */
pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                sh './gradlew build'
            }
        }
        stage('Unit Tests') {
            agent any
            steps {
                sh './gradlew test'
            }
        }
    }
}
