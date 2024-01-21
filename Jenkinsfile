pipeline {
    agent {
        docker {
            image 'ubuntu:latest'
            args '--user root -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                echo "Jenkins Demo"
                // git clone https://github.com/Arunodhai/Kaiburr-Task1.git
            }
        }
        stage('Build and Test') {
            steps {
                sh 'ls -ltr'
                
                // Install necessary packages for Java
                sh 'apt-get update && apt-get install -y openjdk-17-jre-headless'

                // Install Maven
                sh 'apt-get install -y maven'

                // build the project and create a JAR file
                sh 'mvn clean package'
            }
        }
        stage('Static Code Analysis') {
            environment {
                SONAR_URL = "http://localhost:9000"
            }
            steps {
                withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
                }
            }
        }
        stage('Build and Push Docker Image') {
            environment {
                DOCKER_IMAGE = "arunodhai/jenkins-demo"
                REGISTRY_CREDENTIALS = credentials('docker-cred')
            }
            steps {
                script {
                    sh 'cd kaiburrTask1 && docker build -t ${DOCKER_IMAGE} .'
                    def dockerImage = docker.image("${DOCKER_IMAGE}")
                    docker.withRegistry('https://index.docker.io/v1/', "docker-cred") {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
