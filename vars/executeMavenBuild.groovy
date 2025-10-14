def call() {
    // This is the logic from your old 'Build' stage
    script {
        currentBuild.description = "Commit: ${env.GIT_COMMIT}"
    }
    echo "Now building commit: ${env.GIT_COMMIT}"
    sh 'mvn clean install'
    
    // This is the logic from your old 'post' block
    archiveArtifacts artifacts: 'target/*.jar'
}
