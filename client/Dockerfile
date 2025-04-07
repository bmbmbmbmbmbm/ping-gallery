# build
FROM node:22-alpine AS build
WORKDIR /client
COPY package*.json ./
RUN npm i
COPY . .
EXPOSE 5173
CMD ["npm", "run", "build"]

# deploy
FROM nginx:stable-alpine AS production
COPY --from=build /client/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]