FROM mhart/alpine-node:8

WORKDIR /application
ADD . .
RUN npm install

EXPOSE 3000
CMD ["node", "src/index.js"]
