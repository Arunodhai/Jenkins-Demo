pipeline{
  agent{
    docker {
      image 'abhishekf5/maven-abhishek-docker-agent:v1'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock' // mount Docker socket to access the host's Docker daemon
    }

  }
    stages{
    stage('Checkout'){
      steps{
        echo "Jenkins Demo"
        // git clone https://github.com/Arunodhai/Kaiburr-Task1.git
      }
    }

    stage('Install Maven and Java') {
            steps {
                // Install Maven 3.9.6
                sh '''
                    wget -O /opt/apache-maven-3.6.3-bin.tar.gz http://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
                    tar xzf /opt/apache-maven-3.6.3-bin.tar.gz -C /opt
                    ln -s /opt/apache-maven-3.6.3 /opt/maven
                    export PATH=$PATH:/opt/maven/bin
                '''
                
                // Install Java 21
                sh '''
                    wget -O /opt/jdk-21.tar.gz https://download.java.net/java/early_access/jdk21/23/GPL/openjdk-21_linux-x64_bin.tar.gz
                    tar xzf /opt/jdk-21.tar.gz -C /opt
                    ln -s /opt/jdk-21 /opt/java
                    export PATH=$PATH:/opt/java/bin
                '''
            }
        }

    stage('Build and Test') {
      steps {
        sh 'ls -ltr'
        // build the project and create a JAR file
        sh 'mvn clean package'
      }
    }
    stage('Static Code Analysis') {
      environment {
        SONAR_URL = "http://34.201.116.83:9000"
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
