pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    def mvn = tool 'M2_HOME'; // Using 'M2_HOME' as your Maven tool name
                    sh "${mvn}/bin/mvn clean install" // Modify this command as needed for your build
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def mvn = tool 'M2_HOME'; // Use the same Maven tool for the SonarQube analysis
                    withSonarQubeEnv('SonarQube') { // Reference the SonarQube configuration in Jenkins
                        sh "${mvn}/bin/mvn sonar:sonar -Dsonar.projectKey=projet2024 -Dsonar.projectName='projet2024'"
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
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
