pipeline {
    agent any

    environment {
        SONARQUBE_URL = 'http://192.168.33.10:9000'          
        SONARQUBE_TOKEN = credentials('sonarqube-token') // Use the ID you set when adding the SonarQube token to Jenkins credentials
    }

    stages {
        stage('Checkout') {
            steps {
                // Replace this with your repository
                git 'https://github.com/Rimesp/ProjetRecrutement.git'  
            }
        }

        stage('Build') {
            steps {
                // Modify this to match your build command (e.g., Maven, Gradle, etc.)
                sh 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {   // This refers to the SonarQube configuration you did earlier in Jenkins
                    // Run the SonarQube analysis using the token for authentication
                    sh 'mvn sonar:sonar -Dsonar.login=${SONARQUBE_TOKEN}'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        // This checks if the SonarQube Quality Gate was passed
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
