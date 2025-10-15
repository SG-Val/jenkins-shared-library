def call() {
    // This step finds the location of the Maven tool and returns its path
    def mvnHome = tool 'Maven-3.9.11'
    
    // This is the logic from your old 'Build' stage
    script {
        currentBuild.description = "Commit: ${env.GIT_COMMIT}"
    }
    echo "Now building commit: ${env.GIT_COMMIT}"
    sh 'mvn clean install'
    
    // This is the logic from your old 'post' block
    archiveArtifacts artifacts: 'target/*.jar'
}
