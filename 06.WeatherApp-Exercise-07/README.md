# Build
mvn clean package && docker build -t pjwstk.fryger/WhetherApp .

# RUN

docker rm -f WhetherApp || true && docker run -d -p 8080:8080 -p 4848:4848 --name WhetherApp pjwstk.fryger/WhetherApp 