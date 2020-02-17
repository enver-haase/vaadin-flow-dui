if [ $# -eq 0 ]
  then
    echo "Release version not specified."
    exit
fi

RELEASE_VERSION=$1
RELEASE_TAG="release-${RELEASE_VERSION}"

./mvnw versions:set -DnewVersion=${RELEASE_VERSION}
sed -i "s:<version>.*</version>:<version>${RELEASE_VERSION}</version>:g" README.md

git add -u
git commit -m "RELEASE: ${RELEASE_VERSION}"
git tag -a -m "RELEASE: ${RELEASE_VERSION}" ${RELEASE_TAG}


./mvnw versions:set -DnextSnapshot=true
NEXT_VERSION=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
sed -i "s:<version>.*</version>:<version>${NEXT_VERSION}</version>:g" README.md

git add -u
git commit -m "Prepare next snapshot version."
