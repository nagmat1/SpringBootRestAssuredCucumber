pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk'  // Adjust based on your system
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'main', url: 'https://github.com/nagmat1/FirstSpringBootSuiteTest.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh './mvnw clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh './mvnw test'
            }

            post {
                always {
                    // Archive test results
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                // Package the application
                sh './mvnw package'
            }

            post {
                success {
                    // Archive the built artifacts
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add your deployment script or logic here
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check logs.'
        }
    }
}
