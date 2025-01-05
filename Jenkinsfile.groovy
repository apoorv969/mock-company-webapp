pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh './gradlew assemble' // Build step
            }
        }
      stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test' // Test step
            }
        }
    }
    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
