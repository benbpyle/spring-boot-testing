# Helpful Docker Commands

## [Docker CLI](https://docs.docker.com/engine/reference/commandline/docker/)

[Docker Build](https://docs.docker.com/engine/reference/commandline/build/)
```bash
# building a Docker image
# -t = target
docker build -t golf-bag-app .
```

[Docker Tag](https://docs.docker.com/engine/reference/commandline/tag/)
```bash
# tag your image
docker tag golf-bag-app golf-bag-app:demo
```

[Docker Image](https://docs.docker.com/engine/reference/commandline/images/)
```bash
# list docker images (search by golf-bag-app)
docker images golf-bag-app
```

[Docker Pull](https://docs.docker.com/engine/reference/commandline/pull/)
```bash
# pull an image down from a repository
docker pull postgres
```

[Docker PS](https://docs.docker.com/engine/reference/commandline/ps/)
```bash
# show docker running processes/containers
docker ps # show running
docker ps -a # show all
```

[Docker Run](https://docs.docker.com/engine/reference/commandline/run/)
```bash
# run in foreground
docker run postgres
# run in background
docker run -d postgres
# run with ports exposed
docker run -p 5432:5432 -d postgres # exposes port 5432 and forwards to the container
```

[Docker Exec](https://docs.docker.com/engine/reference/commandline/exec/)
```bash
# shell into a running container
docker exec -it postgres bash
```

[Docker Stop](https://docs.docker.com/engine/reference/commandline/stop/)
```bash
# stop a running container
docker stop <container-id>
```