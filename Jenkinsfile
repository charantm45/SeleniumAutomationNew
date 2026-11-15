pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    options {
        timestamps()
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Getting latest code from GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Selenium project'
                bat 'mvn -B -DskipTests clean compile'
            }
        }

        stage('Execute Test Cases') {
            steps {
                echo 'Executing Selenium TestNG tests'
                bat 'mvn -B test'
            }
        }

        stage('Test Reports') {
            steps {
                echo 'Publishing TestNG reports'
                junit testResults: '**/target/surefire-reports/*.xml',
                      allowEmptyResults: false
            }
        }
    }

    post {
        always {
            echo 'Jenkins execution completed'
        }

        success {
            echo 'Automation tests passed!'
        }

        failure {
            echo 'Automation tests failed!'
        }
    }
}
