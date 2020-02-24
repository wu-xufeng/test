pipeline {
    agent any 

    environment{
        ONES_PIPELINE_URL="https://api.ones.ai/project/v1/team/EfJdQBt5/pipeline/9FnBc27s/callback?token=Af6bKjiZz3MAHBskQRderB"
    }
    
    stages {
        
        stage('Deploy') {
            steps {
                
                script{
                    sh 'onespl start'
                    echo 'echo Deploy stage ...'
                    sh 'onespl lint --lang java'
                    sh 'onespl artifact https://ones.ai'
                }
            }
        }
    }
    post{
        always{
            script{
                
                def command = ["onespl", "finish"]
                // def env1 = System.getenv()
                // def man = manager
                // def env = manager.envVars.collect { k, v -> "$k=$v" }
                // env.add("BUILD_RESULT=" + manager.getResult())
                    def env=[]
                    env.add('WORKSPACE="${WORKSPACE}"')
                    env.add('BUILD_ID="${}"')
                    env.add('BUILD_URL="${BUILD_URL}"')
                    env.add('JOB_NAME="${JOB_NAME}"')
                    env.add('GIT_BRANCH="${GIT_BRANCH}"')
                    env.add('GIT_COMMIT="${GIT_COMMIT}"')
                    env.add('GIT_PREVIOUS_COMMIT="${GIT_PREVIOUS_COMMIT}"')
                    env.add('BUILD_NUMBER="${BUILD_NUMBER}"')
                    

                    def BUILD_RESUT=currentBuild.result
                        env.add('BUILD_RESULT=$BUILD_RESUT')
                   sh 'echo "${BUILD_RESULT}"'
                   // env.add('BUILD_RESULT')
                
                def workspace = new File("${WORKSPACE}")
                command.execute(env, workspace).waitFor()
            }
        }
    }
  }
